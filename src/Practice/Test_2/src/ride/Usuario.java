package ride;

/**
 * Representa um usuário do sistema de caronas
 */
public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private TripSelectionStrategy strategy;
    
    public Usuario(String id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.strategy = new CheapestTripStrategy(); // estratégia padrão
    }
    
    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    public TripSelectionStrategy getStrategy() { return strategy; }
    public void setStrategy(TripSelectionStrategy strategy) { this.strategy = strategy; }
    
    /**
     * Seleciona uma viagem usando a estratégia definida
     */
    public Viagem selecionarViagem(java.util.List<Viagem> viagens) {
        return strategy.selectTrip(viagens);
    }
    
    @Override
    public String toString() {
        return "Usuario{id='" + id + "', nome='" + nome + "'}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id.equals(usuario.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
