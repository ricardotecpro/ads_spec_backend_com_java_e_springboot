# Projeto 09 - Sistema de Login (Simulado) 🔐

**Objetivo**: Implementar a lógica de geração de tokens JWT para autenticação.

## O Desafio
Crie uma API de simulação de login:

1.  **Entrada**: Receba um JSON com `email` e `senha`.
2.  **Validação**: Verifique se a senha tem mais de 6 caracteres.
3.  **JWT**: Use uma biblioteca (ou pseudocódigo) para gerar um token que contenha o `id` do usuário e sua `permissão` (ex: 'aluno').
4.  **Expiração**: Configure o token para ser válido por apenas 24 horas.
5.  **Resposta**: Retorne para o cliente um objeto contendo o `token` e o `nome` do usuário.

## O que avaliar?
- Tratamento correto de erro caso a senha seja curta.
- Estrutura limpa do Payload do JWT.
- Escolha de uma chave secreta segura (simulada).