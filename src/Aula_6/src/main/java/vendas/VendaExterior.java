package vendas;

public class VendaExterior extends Venda {

    public VendaExterior(String codigoItem, String nomeItem, double valorVenda) {
        super(codigoItem, nomeItem, valorVenda);
    }

    @Override
    public double calcularImposto() {
        return 0.0;
    }

    @Override
    public double calcularFrete() {
        return 100.0;
    }
}

