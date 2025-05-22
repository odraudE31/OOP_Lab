package exercise1;
public class Mp3 extends Musica{
    String formato = "MP3";
    int tamanho_bytes;
    
    public Mp3(String titulo, String album, String compositor, String interprete, int ano, int tamanho_bytes){
        this.titulo = titulo;
        this.album = album;
        this.compositor = compositor;
        this.interprete = interprete;
        this.ano = ano;
        this.tamanho_bytes = tamanho_bytes;
    }

    public int getTamanho(){
        return tamanho_bytes;
    }

    public void mostraMusica(){
        System.out.println("Título: " + titulo +
                           " Álbum: " + album +
                           " Compositor: " + compositor +
                           " Intérprete: " + interprete +
                           " Ano: " + ano +
                           " Tamanho:" + tamanho_bytes + "bytes");
    }

}
