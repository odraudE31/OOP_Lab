package ride;

/**
 * Estado: Cancelada
 * Viagem cancelada pelo motorista
 */
public class EstadoCancelada implements RideState {
    
    @Override
    public void requestRide(Viagem viagem) {
        System.out.println("Viagem foi cancelada.");
    }
    
    @Override
    public void cancelTrip(Viagem viagem) {
        System.out.println("Viagem já está cancelada.");
    }
    
    @Override
    public void startTrip(Viagem viagem) {
        System.out.println("Não é possível iniciar: viagem foi cancelada.");
    }
    
    @Override
    public void completeTrip(Viagem viagem) {
        System.out.println("Não é possível concluir: viagem foi cancelada.");
    }
    
    @Override
    public void addPassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível adicionar passageiro: viagem cancelada.");
    }
    
    @Override
    public void removePassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível remover passageiro: viagem cancelada.");
    }
    
    @Override
    public String getStatus() {
        return "Cancelada";
    }
}
