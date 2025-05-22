import java.util.ArrayList;

public class Cliente {
    int cpf;
    int idade;
    String nome;
    Endereco endereco;
    String email;
    String telefone;
    ArrayList <IdentificadorIngresso> ingressos = new ArrayList<>();
    boolean assinatura = false;

    public Cliente(int cpf, int idade, String nome, Endereco endereco, String email, String telefone) {
        this.cpf = cpf;
        this.idade = idade;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
}
