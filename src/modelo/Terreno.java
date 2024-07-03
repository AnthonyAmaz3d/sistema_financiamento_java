/**
 * @author Anthony.Amaz3d
 */

package modelo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Terreno extends Financiamento implements Serializable {
    Locale localeBR = new Locale("pt", "BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }

    @Override
    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "--- Informações sobre o financiamento do Terreno ---" + "\n" +
                "- Valor do Terreno (imovel) = " + dinheiro.format(valorImovel) + "\n" +
                "- Taxa de Juros Anual = " + taxaJurosAnual + "%" +"\n" +
                "- Prazo do Financiamento = " + prazoFinanciamento + " anos" + "\n" +
                "- Tipo da Zona = " + tipoZona  + "\n" +
                "-----------------------------------------------------";
    }
}