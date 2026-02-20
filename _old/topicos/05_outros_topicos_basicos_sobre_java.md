# Outros Tópicos Básicos sobre Java ☕

Este documento aborda conceitos fundamentais em Java, incluindo convenções de nomenclatura, manipulação de strings, uso de funções (métodos) e exemplos práticos.

## Restrições e Convenções para Nomes 🏷️

Ao nomear variáveis, classes e outros elementos em Java, é importante seguir certas regras e convenções para garantir que o código seja legível e funcional.

### Restrições para Nomes de Variáveis
Existem algumas regras estritas para nomear identificadores (como variáveis) em Java:
- **Não pode começar com dígito:** Um nome de variável deve iniciar com uma letra, cifrão (`$`) ou sublinhado (`_`). Por convenção, geralmente se inicia com uma letra.
- **Não usar acentos ou til:** Embora o Java tecnicamente permita alguns caracteres Unicode, a convenção é usar apenas letras do alfabeto inglês (a-z, A-Z), dígitos (0-9) e o sublinhado (`_`).
- **Não pode ter espaço em branco:** Nomes de variáveis não podem conter espaços.
- **Nomes significativos:** É uma boa prática usar nomes que descrevam o propósito da variável.

**Exemplos:**

**Errado:**
```java
// int 5minutes; // Erro: começa com dígito
// int salário; // Evitar acentos
// int salario do funcionario; // Erro: contém espaços
```

**Correto:**
```java
int cincoMinutos; // ou _5minutes, mas menos comum para iniciar
int salario; // Sem acento
int salarioDoFuncionario; // Usando Camel Case
```

### Convenções de Nomenclatura
As convenções ajudam a manter o código consistente e fácil de ler por outros desenvolvedores.

- **Camel Case:** Inicia com letra minúscula, e cada nova palavra subsequente começa com letra maiúscula.
  - **Usado para:**
    - `pacotes` (ex: `com.minhaempresa.projeto.utilitarios`)
    - `atributos` (variáveis de instância, ex: `nomeCliente`)
    - `métodos` (ex: `calcularTotalPedido()`)
    - `variáveis` locais e `parâmetros` (ex: `contador`, `nomeUsuario`)
  - **Exemplo:** `lastName` (traduzido: `ultimoNome`)

- **Pascal Case (ou Upper Camel Case):** Similar ao Camel Case, mas a primeira letra também é maiúscula.
  - **Usado para:**
    - `classes` (ex: `ClientePremium`)
    - `interfaces` (ex: `ServicoDePagamento`)
    - `enums` (ex: `DiaDaSemana`)
  - **Exemplo:** `ProductService` (traduzido: `ServicoProduto`)

Seguir estas convenções melhora a legibilidade e a manutenção do código, facilitando a colaboração em projetos.

## Estrutura Básica de uma Classe e Métodos (Exemplo `Conta`) 🏛️

Classes são os blocos de construção fundamentais na Programação Orientada a Objetos (POO). Elas encapsulam dados (atributos) e comportamentos (métodos).

Abaixo, um exemplo de uma classe `Conta` em Java, com atributos para `titular` e `saldo`, e métodos para `depositar` e `sacar`.

```java
package entidades;

public class Conta {

    private String titular;
    private Double saldo;

    public Conta(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Não há um setTitular neste exemplo, o titular é definido no construtor.

    public Double getSaldo() {
        return saldo;
    }

    // O saldo não deve ter um setter público direto para proteger a consistência dos dados.
    // Modificações no saldo devem ser feitas através de depósitos e saques.

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor; // Adiciona o valor ao saldo
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor; // Subtrai o valor do saldo
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Valor de saque deve ser positivo.");
        }
    }
}
```

<!-- commentario
**Nota sobre o código original:**
- O código original `balance + amount;` e `balance amount;` nos métodos `deposit` e `withdraw` respectivamente, não alterariam o saldo. Foram corrigidos para `saldo += valor;` e `saldo -= valor;`.
- Foram adicionadas verificações básicas nos métodos `depositar` e `sacar` para melhorar a robustez.
-->

## Funções Interessantes para `String` 🧵

A classe `String` em Java oferece uma variedade de métodos úteis para manipulação de texto.

### Checklist de Métodos Comuns:
- **Formatar:**
    - `toLowerCase()`: Converte todos os caracteres da string para minúsculas.
    - `toUpperCase()`: Converte todos os caracteres da string para maiúsculas.
    - `trim()`: Remove espaços em branco no início e no fim da string.
