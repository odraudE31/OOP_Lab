package ride;

import java.time.LocalDateTime;

/**
 * Classe de demonstração do sistema de caronas
 * Mostra todos os padrões implementados em ação
 */
public class DemoSistemaCaronas {
    
    public static void main(String[] args) {
        System.out.println("=== DEMO SISTEMA DE CARONAS ===\n");
        
        // Obter instância do sistema (Singleton)
        SistemaCaronas sistema = SistemaCaronas.getInstance();
        
        // Criar usuários
        Usuario joao = new Usuario("U001", "João Silva", "joao@email.com", "11999887766");
        Usuario maria = new Usuario("U002", "Maria Santos", "maria@email.com", "11998776655");
        Usuario pedro = new Usuario("U003", "Pedro Costa", "pedro@email.com", "11997665544");
        Usuario ana = new Usuario("U004", "Ana Oliveira", "ana@email.com", "11996554433");
        
        // Cadastrar usuários
        sistema.cadastrarUsuario(joao);
        sistema.cadastrarUsuario(maria);
        sistema.cadastrarUsuario(pedro);
        sistema.cadastrarUsuario(ana);
        
        // Criar viagens
        Viagem viagem1 = new Viagem("V001", joao, "São Paulo", "Rio de Janeiro", 
                                   3, 150.0, LocalDateTime.now().plusDays(1));
        Viagem viagem2 = new Viagem("V002", maria, "São Paulo", "Rio de Janeiro", 
                                   2, 120.0, LocalDateTime.now().plusDays(2));
        Viagem viagem3 = new Viagem("V003", pedro, "São Paulo", "Campinas", 
                                   4, 50.0, LocalDateTime.now().plusHours(3));
        
        // Cadastrar viagens
        sistema.cadastrarViagem(viagem1);
        sistema.cadastrarViagem(viagem2);
        sistema.cadastrarViagem(viagem3);
        
        System.out.println("\n1. TESTANDO PADRÃO STATE - Adicionando passageiros");
        System.out.println("=".repeat(50));
        
        // Testar estado "Aceitando passageiros"
        viagem1.adicionarPassageiro(maria);
        viagem1.adicionarPassageiro(pedro);
        
        // Testar estado "Lotada"
        viagem1.adicionarPassageiro(ana); // Vai para estado lotada
        
        // Tentar adicionar mais um (deve falhar)
        Usuario carlos = new Usuario("U005", "Carlos Lima", "carlos@email.com", "11995443322");
        sistema.cadastrarUsuario(carlos);
        viagem1.adicionarPassageiro(carlos);
        
        System.out.println("\n2. TESTANDO TRANSIÇÕES DE ESTADO");
        System.out.println("=".repeat(50));
        
        // Iniciar viagem (Lotada -> Em andamento)
        viagem1.iniciarViagem();
        
        // Tentar adicionar passageiro em viagem em andamento
        viagem1.adicionarPassageiro(carlos);
        
        // Concluir viagem (Em andamento -> Concluída)
        viagem1.concluirViagem();
        
        System.out.println("\n3. TESTANDO PADRÃO STRATEGY - Seleção de viagens");
        System.out.println("=".repeat(50));
        
        // Ana vai procurar uma viagem SP -> RJ
        System.out.println("Ana procurando viagem São Paulo -> Rio de Janeiro");
        
        // Usando estratégia padrão (mais barata)
        System.out.println("\nUsando estratégia: Mais barata");
        sistema.solicitarCarona("U004", "São Paulo", "Rio de Janeiro");
        
        // Mudando estratégia para mais cedo
        ana.setStrategy(new EarliestTripStrategy());
        System.out.println("\nMudando para estratégia: Mais cedo");
        sistema.solicitarCarona("U004", "São Paulo", "Rio de Janeiro");
        
        // Mudando estratégia para mais assentos
        ana.setStrategy(new MostAvailableSeatsStrategy());
        System.out.println("\nMudando para estratégia: Mais assentos disponíveis");
        sistema.solicitarCarona("U004", "São Paulo", "Rio de Janeiro");
        
        System.out.println("\n4. TESTANDO CANCELAMENTOS");
        System.out.println("=".repeat(50));
        
        // Cancelar participação de passageiro
        sistema.cancelarParticipacao("U004", "V002");
        
        // Cancelar viagem inteira
        viagem2.cancelarViagem();
        
        // Tentar adicionar passageiro em viagem cancelada
        viagem2.adicionarPassageiro(carlos);
        
        System.out.println("\n5. TESTANDO PADRÃO SINGLETON - Múltiplas instâncias");
        System.out.println("=".repeat(50));
        
        SistemaCaronas sistema2 = SistemaCaronas.getInstance();
        System.out.println("Sistema1 == Sistema2: " + (sistema == sistema2));
        System.out.println("Usuários no sistema2: " + sistema2.getUsuarios().size());
        
        System.out.println("\n6. RELATÓRIOS");
        System.out.println("=".repeat(50));
        
        // Relatório de viagem específica
        sistema.gerarRelatorioViagem("V001");
        sistema.gerarRelatorioViagem("V002");
        
        // Relatório geral do sistema
        sistema.gerarRelatorioSistema();
        
        System.out.println("\n7. TESTANDO CICLO COMPLETO DE VIAGEM");
        System.out.println("=".repeat(50));
        
        // Iniciar e concluir viagem3
        viagem3.adicionarPassageiro(carlos);
        viagem3.iniciarViagem();
        viagem3.concluirViagem();
        
        // Relatório final
        sistema.gerarRelatorioViagem("V003");
        sistema.gerarRelatorioSistema();
        
        System.out.println("=== FIM DA DEMONSTRAÇÃO ===");
    }
}
