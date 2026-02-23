# Exercícios 08 - Boas Práticas e Validação de Dados ✅

## 🟢 Fáceis

1.  **Conceito**: Por que nunca devemos confiar 100% nos dados vindos do frontend?
2.  **Validação**: Dê um exemplo de uma regra de validação para um campo de "Senha".

## 🟡 Médios

3.  **Sanitização**:
    Qual a diferença prática entre validar um campo e sanitizar um campo? Quando usamos cada um?
4.  **Clean Code**:
    Refatore o nome da função abaixo para seguir as boas práticas:
    ```javascript
    function usr_ch(a, b) { ... } // Recebe e-mail e id, checa se e-mail já existe
    ```

## 🔴 Desafio

5.  **Tratamento de Erros**:
    Imagine que o banco de dados caiu. O Service lança um erro técnico.
    *   Como o **Middleware Global de Erros** deve reagir?
    *   O que ele deve enviar para o usuário final? (Erro 500 com mensagem técnica ou mensagem genérica?)
    *   Por que é importante logar o erro real apenas no console do servidor?