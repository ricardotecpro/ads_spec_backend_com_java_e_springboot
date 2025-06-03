# Java e Orientação a Objetos

## Capítulo: Estrutura Sequencial

Neste capítulo, exploraremos os conceitos fundamentais da estrutura sequencial em Java, incluindo expressões aritméticas, o uso de variáveis e tipos primitivos, e as operações básicas de entrada, processamento e saída de dados.

-----

## Expressões Aritméticas

Uma **expressão aritmética** é uma combinação de valores numéricos, operadores aritméticos e, possivelmente, variáveis, que resulta em um valor numérico.

Por exemplo:
`4 + 5` resulta em `9`.

### Operadores Aritméticos

Java, assim como C, C++, e C\#, utiliza os seguintes operadores aritméticos:

| Operador | Significado                      |
| :------- | :------------------------------- |
| `+`      | Adição                           |
| `-`      | Subtração                        |
| `*`      | Multiplicação                    |
| `/`      | Divisão                          |
| `%`      | Resto da divisão ("mod")         |

**Precedência dos Operadores:**

1.  Primeiro lugar (maior precedência): `*`, `/`, `%`
2.  Segundo lugar (menor precedência): `+`, `-`

Operadores de mesma precedência são avaliados da esquerda para a direita. Parênteses `()` podem ser usados para alterar a ordem de avaliação.

**Nota sobre Divisão:**

  - Se ambos os operandos da divisão `/` forem inteiros, o resultado será um inteiro (a parte fracionária é truncada). Ex: `5 / 2` resulta em `2`.
  - Se pelo menos um dos operandos for um número de ponto flutuante (ex: `float` ou `double`), o resultado será um número de ponto flutuante. Ex: `5.0 / 2` resulta em `2.5`.

### Exemplos de Expressões Aritméticas

| Expressão            | Resultado | Explicação                                      |
| -------------------- | --------- | ----------------------------------------------- |
| `2 * 6 / 3`          | `4`       | `(2 * 6) / 3 = 12 / 3 = 4`                      |
| `3 + 2 * 4`          | `11`      | `3 + (2 * 4) = 3 + 8 = 11`                      |
| `(3 + 2) * 4`        | `20`      | `5 * 4 = 20`                                    |
| `60 / (3 + 2) * 4`   | `48`      | `60 / 5 * 4 = 12 * 4 = 48`                      |
| `60 / ((3 + 2) * 4)` | `3`       | `60 / (5 * 4) = 60 / 20 = 3`                    |

### Exemplos com o Operador "mod" (Resto da Divisão)

O operador `%` retorna o resto da divisão inteira entre dois números.

  - `14 % 3`

      - Resultado: `2`
      - Pois: $14 \\div 3 = 4$ com resto $2$.

  - `19 % 5`

      - Resultado: `4`
      - Pois: $19 \\div 5 = 3$ com resto $4$.

-----

## Variáveis e Tipos Primitivos em Java

### Visão Geral

  - Um programa de computador em execução lida com **dados**.
  - Esses dados são armazenados em **VARIÁVEIS**. Uma variável é, essencialmente, um espaço na memória reservado para guardar um tipo específico de dado, acessível através de um nome.

### Variáveis

**Definição informal:**
Em programação, uma **variável** é uma porção de memória (RAM) utilizada para armazenar dados durante a execução dos programas.

**Uma variável possui:**

  - **Nome** (ou identificador): usado para referenciar a variável no código.
  - **Tipo**: define que tipo de dado a variável pode armazenar (ex: número inteiro, texto, etc.) e quanta memória será alocada.
  - **Valor**: o dado atual armazenado na variável.
  - **Endereço**: a localização na memória onde o valor está armazenado (geralmente gerenciado pelo sistema).

### Declaração de Variáveis

A sintaxe para declarar uma variável em Java é:
`<tipo> <nome> = <valor inicial>;` (a inicialização é opcional no momento da declaração, mas uma variável deve ser inicializada antes de ser usada).

**Exemplos:**

```java
int idade = 25;
double altura = 1.68;
char sexo = 'F';
String nome = "Maria"; // String é um tipo especial, não primitivo, mas fundamental.
```

No exemplo acima:

  - `idade` é uma variável do tipo `int` que armazena o valor `25`.
  - `altura` é uma variável do tipo `double` que armazena o valor `1.68`.
  - `sexo` é uma variável do tipo `char` que armazena o caractere `'F'`.
  - `nome` é uma variável do tipo `String` que armazena o texto `"Maria"`.

