# Projeto 08 - Schema de Validação Profissional ✅

**Objetivo**: Praticar a criação de regras de validação para garantir a integridade da API.

## O Desafio
Crie o esquema de validação (em pseudocódigo ou usando uma biblioteca como Zod/Joi) para um **Cadastro de Eventos**:

1.  **Campos Obrigatórios**: `titulo` (mín. 10 char), `data` (deve ser futura), `capacidade_maxima` (número positivo).
2.  **Campos Opcionais**: `descricao` (máx. 500 char), `link_inscricao` (formato de URL).
3.  **Sanitização**: O título não deve conter espaços em branco sobrando no início ou no fim (trim).
4.  **Simulação**: Mostre qual seria a mensagem de erro retornada se o usuário enviasse uma capacidade negativa.

## O que avaliar?
- Clareza e rigor das regras de validação.
- Escolha dos tipos de dados corretos.
- Mensagens de erro amigáveis ao desenvolvedor (DX).