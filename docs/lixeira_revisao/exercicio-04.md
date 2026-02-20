# Exercícios 04 - Documentação e Mocks 📝

## 🟢 Fáceis

1.  **Conceitos**: O que é OpenAPI e qual a relação dela com o Swagger?
2.  **Mocks**: Explique com suas palavras por que um desenvolvedor Frontend desejaria usar um Mock Server.

## 🟡 Médios

3.  **Análise de YAML**:
    Analise o trecho OpenAPI abaixo e responda: Qual o endpoint? Qual o verbo? O que ele retorna no sucesso?
    ```yaml
    /usuarios/{id}:
      get:
        summary: Busca usuário por ID
        responses:
          '200':
            description: Usuário encontrado
    ```
4.  **Developer Experience (DX)**: Imagine que você recebeu uma documentação que diz apenas: `POST /login - Envie os dados do usuário`. Por que essa documentação é ruim sob a ótica de DX?

## 🔴 Desafio

5.  **Cenário de Desenvolvimento**:
    Você é o arquiteto de um projeto onde o Backend vai demorar 3 semanas para liberar a primeira API, mas o Frontend precisa começar amanhã.
    *   Como você organizaria o trabalho usando **Mocks**?
    *   Como garantir que, quando o Backend ficar pronto, a integração ocorra sem precisar mudar nada no código do Frontend?
    *   Cite uma ferramenta que você usaria para subir esse Mock Server rapidamente.
