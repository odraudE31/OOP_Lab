public class Evento{
    int codigoIdentificacao;
    String descricao;
    String dataHora;
    String local;
    int ingressosDisponiveis;
    float valorBaseIngresso;
    int idadeMinimaEntrada;
    
    public Evento(int codigoIdentificacao, String descricao, String dataHora, String local, int ingressosDisponiveis,
            float valorBaseIngresso, int idadeMinimaEntrada) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
        this.ingressosDisponiveis = ingressosDisponiveis;
        this.valorBaseIngresso = valorBaseIngresso;
        this.idadeMinimaEntrada = idadeMinimaEntrada;
    }
}