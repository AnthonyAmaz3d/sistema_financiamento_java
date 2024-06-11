package util;

import java.util.Scanner;

/**
 * @author Anthony.Amaz3d
 */

public class InterfaceUsuario {

    public double definirValorImovel(){
        while (true) {
            System.out.println("Digite o valor do Imovel: ");
            Scanner s = new Scanner(System.in);
            double p = s.nextDouble();
            if (p < 0) {
                System.out.println("O valor do Imovel deve ser positivo");
            } else {
                return p;
            }
        }
    }

    public int definirPrazoFinanciamento(){
        while (true) {
            System.out.println("Digite o prazo do financiamento em anos: ");
            Scanner s = new Scanner(System.in);
            int b = s.nextInt();
            if (b > 30 || b < 0) {
                System.out.println("O prazo de financiamento não pode ultrapassar 30 anos e deve ser positivo.");
            } else {
                return b;
            }
        }
    }

    public double definirTaxaJurosAnual(){
        while (true) {
            System.out.println("Digite a taxa do Juros anual (em % e positivo): ");
            Scanner s = new Scanner(System.in);
            int j = s.nextInt();
            if (j < 0 || j > 12) {
                System.out.println("O juros informado ultrapassa o valor maximo ou é negativo, por favor insira novamente.");
            } else {
                return j;
            }
        }
    }
}