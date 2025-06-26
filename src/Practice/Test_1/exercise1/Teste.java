package exercise1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Teste {

    @Test
    void testPesquisaPorTitulo() {
        Biblioteca biblioteca = new Biblioteca();
        Cd musica = new Cd("Imagine", "Imagine", "John Lennon", "John Lennon", 1971);
        biblioteca.addMusica(musica);

        assertTrue(biblioteca.pesquisadorTitulo("Imagine"));
        assertFalse(biblioteca.pesquisadorTitulo("Hey Jude"));
    }

    @Test
    void testPesquisaPorCompositor() {
        Biblioteca biblioteca = new Biblioteca();
        Cd musica = new Cd("Yesterday", "Help!", "Paul McCartney", "The Beatles", 1965);
        biblioteca.addMusica(musica);

        assertTrue(biblioteca.pesquisadorCompositor("Paul McCartney"));
        assertFalse(biblioteca.pesquisadorCompositor("John Lennon"));
    }

    @Test
    void testPesquisaPorInterprete() {
        Biblioteca biblioteca = new Biblioteca();
        Cd musica = new Cd("Thriller", "Thriller", "Rod Temperton", "Michael Jackson", 1982);
        biblioteca.addMusica(musica);

        assertTrue(biblioteca.pesquisadorInterprete("Michael Jackson"));
        assertFalse(biblioteca.pesquisadorInterprete("Queen"));
    }
}