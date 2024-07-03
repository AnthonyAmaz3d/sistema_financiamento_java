package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<>();
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valor = 0;
        double valorTotalFinanciamento = 0;


        double valorImovel = interfaceUsuario.definirValorImovel();
        int prazoFinanciamento = interfaceUsuario.definirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.definirTaxaJurosAnual();
        double areaConstruida = interfaceUsuario.definirAreaConstruida();
        double areaTerreno = interfaceUsuario.definirAreaTerreno();
        int totalVagas = interfaceUsuario.definirTotalVagas();
        int numeroAndar = interfaceUsuario.definirAndarApartamento();
        String tipoZona = interfaceUsuario.definirZona();

        Casa casa1 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, areaTerreno);
        listaDeFinanciamentos.add(casa1);
        valor += casa1.getValorImovel();
        valorTotalFinanciamento += casa1.calcularPagamentoTotal();

        Casa casa2 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, areaTerreno);
        listaDeFinanciamentos.add(casa2);
        valor += casa2.getValorImovel();
        valorTotalFinanciamento += casa2.calcularPagamentoTotal();

        Apartamento apartamento1 = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, totalVagas, numeroAndar);
        listaDeFinanciamentos.add(apartamento1);
        valor += apartamento1.getValorImovel();
        valorTotalFinanciamento += apartamento1.calcularPagamentoTotal();

        Apartamento apartamento2 = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, totalVagas, numeroAndar);
        listaDeFinanciamentos.add(apartamento2);
        valor += apartamento2.getValorImovel();
        valorTotalFinanciamento += apartamento2.calcularPagamentoTotal();

        Terreno terreno1 = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
        listaDeFinanciamentos.add(terreno1);
        valor += terreno1.getValorImovel();
        valorTotalFinanciamento += terreno1.calcularPagamentoTotal();


        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("financiamento.test"));

            outputStream.writeObject(casa1);
            outputStream.writeObject(casa2);
            outputStream.writeObject(apartamento1);
            outputStream.writeObject(apartamento2);
            outputStream.writeObject(terreno1);

            outputStream.flush();
            outputStream.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("financiamento.test"));

            Object object = null;
            while ((object = inputStream.readObject()) != null) {
                if (object instanceof Casa) {
                    Casa casa = (Casa) object;
                    System.out.println(casa.toString());;
                } else if (object instanceof Apartamento) {
                    Apartamento apartamento = (Apartamento) object;
                    System.out.println(apartamento.toString());;
                } else if (object instanceof Terreno) {
                    Terreno terreno = (Terreno) object;
                    System.out.println(terreno.toString());
                }
            }
            inputStream.close();
        } catch (EOFException e) {
            System.out.println("Fim do arquivo de leitura!" + "\n\n");
        } catch ( IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObjectOutputStream outputStream1 = null;
        try {
            outputStream1 = new ObjectOutputStream(new FileOutputStream("listafinanciamento.test"));

            outputStream1.writeObject(listaDeFinanciamentos);

            outputStream1.flush();
            outputStream1.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream("listafinanciamento.test"))) {
            for (Financiamento f : listaDeFinanciamentos) {
                System.out.println("Valor de pagamento mensal = " + dinheiro.format(f.calcularPagamentoMensal()) + "\n" +
                        "Valor de pagamento total = " + dinheiro.format(f.calcularPagamentoTotal()) + "\n");
            }
        } catch (EOFException e) {
            System.out.println("Fim do arquivo de leitura!");
        } catch ( IOException e) {
            e.printStackTrace();
        }

        System.out.println("Valor de todos os imoveis: " + dinheiro.format(valor) + "\n" +
                "Valor de todos os imoveis financiado: " + dinheiro.format(valorTotalFinanciamento));
    }
}