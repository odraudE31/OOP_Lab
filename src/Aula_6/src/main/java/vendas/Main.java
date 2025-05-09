package vendas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BalancoDeVendas balanco = new BalancoDeVendas();

        System.out.print("Quantas vendas deseja registrar? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nVenda #" + (i + 1));
            System.out.print("Código do item: ");
            String codigo = sc.nextLine();
            System.out.print("Nome do item: ");
            String nome = sc.nextLine();
            System.out.print("Valor da venda: ");
            double valor = Double.parseDouble(sc.nextLine());

            System.out.print("Destino (SP [s]/ Outro [o]/ Exterior [e]): ");
            String destino = sc.nextLine().toLowerCase();

            Venda venda;
            if (destino.equals("s")) {
                venda = new VendaNacionalSP(codigo, nome, valor);
            } else if (destino.equals("o")) {
                venda = new VendaNacionalOutroEstado(codigo, nome, valor);
            } else {
                venda = new VendaExterior(codigo, nome, valor);
            }

            balanco.adicionarVenda(venda);
        }

        System.out.println("\n--- Relatório de Vendas ---");
        balanco.imprimirVendas();
        System.out.printf("\nTotal de imposto pago: R$%.2f\n", balanco.calcularTotalImpostos());
        System.out.printf("Receita líquida total: R$%.2f\n", balanco.calcularReceitaLiquidaTotal());

        sc.close();
    }
}
