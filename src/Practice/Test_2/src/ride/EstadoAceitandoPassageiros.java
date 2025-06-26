package ride;

/**
 * Estado: Aceitando Passageiros
 * Viagem pode receber novos passageiros
 */
public class EstadoAceitandoPassageiros implements RideState {
    
    @Override
    public void requestRide(Viagem viagem) {
        System.out.println("Viagem já foi solicitada e está aceitando passageiros.");
    }
    
    @Override
    public void cancelTrip(Viagem viagem) {
        System.out.println("Viagem cancelada pelo motorista.");
        viagem.setEstado(new EstadoCancelada());
    }
    
    @Override
    public void startTrip(Viagem viagem) {
        if (viagem.temPassageiros()) {
            System.out.println("Iniciando viagem com " + viagem.getPassageiros().size() + " passageiro(s).");
            viagem.setEstado(new EstadoEmAndamento());
        } else {
            System.out.println("Não é possível iniciar a viagem sem passageiros.");
        }
    }
    
    @Override
    public void completeTrip(Viagem viagem) {
        System.out.println("Não é possível concluir: viagem ainda não foi iniciada.");
    }
    
    @Override
    public void addPassenger(Viagem viagem, Usuario passageiro) {
        if (viagem.getAssentosDisponiveis() > 0) {
            viagem.adicionarPassageiroInterno(passageiro);
            System.out.println("Passageiro " + passageiro.getNome() + " adicionado à viagem.");
            
            if (viagem.estaLotada()) {
                System.out.println("Viagem lotada!");
                viagem.setEstado(new EstadoLotada());
            }
        } else {
            System.out.println("Não há assentos disponíveis.");
        }
    }
    
    @Override
    public void removePassenger(Viagem viagem, Usuario passageiro) {
        if (viagem.getPassageiros().contains(passageiro)) {
            viagem.removerPassageiroInterno(passageiro);
            System.out.println("Passageiro " + passageiro.getNome() + " removido da viagem.");
        } else {
            System.out.println("Passageiro não está nesta viagem.");
        }
    }
    
    @Override
    public String getStatus() {
        return "Aceitando passageiros";
    }
}
