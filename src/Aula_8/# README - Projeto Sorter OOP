# README - Projeto Sorter OOP

## Objetivo

Este projeto tem como objetivo fornecer uma solução orientada a objetos para ordenação de arrays, permitindo:

- **Flexibilidade de tipo de dados:** Ordenar arrays de qualquer tipo que implemente `Comparable` (ex: `Integer`, `Double`, `String`).
- **Eficiência e segurança:** Não permite arrays com dados de tipos mistos e garante que o tipo de retorno seja igual ao tipo de entrada.
- **Extensibilidade:** Permite trocar o algoritmo de ordenação em tempo de execução e adicionar novos algoritmos facilmente, sem alterar o restante do código (usando o padrão Strategy).
- **Opção de ordem:** (Bônus) Possibilidade de ordenar em ordem crescente ou decrescente.
- **Boas práticas de POO:** Código organizado, com responsabilidades bem definidas e fácil manutenção.

## Estrutura do Projeto

- **Sort.java:** Classe abstrata base para algoritmos de ordenação.
- **Quicksort.java, Mergesort.java, Insertionsort.java:** Implementações concretas de algoritmos de ordenação.
- **Sorter.java:** Classe que seleciona e aplica o algoritmo de ordenação desejado.
- **(Opcional) Versão genérica:** Para atender ao requisito de flexibilidade de tipos, recomenda-se criar versões genéricas dessas classes usando `<T extends Comparable<T>>`.

## Como usar

1. **Escolha o algoritmo:** Instancie a classe `Sorter` informando o algoritmo desejado (`QUICKSORT`, `MERGESORT`, `INSERTIONSORT`).
2. **Ordene seu array:** Chame o método `sort` passando o array a ser ordenado.
3. **Teste com diferentes tipos:** Para atender ao requisito do cliente, crie exemplos com arrays de `Integer`, `Double` e `String`.

## Exemplo de uso

```java
Sorter quicksort = new Sorter(Sorter.QUICKSORT);
quicksort.sort(meuArrayDeInteiros);

Sorter mergesort = new Sorter(Sorter.MERGESORT);
mergesort.sort(meuArrayDeDoubles);

Sorter insertionsort = new Sorter(Sorter.INSERTIONSORT);
insertionsort.sort(meuArrayDeStrings);
```

## Como adicionar novos algoritmos

1. Crie uma nova classe que estenda `Sort` e implemente o método `sort`.
2. Adicione um novo valor constante em `Sorter` para o novo algoritmo.
3. Atualize o `switch` em `Sorter` para incluir o novo algoritmo.

## Observações

- O projeto pode ser facilmente adaptado para usar generics e aceitar qualquer tipo de dado comparável.
- Para garantir a eficiência e segurança, não utilize arrays com tipos mistos.
- O padrão Strategy facilita a manutenção e evolução do sistema.

---

**Resumo do desejo do cliente:**  
O cliente deseja um sistema de ordenação flexível, extensível, seguro e fácil de manter, que permita trocar algoritmos e tipos de dados sem grandes alterações no código.