package exercise1;
import java.util.ArrayList;

public class Biblioteca {
    ArrayList <Musica> musicas = new ArrayList<>();
    
    public void addMusica(Musica musica){
        musicas.add(musica);
    }

    public boolean mp3Tamanhos(){
        boolean achou = false;

        for(Musica musica : musicas){
            if(musica.formato == "Mp3"){
                musica.mostraMusica();
                achou = true;
            }
        }

        return achou;
    }

    public boolean pesquisadorTitulo(String titulo){
        boolean achou = false;

        for(Musica musica : musicas){
            if(musica.pesquisaTitulo(titulo)){
                musica.mostraMusica();
                achou = true;
            }
        }

        return achou;
    }

    public boolean pesquisadorCompositor(String compositor){
        boolean achou = false;

        for(Musica musica : musicas){
            if(musica.pesquisaCompositor(compositor)){
                musica.mostraMusica();
                achou = true;
            }
        }

        return achou;
    }

    public boolean pesquisadorInterprete(String interprete){
        boolean achou = false;

        for(Musica musica : musicas){
            if(musica.pesquisaInterprete(interprete)){
                musica.mostraMusica();
                achou = true;
            }
        }

        return achou;
    }

    public boolean pesquisadorPeriodo(int ano_inicio, int ano_fim){
        boolean achou = false;

        for(Musica musica : musicas){
            if(musica.pesquisaPeriodo(ano_inicio, ano_fim)){
                musica.mostraMusica();
                achou = true;
            }
        }

        return achou;
    }
}