### Tipos Primitivos em Java

Java possui oito tipos de dados primitivos, que são os blocos de construção básicos para dados.

| Descrição                      | Tipo    | Tamanho  | Valores Possíveis (aproximado)                      | Valor Padrão |
| ------------------------------ | ------- | -------- | --------------------------------------------------- | ------------ |
| **Tipos Numéricos Inteiros** |         |          |                                                     |              |
|                                | `byte`  | 8 bits   | -128 a 127                                          | `0`          |
|                                | `short` | 16 bits  | -32768 a 32767                                      | `0`          |
|                                | `int`   | 32 bits  | -2.147.483.648 a 2.147.483.647                     | `0`          |
|                                | `long`  | 64 bits  | -9.223.372.036.854.770.000 a 9.223.372.036.854.770.000 | `0L`         |
| **Tipos Numéricos com Ponto Flutuante** |         |          |                                                     |              |
|                                | `float` | 32 bits  | Números com aprox. 6-7 dígitos decimais de precisão   | `0.0f`       |
|                                | `double`| 64 bits  | Números com aprox. 15 dígitos decimais de precisão    | `0.0`        |
| **Um Caractere Unicode** | `char`  | 16 bits  | '\\u0000' a '\\uFFFF' (um único caractere)           | `'\u0000'`   |
| **Valor Verdade (Lógico)** | `boolean`| 1 bit    | `false` ou `true`                                   | `false`      |

**Notas Adicionais sobre Tipos:**

  - **Escolha do Tipo Inteiro:** Use `int` como padrão para números inteiros, a menos que haja uma razão específica para `byte`, `short` (economia de memória em grandes arrays) ou `long` (valores muito grandes).
  - **Escolha do Tipo Ponto Flutuante:** Use `double` como padrão para números decimais devido à sua maior precisão em relação ao `float`. Use `f` como sufixo para literais `float` (ex: `3.14f`).
  - **`char`**: Armazena um único caractere Unicode. Literais `char` são colocados entre aspas simples (ex: `'A'`, `'%'`, `'\u0061'` para 'a').
  - **`boolean`**: Usado para representar condições verdadeiras ou falsas, comumente em estruturas de controle.

**String:**

  - `String` não é um tipo primitivo, mas uma **classe** em Java, usada para representar sequências de caracteres (palavras, textos). É fundamental e possui tratamento especial na linguagem.
    Exemplo: `String mensagem = "Olá, Mundo!";`

**Unicode:**

  - Java usa Unicode para representar caracteres, o que permite o uso de caracteres de diversas línguas.
  - Exemplo: `'a'` é representado como `'\u0061'` em Unicode.
  - Um bit pode armazenar 2 valores (0 ou 1). Com 8 bits ($2^8$), temos 256 possibilidades. Com 16 bits ($2^{16}$), `char` pode representar 65.536 caracteres diferentes.

### Nomes de Variáveis

Regras e convenções para nomear variáveis em Java:

  - **Não pode começar com dígito**: Deve começar com uma letra, `_` (underline), ou `$` (cifrão - geralmente não recomendado para nomes comuns).
  - **Não pode ter espaço em branco**.
  - **Não usar acentos ou til** (embora tecnicamente permitido em alguns casos com Unicode, é uma má prática e pode causar problemas de compatibilidade).
  - **Sugestão (Convenção Forte)**: Use o padrão **"camelCase"**.
      - Inicia com letra minúscula.
      - Se o nome for composto por várias palavras, a primeira letra de cada palavra subsequente é maiúscula.
      - Exemplos: `nomeCliente`, `saldoDaConta`, `taxaDeJurosAnual`.

**Exemplos de Nomes de Variáveis:**

| Errado (ou má prática)      | Correto                        |
| --------------------------- | ------------------------------ |
| `int 5minutos;`             | `int _5minutos;` ou `int cincoMinutos;` |
| `int salário;` (com acento) | `int salario;`                 |
| `int salário do funcionario;` (com espaço e acento) | `int salarioDoFuncionario;`    |

