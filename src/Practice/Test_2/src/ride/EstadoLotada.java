package ride;

/**
 * Estado: Lotada
 * Viagem com todos os assentos ocupados, mas ainda não iniciada
 */
public class EstadoLotada implements RideState {
    
    @Override
    public void requestRide(Viagem viagem) {
        System.out.println("Viagem já está lotada.");
    }
    
    @Override
    public void cancelTrip(Viagem viagem) {
        System.out.println("Viagem cancelada pelo motorista.");
        viagem.setEstado(new EstadoCancelada());
    }
    
    @Override
    public void startTrip(Viagem viagem) {
        System.out.println("Iniciando viagem lotada com " + viagem.getPassageiros().size() + " passageiros.");
        viagem.setEstado(new EstadoEmAndamento());
    }
    
    @Override
    public void completeTrip(Viagem viagem) {
        System.out.println("Não é possível concluir: viagem ainda não foi iniciada.");
    }
    
    @Override
    public void addPassenger(Viagem viagem, Usuario passageiro) {
        System.out.println("Não é possível adicionar passageiro: viagem está lotada.");
    }
    
    @Override
    public void removePassenger(Viagem viagem, Usuario passageiro) {
        if (viagem.getPassageiros().contains(passageiro)) {
            viagem.removerPassageiroInterno(passageiro);
            System.out.println("Passageiro " + passageiro.getNome() + " removido da viagem.");
            // Volta para estado aceitando passageiros
            viagem.setEstado(new EstadoAceitandoPassageiros());
        } else {
            System.out.println("Passageiro não está nesta viagem.");
        }
    }
    
    @Override
    public String getStatus() {
        return "Lotada";
    }
}
