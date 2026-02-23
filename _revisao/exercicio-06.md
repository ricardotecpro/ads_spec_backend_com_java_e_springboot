# Exercícios 06 - Services e Regras de Negócio 🧠

## 🟢 Fáceis

1.  **Conceito**: Explique por que não é uma boa prática colocar lógica de cálculo ou validação dentro do Controller.
2.  **Responsabilidade**: Cite 3 exemplos de tarefas que devem ser feitas na camada de Service.

## 🟡 Médios

3.  **Tratamento de Erros**:
    Por que o Service deve lançar (throw) um erro em vez de retornar um Status Code (ex: 404)?
4.  **Reutilização**:
    Imagine que você tem um `EmailService`. Cite dois Controllers diferentes que poderiam usar esse mesmo serviço.

## 🔴 Desafio

5.  **Lógica de Negócio**:
    Escreva o pseudocódigo para um `PedidoService.finalizar(pedidoId)`.
    *   Quais validações você faria? (Estoque, status do pedido, limite de crédito do cliente).
    *   Como você lidaria com o caso de "Produto Sem Estoque"?
    *   Qual tipo de dado (DTO) o Service deveria retornar para o Controller após o sucesso?