### Resumo da Aula (Variáveis e Tipos)

  - **Conceito informal de variável**: Espaço na memória para guardar dados.
  - **Declaração de variáveis**: `<tipo> <nome> = <valor inicial>;`
  - **Tipos primitivos**:
      - Números inteiros: `byte`, `short`, `int`, `long`
      - Números com ponto flutuante: `float`, `double`
      - Valor verdade: `boolean`
      - Um caractere Unicode: `char`
  - **Tipo String**: Cadeia de caracteres (palavras, textos).
  - **Nomes de variáveis**: Regras e o padrão camelCase.

-----

## As Três Operações Básicas de Programação

Um programa de computador é capaz de realizar essencialmente três operações:

1.  **Entrada de dados**: Receber dados do mundo exterior (ex: teclado, arquivo, rede).
2.  **Processamento de dados**: Realizar cálculos, manipulações e tomar decisões com base nos dados.
3.  **Saída de dados**: Enviar dados processados para o mundo exterior (ex: tela, impressora, arquivo).

### Entrada de Dados

  - Ocorre quando o **Usuário** (ou outra fonte) fornece dados para o **Programa**.
  - Esses dados são tipicamente armazenados dentro de variáveis.
  - Dispositivos comuns de ENTRADA: teclado, mouse, leitor de arquivos.
  - Também chamada de **LEITURA**: "O programa está lendo dados."

### Processamento de Dados

  - É quando o programa realiza os cálculos e transformações nos dados.
  - O processamento de dados se dá por um comando chamado **ATRIBUIÇÃO**, onde o resultado de uma expressão é armazenado em uma variável.
    Exemplo: `media = (nota1 + nota2) / 2.0;`

### Saída de Dados

  - Ocorre quando o **Programa** envia dados para o **Usuário** (ou outro destino).
  - Dispositivos comuns de SAÍDA: monitor, impressora, gravador de arquivos.
  - Também chamada de **ESCRITA**: "O programa está escrevendo dados."

-----

## Saída de Dados em Java

Java oferece várias maneiras de exibir dados no console (saída padrão).

### Para Escrever na Tela um Texto Qualquer

  - **Sem quebra de linha ao final:** `System.out.print()`

    ```java
    System.out.print("Bom dia!");
    System.out.print(" Como você está?"); // Continua na mesma linha
    // Saída: Bom dia! Como você está?
    ```

  - **Com quebra de linha ao final:** `System.out.println()`

    ```java
    System.out.println("Bom dia!");
    System.out.println("Tudo bem?"); // Aparece na linha seguinte
    // Saída:
    // Bom dia!
    // Tudo bem?
    ```

### Para Escrever o Conteúdo de uma Variável de Tipo Básico

Suponha uma variável `int` declarada e iniciada:

```java
int quantidade = 32;
System.out.println(quantidade); // Exibe o valor da variável 'quantidade'
// Saída: 32
```

### Para Escrever o Conteúdo de uma Variável com Ponto Flutuante (Formatado)

Suponha uma variável `double` declarada e iniciada:

```java
double preco = 10.35784;
```

Podemos usar `System.out.println()` para uma saída simples ou `System.out.printf()` para uma saída formatada.

```java
System.out.println(preco); // Saída: 10.35784

// Saída formatada com printf
// %.2f : formata para duas casas decimais
// %.4f : formata para quatro casas decimais
// %n   : insere uma quebra de linha independente de plataforma
System.out.printf("Preço (2 casas): R$ %.2f%n", preco); // Saída: Preço (2 casas): R$ 10.36
System.out.printf("Preço (4 casas): R$ %.4f%n", preco); // Saída: Preço (4 casas): R$ 10.3578
```

**ATENÇÃO: Localidade (Separador Decimal)**

  - O separador decimal padrão (vírgula ou ponto) depende da configuração de localidade (região) do sistema operacional.
  - Para garantir que o ponto `.` seja usado como separador decimal, especialmente ao lidar com entrada de dados que espera esse formato, você pode configurar a localidade padrão do Java para US (Estados Unidos) no início do seu programa:
    ```java
    import java.util.Locale;

    public class Programa {
        public static void main(String[] args) {
            Locale.setDefault(Locale.US); // Configura o ponto como separador decimal
            // Restante do código
            double valor = 25.78;
            System.out.printf("Valor: %.2f%n", valor); // Saída: Valor: 25.78
        }
    }
    ```

### Para Concatenar Vários Elementos em um Mesmo Comando de Escrita

**Regra geral para `print` e `println`:**
Use o operador `+` para concatenar (unir) strings e outros tipos de dados. Se um dos operandos for uma String, os outros tipos são convertidos para String.
`elemento1 + elemento2 + elemento3 + ... + elementoN`

