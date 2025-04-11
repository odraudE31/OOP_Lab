import java.util.ArrayList;

public abstract class Conta {
    protected String agencia;
    protected String numero;
    protected double saldo;
    protected ArrayList<Cliente> titulares = new ArrayList<>();

    public Conta(String agencia, String numero, ArrayList<Cliente> titulares) {
        this.agencia = agencia;
        this.numero = numero;
        this.titulares = titulares;
        this.saldo = 0;
    }

    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    public abstract void transferir(Conta destino, double valor);

    public void exibirExtrato() {
        System.out.println("Agência: " + agencia);
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titulares:");
        for (Cliente c : titulares) {
            System.out.println("  - " + c.getNome());
        }
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Conta " + numero + " - Agência " + agencia + " - Saldo: R$ " + saldo;
    }

    public boolean mesmaTitularidade(Conta outra) {
        return this.titulares.equals(outra.titulares);
    }
}