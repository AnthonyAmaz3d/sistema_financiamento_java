package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valor = 0;
        double valorTotalFinanciamento = 0;


        double valorImovel = interfaceUsuario.definirValorImovel();
        int prazoFinanciamento = interfaceUsuario.definirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.definirTaxaJurosAnual();

        Casa casa1 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(casa1);
        valor += casa1.getValorImovel();
        valorTotalFinanciamento += casa1.calcularPagamentoTotal();

        Casa casa2 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(casa2);
        valor += casa2.getValorImovel();
        valorTotalFinanciamento += casa2.calcularPagamentoTotal();

        Apartamento apartamento1 = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(apartamento1);
        valor += apartamento1.getValorImovel();
        valorTotalFinanciamento += apartamento1.calcularPagamentoTotal();

        Apartamento apartamento2 = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(apartamento2);
        valor += apartamento2.getValorImovel();
        valorTotalFinanciamento += apartamento2.calcularPagamentoTotal();

        Terreno terreno1 = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(terreno1);
        valor += terreno1.getValorImovel();
        valorTotalFinanciamento += terreno1.calcularPagamentoTotal();

        int i = 0;
        for (Financiamento f : listaDeFinanciamentos) {
            System.out.println("--- Informações do Financiamento " + (i + 1) + " ---\n\n" +
                    "Valor do Imovel: " + dinheiro.format(f.getValorImovel()) + "\n" +
                    "Prazo do Financiamento em anos: " + f.getPrazoFinanciamento() + " anos\n" +
                    "Taxa de juros anual (em %): " + f.getTaxaJurosAnual() + "%\n" +
                    "Pagamento Mensal: " + dinheiro.format(f.calcularPagamentoMensal()) + "\n" +
                    "Pagamento Total: " + dinheiro.format(f.calcularPagamentoTotal()) + "\n");
            i++;
        }

        System.out.println("Valor de todos os imoveis: " + dinheiro.format(valor) + "\n" +
                "Valor de todos os imoveis financiado: " + dinheiro.format(valorTotalFinanciamento));
    }
}