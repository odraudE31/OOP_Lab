package exercise1;
public class Cd extends Musica {

    public Cd(String titulo, String album, String compositor, String interprete, int ano){
        this.titulo = titulo;
        this.album = album;
        this.compositor = compositor;
        this.interprete = interprete;
        this.ano = ano;
    }

    public void mostraMusica(){
        System.out.println("Título: " + titulo +
                           " Álbum: " + album +
                           " Compositor: " + compositor +
                           " Intérprete: " + interprete +
                           " Ano: " + ano);
    }

}
