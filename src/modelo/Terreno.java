/**
 * @author Anthony.Amaz3d
 */

package modelo;

public class Terreno extends Financiamento{

    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }
}