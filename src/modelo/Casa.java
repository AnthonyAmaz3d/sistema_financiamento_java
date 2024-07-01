/**
 * @author Anthony.Amaz3d
 */

package modelo;

import util.AcrescimoException;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    public void verificaAcrescimoMaiorQueJuros(double juros, double acrescimo) throws AcrescimoException {
        if (acrescimo > juros) {
            throw new AcrescimoException("O Acrescimo é maior que o juros.");
        }
    }

    public double calcularPagamentoMensal(){
        double valorDojuros = super.calcularPagamentoMensal() - (this.valorImovel / (this.prazoFinanciamento * 12));
        double valorDoAcrescimo = 80;
        try {
            verificaAcrescimoMaiorQueJuros(valorDojuros, valorDoAcrescimo);
        } catch (AcrescimoException e) {
            System.out.println("Erro ao calcular pagamento Mensal: " + e.getMessage());
            valorDoAcrescimo = valorDojuros;
        }

        return super.calcularPagamentoMensal() + valorDoAcrescimo;
    }

    @Override
    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
}