```java
String produto = "Laptop";
double precoProduto = 3500.50;
int quantidadeProduto = 5;

System.out.println("Produto: " + produto + ", Preço: R$ " + precoProduto + ", Quantidade: " + quantidadeProduto);
// Saída: Produto: Laptop, Preço: R$ 3500.5, Quantidade: 5
```

**Regra geral para `printf`:**
Use especificadores de formato (`%s` para string, `%d` para inteiro, `%f` para ponto flutuante, `%c` para char, `%b` para boolean, `%n` para nova linha) na string de formato, seguidos pelas variáveis correspondentes.

`"TEXTO1 %<especificador1> TEXTO2 %<especificador2> ...", variavel1, variavel2, ...`

**Especificadores de Formato Comuns:**

  - `%f`: Ponto flutuante (double ou float). Ex: `%.2f` para duas casas decimais.
  - `%d`: Inteiro decimal (byte, short, int, long).
  - `%s`: String.
  - `%c`: Caractere.
  - `%b`: Boolean.
  - `%n`: Quebra de linha (independente de plataforma).

<!-- end list -->

```java
String nome = "Maria";
int idade = 31;
double renda = 4000.0;

System.out.printf("%s tem %d anos e ganha R$ %.2f reais.%n", nome, idade, renda);
// Saída: Maria tem 31 anos e ganha R$ 4000.00 reais.
```

*Mais informações sobre formatação podem ser encontradas na documentação oficial do Java sobre `Formatter`.*

### Resumo da Aula (Saída de Dados)

  - `System.out.print()`: Escreve sem pular linha.
  - `System.out.println()`: Escreve e pula para a próxima linha.
  - `System.out.printf()`: Escreve dados formatados.
      - Especificadores de formato: `%d` (inteiro), `%f` (ponto flutuante), `%s` (string), `%c` (char), `%b` (boolean), `%n` (nova linha).
  - `Locale`: Configuração de localidade, importante para formatação de números (ex: `Locale.US` para ponto decimal).
  - Como concatenar vários elementos:
      - Com `+` em `print`/`println`.
      - Com especificadores de formato em `printf`.
  - Exemplos práticos de uso.

-----

### Exercício de Fixação

Em um novo programa, inicie as seguintes variáveis:

```java
String produto1 = "Computador";
String produto2 = "Mesa de escritório";
int idade = 30;
int codigo = 5290;
char genero = 'F';
double preco1 = 2100.0;
double preco2 = 650.50;
double medida = 53.234567;
```

Em seguida, usando os valores das variáveis, produza a seguinte saída na tela do console:

```
Produtos:
Computador, cujo preço é $ 2100,00
Mesa de escritório, cujo preço é $ 650,50

Registro: 30 anos, código 5290 e gênero: F

Medida com oito casas decimais: 53,23456700
Arredondado (três casas decimais): 53,235
Ponto decimal US: 53.235
```

**Solução Proposta:**

```java
import java.util.Locale;

public class Main { // Mantido 'Main' conforme exemplo do PDF para este exercício específico
    public static void main(String[] args) {
        String produto1 = "Computador";
        String produto2 = "Mesa de escritório";
        // No PDF a variável idade do exercício foi declarada como int,
        // mas na solução foi usada byte. Vamos usar byte como na solução.
        byte idade = 30; 
        int codigo = 5290;
        char genero = 'F';
        double preco1 = 2100.0;
        double preco2 = 650.50;
        double medida = 53.234567;

        System.out.println("Produtos:");
        // Para formatar com vírgula como separador decimal, a localidade padrão do sistema
        // (se for Brasil, por exemplo) já faria isso. Se não, precisaríamos de um NumberFormat.
        // O printf com Locale padrão do Brasil usaria vírgula.
        // Para manter o formato exato do exercício ($ 2100,00):
        System.out.printf("%s, cujo preço é $ %.2f%n", produto1, preco1);
        System.out.printf("%s, cujo preço é $ %.2f%n", produto2, preco2);
        System.out.println(); // Linha em branco
        System.out.printf("Registro: %d anos, código %d e gênero: %c%n", idade, codigo, genero);
        System.out.println(); // Linha em branco

        // Para "Medida com oito casas decimais: 53,23456700"
        // Se a localidade padrão for pt_BR, a vírgula será usada.
        System.out.printf("Medida com oito casas decimais: %.8f%n", medida);
        // Para "Arredondado (três casas decimais): 53,235"
        System.out.printf("Arredondado (três casas decimais): %.3f%n", medida);
        
        Locale.setDefault(Locale.US); // Muda para ponto decimal
        System.out.printf("Ponto decimal US: %.3f%n", medida);
    }
}
```

