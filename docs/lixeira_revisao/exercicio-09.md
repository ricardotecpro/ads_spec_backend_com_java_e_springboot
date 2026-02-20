# Exercícios 09 - Segurança e Autenticação com JWT 🔐

## 🟢 Fáceis

1.  **Conceito**: Qual a principal diferença entre Autenticação e Autorização?
2.  **JWT**: Quais são as 3 partes de um token JWT?

## 🟡 Médios

3.  **Segurança**:
    Por que nunca devemos incluir informações sensíveis (como a senha do usuário) dentro do Payload do JWT?
4.  **Stateless**:
    Quais as vantagens de uma arquitetura "Stateless" em sistemas que precisam escalar para milhões de usuários?

## 🔴 Desafio

5.  **Análise de Token**:
    Imagine que você interceptou um token JWT.
    *   Como você faria para ler o nome do usuário que está dentro dele sem saber a chave secreta?
    *   Agora, imagine que você tentou mudar o `id` do usuário para burlar o sistema. Por que o servidor vai rejeitar esse token quando você tentar usá-lo?
    *   Onde o frontend deve armazenar o token para que ele não suma quando a página for recarregada?