- **Recortar:**
    - `substring(int inicio)`: Retorna uma nova string que é uma substring da string original, começando do índice `inicio` até o final.
    - `substring(int inicio, int fim)`: Retorna uma nova string que é uma substring da string original, começando do índice `inicio` até o índice `fim - 1`.
- **Substituir:**
    - `replace(char antigoChar, char novoChar)`: Substitui todas as ocorrências de `antigoChar` por `novoChar`.
    - `replace(CharSequence antigaString, CharSequence novaString)`: Substitui todas as ocorrências da `antigaString` pela `novaString`.
- **Buscar:**
    - `indexOf(String str)`: Retorna o índice da primeira ocorrência da substring `str`. Retorna -1 se não encontrada.
    - `lastIndexOf(String str)`: Retorna o índice da última ocorrência da substring `str`. Retorna -1 se não encontrada.
- **Dividir:**
    - `split(String regex)`: Divide a string em um array de substrings com base em um delimitador (expressão regular `regex`).

### Exemplo Prático com Métodos de `String`

```java
public class ExemploStrings {

    public static void main(String[] args) {
        String original = "   abcde FGHIJ ABC abc DEFG   ";

        String str01 = original.toLowerCase();
        String str02 = original.toUpperCase();
        String str03 = original.trim();
        String str04 = original.substring(5); // Considerando o trim, ou original.trim().substring(2)
        String str05 = original.trim().substring(2, 9); // Aplicando trim antes para consistência com os índices esperados

        String str06 = original.replace('a', 'x');
        String str07 = original.replace("abc", "xy");

        int indice1 = original.indexOf("bc");
        int ultimoIndiceBC = original.lastIndexOf("bc");

        System.out.println("Original: -" + original + "-");
        System.out.println("toLowerCase: -" + str01 + "-");
        System.out.println("toUpperCase: -" + str02 + "-");
        System.out.println("trim: -" + str03 + "-");
        System.out.println("substring(inicio): -" + str04 + "- (a partir do 5º caractere da original com espaços)");
        System.out.println("substring(inicio, fim) após trim: -" + str05 + "- ('cde FGH')");
        System.out.println("replace('a', 'x'): -" + str06 + "-");
        System.out.println("replace(\"abc\", \"xy\"): -" + str07 + "-");
        System.out.println("Primeiro índice de 'bc': " + indice1);
        System.out.println("Último índice de 'bc': " + ultimoIndiceBC);
    }
}
```

## Operação `split` 

O método `split()` é muito útil para quebrar uma string em várias partes (tokens) com base em um delimitador. Ele retorna um array de strings.

**Exemplo:**
```java
public class ExemploSplit {

    public static void main(String[] args) {
        String s = "batata maçã limão laranja";
        String[] vetorDePalavras = s.split(" "); // Divide a string usando o espaço como delimitador

        String palavra1 = vetorDePalavras[0]; // "batata"
        String palavra2 = vetorDePalavras[1]; // "maçã"
        String palavra3 = vetorDePalavras[2]; // "limão"
        String palavra4 = vetorDePalavras[3]; // "laranja"

        System.out.println("Palavra 1: " + palavra1);
        System.out.println("Palavra 2: " + palavra2);
        System.out.println("Palavra 3: " + palavra3);
        System.out.println("Palavra 4: " + palavra4);

        System.out.println("\nTodas as palavras do vetor:");
        for (String palavra : vetorDePalavras) {
            System.out.println("- " + palavra);
        }
    }
}
```

**Visualização do processo `split`:**

String `s`: `"batata maçã limão laranja"`

Após `s.split(" ")`:

`vetorDePalavras` (array):
- Índice `0`: `"batata"`
- Índice `1`: `"maçã"`
- Índice `2`: `"limão"`
- Índice `3`: `"laranja"`

## Comentários em Java (Básico) 📝

Comentários são trechos de código que o compilador Java ignora. Eles são usados para adicionar explicações, notas ou desabilitar temporariamente partes do código, tornando-o mais compreensível para você e outros desenvolvedores.

- **Comentário de Linha Única:** Começa com `//` e se estende até o final da linha.
  ```java
  // Este é um comentário de linha única
  int idade = 30; // Este comentário explica o propósito da variável 'idade'
  ```

- **Comentário de Múltiplas Linhas:** Começa com `/*` e termina com `*/`. Pode abranger várias linhas e é útil para explicações mais longas.
  ```java
  /*
   Este é um exemplo
   de um comentário
   que ocupa várias linhas.
  */
  double precoProduto = 19.99;
  ```