*Nota: A formatação exata do separador decimal (`.` ou `,`) em `printf` depende da `Locale`. O exercício pede explicitamente uma saída com vírgula e depois com ponto.*

-----

## Processamento de Dados em Java, Casting

### Processamento de Dados

O processamento de dados em Java frequentemente envolve o **comando de atribuição**.

**Sintaxe:**
`<variável> = <expressão>;`

Lê-se: A `<variável>` **recebe** o resultado da `<expressão>`.

**REGRA:**

1.  A `<expressão>` à direita do `=` é calculada primeiro.
2.  O resultado da expressão é armazenado na `<variável>` à esquerda do `=`.

**Exemplo 1:**

```java
int x, y;
x = 5;       // x recebe 5
y = 2 * x;   // A expressão (2 * x), que é (2 * 5 = 10), é calculada.
             // y recebe o resultado 10.
System.out.println(x); // Saída: 5
System.out.println(y); // Saída: 10
```

**Exemplo 2: Conversão Implícita**

```java
int xVariavel;
double yVariavel;

xVariavel = 5;
yVariavel = 2 * xVariavel; // xVariavel é int (5). 2 * 5 = 10 (int).
                         // O valor int 10 é promovido (convertido implicitamente) para double 10.0
                         // e armazenado em yVariavel.
System.out.println(xVariavel);   // Saída: 5
System.out.println(yVariavel); // Saída: 10.0
```

**Exemplo 3: Cálculo de Área de Trapézio**
Fórmula da área do trapézio: $area = \\frac{(\\text{baseMenor} + \\text{baseMaior})}{2} \\times \\text{altura}$

```java
double baseMenor, baseMaior, altura, area;

baseMenor = 6.0;
baseMaior = 8.0;
altura = 5.0;

area = (baseMenor + baseMaior) / 2.0 * altura; 
// (6.0 + 8.0) / 2.0 * 5.0  =>  14.0 / 2.0 * 5.0  =>  7.0 * 5.0  =>  35.0

System.out.println(area); // Saída: 35.0
```

**Boa Prática ao Lidar com Números de Ponto Flutuante:**

  - Sempre indique o tipo do número literal se a expressão for de ponto flutuante.
      - Para `double`, use `.0` (ex: `2.0`, `0.0`) ou simplesmente o ponto decimal (ex: `2.`, `0.`).
      - Para `float`, use o sufixo `f` (ex: `2.0f`, `6f`).

<!-- end list -->

```java
// Exemplo com float
float bMenorF, bMaiorF, alturaF, areaF;
bMenorF = 6f;
bMaiorF = 8f;
alturaF = 5f;
areaF = (bMenorF + bMaiorF) / 2f * alturaF;
System.out.println(areaF); // Saída: 35.0
```

### Casting (Conversão Explícita de Tipos)

**Casting** é a conversão explícita de um tipo de dado para outro. É necessário quando o compilador não consegue realizar uma conversão implícita segura (geralmente de um tipo "maior" para um "menor", ou entre tipos não diretamente compatíveis sem perda de informação).

**Sintaxe:** `(<tipo_desejado>) <valor_ou_variavel>;`

**Exemplo 4: Divisão Inteira vs. Divisão com Ponto Flutuante**
Se dividirmos dois inteiros, o resultado é um inteiro (a parte decimal é truncada).

```java
int a, b;
double resultado;

a = 5;
b = 2;

// Problema: Divisão inteira
resultado = a / b; // 5 / 2 (divisão inteira) resulta em 2. 
                   // O valor 2 (int) é promovido para 2.0 (double) e armazenado em resultado.
System.out.println(resultado); // Saída: 2.0 (incorreto se esperávamos 2.5)
```

**Solução com Casting:**
Para obter um resultado com ponto flutuante, precisamos converter um dos operandos para `double` *antes* da divisão.

```java
int numeroA, numeroB;
double resultadoDivisao;

numeroA = 5;
numeroB = 2;

// Solução: Fazer o casting de 'numeroA' (ou 'numeroB') para double
resultadoDivisao = (double) numeroA / numeroB; // (double) 5 / 2  =>  5.0 / 2  =>  2.5
System.out.println(resultadoDivisao);         // Saída: 2.5
```

