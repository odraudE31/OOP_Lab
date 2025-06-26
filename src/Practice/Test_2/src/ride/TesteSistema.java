package ride;

import java.time.LocalDateTime;

/**
 * Classe de testes unitários para verificar funcionamento
 */
public class TesteSistema {
    
    public static void main(String[] args) {
        System.out.println("=== EXECUTANDO TESTES DO SISTEMA ===\n");
        
        boolean todosTestesPassaram = true;
        
        // Teste 1: Singleton
        todosTestesPassaram &= testeSingleton();
        
        // Teste 2: Estados
        todosTestesPassaram &= testeEstados();
        
        // Teste 3: Estratégias
        todosTestesPassaram &= testeEstrategias();
        
        // Teste 4: Sistema completo
        todosTestesPassaram &= testeSistemaCompleto();
        
        System.out.println("\n=== RESULTADO DOS TESTES ===");
        if (todosTestesPassaram) {
            System.out.println("✅ TODOS OS TESTES PASSARAM!");
        } else {
            System.out.println("❌ ALGUNS TESTES FALHARAM!");
        }
    }
    
    private static boolean testeSingleton() {
        System.out.println("Teste 1: Padrão Singleton");
        
        SistemaCaronas s1 = SistemaCaronas.getInstance();
        SistemaCaronas s2 = SistemaCaronas.getInstance();
        
        boolean passou = (s1 == s2);
        System.out.println(passou ? "✅ Singleton OK" : "❌ Singleton FALHOU");
        System.out.println();
        
        return passou;
    }
    
    private static boolean testeEstados() {
        System.out.println("Teste 2: Padrão State");
        
        Usuario motorista = new Usuario("M001", "Motorista Teste", "m@test.com", "11111111");
        Usuario p1 = new Usuario("P001", "Passageiro 1", "p1@test.com", "22222222");
        Usuario p2 = new Usuario("P002", "Passageiro 2", "p2@test.com", "33333333");
        
        Viagem viagem = new Viagem("TEST001", motorista, "São Paulo", "Rio de Janeiro", 
                                 2, 100.0, LocalDateTime.now().plusDays(1));
        
        // Estado inicial: Aceitando passageiros
        boolean teste1 = viagem.getEstado().equals("Aceitando passageiros");
        
        // Adicionar passageiro
        viagem.adicionarPassageiro(p1);
        boolean teste2 = viagem.getEstado().equals("Aceitando passageiros");
        
        // Lotar viagem
        viagem.adicionarPassageiro(p2);
        boolean teste3 = viagem.getEstado().equals("Lotada");
        
        // Iniciar viagem
        viagem.iniciarViagem();
        boolean teste4 = viagem.getEstado().equals("Em andamento");
        
        // Concluir viagem
        viagem.concluirViagem();
        boolean teste5 = viagem.getEstado().equals("Concluída");
        boolean teste6 = viagem.getValorTotal() == 200.0; // 2 passageiros * 100
        
        boolean passou = teste1 && teste2 && teste3 && teste4 && teste5 && teste6;
        System.out.println(passou ? "✅ Estados OK" : "❌ Estados FALHARAM");
        if (!passou) {
            System.out.println("  Detalhes: " + teste1 + " " + teste2 + " " + teste3 + 
                             " " + teste4 + " " + teste5 + " " + teste6);
        }
        System.out.println();
        
        return passou;
    }
    
    private static boolean testeEstrategias() {
        System.out.println("Teste 3: Padrão Strategy");
        
        Usuario usuario = new Usuario("U001", "Usuario Teste", "u@test.com", "11111111");
        Usuario m1 = new Usuario("M001", "Motorista 1", "m1@test.com", "11111111");
        Usuario m2 = new Usuario("M002", "Motorista 2", "m2@test.com", "22222222");
        
        Viagem v1 = new Viagem("V001", m1, "A", "B", 2, 150.0, LocalDateTime.now().plusHours(1));
        Viagem v2 = new Viagem("V002", m2, "A", "B", 3, 100.0, LocalDateTime.now().plusHours(2));
        
        java.util.List<Viagem> viagens = java.util.Arrays.asList(v1, v2);
        
        // Estratégia mais barata
        usuario.setStrategy(new CheapestTripStrategy());
        Viagem escolhida1 = usuario.selecionarViagem(viagens);
        boolean teste1 = escolhida1.equals(v2); // v2 é mais barata
        
        // Estratégia mais cedo
        usuario.setStrategy(new EarliestTripStrategy());
        Viagem escolhida2 = usuario.selecionarViagem(viagens);
        boolean teste2 = escolhida2.equals(v1); // v1 parte mais cedo
        
        // Estratégia mais assentos
        usuario.setStrategy(new MostAvailableSeatsStrategy());
        Viagem escolhida3 = usuario.selecionarViagem(viagens);
        boolean teste3 = escolhida3.equals(v2); // v2 tem mais assentos
        
        boolean passou = teste1 && teste2 && teste3;
        System.out.println(passou ? "✅ Estratégias OK" : "❌ Estratégias FALHARAM");
        if (!passou) {
            System.out.println("  Detalhes: " + teste1 + " " + teste2 + " " + teste3);
        }
        System.out.println();
        
        return passou;
    }
    
    private static boolean testeSistemaCompleto() {
        System.out.println("Teste 4: Sistema Completo");
        
        SistemaCaronas sistema = SistemaCaronas.getInstance();
        
        // Limpar dados anteriores se houver
        sistema.getUsuarios().clear();
        sistema.getViagens().clear();
        
        Usuario motorista = new Usuario("M001", "Motorista", "m@test.com", "11111111");
        Usuario passageiro = new Usuario("P001", "Passageiro", "p@test.com", "22222222");
        
        sistema.cadastrarUsuario(motorista);
        sistema.cadastrarUsuario(passageiro);
        
        Viagem viagem = new Viagem("V001", motorista, "São Paulo", "Rio de Janeiro", 
                                 2, 100.0, LocalDateTime.now().plusDays(1));
        sistema.cadastrarViagem(viagem);
        
        // Buscar viagens
        java.util.List<Viagem> encontradas = sistema.buscarViagens("São Paulo", "Rio de Janeiro");
        boolean teste1 = encontradas.size() == 1;
        
        // Solicitar carona
        int passageirosAntes = viagem.getPassageiros().size();
        sistema.solicitarCarona("P001", "São Paulo", "Rio de Janeiro");
        int passageirosDepois = viagem.getPassageiros().size();
        boolean teste2 = passageirosDepois > passageirosAntes;
        
        boolean passou = teste1 && teste2;
        System.out.println(passou ? "✅ Sistema Completo OK" : "❌ Sistema Completo FALHOU");
        if (!passou) {
            System.out.println("  Detalhes: " + teste1 + " " + teste2);
        }
        System.out.println();
        
        return passou;
    }
}
