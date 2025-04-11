import java.util.*;

public class Main {
    public static void main(String[] args) {
        Endereco enderecoCasal = new Endereco("Rua das Flores", 123, "Ap 45", "12345-678", "São Paulo", "SP");
        Cliente cliente1 = new Cliente("João Silva", "111.111.111-11", "MG-11.111.111", enderecoCasal, false);
        Cliente cliente2 = new Cliente("Maria Silva", "222.222.222-22", "MG-22.222.222", enderecoCasal, false);
        Cliente cliente3 = new Cliente("Carlos Souza", "333.333.333-33", "MG-33.333.333", new Endereco("Av. Central", 456, "", "87654-321", "Belo Horizonte", "MG"), true);

        ArrayList<Cliente> casal = new ArrayList<>(Arrays.asList(cliente1, cliente2));
        ArrayList<Cliente> individual1 = new ArrayList<>(Collections.singletonList(cliente1));
        ArrayList<Cliente> individual3 = new ArrayList<>(Collections.singletonList(cliente3));

        Conta contaConjunta = new ContaCorrente("001", "0001", casal);
        Conta contaPoupanca = new ContaPoupanca("001", "0002", individual1);
        Conta contaPreferencial = new ContaPreferencial("001", "0003", individual3);

        ArrayList<Conta> contas = new ArrayList<>(Arrays.asList(contaConjunta, contaPoupanca, contaPreferencial));

        contaConjunta.depositar(1000);
        contaConjunta.exibirExtrato();

        contaConjunta.transferir(contaPoupanca, 300);
        contaPoupanca.exibirExtrato();
        contaConjunta.exibirExtrato();

        contaPoupanca.sacar(100);
        contaPoupanca.exibirExtrato();

        contaPreferencial.depositar(60000);
        contaPreferencial.exibirExtrato();

        contaPreferencial.transferir(contaConjunta, 10000);
        contaConjunta.exibirExtrato();
        contaPreferencial.exibirExtrato();
    }
}