**Exemplo 5: Casting de `double` para `int` (Perda de Informação)**
Ao converter um `double` para `int`, a parte fracionária é perdida (truncada, não arredondada).

```java
double numeroDouble = 5.9;
int numeroInteiro;

// numeroInteiro = numeroDouble; // ERRO DE COMPILAÇÃO! Conversão implícita de double para int não é permitida.

numeroInteiro = (int) numeroDouble; // Casting explícito. A parte decimal (.9) é truncada.
System.out.println(numeroInteiro);  // Saída: 5
```

É crucial estar ciente da possível perda de informação ao fazer casting de um tipo de maior capacidade/precisão para um de menor.

-----

## Entrada de Dados em Java

Para ler dados do teclado (entrada padrão), Java utiliza a classe `Scanner`, que pertence ao pacote `java.util`.

### Configurando o Scanner

Primeiro, crie um objeto do tipo `Scanner` associado à entrada padrão (`System.in`):

```java
import java.util.Scanner; // Necessário importar a classe

public class ProgramaEntrada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Cria o objeto Scanner

        // ... usar o Scanner para ler dados ...

        sc.close(); // Boa prática: fechar o Scanner quando não for mais necessário para liberar recursos.
    }
}
```

### Lendo Diferentes Tipos de Dados

**1. Para ler uma palavra (texto sem espaços): `sc.next()`**
Lê a próxima sequência de caracteres até encontrar um espaço, tabulação ou nova linha.

```java
System.out.print("Digite seu primeiro nome: ");
String primeiroNome = sc.next();
System.out.println("Olá, " + primeiroNome + "!");
```

**2. Para ler um número inteiro: `sc.nextInt()`**
Lê a próxima sequência de caracteres que representa um inteiro e a converte para `int`.

```java
System.out.print("Digite sua idade: ");
int idadeUsuario = sc.nextInt();
System.out.println("Você tem " + idadeUsuario + " anos.");
```

**3. Para ler um número com ponto flutuante: `sc.nextDouble()`**
Lê a próxima sequência de caracteres que representa um número de ponto flutuante e a converte para `double`.

```java
System.out.print("Digite sua altura (ex: 1.75): ");
double alturaUsuario = sc.nextDouble(); // Espera ponto como separador se Locale.US estiver configurado
System.out.println("Sua altura é " + alturaUsuario + "m.");
```

**ATENÇÃO `Locale`**: Como mencionado antes, para `nextDouble()` (e `nextFloat()`) interpretar corretamente o ponto como separador decimal, independentemente da configuração regional do sistema, é recomendado definir `Locale.setDefault(Locale.US);` no início do método `main`.

**4. Para ler um caractere: `sc.next().charAt(0)`**
Não existe um `sc.nextChar()`. Para ler um único caractere, leia a próxima palavra (string) com `sc.next()` e pegue o primeiro caractere dessa string usando `charAt(0)`.

```java
System.out.print("Digite seu gênero (M/F): ");
char generoUsuario = sc.next().charAt(0);
System.out.println("Gênero digitado: " + generoUsuario);
```

**5. Para ler vários dados na mesma linha (separados por espaço):**
Você pode fazer chamadas consecutivas aos métodos `next()`, `nextInt()`, `nextDouble()`, etc. O Scanner consumirá os dados da linha um por um.

```java
System.out.print("Digite seu nome, idade e salário (separados por espaço): ");
// Exemplo de entrada: Ana 25 3500.75
String nomePessoa = sc.next();
int idadePessoa = sc.nextInt();
double salarioPessoa = sc.nextDouble();

System.out.printf("Nome: %s, Idade: %d, Salário: R$ %.2f%n", nomePessoa, idadePessoa, salarioPessoa);
```

**6. Para ler um texto ATÉ A QUEBRA DE LINHA: `sc.nextLine()`**
Lê todos os caracteres restantes na linha atual, incluindo espaços, até que a tecla Enter (nova linha) seja pressionada.

```java
System.out.print("Digite uma frase completa: ");
String frase = sc.nextLine();
System.out.println("Você digitou: " + frase);
```

### ATENÇÃO: Quebra de Linha Pendente (Problema Comum)

