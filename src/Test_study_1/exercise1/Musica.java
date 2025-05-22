package exercise1;
public abstract class Musica {
    String titulo;
    String album;
    String compositor;
    String interprete;
    String formato;
    int ano;

    public abstract void mostraMusica();

    public boolean pesquisaTitulo(String titulo){
        return titulo == this.titulo;
    }

    public boolean pesquisaCompositor(String compositor){
        return compositor == this.compositor;
    }

    public boolean pesquisaInterprete(String interprete){
        return interprete == this.interprete;
    }

    public boolean pesquisaPeriodo(int ano_inicio, int ano_fim){
        return (ano_inicio <= ano) && (ano <= ano_fim);
    }
}

    
