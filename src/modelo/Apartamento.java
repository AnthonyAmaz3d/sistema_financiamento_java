/**
 * @author Anthony.Amaz3d
 */

package modelo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Apartamento extends Financiamento implements Serializable {
    Locale localeBR = new Locale("pt", "BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

    private int totalVagas;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int totalVagas, int numeroAndar) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.totalVagas = totalVagas;
        this.numeroAndar = numeroAndar;
    }

    public int getTotalVagas() {
        return totalVagas;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public double calcularTaxaMensal() {
        return ((this.getTaxaJurosAnual())/100) / 12;
    }

    public int calcularValorMesesFinaciamento() {
        return this.getPrazoFinanciamento() * 12;
    }

    public double calcularPagamentoMensal() {
        double valorImovel = this.getValorImovel();
        double taxaMensal = this.calcularTaxaMensal();
        int mesesFinanciamento = this.calcularValorMesesFinaciamento();

        return (valorImovel * taxaMensal)/ (1 - Math.pow(1 + taxaMensal, -mesesFinanciamento));
    }

    @Override
    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "--- Informações sobre o financiamento do Apartamento ---" + "\n" +
                "- Valor do apartamento (imovel) = " + dinheiro.format(valorImovel) + "\n" +
                "- Taxa de Juros Anual = " + taxaJurosAnual + "%" + "\n" +
                "- Prazo do Financiamento = " + prazoFinanciamento + " anos" + "\n" +
                "- Total de Vagas na garagem = " + totalVagas + "\n" +
                "- Numero do Andar = " + numeroAndar + "\n" +
                "- Valor do pagamento mensal = " + dinheiro.format(calcularPagamentoMensal()) + "\n" +
                "- Valor do pagemento total = " + dinheiro.format(calcularPagamentoTotal()) + "\n" +
                "-----------------------------------------------------";
    }
}