Quando você usa um comando de leitura que não consome a quebra de linha (como `nextInt()`, `nextDouble()`, `next()`), e em seguida tenta ler uma linha inteira com `nextLine()`, essa quebra de linha "pendente" é consumida pelo `nextLine()`, resultando em uma leitura de uma string vazia.

**Exemplo do Problema:**

```java
Scanner leitor = new Scanner(System.in);
System.out.print("Digite um número inteiro: ");
int numero = leitor.nextInt(); // Lê o número, mas deixa o "\n" (Enter) no buffer

System.out.print("Digite seu nome completo: ");
String nomeCompleto = leitor.nextLine(); // Consome o "\n" pendente, nomeCompleto fica vazio!

System.out.println("Número: " + numero);
System.out.println("Nome: '" + nomeCompleto + "'"); // Mostra o nome como vazio

leitor.close();
```

**Solução:**
Consuma a quebra de linha pendente com uma chamada extra a `sc.nextLine()` antes de ler a linha desejada.

```java
Scanner leitorSolucao = new Scanner(System.in);
System.out.print("Digite um número inteiro: ");
int numeroId = leitorSolucao.nextInt();

leitorSolucao.nextLine(); // <<< LIMPA O BUFFER (consome o "\n" pendente)

System.out.print("Digite seu nome completo: ");
String nomeFuncionario = leitorSolucao.nextLine(); // Agora lê corretamente

System.out.println("ID: " + numeroId);
System.out.println("Nome do Funcionário: '" + nomeFuncionario + "'");

leitorSolucao.close();
```

### Resumo da Aula (Entrada de Dados)

  - **`Scanner`**: Classe para facilitar a leitura de dados da entrada padrão.
      - `Scanner sc = new Scanner(System.in);`
      - `sc.close();` (importante para liberar recursos).
  - **Métodos de Leitura:**
      - `sc.next()`: Lê uma palavra (string sem espaços).
      - `sc.nextInt()`: Lê um número inteiro.
      - `sc.nextDouble()`: Lê um número de ponto flutuante.
      - `sc.next().charAt(0)`: Lê um único caractere.
      - `sc.nextLine()`: Lê uma linha inteira de texto.
  - **`Locale`**: `Locale.setDefault(Locale.US);` para usar ponto como separador decimal na entrada.
  - **Problema da Quebra de Linha Pendente**: Ocorre ao misturar `nextInt()`/`nextDouble()`/`next()` com `nextLine()`.
      - **Solução**: Consumir a quebra de linha com um `sc.nextLine()` extra.

-----

## Funções Matemáticas em Java

Java fornece uma variedade de funções matemáticas prontas para uso através da classe `Math`, que faz parte do pacote `java.lang` (importado automaticamente).

### Algumas Funções Matemáticas Comuns em Java (`Math`)

| Exemplo de Uso             | Significado                                     | Função Math          |
| -------------------------- | ----------------------------------------------- | -------------------- |
| `A = Math.sqrt(x);`        | Variável `A` recebe a raiz quadrada de `x`.     | `Math.sqrt(double a)`|
| `A = Math.pow(x, y);`      | Variável `A` recebe o resultado de `x` elevado a `y`. | `Math.pow(double a, double b)` |
| `A = Math.abs(x);`         | Variável `A` recebe o valor absoluto de `x`.    | `Math.abs(double a)` (também para `int`, `long`, `float`) |
| `A = Math.sin(x);`        | Variável `A` recebe o seno de `x` (x em radianos).| `Math.sin(double a)` |
| `A = Math.cos(x);`        | Variável `A` recebe o cosseno de `x` (x em radianos).| `Math.cos(double a)` |
| `A = Math.tan(x);`        | Variável `A` recebe a tangente de `x` (x em radianos).| `Math.tan(double a)` |
| `A = Math.round(x);`      | Variável `A` recebe o valor de `x` arredondado para o inteiro mais próximo (retorna `long` para `double`, `int` para `float`). | `Math.round(double a)` ou `Math.round(float a)`|
| `A = Math.ceil(x);`       | Variável `A` recebe o menor inteiro maior ou igual a `x`. | `Math.ceil(double a)` |
| `A = Math.floor(x);`      | Variável `A` recebe o maior inteiro menor ou igual a `x`. | `Math.floor(double a)` |
| `A = Math.max(x, y);`     | Variável `A` recebe o maior valor entre `x` e `y`. | `Math.max(double a, double b)` (e outras sobrecargas) |
| `A = Math.min(x, y);`     | Variável `A` recebe o menor valor entre `x` e `y`. | `Math.min(double a, double b)` (e outras sobrecargas) |
| `double PI = Math.PI;`    | A constante PI ($\\pi \\approx 3.14159$).        | `Math.PI`            |
| `double E = Math.E;`      | A constante E (base dos logaritmos naturais $\\approx 2.71828$). | `Math.E`             |

