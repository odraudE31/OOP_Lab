import java.util.Scanner;

import Conversor.Conversor;
import Conversor.ConversorFactory;

public class AppConversor {
    public static void main(String[] args) {
        Conversor conv; // Criaremos um conversor dependento das entradas e saídas.
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a unidade a ser convertida [F, C, K, M ou k]: ");
        char unidadeEntrada = sc.next().charAt(0);   
        System.out.print("Digite para qual unidade convertê-la [F, C, K, M ou k]: ");
        char unidadeSaída = sc.next().charAt(0);   
        System.out.print("Digite o valor de entrada (em " + unidadeEntrada + "): ");
        double tempEntrada = sc.nextDouble();
    
        sc.close();

        ConversorFactory fact =  ConversorFactory.getInstance();
        conv = fact.genConversor(unidadeEntrada, unidadeSaída);
        
        double tempSaída = conv.converte(tempEntrada);

        System.out.printf("%.2f%c -> %.2f%c\n", tempEntrada, unidadeEntrada, tempSaída, unidadeSaída);

    }
}
