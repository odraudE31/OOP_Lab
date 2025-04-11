import java.util.ArrayList;

public class ContaCorrente extends Conta {
    public ContaCorrente(String agencia, String numero, ArrayList<Cliente> titulares) {
        super(agencia, numero, titulares);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor - 0.5; // taxa de R$0.50
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor + 1.0; // taxa de R$1.00
    }

    @Override
    public void transferir(Conta destino, double valor) {
        saldo -= valor + 2.0; // taxa de R$2.00
        destino.depositar(valor);
    }
}