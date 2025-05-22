package exercise1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca vibeAnos90 = new Biblioteca();

        vibeAnos90.addMusica(new Cd("Smells Like Teen Spirit", "Nevermind", "Kurt Cobain", "Nirvana", 1991));
        vibeAnos90.addMusica(new Mp3("Wonderwall", "What's the Story Morning Glory?", "Noel Gallagher", "Oasis", 1995, 4000000));
        vibeAnos90.addMusica(new Lp("Losing My Religion", "Out of Time", "Bill Berry", "R.E.M.", 1991, 33));
        vibeAnos90.addMusica(new Cd("Enter Sandman", "Metallica", "James Hetfield", "Metallica", 1991));
        vibeAnos90.addMusica(new Mp3("Black or White", "Dangerous", "Michael Jackson", "Michael Jackson", 1991, 3500000));
        vibeAnos90.addMusica(new Lp("My Heart Will Go On", "Let's Talk About Love", "James Horner", "Celine Dion", 1997, 45));
        vibeAnos90.addMusica(new Cd("I Will Always Love You", "The Bodyguard", "Dolly Parton", "Whitney Houston", 1992));
        vibeAnos90.addMusica(new Mp3("Creep", "Pablo Honey", "Radiohead", "Radiohead", 1992, 3200000));
        vibeAnos90.addMusica(new Lp("No Scrubs", "FanMail", "Kandi Burruss", "TLC", 1999, 33));
        vibeAnos90.addMusica(new Cd("Basket Case", "Dookie", "Billie Joe Armstrong", "Green Day", 1994));
        vibeAnos90.addMusica(new Cd("Bohemian Rhapsody", "A Night at the Opera", "Freddie Mercury", "Queen", 1975));
        vibeAnos90.addMusica(new Mp3("Shape of You", "Divide", "Ed Sheeran", "Ed Sheeran", 2017, 5000000));
        vibeAnos90.addMusica(new Lp("Billie Jean", "Thriller", "Michael Jackson", "Michael Jackson", 1982, 45));

        System.out.println("Músicas dos anos 90:");
        vibeAnos90.pesquisadorPeriodo(1990, 1999);

        System.out.println("\nPesquisa por intérprete 'Michael Jackson':");
        vibeAnos90.pesquisadorInterprete("Michael Jackson");

        System.out.println("\nPesquisa por título 'Creep':");
        vibeAnos90.pesquisadorTitulo("Creep");
    }
}