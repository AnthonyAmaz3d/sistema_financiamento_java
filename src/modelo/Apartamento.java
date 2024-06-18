/**
 * @author Anthony.Amaz3d
 */

package modelo;

public class Apartamento extends Financiamento{

    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
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
}