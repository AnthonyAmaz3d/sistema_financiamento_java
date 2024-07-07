/**
 * @author Anthony.Amaz3d
 */

package modelo;

import util.AcrescimoException;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Casa extends Financiamento {
    Locale localeBR = new Locale("pt", "BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

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

    private boolean acrescimoAjustado = false;
    private static boolean mensagemErroApareceu = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void verificaAcrescimoMaiorQueJuros(double juros, double acrescimo) throws AcrescimoException {
        if (acrescimo > juros) {
            throw new AcrescimoException("O Acrescimo é maior que o juros. Mudando valor do acréscimo.");
        }
    }

    public double calcularPagamentoMensal(){
        double pagamentoMensal = super.calcularPagamentoMensal();
        double valorDojuros = pagamentoMensal - (this.valorImovel / (this.prazoFinanciamento * 12));
        double valorDoAcrescimo = 80;
        if (!acrescimoAjustado) {
            try {
                verificaAcrescimoMaiorQueJuros(valorDojuros, valorDoAcrescimo);
            } catch (AcrescimoException e) {
                if (!mensagemErroApareceu) {
                    System.out.println( ANSI_RED + "Erro ao calcular pagamento Mensal: " + e.getMessage() + ANSI_RESET + "\n");
                    mensagemErroApareceu = true;
                }
                valorDoAcrescimo = valorDojuros;
                acrescimoAjustado = true;
            }
        } else {
            valorDoAcrescimo = valorDojuros;
        }
        return pagamentoMensal + valorDoAcrescimo;
    }

    @Override
    public String toString() {
        return "--- Informações sobre o financiamento da Casa ---" + "\n" +
                "- Valor da Casa (Imovel) = " + dinheiro.format(this.valorImovel) + "\n" +
                "- Taxa de Juros Anual = " + taxaJurosAnual + "%" + "\n" +
                "- Prazo do Financiamento = " + prazoFinanciamento + " anos" + "\n" +
                "- Área Construida = " + areaConstruida + " m2" + "\n" +
                "- Área do Terreno = " + areaTerreno + " m2" + "\n" +
                "- Valor pagamento mensal =  " + dinheiro.format(this.calcularPagamentoMensal()) + "\n" +
                "- Valor do pagamento total = " + dinheiro.format(this.calcularPagamentoTotal()) + "\n" +
                "-----------------------------------------------------";
    }

    @Override
    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
}