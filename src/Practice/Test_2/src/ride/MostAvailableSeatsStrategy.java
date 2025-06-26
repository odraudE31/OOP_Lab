package ride;

import java.util.List;

/**
 * Estratégia: Seleciona a viagem com mais assentos disponíveis
 */
public class MostAvailableSeatsStrategy implements TripSelectionStrategy {
    
    @Override
    public Viagem selectTrip(List<Viagem> viagens) {
        if (viagens == null || viagens.isEmpty()) {
            return null;
        }
        
        Viagem maisAssentos = viagens.get(0);
        for (Viagem viagem : viagens) {
            if (viagem.getAssentosDisponiveis() > maisAssentos.getAssentosDisponiveis()) {
                maisAssentos = viagem;
            }
        }
        return maisAssentos;
    }
}
