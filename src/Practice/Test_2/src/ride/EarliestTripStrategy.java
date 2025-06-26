package ride;

import java.util.List;

/**
 * Estratégia: Seleciona a viagem com partida mais cedo
 */
public class EarliestTripStrategy implements TripSelectionStrategy {
    
    @Override
    public Viagem selectTrip(List<Viagem> viagens) {
        if (viagens == null || viagens.isEmpty()) {
            return null;
        }
        
        Viagem maisCedo = viagens.get(0);
        for (Viagem viagem : viagens) {
            if (viagem.getDataPartida().isBefore(maisCedo.getDataPartida())) {
                maisCedo = viagem;
            }
        }
        return maisCedo;
    }
}
