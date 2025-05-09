package vendas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancoDeVendasTest {

    @Test
    public void testVendaNacionalSP() {
        Venda venda = new VendaNacionalSP("001", "Produto SP", 100.0);
        assertEquals(12.0, venda.calcularImposto(), 0.001);
        assertEquals(10.0, venda.calcularFrete(), 0.001);
        assertEquals(78.0, venda.calcularReceitaLiquida(), 0.001);
    }

    @Test
    public void testVendaNacionalOutroEstado() {
        Venda venda = new VendaNacionalOutroEstado("002", "Produto Outro", 200.0);
        assertEquals(16.0, venda.calcularImposto(), 0.001);
        assertEquals(30.0, venda.calcularFrete(), 0.001);
        assertEquals(154.0, venda.calcularReceitaLiquida(), 0.001);
    }

    @Test
    public void testVendaExterior() {
        Venda venda = new VendaExterior("003", "Produto Exterior", 300.0);
        assertEquals(0.0, venda.calcularImposto(), 0.001);
        assertEquals(100.0, venda.calcularFrete(), 0.001);
        assertEquals(200.0, venda.calcularReceitaLiquida(), 0.001);
    }

    @Test
    public void testBalancoDeVendasTotais() {
        BalancoDeVendas balanco = new BalancoDeVendas();

        balanco.adicionarVenda(new VendaNacionalSP("001", "Produto A", 100.0));      // Imposto 12, Frete 10, Receita 78
        balanco.adicionarVenda(new VendaNacionalOutroEstado("002", "Produto B", 200.0)); // Imposto 16, Frete 30, Receita 154
        balanco.adicionarVenda(new VendaExterior("003", "Produto C", 300.0));        // Imposto 0, Frete 100, Receita 200

        assertEquals(28.0, balanco.calcularTotalImpostos(), 0.001);
        assertEquals(432.0, balanco.calcularReceitaLiquidaTotal(), 0.001);
    }
}
