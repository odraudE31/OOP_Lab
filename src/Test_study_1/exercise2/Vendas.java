import java.util.ArrayList;

public class Vendas{
    ArrayList <IdentificadorIngresso> vendidos = new ArrayList<>();

    public void venda(Cliente cliente, boolean ehAssiduo, Evento evento, boolean entrega) {
        // Verifica idade mínima
        if (cliente.idade < evento.idadeMinimaEntrada) {
            throw new IllegalArgumentException("Cliente não possui idade mínima para o evento.");
        }
        // Verifica disponibilidade de ingressos
        if (evento.ingressosDisponiveis <= 0) {
            throw new IllegalArgumentException("Ingressos esgotados.");
        }

        float valorBase = evento.valorBaseIngresso;
        float valorComDesconto = valorBase;
        boolean desconto = false;

        // Aplica desconto se for assíduo com assinatura em dia OU menor de 25 anos
        if ((ehAssiduo && cliente.assinatura) || cliente.idade < 25) {
            valorComDesconto = valorBase * 0.5f;
            desconto = true;
        }

        // Calcula imposto (12% sobre valor efetivamente pago)
        float imposto = valorComDesconto * 0.12f;

        // Calcula taxa de conveniência
        float taxaConveniencia = 0;
        if (entrega) {
            if (cliente.endereco.cidade.equalsIgnoreCase(evento.local)) {
                taxaConveniencia = 10.0f;
            } else {
                taxaConveniencia = 30.0f;
            }
        }

        float valorFinal = valorComDesconto + imposto + taxaConveniencia;

        // Atualiza quantidade de ingressos disponíveis
        evento.ingressosDisponiveis--;

        // Cria identificador do ingresso
        IdentificadorIngresso ingresso = new IdentificadorIngresso();
        ingresso.setCliente(cliente);
        ingresso.setEvento(evento);

        // Adiciona ingresso ao cliente e à lista de vendidos
        cliente.ingressos.add(ingresso);
        vendidos.add(ingresso);

        // Aqui você pode registrar o valor da venda, imposto, desconto, etc., para relatórios
        // Exemplo: salvar em uma lista de vendas detalhadas

        System.out.println("Venda realizada. Valor final: R$" + valorFinal);
    }
}