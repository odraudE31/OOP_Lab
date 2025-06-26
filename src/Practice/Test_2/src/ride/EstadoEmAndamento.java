package ride;

/**
 * Estado: Em Andamento
 * Viagem já iniciada, não aceita novos passageiros nem cancelamentos
 */
public class EstadoEmAndamento implements RideState {
    
    @Override
    public void requestRide(Viagem viagem) {
        System.out.println("Não é possível solicitar: viagem já está em andamento.");
    }
    
    @Override
    public void cancelTrip(Viagem viagem) {
        System.out.println("Não é possível cancelar: viagem já está em andamento.");
    }
    
    @Override
    public void startTrip(Viagem viagem) {
        System.out.println("Viagem já está em andamento.");
    }
    
    @Override
    public void completeTrip(Viagem viagem) {
        System.out.println("Viagem concluída com sucesso!");
        viagem.calcularCobranca();
        viagem.setEstado(new EstadoConcluida());
    }
    
    @Override
    public void addPassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível adicionar passageiro: viagem em andamento.");
    }
    
    @Override
    public void removePassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível remover passageiro: viagem em andamento.");
    }
    
    @Override
    public String getStatus() {
        return "Em andamento";
    }
}
