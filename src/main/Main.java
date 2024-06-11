package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valor = 0;
        double valorTotalFinanciamento = 0;

        for (int i = 0; i < 4; i++) {
            double valorImovel = interfaceUsuario.definirValorImovel();
            int prazoFinanciamento = interfaceUsuario.definirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.definirTaxaJurosAnual();

            Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
            System.out.println("Valor do financiamento mensal: " + dinheiro.format(financiamento.calcularPagamentoMensal()));
            System.out.println("\nValor do financiamento total: " + dinheiro.format(financiamento.calcularPagamentoTotal()));
            valor += financiamento.getValorImovel();
            valorTotalFinanciamento += financiamento.calcularPagamentoTotal();
            listaDeFinanciamentos.add(financiamento);
        }
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