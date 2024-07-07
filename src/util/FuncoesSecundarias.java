/**
 * @author Anthony.Amaz3d
 */

package util;

import java.io.*;
import java.util.ArrayList;

import modelo.Financiamento;


public class FuncoesSecundarias {
    public static void salvarTxt(ArrayList<Financiamento> financiamentos, String arquivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo)))) {
            for (Financiamento f : financiamentos) {
                escritor.write(f.toString());
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lerTxt(String arquivo) throws IOException {
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))){
            String linha = leitor.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = leitor.readLine();
            }
        } catch (EOFException e) {
            System.out.println("""
                    Fim do arquivo de leitura!

                    """);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarSerializado(ArrayList<Financiamento> financiamentos, String arquivo){
        try {
            ObjectOutputStream objeto = new ObjectOutputStream(new FileOutputStream(arquivo));

            objeto.writeObject(financiamentos);
            System.out.println("Dados que foram serializados salvo em "+ arquivo + "\n");

            objeto.flush();
            objeto.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> lerSerializado(String arquivo){
        ArrayList<Financiamento> financiamentosDesserializados = new ArrayList<>();

        try (ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(arquivo))) {
            financiamentosDesserializados = (ArrayList<Financiamento>) objeto.readObject();
            System.out.println("Dados desserializados: " + financiamentosDesserializados);
        } catch (EOFException e) {
            System.out.println("Fim do arquivo de leitura!");
        } catch ( IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return financiamentosDesserializados;
    }
}