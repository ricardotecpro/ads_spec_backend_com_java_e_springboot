# Exercícios 11 - Refresh Token e Segurança Avançada 🏗️

## 🟢 Fáceis

1.  **Conceito**: Por que Access Tokens costumam ter vida curta?
2.  **Bibliotecas**: Para que serve a biblioteca **Helmet** em um aplicativo Express?

## 🟡 Médios

3.  **CORS**:
    Explique por que o CORS é uma segurança do **Navegador** e não do servidor. O que acontece se você tentar chamar uma API sem CORS a partir de um script no Terminal (cURL)?
4.  **Flow**:
    Desenhe o fluxo de uma requisição que retorna erro 401 por token expirado e como o frontend deve agir para usar o Refresh Token.
5.  **Headers**:
    Cite três informações sensíveis que o Helmet ajuda a esconder nos cabeçalhos HTTP.

## 🔴 Desafio

6.  **Segurança de Refresh Tokens**:
    Se o Refresh Token permite gerar novos Access Tokens, por que ele é considerado mais seguro?
    *   Onde ele deve ser armazenado preferencialmente no navegador (LocalStorage ou Cookies HttpOnly)? Por quê?
    *   O que é o "Refresh Token Rotation"?