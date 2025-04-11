public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private Endereco endereco;
    private boolean especial;

    public Cliente(String nome, String cpf, String rg, Endereco endereco, boolean especial) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.especial = especial;
    }

    public boolean isEspecial() {
        return especial;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ", RG: " + rg + ", Tipo: " + (especial ? "Especial" : "Comum") + ")\nEndereco: " + endereco;
    }
}
