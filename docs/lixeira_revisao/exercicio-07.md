# Exercícios 07 - Repositories e Banco de Dados 🗄️

## 🟢 Fáceis

1.  **Fundamentos**: O que significa a sigla SQL e para que ela serve?
2.  **CRUD**: Escreva o comando SQL para inserir um novo produto (nome "Mouse", preço 50.00) na tabela `produtos`.

## 🟡 Médios

3.  **Relacionamentos**:
    Explique a diferença entre uma **Primary Key (PK)** e uma **Foreign Key (FK)**. Por que a FK é essencial para bancos relacionais?
4.  **Isolamento**:
    Por que usamos o padrão Repository em vez de escrever o código SQL diretamente dentro do Service?

## 🔴 Desafio

5.  **Modelagem Real**:
    Imagine um sistema de Blog. Temos `Escritores` e `Artigos`.
    *   **1:N**: Como você modelaria a ligação entre um Escritor e seus Artigos?
    *   **SQL**: Escreva uma query que retorne o título de todos os artigos escritos pelo autor com `id = 5`.
    *   **Repository**: Como ficaria a assinatura (nome e parâmetros) da função no `ArtigoRepository` responsável por essa busca?