public class Endereco {
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    //constructor
    public Endereco(String logradouro, int numero, String complemento, String cep, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero + (complemento.isEmpty() ? "" : ", " + complemento) +
                ", " + cidade + " - " + estado + ", CEP: " + cep;
    }
}