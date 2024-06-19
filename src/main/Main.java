package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> listaDeFinanciamentos = new ArrayList<>();
        ArrayList<Casa> listaCasa = new ArrayList<>();
        ArrayList<Apartamento> listaApartamento = new ArrayList<>();
        ArrayList<Terreno> listaTerreno = new ArrayList<>();
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
        listaCasa.add(casa1);
        valor += casa1.getValorImovel();
        valorTotalFinanciamento += casa1.calcularPagamentoTotal();

        Casa casa2 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, areaTerreno);
        listaCasa.add(casa2);
        valor += casa2.getValorImovel();
        valorTotalFinanciamento += casa2.calcularPagamentoTotal();

        Apartamento apartamento1 = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, totalVagas, numeroAndar);
        listaApartamento.add(apartamento1);
        valor += apartamento1.getValorImovel();
        valorTotalFinanciamento += apartamento1.calcularPagamentoTotal();

        Apartamento apartamento2 = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, totalVagas, numeroAndar);
        listaApartamento.add(apartamento2);
        valor += apartamento2.getValorImovel();
        valorTotalFinanciamento += apartamento2.calcularPagamentoTotal();

        Terreno terreno1 = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
        listaTerreno.add(terreno1);
        valor += terreno1.getValorImovel();
        valorTotalFinanciamento += terreno1.calcularPagamentoTotal();

        listaDeFinanciamentos.add(listaCasa);
        listaDeFinanciamentos.add(listaApartamento);
        listaDeFinanciamentos.add(listaTerreno);

        int i = 0;
        for (Casa c : listaCasa) {
            System.out.println("--- Informações do Financiamento de Casa " + (i + 1) + " ---\n\n" +
                    "Valor do Imovel: " + dinheiro.format(c.getValorImovel()) + "\n" +
                    "Prazo do Financiamento em anos: " + c.getPrazoFinanciamento() + " anos\n" +
                    "Taxa de juros anual (em %): " + c.getTaxaJurosAnual() + "%\n" +
                    "Pagamento Mensal: " + dinheiro.format(c.calcularPagamentoMensal()) + "\n" +
                    "Pagamento Total: " + dinheiro.format(c.calcularPagamentoTotal()) + "\n" +
                    "Área construída: " + c.getAreaConstruida() + "\n" +
                    "Área total do terreno: " + c.getAreaTerreno() + "\n");
            i++;
        }

        int j = 0;
        for (Apartamento a : listaApartamento) {
            System.out.println("--- Informações do Financiamento de Apartamento " + (j + 1) + " ---\n\n" +
                    "Valor do Imovel: " + dinheiro.format(a.getValorImovel()) + "\n" +
                    "Prazo do Financiamento em anos: " + a.getPrazoFinanciamento() + " anos\n" +
                    "Taxa de juros anual (em %): " + a.getTaxaJurosAnual() + "%\n" +
                    "Pagamento Mensal: " + dinheiro.format(a.calcularPagamentoMensal()) + "\n" +
                    "Pagamento Total: " + dinheiro.format(a.calcularPagamentoTotal()) + "\n" +
                    "Número de vagas da garagem: " + a.getTotalVagas() + "\n" +
                    "Número do andar: " + a.getNumeroAndar() + "\n");
            j++;
        }

        int k = 0;
        for (Terreno t: listaTerreno) {
            System.out.println("--- Informações do Financiamento de Terreno " + (k + 1) + " ---\n\n" +
                    "Valor do Imovel: " + dinheiro.format(t.getValorImovel()) + "\n" +
                    "Prazo do Financiamento em anos: " + t.getPrazoFinanciamento() + " anos\n" +
                    "Taxa de juros anual (em %): " + t.getTaxaJurosAnual() + "%\n" +
                    "Pagamento Mensal: " + dinheiro.format(t.calcularPagamentoMensal()) + "\n" +
                    "Pagamento Total: " + dinheiro.format(t.calcularPagamentoTotal()) + "\n" +
                    "Tipo da zona: " + t.getTipoZona() + "\n");
            k++;
        }

        System.out.println("Valor de todos os imoveis: " + dinheiro.format(valor) + "\n" +
                "Valor de todos os imoveis financiado: " + dinheiro.format(valorTotalFinanciamento));
    }
}