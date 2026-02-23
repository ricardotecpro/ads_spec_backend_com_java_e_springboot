# Projeto 04 - Criando o Primeiro Mock 🧱

**Objetivo**: Dominar o fluxo de documentação de contrato e simulação de servidor.

## O Desafio
Você deve criar um servidor de Mock para uma API de **Lista de Tarefas (ToDo)**.

1.  Use o **Postman** (Mock Server) ou o **Mockoon** para criar 2 rotas:
    - `GET /tarefas`: Deve retornar uma lista com pelo menos 3 tarefas.
    - `POST /tarefas`: Deve aceitar uma nova tarefa e retornar `201 Created`.
2.  Documente os campos de uma tarefa (ex: `id`, `titulo`, `concluida`).
3.  Teste as rotas e garanta que o servidor responda corretamente no formato JSON.

## O que entregar?
- Print (screenshot) do Swagger UI ou da tela do Mock Server rodando.
- O JSON de exemplo retornado pelo `GET /tarefas`.
- Print do teste da rota `POST /tarefas` com sucesso.