- **Comentário Javadoc (Documentação):** Começa com `/**` e termina com `*/`. Este tipo especial de comentário é usado para gerar documentação da API automaticamente.
  ```java
  /**
   * Esta classe representa um Produto em um sistema de e-commerce.
   *
   * @author Seu Nome
   * @version 1.0
   */
  public class Produto {
      // ... corpo da classe ...

      /**
       * Calcula o preço final do produto com desconto.
       *
       * @param descontoPercentual O percentual de desconto a ser aplicado (ex: 0.10 para 10%).
       * @return O preço final após o desconto.
       */
      public double calcularPrecoComDesconto(double descontoPercentual) {
          // ... lógica do método ...
          return 0.0; // Exemplo
      }
  }
  ```

## Funções (Sintaxe) ⚙️

Em Java, funções são geralmente chamadas de **métodos** quando estão dentro de classes. Eles são blocos de código que realizam uma tarefa específica e podem ser chamados (invocados) quando necessário.

### Exemplo: Programa para Cálculo de Delta em Equação de Segundo Grau

O código abaixo demonstra a estrutura básica de um programa Java que lê os coeficientes de uma equação de segundo grau ($ax^2 + bx + c = 0$) e calcula o valor de delta ($\Delta = b^2 - 4ac$).

```java
package curso;

import java.util.Locale;
import java.util.Scanner;

// Este programa calcula as raízes de uma equação do segundo grau
// Os valores dos coeficientes devem ser digitados um por linha

public class ProgramaEquacao { // Nome da classe alterado para ser mais descritivo

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Para usar o ponto como separador decimal
        Scanner sc = new Scanner(System.in);

        double a, b, c, delta;

        System.out.println("Digite os valores dos coeficientes (a, b, c):");

        System.out.print("Coeficiente a: ");
        a = sc.nextDouble();

        System.out.print("Coeficiente b: ");
        b = sc.nextDouble();

        System.out.print("Coeficiente c: ");
        c = sc.nextDouble();

        delta = b * b - 4 * a * c; // Cálculo do valor de delta

        System.out.println("O valor de Delta é: " + delta);

        // Aqui, poderíamos adicionar a lógica para calcular as raízes x' e x''
        // com base no valor de delta.

        sc.close();
    }
}
```

### O que são Funções (ou Métodos em Java)? 📜
- **Representam um processamento que possui um significado:** Um método agrupa uma sequência de instruções para realizar uma operação específica, como `Math.sqrt()` para calcular a raiz quadrada ou `System.out.println()` para imprimir no console.
- **Principais vantagens:**
    - **Modularização:** Dividir um programa complexo em partes menores e gerenciáveis.
    - **Delegação:** Atribuir responsabilidades específicas a diferentes métodos.
    - **Reaproveitamento:** Escrever um método uma vez e usá-lo várias vezes em diferentes partes do programa ou em outros programas.
- **Dados de entrada e saída:**
    - Métodos podem receber dados de entrada, chamados **parâmetros** ou **argumentos**.
    - Métodos podem ou não retornar uma **saída** (um valor resultante do processamento). Se um método não retorna um valor, seu tipo de retorno é `void`.
- **Em programação orientada a objetos (POO):** Funções definidas dentro de classes são chamadas de **métodos**.

## Problema Exemplo: Encontrar o Maior de Três Números 🤔

**Tarefa:** Fazer um programa para ler três números inteiros e mostrar na tela o maior deles.

**Exemplo de Execução:**
```
Digite três números:
5
8
3
Maior = 8
```

### Solução 1: Lógica Direto no `main`

Nesta abordagem, toda a lógica para encontrar o maior número está contida diretamente no método `main`.

```java
package curso;

import java.util.Scanner;

public class ProgramaMaiorNumeroV1 { // Classe renomeada para Solução 1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite três números:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a > b && a > c) {
            System.out.println("Maior = " + a);
        } else if (b > c) { // Se 'a' não é o maior, e 'b' é maior que 'c', então 'b' é o maior
            System.out.println("Maior = " + b);
        } else { // Se 'a' não é o maior e 'b' não é o maior, então 'c' é o maior
            System.out.println("Maior = " + c);
        }

        sc.close();
    }
}
```

### Solução 2: Usando Métodos Auxiliares

Esta abordagem utiliza métodos auxiliares para tornar o código mais modular e legível. Um método `encontrarMaior` calcula o maior número, e um método `mostrarResultado` exibe o resultado.

