package util;

import java.util.Objects;
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
            double j = s.nextDouble();
            if (j < 0 || j > 12) {
                System.out.println("O juros informado ultrapassa o valor maximo ou é negativo, por favor insira novamente.");
            } else {
                return j;
            }
        }
    }

    public double definirAreaConstruida() {
        while (true) {
            System.out.println("Digite a área construída da casa: (apenas valores positivos) ");
            Scanner s = new Scanner(System.in);
            double a = s.nextDouble();
            if (a < 0) {
                System.out.println("A área construída deve ser positiva, por favor insira novamente.");
            } else {
                return a;
            }
        }
    }

    public double definirAreaTerreno() {
        while (true) {
            System.out.println("Digite a área total do terreno da casa: (apenas valores positivos) ");
            Scanner s = new Scanner(System.in);
            double a = s.nextDouble();
            if (a < 0) {
                System.out.println("A área do terreno deve ser positivo, por favor insira novamente.");
            } else {
                return a;
            }
        }
    }

    public int definirTotalVagas() {
        while (true) {
            System.out.println("Digite o número total de vagas: (apenas valores positivos) ");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            if (n < 0 || n > 100) {
                System.out.println("Número de vagas muito grande ou negativo, insira novamente.");
            } else {
                return n;
            }
        }
    }

    public int definirAndarApartamento() {
        while (true) {
            System.out.println("Digite o andar do Apartamento (apenas valores positivos) ");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            if (n < 0 || n > 100) {
                System.out.println("Valor negativo ou número do andar muito grande, insira novamente.");
            } else {
                return n;
            }
        }
    }

    public String definirZona() {
        while (true) {
            System.out.println("Digite o tipo de zona que o terreno se encontra: (residencial ou comercial)");
            Scanner s = new Scanner(System.in);
            String z = s.nextLine();
            String r = "residencial";
            String c = "comercial";
            if (r.equalsIgnoreCase(z) || c.equalsIgnoreCase(z)) {
                return z;
            } else {
                System.out.println("Valor digitado não é o esperado, digite novamente: ");
            }
        }
    }
}