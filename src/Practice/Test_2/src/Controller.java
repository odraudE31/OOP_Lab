import ride.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Controller para interação com o sistema de caronas
 * Fornece interface para testar todas as funcionalidades
 */
public class Controller {
    private SistemaCaronas sistema;
    private Scanner scanner;
    private DateTimeFormatter formatter;
    
    public Controller() {
        this.sistema = SistemaCaronas.getInstance();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }
    
    /**
     * Menu principal do sistema
     */
    public void iniciar() {
        System.out.println("=== SISTEMA DE CARONAS ===");
        System.out.println("Implementação com padrões State, Strategy e Singleton\n");
        
        while (true) {
            mostrarMenu();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> cadastrarViagem();
                case 3 -> buscarViagens();
                case 4 -> solicitarCarona();
                case 5 -> cancelarParticipacao();
                case 6 -> gerenciarViagem();
                case 7 -> configurarEstrategia();
                case 8 -> gerarRelatorios();
                case 9 -> executarTestesAutomaticos();
                case 0 -> {
                    System.out.println("Sistema encerrado!");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
    
    private void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Cadastrar viagem");
        System.out.println("3. Buscar viagens");
        System.out.println("4. Solicitar carona");
        System.out.println("5. Cancelar participação");
        System.out.println("6. Gerenciar viagem (iniciar/concluir/cancelar)");
        System.out.println("7. Configurar estratégia de seleção");
        System.out.println("8. Gerar relatórios");
        System.out.println("9. Executar testes automáticos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void cadastrarUsuario() {
        System.out.println("\n--- CADASTRAR USUÁRIO ---");
        System.out.print("ID do usuário: ");
        String id = scanner.nextLine();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        Usuario usuario = new Usuario(id, nome, email, telefone);
        sistema.cadastrarUsuario(usuario);
    }
    
    private void cadastrarViagem() {
        System.out.println("\n--- CADASTRAR VIAGEM ---");
        System.out.print("ID da viagem: ");
        String id = scanner.nextLine();
        
        System.out.print("ID do motorista: ");
        String motoristaId = scanner.nextLine();
        
        Usuario motorista = sistema.buscarUsuario(motoristaId);
        if (motorista == null) {
            System.out.println("Motorista não encontrado!");
            return;
        }
        
        System.out.print("Cidade de origem: ");
        String origem = scanner.nextLine();
        
        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();
        
        System.out.print("Número máximo de passageiros: ");
        int maxPassageiros = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Valor por passageiro: R$ ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Data/hora de partida (dd/MM/yyyy HH:mm): ");
        String dataStr = scanner.nextLine();
        LocalDateTime dataPartida = LocalDateTime.parse(dataStr, formatter);
        
        Viagem viagem = new Viagem(id, motorista, origem, destino, maxPassageiros, valor, dataPartida);
        sistema.cadastrarViagem(viagem);
    }
    
    private void buscarViagens() {
        System.out.println("\n--- BUSCAR VIAGENS ---");
        System.out.print("Cidade de origem: ");
        String origem = scanner.nextLine();
        
        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();
        
        List<Viagem> viagens = sistema.buscarViagens(origem, destino);
        
        if (viagens.isEmpty()) {
            System.out.println("Nenhuma viagem encontrada para este percurso.");
        } else {
            System.out.println("\n--- VIAGENS DISPONÍVEIS ---");
            for (int i = 0; i < viagens.size(); i++) {
                Viagem v = viagens.get(i);
                System.out.printf("%d. %s\n", i + 1, v.toString());
                System.out.printf("   Motorista: %s | Partida: %s\n", 
                                v.getMotorista().getNome(),
                                v.getDataPartida().format(formatter));
            }
        }
    }
    
    private void solicitarCarona() {
        System.out.println("\n--- SOLICITAR CARONA ---");
        System.out.print("ID do usuário: ");
        String usuarioId = scanner.nextLine();
        
        System.out.print("Cidade de origem: ");
        String origem = scanner.nextLine();
        
        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();
        
        sistema.solicitarCarona(usuarioId, origem, destino);
    }
    
    private void cancelarParticipacao() {
        System.out.println("\n--- CANCELAR PARTICIPAÇÃO ---");
        System.out.print("ID do usuário: ");
        String usuarioId = scanner.nextLine();
        
        System.out.print("ID da viagem: ");
        String viagemId = scanner.nextLine();
        
        sistema.cancelarParticipacao(usuarioId, viagemId);
    }
    
    private void gerenciarViagem() {
        System.out.println("\n--- GERENCIAR VIAGEM ---");
        System.out.print("ID da viagem: ");
        String viagemId = scanner.nextLine();
        
        Viagem viagem = sistema.buscarViagem(viagemId);
        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }
        
        System.out.println("Estado atual: " + viagem.getEstado());
        System.out.println("1. Iniciar viagem");
        System.out.println("2. Concluir viagem");
        System.out.println("3. Cancelar viagem");
        System.out.print("Escolha uma ação: ");
        
        int acao = lerOpcao();
        switch (acao) {
            case 1 -> viagem.iniciarViagem();
            case 2 -> viagem.concluirViagem();
            case 3 -> viagem.cancelarViagem();
            default -> System.out.println("Ação inválida!");
        }
    }
    
    private void configurarEstrategia() {
        System.out.println("\n--- CONFIGURAR ESTRATÉGIA ---");
        System.out.print("ID do usuário: ");
        String usuarioId = scanner.nextLine();
        
        Usuario usuario = sistema.buscarUsuario(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }
        
        System.out.println("Estratégias disponíveis:");
        System.out.println("1. Viagem mais barata");
        System.out.println("2. Viagem com partida mais cedo");
        System.out.println("3. Viagem com mais assentos disponíveis");
        System.out.print("Escolha uma estratégia: ");
        
        int estrategia = lerOpcao();
        switch (estrategia) {
            case 1 -> {
                usuario.setStrategy(new CheapestTripStrategy());
                System.out.println("Estratégia alterada para: Mais barata");
            }
            case 2 -> {
                usuario.setStrategy(new EarliestTripStrategy());
                System.out.println("Estratégia alterada para: Partida mais cedo");
            }
            case 3 -> {
                usuario.setStrategy(new MostAvailableSeatsStrategy());
                System.out.println("Estratégia alterada para: Mais assentos");
            }
            default -> System.out.println("Estratégia inválida!");
        }
    }
    
    private void gerarRelatorios() {
        System.out.println("\n--- RELATÓRIOS ---");
        System.out.println("1. Relatório de viagem específica");
        System.out.println("2. Relatório geral do sistema");
        System.out.print("Escolha um relatório: ");
        
        int tipo = lerOpcao();
        switch (tipo) {
            case 1 -> {
                System.out.print("ID da viagem: ");
                String viagemId = scanner.nextLine();
                sistema.gerarRelatorioViagem(viagemId);
            }
            case 2 -> sistema.gerarRelatorioSistema();
            default -> System.out.println("Tipo de relatório inválido!");
        }
    }
    
    private void executarTestesAutomaticos() {
        System.out.println("\n--- EXECUTANDO TESTES AUTOMÁTICOS ---");
        System.out.println("Este teste demonstra todos os padrões implementados:\n");
        
        // Teste do padrão Singleton
        System.out.println("1. TESTANDO PADRÃO SINGLETON");
        SistemaCaronas sistema1 = SistemaCaronas.getInstance();
        SistemaCaronas sistema2 = SistemaCaronas.getInstance();
        System.out.println("Mesma instância: " + (sistema1 == sistema2));
        
        // Criar dados de teste
        Usuario joao = new Usuario("TEST001", "João Silva", "joao@test.com", "11999887766");
        Usuario maria = new Usuario("TEST002", "Maria Santos", "maria@test.com", "11998776655");
        Usuario pedro = new Usuario("TEST003", "Pedro Costa", "pedro@test.com", "11997665544");
        
        sistema.cadastrarUsuario(joao);
        sistema.cadastrarUsuario(maria);
        sistema.cadastrarUsuario(pedro);
        
        Viagem viagem = new Viagem("TESTE001", joao, "São Paulo", "Rio de Janeiro", 
                                 2, 150.0, LocalDateTime.now().plusDays(1));
        sistema.cadastrarViagem(viagem);
        
        // Teste do padrão State
        System.out.println("\n2. TESTANDO PADRÃO STATE");
        System.out.println("Estado inicial: " + viagem.getEstado());
        
        viagem.adicionarPassageiro(maria);
        System.out.println("Após adicionar 1º passageiro: " + viagem.getEstado());
        
        viagem.adicionarPassageiro(pedro);
        System.out.println("Após adicionar 2º passageiro: " + viagem.getEstado());
        
        viagem.iniciarViagem();
        System.out.println("Após iniciar viagem: " + viagem.getEstado());
        
        viagem.concluirViagem();
        System.out.println("Após concluir viagem: " + viagem.getEstado());
        System.out.println("Valor total: R$ " + viagem.getValorTotal());
        
        // Teste do padrão Strategy
        System.out.println("\n3. TESTANDO PADRÃO STRATEGY");
        Viagem v1 = new Viagem("TESTE002", maria, "São Paulo", "Campinas", 
                             3, 100.0, LocalDateTime.now().plusHours(1));
        Viagem v2 = new Viagem("TESTE003", pedro, "São Paulo", "Campinas", 
                             2, 80.0, LocalDateTime.now().plusHours(2));
        
        sistema.cadastrarViagem(v1);
        sistema.cadastrarViagem(v2);
        
        List<Viagem> viagens = List.of(v1, v2);
        
        // Testando diferentes estratégias
        Usuario testUser = new Usuario("STRATEGY", "Teste Strategy", "test@test.com", "11111111");
        
        testUser.setStrategy(new CheapestTripStrategy());
        System.out.println("Estratégia mais barata escolheu: " + 
                         testUser.selecionarViagem(viagens).getId());
        
        testUser.setStrategy(new EarliestTripStrategy());
        System.out.println("Estratégia mais cedo escolheu: " + 
                         testUser.selecionarViagem(viagens).getId());
        
        testUser.setStrategy(new MostAvailableSeatsStrategy());
        System.out.println("Estratégia mais assentos escolheu: " + 
                         testUser.selecionarViagem(viagens).getId());
        
        System.out.println("\n4. RELATÓRIO FINAL");
        sistema.gerarRelatorioSistema();
        
        System.out.println("=== TESTES AUTOMÁTICOS CONCLUÍDOS ===");
    }
    
    /**
     * Método para criar dados de exemplo para testes
     */
    public void criarDadosExemplo() {
        // Usuários
        sistema.cadastrarUsuario(new Usuario("U001", "João Silva", "joao@email.com", "11999887766"));
        sistema.cadastrarUsuario(new Usuario("U002", "Maria Santos", "maria@email.com", "11998776655"));
        sistema.cadastrarUsuario(new Usuario("U003", "Pedro Costa", "pedro@email.com", "11997665544"));
        sistema.cadastrarUsuario(new Usuario("U004", "Ana Oliveira", "ana@email.com", "11996554433"));
        
        // Viagens
        Usuario joao = sistema.buscarUsuario("U001");
        Usuario maria = sistema.buscarUsuario("U002");
        
        sistema.cadastrarViagem(new Viagem("V001", joao, "São Paulo", "Rio de Janeiro", 
                                         3, 150.0, LocalDateTime.now().plusDays(1)));
        sistema.cadastrarViagem(new Viagem("V002", maria, "São Paulo", "Campinas", 
                                         2, 50.0, LocalDateTime.now().plusHours(4)));
        
        System.out.println("Dados de exemplo criados com sucesso!");
    }
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        // Opção para criar dados de exemplo
        System.out.println("Deseja criar dados de exemplo? (s/n): ");
        Scanner scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        
        if (resposta.toLowerCase().startsWith("s")) {
            controller.criarDadosExemplo();
        }
        
        controller.iniciar();
    }
}