**Exemplo de Código:**

```java
public class ProgramaMatematica {
    public static void main(String[] args) {
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double anguloGraus = 90.0;
        double anguloRadianos = Math.toRadians(anguloGraus); // Converter graus para radianos

        double resultadoA, resultadoB, resultadoC;

        // Raiz Quadrada
        resultadoA = Math.sqrt(x); // Raiz de 3.0
        resultadoB = Math.sqrt(y); // Raiz de 4.0
        resultadoC = Math.sqrt(25.0); // Raiz de 25.0
        System.out.println("Raiz quadrada de " + x + " = " + resultadoA); // Saída: ~1.732
        System.out.println("Raiz quadrada de " + y + " = " + resultadoB); // Saída: 2.0
        System.out.println("Raiz quadrada de 25 = " + resultadoC);   // Saída: 5.0

        // Potenciação
        resultadoA = Math.pow(x, y);    // 3.0 elevado a 4.0
        resultadoB = Math.pow(x, 2.0);  // 3.0 elevado ao quadrado
        resultadoC = Math.pow(5.0, 3.0);  // 5.0 elevado ao cubo
        System.out.println(x + " elevado a " + y + " = " + resultadoA);    // Saída: 81.0
        System.out.println(x + " elevado ao quadrado = " + resultadoB); // Saída: 9.0
        System.out.println("5 elevado ao cubo = " + resultadoC);     // Saída: 125.0

        // Valor Absoluto
        resultadoA = Math.abs(y); // Valor absoluto de 4.0
        resultadoB = Math.abs(z); // Valor absoluto de -5.0
        System.out.println("Valor absoluto de " + y + " = " + resultadoA); // Saída: 4.0
        System.out.println("Valor absoluto de " + z + " = " + resultadoB); // Saída: 5.0
        
        // Funções Trigonométricas (ângulo em radianos)
        System.out.println("Seno de " + anguloGraus + " graus = " + Math.sin(anguloRadianos)); // Saída: 1.0
    }
}
```

### Incluindo Funções em Expressões Maiores

As funções matemáticas podem ser usadas como parte de expressões aritméticas mais complexas, como no cálculo das raízes de uma equação quadrática usando a fórmula de Bhaskara:
$x = \\frac{-b \\pm \\sqrt{\\Delta}}{2a}$, onde $\\Delta = b^2 - 4ac$.

```java
// Exemplo de cálculo das raízes de uma equação quadrática ax^2 + bx + c = 0
double a = 1.0;
double b = -3.0;
double c = 2.0;
double delta, x1, x2;

// Calcula o delta
delta = Math.pow(b, 2.0) - 4 * a * c; // (-3)^2 - 4*1*2 = 9 - 8 = 1

// Verifica se existem raízes reais
if (delta >= 0) {
    // Calcula as raízes
    x1 = (-b + Math.sqrt(delta)) / (2.0 * a); // (3 + sqrt(1)) / (2*1) = (3+1)/2 = 2
    x2 = (-b - Math.sqrt(delta)) / (2.0 * a); // (3 - sqrt(1)) / (2*1) = (3-1)/2 = 1

    System.out.println("x1 = " + x1); // Saída: x1 = 2.0
    System.out.println("x2 = " + x2); // Saída: x2 = 1.0
} else {
    System.out.println("A equação não possui raízes reais.");
}
```

### Resumo (Funções Matemáticas)

  - A classe `Math` (do pacote `java.lang`) oferece diversas funções estáticas para operações matemáticas.
      - `Math.sqrt()`: Raiz quadrada.
      - `Math.pow()`: Potenciação.
      - `Math.abs()`: Valor absoluto.
      - E muitas outras (trigonométricas, logarítmicas, arredondamento, etc.).
  - As funções geralmente operam com `double` e retornam `double`.
  - Podem ser integradas diretamente em expressões complexas.
  - Para mais informações, consulte a documentação oficial da classe `java.lang.Math`.

---
## 📚