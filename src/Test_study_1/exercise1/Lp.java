package exercise1;
public class Lp extends Musica {
    int velocidade;

    public Lp(String titulo, String album, String compositor, String interprete, int ano, int velocidade){
        this.titulo = titulo;
        this.album = album;
        this.compositor = compositor;
        this.interprete = interprete;
        this.ano = ano;
        this.velocidade = velocidade;
    }

    public void mostraMusica(){
        System.out.println("Título: " + titulo +
                           " Álbum: " + album +
                           " Compositor: " + compositor +
                           " Intérprete: " + interprete +
                           " Ano: " + ano +
                           " Velocidade: " + velocidade + "rpm");
    }
}
