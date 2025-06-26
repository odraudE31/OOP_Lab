package ride;

import java.util.List;

/**
 * Interface para o padrão Strategy
 * Define estratégias de seleção de viagens
 */
public interface TripSelectionStrategy {
    Viagem selectTrip(List<Viagem> viagens);
}
