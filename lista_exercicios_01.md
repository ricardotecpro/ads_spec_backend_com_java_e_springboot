# Lista de Exercícios POO Java 01

---

### 📌 **Descrição das Atividades**


1. **Desenvolvimento do Código**
   Cada atividade proposta deverá ser implementada em uma **IDE de sua preferência** (ex: Visual Studio Code, IntelliJ, Eclipse, etc.). Organize os arquivos de forma clara, utilizando nomes apropriados para pastas e scripts conforme especificado nos enunciados.

2. **Criação do README.md**
   No repositório, crie um arquivo `README.md` contendo as seguintes informações:

   * Qual **linguagem de programação** foi utilizada;
   * Qual **versão da linguagem** ou ambiente (ex: Python 3.11, Node.js 20.11, Java 17, etc.);
   * Instruções claras de como **executar o código**, incluindo dependências, comandos e passos necessários para rodar o projeto localmente.

3. **Versionamento com Git**
   Utilize o **Git** para versionar o projeto. Faça *commits* frequentes com mensagens descritivas que indiquem as alterações realizadas em cada etapa do desenvolvimento.

4. **Publicação no GitHub**
   Envie todos os arquivos para um **repositório no GitHub** (público).

5. **Entrega via Moodle**
   Copie o **link do repositório no GitHub** e cole no campo de resposta da atividade no **Moodle**, respeitando o prazo estabelecido. Verifique se o link está acessível e se todos os arquivos necessários estão incluídos no repositório.


---

## 1. Métodos (equivalente a Funções)

### 1.1 Calculadora Simples
Crie uma classe `Calculadora` com métodos para as quatro operações básicas (soma, subtração, multiplicação, divisão).  
O programa principal deve permitir ao usuário inserir dois números e escolher a operação desejada.  
**Exiba o resultado.**

---

### 1.2 Verificador de Palíndromos
Escreva um método que receba uma `String` como entrada e verifique se ela é um **palíndromo**  
(lê-se da mesma forma de trás para frente, desconsiderando espaços e maiúsculas/minúsculas).  
**Peça ao usuário para inserir uma palavra e use o método para verificar.**

---

### 1.3 Fatorial (Usar método recursivo)
Implemente um método **recursivo** para calcular o **fatorial** de um número inteiro não negativo.  
**Solicite ao usuário que insira um número e use o método para calcular e exibir o fatorial.**

---

### 1.4 Conversor de Temperaturas
Crie uma classe `ConversorTemperatura` com dois métodos:
- Um para converter **Celsius para Fahrenheit**
- Outro para converter **Fahrenheit para Celsius**

Permita que o usuário escolha a direção da conversão, insira a temperatura e veja o resultado.

**Fórmulas:**
- Celsius → Fahrenheit: `F = (C * 9/5) + 32`
- Fahrenheit → Celsius: `C = (F - 32) * 5/9`

---

## 2. Arrays Multidimensionais (equivalente a Matrizes)

### 2.1 Maior e Menor Elemento em uma Matriz
Implemente um programa que crie e preencha uma **matriz de inteiros (m x n)** com dimensões informadas pelo usuário.  
**Encontre e exiba o maior e o menor elemento** presente na matriz.

---

### 2.2 Soma das Diagonais de uma Matriz Quadrada
Escreva um programa que crie e preencha uma **matriz quadrada de inteiros** de ordem `n` (informada pelo usuário).  
**Calcule e exiba a soma** dos elementos da **diagonal principal** e da **diagonal secundária**.

---

## 3. Manipulação de Objetos e Referências (abordagem Java para Ponteiros)

> Observação: Java não usa ponteiros explicitamente como C/C++, mas usa referências para objetos.

### 3.1 Manipulando Dados de um Objeto
Crie uma classe `Numero` que tenha um atributo inteiro. No método `main`:
- Crie uma instância (objeto) da classe `Numero`
- Atribua um valor ao atributo do objeto
- Crie um método na classe `Numero` que **imprima o valor** do atributo
- Chame este método

Para simular a ideia de "endereço de memória", você pode usar:
```java
System.identityHashCode(objeto)
````

---

### 3.2 Trocando Valores entre Objetos (simulado)

Crie uma classe `ValorContainer` com um atributo inteiro `valor`.

No `main`:

* Crie duas instâncias de `ValorContainer`: `objA` e `objB`
* Peça ao usuário para inserir valores para `objA.valor` e `objB.valor`
* Imprima os valores de `objA.valor` e `objB.valor`

Crie um método estático:

```java
trocarValores(ValorContainer refA, ValorContainer refB)
```

Esse método deve trocar os atributos `valor` dos objetos.

Chame `trocarValores(objA, objB)` e imprima novamente os valores para verificar a troca.

---

## 4. Classes e Objetos (equivalente a Structs)

### 4.1 Sistema de Gerenciamento de Funcionários

Crie uma classe `Funcionario` com os atributos:

* `nome` (String)
* `id` (int)
* `salario` (double)
* `departamento` (String)

No programa principal, permita ao usuário:

* **Cadastrar vários funcionários** (armazenando-os em um `ArrayList<Funcionario>`)
* **Calcular e exibir o total de salários** de um **departamento específico**
* **Listar todos os funcionários** cadastrados com seus respectivos dados

---

### 4.2 Agenda de Contatos

Crie uma classe `Contato` com os atributos:

* `nome` (String)
* `telefone` (String)
* `email` (String)

Escreva um programa que permita ao usuário:

* **Adicionar até 10 contatos** a um `ArrayList<Contato>`
* **Listar todos os contatos** armazenados
* **Procurar e exibir telefone e email** de um contato, dado o seu nome

---

### Fim da Lista de Exercícios
