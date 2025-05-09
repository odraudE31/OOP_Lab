package vendas;

public class VendaNacionalSP extends Venda {

    public VendaNacionalSP(String codigoItem, String nomeItem, double valorVenda) {
        super(codigoItem, nomeItem, valorVenda);
    }

    @Override
    public double calcularImposto() {
        return valorVenda * 0.12;
    }

    @Override
    public double calcularFrete() {
        return 10.0;
    }
}
