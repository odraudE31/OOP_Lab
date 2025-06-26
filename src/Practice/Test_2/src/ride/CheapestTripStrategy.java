package ride;

import java.util.List;

/**
 * Estratégia: Seleciona a viagem mais barata
 */
public class CheapestTripStrategy implements TripSelectionStrategy {
    
    @Override
    public Viagem selectTrip(List<Viagem> viagens) {
        if (viagens == null || viagens.isEmpty()) {
            return null;
        }
        
        Viagem maisBarata = viagens.get(0);
        for (Viagem viagem : viagens) {
            if (viagem.getValorPorPassageiro() < maisBarata.getValorPorPassageiro()) {
                maisBarata = viagem;
            }
        }
        return maisBarata;
    }
}
