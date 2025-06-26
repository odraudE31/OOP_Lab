import java.util.ArrayList;

public class ClienteAssiduo extends Cliente {
    int cpf;
    int idade;
    String nome;
    Endereco endereco;
    String email;
    String telefone;
    ArrayList <IdentificadorIngresso> ingressos = new ArrayList<>();
    boolean assinatura;

    public ClienteAssiduo(int cpf, int idade, String nome, Endereco endereco, String email, String telefone, boolean assinatura) {
        super(cpf, idade, nome, endereco, email, telefone);
        this.assinatura = assinatura;
    }
}
