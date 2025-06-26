package ride;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sistema principal de gerenciamento de caronas
 * Implementa o padrão Singleton
 */
public class SistemaCaronas {
    private static SistemaCaronas instancia;
    private List<Usuario> usuarios;
    private List<Viagem> viagens;
    
    private SistemaCaronas() {
        this.usuarios = new ArrayList<>();
        this.viagens = new ArrayList<>();
    }
    
    /**
     * Método para obter a instância única (Singleton)
     */
    public static SistemaCaronas getInstance() {
        if (instancia == null) {
            instancia = new SistemaCaronas();
        }
        return instancia;
    }
    
    // Gerenciamento de usuários
    public void cadastrarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
            System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso.");
        } else {
            System.out.println("Usuário já está cadastrado.");
        }
    }
    
    public Usuario buscarUsuario(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    // Gerenciamento de viagens
    public void cadastrarViagem(Viagem viagem) {
        viagens.add(viagem);
        System.out.println("Viagem " + viagem.getId() + " cadastrada com sucesso.");
    }
    
    public List<Viagem> buscarViagens(String origem, String destino) {
        return viagens.stream()
                .filter(v -> v.getCidadeOrigem().equalsIgnoreCase(origem) && 
                           v.getCidadeDestino().equalsIgnoreCase(destino))
                .filter(v -> v.getEstado().equals("Aceitando passageiros") || 
                           v.getEstado().equals("Lotada"))
                .collect(Collectors.toList());
    }
    
    public Viagem buscarViagem(String id) {
        return viagens.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    // Funcionalidades principais
    public void solicitarCarona(String usuarioId, String origem, String destino) {
        Usuario usuario = buscarUsuario(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        
        List<Viagem> viagensDisponiveis = buscarViagens(origem, destino);
        if (viagensDisponiveis.isEmpty()) {
            System.out.println("Nenhuma viagem disponível para este percurso.");
            return;
        }
        
        Viagem viagemEscolhida = usuario.selecionarViagem(viagensDisponiveis);
        if (viagemEscolhida != null) {
            viagemEscolhida.adicionarPassageiro(usuario);
        }
    }
    
    public void cancelarParticipacao(String usuarioId, String viagemId) {
        Usuario usuario = buscarUsuario(usuarioId);
        Viagem viagem = buscarViagem(viagemId);
        
        if (usuario == null || viagem == null) {
            System.out.println("Usuário ou viagem não encontrados.");
            return;
        }
        
        viagem.removerPassageiro(usuario);
    }
    
    // Relatórios
    public void gerarRelatorioViagem(String viagemId) {
        Viagem viagem = buscarViagem(viagemId);
        if (viagem == null) {
            System.out.println("Viagem não encontrada.");
            return;
        }
        
        System.out.println("\n=== RELATÓRIO DA VIAGEM ===");
        System.out.println("ID: " + viagem.getId());
        System.out.println("Percurso: " + viagem.getCidadeOrigem() + " → " + viagem.getCidadeDestino());
        System.out.println("Motorista: " + viagem.getMotorista().getNome());
        System.out.println("Estado: " + viagem.getEstado());
        System.out.println("Assentos: " + (viagem.getAssentosMaximos() - viagem.getAssentosDisponiveis()) + 
                          "/" + viagem.getAssentosMaximos());
        System.out.println("Valor por passageiro: R$ " + String.format("%.2f", viagem.getValorPorPassageiro()));
        
        System.out.println("Passageiros:");
        if (viagem.getPassageiros().isEmpty()) {
            System.out.println("  Nenhum passageiro");
        } else {
            for (Usuario passageiro : viagem.getPassageiros()) {
                System.out.println("  - " + passageiro.getNome() + " (" + passageiro.getId() + ")");
            }
        }
        
        if (viagem.getEstado().equals("Concluída")) {
            System.out.println("Valor total cobrado: R$ " + String.format("%.2f", viagem.getValorTotal()));
        }
        System.out.println("========================\n");
    }
    
    public void gerarRelatorioSistema() {
        System.out.println("\n=== RELATÓRIO DO SISTEMA ===");
        System.out.println("Total de usuários: " + usuarios.size());
        
        long viagensConcluidas = viagens.stream()
                .filter(v -> v.getEstado().equals("Concluída"))
                .count();
        System.out.println("Total de viagens concluídas: " + viagensConcluidas);
        
        double totalMovimentado = viagens.stream()
                .filter(v -> v.getEstado().equals("Concluída"))
                .mapToDouble(Viagem::getValorTotal)
                .sum();
        System.out.println("Total movimentado: R$ " + String.format("%.2f", totalMovimentado));
        
        System.out.println("\nViagens por estado:");
        viagens.stream()
                .collect(Collectors.groupingBy(Viagem::getEstado, Collectors.counting()))
                .forEach((estado, quantidade) -> 
                    System.out.println("  " + estado + ": " + quantidade));
        System.out.println("==========================\n");
    }
    
    // Getters para acesso aos dados
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
    
    public List<Viagem> getViagens() {
        return new ArrayList<>(viagens);
    }
}
