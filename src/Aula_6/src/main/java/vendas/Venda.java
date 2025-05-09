package vendas;


public abstract class Venda {
    protected String codigoItem;
    protected String nomeItem;
    protected double valorVenda;

    public Venda(String codigoItem, String nomeItem, double valorVenda) {
        this.codigoItem = codigoItem;
        this.nomeItem = nomeItem;
        this.valorVenda = valorVenda;
    }

    public abstract double calcularImposto();

    public abstract double calcularFrete();

    public double calcularReceitaLiquida() {
        return valorVenda - calcularImposto() - calcularFrete();
    }

    public String toString() {
        return String.format("Item: %s | Código: %s | Valor: R$%.2f | Imposto: R$%.2f | Frete: R$%.2f | Receita líquida: R$%.2f",
                nomeItem, codigoItem, valorVenda, calcularImposto(), calcularFrete(), calcularReceitaLiquida());
    }
}
