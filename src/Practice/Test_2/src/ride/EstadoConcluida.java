package ride;

/**
 * Estado: Concluída
 * Viagem finalizada, gera cobranças
 */
public class EstadoConcluida implements RideState {
    
    @Override
    public void requestRide(Viagem viagem) {
        System.out.println("Viagem já foi concluída.");
    }
    
    @Override
    public void cancelTrip(Viagem viagem) {
        System.out.println("Não é possível cancelar: viagem já foi concluída.");
    }
    
    @Override
    public void startTrip(Viagem viagem) {
        System.out.println("Viagem já foi concluída.");
    }
    
    @Override
    public void completeTrip(Viagem viagem) {
        System.out.println("Viagem já está concluída.");
    }
    
    @Override
    public void addPassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível adicionar passageiro: viagem concluída.");
    }
    
    @Override
    public void removePassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível remover passageiro: viagem concluída.");
    }
    
    @Override
    public String getStatus() {
        return "Concluída";
    }
}
