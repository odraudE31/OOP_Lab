package vendas;

import java.util.ArrayList;
import java.util.List;

public class BalancoDeVendas {
    private List<Venda> vendas;

    public BalancoDeVendas() {
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void imprimirVendas() {
        for (Venda v : vendas) {
            System.out.println(v);
        }
    }

    public double calcularTotalImpostos() {
        double total = 0;
        for (Venda v : vendas) {
            total += v.calcularImposto();
        }
        return total;
    }

    public double calcularReceitaLiquidaTotal() {
        double total = 0;
        for (Venda v : vendas) {
            total += v.calcularReceitaLiquida();
        }
        return total;
    }
}

