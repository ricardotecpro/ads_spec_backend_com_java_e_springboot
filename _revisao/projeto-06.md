# Projeto 06 - Implementando a Lógica de Negócio 🧠

**Objetivo**: Aplicar a separação de camadas criando um Service para validação de dados.

## O Desafio
Você deve criar o `UsuarioService` para um sistema de cadastro.

1.  **Função `validarSenha(senha)`**: Deve garantir que a senha tenha no mínimo 8 caracteres e contenha pelo menos um número.
2.  **Função `criarUsuario(dados)`**:
    - Chama a validação de senha.
    - Verifica se o e-mail já está sendo usado (simule um erro se estiver).
    - Retorna o usuário criado (sem a senha!).
3.  Simule o Controller chamando esse Service e tratando o erro de "Senha Insegura" com um Status Code 400.

## O que observar?
- O Service não deve usar objetos globais como `req` ou `res`.
- As mensagens de erro devem ser claras e informativas.
- Uso de DTOs (retornar objeto filtrado).