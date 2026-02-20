# Exercícios 05 - Implementação de APIs ⚙️

## 🟢 Fáceis

1.  **Responsabilidade**: Qual a principal função de um Controller em uma arquitetura de camadas?
2.  **Mapeamento**: O que é um "Handler" no contexto de rotas backend?

## 🟡 Médios

3.  **Parâmetros**: Diferencie, com exemplos de URIs, o uso de **Path Params** e **Query Params**.
4.  **Erros**: Por que o Controller nunca deve retornar uma resposta sem um Status Code explícito?

## 🔴 Desafio

5.  **Cenário Real**:
    Imagine que você está implementando a rota de `PUT /produtos/123`.
    *   Como você capturaria o `123`?
    *   Como você capturaria o novo nome do produto?
    *   Em qual objeto (`req.params`, `req.query` ou `req.body`) cada um desses dados estaria?
    *   O que você faria se o cliente enviasse o `id` no Body diferente do `id` na URL?