package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.FuncoesSecundarias;
import util.InterfaceUsuario;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException {
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


        FuncoesSecundarias.salvarTxt(listaDeFinanciamentos, "financiamentos.txt");

        FuncoesSecundarias.lerTxt("financiamentos.txt");

        FuncoesSecundarias.salvarSerializado(listaDeFinanciamentos, "listafinanciamentos.ser");

        FuncoesSecundarias.lerSerializado("listafinanciamentos.ser");


        System.out.println("Valor de todos os imoveis: " + dinheiro.format(valor) + "\n" +
                "Valor de todos os imoveis financiado: " + dinheiro.format(valorTotalFinanciamento));
    }
}