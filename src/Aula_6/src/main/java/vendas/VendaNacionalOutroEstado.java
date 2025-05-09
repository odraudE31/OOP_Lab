package vendas;
public class VendaNacionalOutroEstado extends Venda {

    public VendaNacionalOutroEstado(String codigoItem, String nomeItem, double valorVenda) {
        super(codigoItem, nomeItem, valorVenda);
    }

    @Override
    public double calcularImposto() {
        return valorVenda * 0.08;
    }

    @Override
    public double calcularFrete() {
        return 30.0;
    }
}
