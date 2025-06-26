package ride;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 * Representa uma viagem no sistema de caronas
 * Implementa o padrão State para gerenciar estados
 */
public class Viagem {
    private String id;
    private Usuario motorista;
    private String cidadeOrigem;
    private String cidadeDestino;
    private int assentosDisponiveis;
    private int assentosMaximos;
    private double valorPorPassageiro;
    private LocalDateTime dataPartida;
    private List<Usuario> passageiros;
    private RideState estadoAtual;
    private double valorTotal;
    
    public Viagem(String id, Usuario motorista, String cidadeOrigem, 
                  String cidadeDestino, int assentosMaximos, double valorPorPassageiro,
                  LocalDateTime dataPartida) {
        this.id = id;
        this.motorista = motorista;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.assentosMaximos = assentosMaximos;
        this.assentosDisponiveis = assentosMaximos;
        this.valorPorPassageiro = valorPorPassageiro;
        this.dataPartida = dataPartida;
        this.passageiros = new ArrayList<>();
        this.estadoAtual = new EstadoAceitandoPassageiros();
        this.valorTotal = 0.0;
    }
    
    // Métodos delegados para o estado
    public void iniciarViagem() {
        estadoAtual.startTrip(this);
    }
    
    public void cancelarViagem() {
        estadoAtual.cancelTrip(this);
    }
    
    public void concluirViagem() {
        estadoAtual.completeTrip(this);
    }
    
    public void adicionarPassageiro(Usuario passageiro) {
        estadoAtual.addPassenger(this, passageiro);
    }
    
    public void removerPassageiro(Usuario passageiro) {
        estadoAtual.removePassenger(this, passageiro);
    }
    
    // Métodos internos para manipulação do estado
    public void setEstado(RideState novoEstado) {
        this.estadoAtual = novoEstado;
    }
    
    public void adicionarPassageiroInterno(Usuario passageiro) {
        if (!passageiros.contains(passageiro) && assentosDisponiveis > 0) {
            passageiros.add(passageiro);
            assentosDisponiveis--;
        }
    }
    
    public void removerPassageiroInterno(Usuario passageiro) {
        if (passageiros.remove(passageiro)) {
            assentosDisponiveis++;
        }
    }
    
    public boolean estaLotada() {
        return assentosDisponiveis == 0;
    }
    
    public boolean temPassageiros() {
        return !passageiros.isEmpty();
    }
    
    public void calcularCobranca() {
        this.valorTotal = passageiros.size() * valorPorPassageiro;
    }
    
    // Getters e Setters
    public String getId() { return id; }
    public Usuario getMotorista() { return motorista; }
    public String getCidadeOrigem() { return cidadeOrigem; }
    public String getCidadeDestino() { return cidadeDestino; }
    public int getAssentosDisponiveis() { return assentosDisponiveis; }
    public int getAssentosMaximos() { return assentosMaximos; }
    public double getValorPorPassageiro() { return valorPorPassageiro; }
    public LocalDateTime getDataPartida() { return dataPartida; }
    public List<Usuario> getPassageiros() { return new ArrayList<>(passageiros); }
    public String getEstado() { return estadoAtual.getStatus(); }
    public double getValorTotal() { return valorTotal; }
    
    @Override
    public String toString() {
        return String.format("Viagem{id='%s', %s->%s, assentos=%d/%d, valor=%.2f, estado='%s'}", 
                           id, cidadeOrigem, cidadeDestino, 
                           assentosMaximos - assentosDisponiveis, assentosMaximos, 
                           valorPorPassageiro, getEstado());
    }
}
