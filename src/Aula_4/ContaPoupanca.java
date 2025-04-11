import java.util.ArrayList;

public class ContaPoupanca extends Conta {

    //constructor
    public ContaPoupanca(String agencia, String numero, ArrayList<Cliente> titulares) {
        super(agencia, numero, titulares);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor; //sem taxa
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor + 0.5; //pequena taxa
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (this.mesmaTitularidade(destino) && destino instanceof ContaCorrente) {
            saldo -= valor;
            destino.depositar(valor);
        } else {
            System.out.println("Transferência não permitida.");
        }
    }
}
