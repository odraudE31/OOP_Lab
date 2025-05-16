import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SumPair {
    public static void main(String[] args) {
        Scanner leitor = null;
        PrintWriter escritor = null;

        String nomeArquivoEntrada = null;
        String nomeArquivoSaida = null;

        try {
            if (args.length < 1) {
                throw new NoArgsException();
            }

            nomeArquivoEntrada = args[0];

            if (args.length < 2) {
                System.out.println("[WARNING]: no entry file provided, printing in the terminal.");
            } else {
                nomeArquivoSaida = args[1];
                escritor = new PrintWriter(new FileWriter(nomeArquivoSaida));
            }

            leitor = new Scanner(new File(nomeArquivoEntrada));

            while (leitor.hasNextInt()) {
                int a = leitor.nextInt();

                if (!leitor.hasNextInt()) {
                    throw new OddNumberOfValuesException(a);
                }

                int b = leitor.nextInt();
                int soma = a + b;

                if (escritor != null) {
                    escritor.println(soma);
                } else {
                    System.out.println(soma);
                }
            }

        } 
        
        catch (NoArgsException e) {
            System.out.println("[ERROR]: " + e.getMessage());
            return;
        } 
        
        catch (OddNumberOfValuesException e) {
            System.out.println("[WARNING]: " + e.getMessage());
        } 
        
        catch (IOException e) {
            System.out.println("[ERROR]: " + e.getMessage());
        } 
        
        finally {
            if (leitor != null) leitor.close();
            if (escritor != null) escritor.close();
        }
    }
}
