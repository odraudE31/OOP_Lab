import java.util.ArrayList;

public class ContaPreferencial extends Conta {
    public ContaPreferencial(String agencia, String numero, ArrayList<Cliente> titulares) {
        super(agencia, numero, titulares);
        for (Cliente c : titulares) {
            if (!c.isEspecial()) {
                throw new IllegalArgumentException("Todos os titulares devem ser clientes especiais.");
            }
        }
    }

    @Override
    public void depositar(double valor) {
        double taxa = saldo > 50000 ? 0.1 : 0.5;
        saldo += valor - taxa;
    }

    @Override
    public void sacar(double valor) {
        double taxa = saldo > 50000 ? 0.5 : 2.0;
        saldo -= valor + taxa;
    }

    @Override
    public void transferir(Conta destino, double valor) {
        double taxa = saldo > 50000 ? 1.0 : 3.0;
        saldo -= valor + taxa;
        destino.depositar(valor);
    }
}
