package Conversor;

import java.util.HashMap;
import java.util.Map;

public class ConversorFactory {
    private static ConversorFactory instance;
    private Map<String, Conversor> prototipos = new HashMap<>();

    private ConversorFactory() {
        // Registro inicial dos conversores
        registrarConversor("k->M", new ConversorKmParaMilha());
        registrarConversor("k->k", new ConversorIdentidade()); 

        registrarConversor("M->k", new ConversorMilhaParaKm());
        registrarConversor("M->M", new ConversorIdentidade());

        registrarConversor("C->F", new ConversorCelsiusParaFarenheit());
        registrarConversor("C->K", new ConversorCelsiusParaKelvin()); 
        registrarConversor("C->C", new ConversorIdentidade());

        registrarConversor("F->C", new ConversorFarenheitParaCelsius());
        registrarConversor("F->K", new ConversorFarenheitParaKelvin());
        registrarConversor("F->F", new ConversorIdentidade());

        registrarConversor("K->C", new ConversorKelvinParaCelsius());
        registrarConversor("K->F", new ConversorKelvinParaFarenheit());
        registrarConversor("K->K", new ConversorIdentidade());
    }

    public static synchronized ConversorFactory getInstance() {
        if (instance == null) {
            instance = new ConversorFactory();
        }
        return instance;
    }

    public void registrarConversor(String chave, Conversor conversor) {
        prototipos.put(chave, conversor);
    }

    public Conversor genConversor(char unidadeEntrada, char unidadeSaida) {
        String chave = unidadeEntrada + "->" + unidadeSaida;
        Conversor prototipo = prototipos.get(chave);
        if (prototipo == null) {
            throw new UnsupportedOperationException("Conversão " + chave + " não suportada.");
        }
        return prototipo.clone();
    }
}