```java
package curso;

import java.util.Scanner;

public class ProgramaMaiorNumeroV2 { // Classe renomeada para Solução 2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite três números:");
        int num1 = sc.nextInt(); // Variáveis renomeadas para clareza
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int maiorNumero = encontrarMaior(num1, num2, num3);
        mostrarResultado(maiorNumero);

        sc.close();
    }

    /**
     * Encontra o maior entre três números inteiros.
     * @param x O primeiro número.
     * @param y O segundo número.
     * @param z O terceiro número.
     * @return O maior dos três números.
     */
    public static int encontrarMaior(int x, int y, int z) {
        int auxiliar;
        if (x > y && x > z) {
            auxiliar = x;
        } else if (y > z) { // Corrigido de y+z para y > z
            auxiliar = y;
        } else {
            auxiliar = z;
        }
        return auxiliar;
    }

    /**
     * Exibe o resultado (o maior número).
     * @param valor O valor a ser exibido.
     */
    public static void mostrarResultado(int valor) {
        System.out.println("Maior = " + valor);
    }
}
```

<!-- comentario 
**Nota sobre o código original:**
- O `else if (y+z)` no método `max` (agora `encontrarMaior`) foi corrigido para `else if (y > z)`, que é a lógica correta para encontrar o maior número.


## Executando os Exemplos em IDEs Populares 💻

Os exemplos de código Java fornecidos podem ser compilados e executados em qualquer ambiente de desenvolvimento Java configurado. Abaixo estão algumas dicas para duas IDEs populares: IntelliJ IDEA e Visual Studio Code.

### IntelliJ IDEA (Community Edition ou Ultimate)
1.  **Instalação:** Baixe e instale o IntelliJ IDEA do site da JetBrains. A Community Edition é gratuita.
2.  **JDK:** Certifique-se de ter um JDK (Java Development Kit) instalado e configurado no IntelliJ (normalmente detectado automaticamente ou pode ser configurado em `File > Project Structure > SDKs`).
3.  **Novo Projeto:**
    - Clique em `File > New > Project...`.
    - Selecione `Java` no painel esquerdo.
    - Escolha o seu JDK em `Project SDK`.
    - Clique em `Next`, `Next` (sem selecionar templates), dê um nome ao projeto e clique em `Finish`.
4.  **Criar Classe:**
    - Na janela `Project`, clique com o botão direito na pasta `src`.
    - Selecione `New > Java Class`.
    - Digite o nome da classe (ex: `ProgramaMaiorNumeroV1`) e pressione Enter.
5.  **Escrever o Código:** Copie e cole o código do exemplo na classe criada.
6.  **Executar:**
    - Clique com o botão direito do mouse dentro da classe que contém o método `main`.
    - Selecione `Run 'NomeDaClasse.main()'`.
    - Alternativamente, clique na seta verde ao lado da declaração do método `main`.

### Visual Studio Code (VS Code)
1.  **Instalação:** Baixe e instale o VS Code do site oficial.
2.  **JDK:** Certifique-se de ter um JDK (Java Development Kit) instalado em seu sistema e que o `JAVA_HOME` esteja configurado, ou que o VS Code consiga localizá-lo.
3.  **Extensões Java:** Instale o "Extension Pack for Java" da Microsoft a partir do painel de Extensões do VS Code (Ctrl+Shift+X). Este pacote inclui suporte à linguagem, depuração, Maven, etc.
4.  **Abrir Projeto/Pasta:**
    - Crie uma pasta para o seu projeto (ex: `MeusProjetosJava`).
    - No VS Code, clique em `File > Open Folder...` e selecione a pasta criada.
5.  **Criar Arquivo `.java`:**
    - Clique com o botão direito no painel `Explorer` (dentro da sua pasta de projeto) e selecione `New File`.
    - Nomeie o arquivo com o mesmo nome da classe pública e a extensão `.java` (ex: `ProgramaMaiorNumeroV1.java`).
    - É uma boa prática organizar os arquivos `.java` em uma subpasta `src`.
6.  **Escrever o Código:** Copie e cole o código do exemplo no arquivo `.java` criado.
7.  **Executar:**
    - Com o arquivo Java aberto, você verá links "Run" e "Debug" acima do método `main` (fornecidos pela extensão Java). Clique em "Run".
    - Alternativamente, clique com o botão direito no arquivo no Explorer ou no editor e selecione `Run Java`.
    - A saída será exibida no painel `TERMINAL` ou `DEBUG CONSOLE`.

Lembre-se de que o nome do arquivo `.java` deve corresponder exatamente ao nome da classe `public` declarada dentro dele. Os pacotes (`package curso;`) implicam uma estrutura de pastas (ex: `src/curso/NomeDaClasse.java`). Se você não estiver usando essa estrutura de pastas, pode remover a declaração de `package` para exemplos simples que estão na raiz do `src` ou da pasta do projeto.

-->
---
## 📚

---

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)
