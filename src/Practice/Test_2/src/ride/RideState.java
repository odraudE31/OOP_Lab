package ride;

/**
 * Interface para o padrão State
 * Define os comportamentos possíveis para uma viagem
 */
public interface RideState {
    void requestRide(Viagem viagem);
    void cancelTrip(Viagem viagem);
    void startTrip(Viagem viagem);
    void completeTrip(Viagem viagem);
    void addPassenger(Viagem viagem, Usuario passageiro);
    void removePassenger(Viagem viagem, Usuario passageiro);
    String getStatus();
}