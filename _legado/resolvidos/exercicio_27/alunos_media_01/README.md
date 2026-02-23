# EXERCÍCIO DE FIXAÇÃO - P.27

## Descrição
Você foi contratado para desenvolver um sistema de cadastro de alunos para uma escola. Este sistema foi implementado em **Java** utilizando conceitos básicos de **Orientação a Objetos**.

## Objetivo
O objetivo do sistema é permitir o cadastro de alunos, incluindo informações como nome, idade, número de matrícula e média de notas. Além disso, o sistema exibe todas as informações cadastradas.

## Estrutura do Sistema
O sistema é composto por duas classes principais:

### 1. Classe `Aluno`
A classe `Aluno` representa um aluno da escola e possui os seguintes atributos e métodos:
- **Atributos**:
  - `nome` (String): Nome do aluno.
  - `idade` (int): Idade do aluno.
  - `matricula` (int): Número de matrícula do aluno.
  - `media` (float): Média de notas do aluno.
- **Métodos**:
  - `cadastrarDados(String nome, int idade, int matricula, float media)`: Cadastra os dados básicos do aluno.
  - `cadastrarMediaNotas(float media)`: Atualiza a média de notas do aluno.
  - `exibirInformacoes()`: Exibe todas as informações do aluno.

### 2. Classe `Main`
A classe `Main` é responsável por interagir com o usuário, coletar os dados do aluno e exibir as informações cadastradas.

## Como Executar
1. Certifique-se de ter o **Java Development Kit (JDK)** instalado.
2. Compile os arquivos `.java` utilizando o comando:
   ```bash
   javac Aluno.java Main.java

### 📌 