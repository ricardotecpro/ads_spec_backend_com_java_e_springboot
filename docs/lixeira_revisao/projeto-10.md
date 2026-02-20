# Projeto 10 - Gerenciador de Permissões 🛡️

**Objetivo**: Implementar a lógica de proteção de rotas baseada em perfis de usuário.

## O Desafio
Crie a estrutura de autorização para um **Sistema de RH**:

1.  **Roles**: Defina três tipos: `ADMIN`, `GESTOR` e `FUNCIONARIO`.
2.  **Regras**:
    - Todos podem ver o próprio perfil (`GET /me`).
    - Apenas `GESTOR` e `ADMIN` podem ver a lista de salários (`GET /salarios`).
    - Apenas `ADMIN` pode deletar um registro (`DELETE /colaboradores/:id`).
3.  **Middleware**: Desenhe (em desenho técnico ou código) como seria o "fluxo da cancela" (Authentication Middleware -> Authorization Middleware).

## O que avaliar?
- Separação clara entre quem é você e o que você pode fazer.
- Uso correto dos Status Codes em caso de bloqueio.
- Lógica de hierarquia (Admin pode tudo).