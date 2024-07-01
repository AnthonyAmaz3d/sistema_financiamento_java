/**
 * @author Anthony.Amaz3d
 */

package modelo;

public class Apartamento extends Financiamento{

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
}