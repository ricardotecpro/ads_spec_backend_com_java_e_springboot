# Java e Orientação a Objetos: Estrutura Sequencial

Este documento aborda os conceitos fundamentais da estrutura sequencial em Java, incluindo expressões aritméticas, variáveis, tipos primitivos, entrada e saída de dados, processamento e casting, e funções matemáticas.

---

## Expressões Aritméticas

Uma **expressão aritmética** é uma combinação de operandos (valores, variáveis) e operadores aritméticos que resulta em um valor numérico.

**Exemplo:**
4 + 5 resulta em 9

---

### Operadores Aritméticos

As linguagens C, C++, Java e C# utilizam os seguintes operadores aritméticos:

| Operador | Significado             |
| :------- | :---------------------- |
| `+`      | Adição                  |
| `-`      | Subtração               |
| `*`      | Multiplicação           |
| `/`      | Divisão                 |
| `%`      | Resto da divisão ("mod") |

**Precedência dos Operadores:**
1.  `*` `/` `%` (Multiplicação, Divisão, Módulo)
2.  `+` `-` (Adição, Subtração)

Parênteses `()` podem ser usados para alterar a ordem de avaliação padrão.

---

### Exemplos de Expressões Aritméticas

-   2 * 6 / 3  = Resultado: 4
-   3 + 2 * 4  = Resultado: 11 (Multiplicação primeiro: 2 * 4 = 8, depois 3 + 8 = 11)
-   (3 + 2) * 4 = Resultado: 20 (Parênteses primeiro: 3 + 2 = 5, depois 5 * 4 = 20)
-   60 / (3 + 2) * 4 = Resultado: 48 (Parênteses: 3+2=5; Divisão: 60/5=12; Multiplicação: 12*4=48)
-   60 / ((3 + 2) * 4) = Resultado: 3 (Parênteses internos: 3+2=5; Multiplicação dentro dos parênteses externos: 5*4=20; Divisão: 60/20=3)

---

### Exemplos com o Operador "mod" (Resto da Divisão)

O operador `%` (mod) retorna o resto de uma divisão inteira.

-   `14 % 3` = Resultado: 2
    * Pois: 14 dividido por 3 é 4 com resto 2. (14 = 3 * 4 + 2)
-   `19 % 5` =  Resultado: 4
    * Pois: 19 dividido por 5 é 3 com resto 4. (19 = 5 * 3 + 4)

---

## Variáveis e Tipos Primitivos em Java

### Visão Geral

-   Um programa de computador em execução lida com **dados**.
-   Esses dados são armazenados em **VARIÁVEIS**.

---

### Variáveis

**Definição Informal:**
Em programação, uma **variável** é uma porção de memória (RAM) utilizada para armazenar dados durante a execução dos programas.

Uma variável possui:
-   **Nome** (ou identificador): Um nome único para se referir à variável.
-   **Tipo**: Define o tipo de dado que a variável pode armazenar (ex: número inteiro, texto).
-   **Valor**: O dado armazenado na variável.
-   **Endereço**: A localização na memória onde o valor está armazenado (geralmente gerenciado pelo sistema).

**Exemplo Esquemático na Memória RAM:**
-   Variável `x` pode armazenar o valor `3`.
-   Variável `salario` pode armazenar o valor `5000.0`.
-   Variável `nome` pode armazenar o valor `"Maria"`.

---

### Declaração de Variáveis

A sintaxe para declarar uma variável em Java é:
`<tipo> <nome> = <valor inicial>;` (a inicialização é opcional no momento da declaração, mas variáveis locais devem ser inicializadas antes do uso).

**Exemplos:**
```java
int idade = 25;
double altura = 1.68;
char sexo = 'F';
String nome = "João"; // String não é um tipo primitivo, mas uma classe.
```

---

### Tipos Primitivos em Java

Java possui oito tipos de dados primitivos:

| Descrição                          | Tipo      | Tamanho | Valores Mínimos e Máximos Aproximados        | Valor Padrão |
| :--------------------------------- | :-------- | :------ | :----------------------------------------- | :----------- |
| **Tipos Numéricos Inteiros** |           |         |                                            |              |
| Representa um byte                 | `byte`    | 8 bits  | -128 a 127                                 | `0`          |
| Inteiro curto                      | `short`   | 16 bits | -32768 a 32767                             | `0`          |
| Inteiro padrão                     | `int`     | 32 bits | -2.147.483.648 a 2.147.483.647             | `0`          |
| Inteiro longo                      | `long`    | 64 bits | -9 x 10^{18} a 9 x 10^{18} (aproximadamente) | `0L`         |
| **Tipos Numéricos com Ponto Flutuante** |        |         |                                            |              |
| Ponto flutuante de precisão simples| `float`   | 32 bits | +/- 3.4 x 10^{38}                          | `0.0f`       |
| Ponto flutuante de precisão dupla  | `double`  | 64 bits | +/- 1.8 x 10^{308}                         | `0.0`        |
| **Outros Tipos** |           |         |                                            |              |
| Um caractere Unicode               | `char`    | 16 bits | '\u0000' a '\uFFFF' (0 a 65535)            | `'\u0000'`   |
| Valor verdade (booleano)           | `boolean` | 1 bit   | `true` ou `false`                            | `false`      |

**Nota sobre Bits e Possibilidades:**
-   Um bit pode armazenar 2 valores possíveis (0 ou 1).
-   Com 8 bits, temos 2^8 = 256 possibilidades.

**Tipo `String`**:
-   Embora não seja um tipo primitivo, a `String` é fundamental em Java para representar cadeias de caracteres (palavras, textos). Exemplo: `String mensagem = "Olá, Mundo!";`

---

### Nomes de Variáveis

Regras e convenções para nomear variáveis em Java:
-   **Não pode começar com dígito**: Deve iniciar com uma letra, underscore (`_`) ou cifrão (``). É convenção iniciar com letra minúscula.
-   **Não pode ter espaço em branco**.
-   **Não usar acentos ou til** (embora permitido, não é uma boa prática para portabilidade e consistência).
-   **Case-sensitive**: `minhaVariavel` é diferente de `minhavariavel`.
-   **Sugestão**: Use o padrão **camelCase**. Neste padrão, a primeira palavra começa com letra minúscula e as subsequentes começam com letra maiúscula. Ex: `salarioDoFuncionario`, `idadeDoAluno`.
-   **Não pode ser uma palavra reservada** do Java (ex: `int`, `class`, `public`).

**Exemplos:**

*Errado:*
```java
// int 5minutos; // Começa com dígito
// int salário; // Contém acento (evitar)
// int salário do funcionario; // Contém espaços e acento
```

*Correto (seguindo convenções):*
```java
int cincoMinutos; // Ou _5minutos, mas menos comum para variáveis locais
int salario; // Sem acento
int salarioDoFuncionario; // Padrão camelCase
```

---

## As Três Operações Básicas de Programação

Um programa de computador é capaz de realizar essencialmente três operações:

1.  **Entrada de dados**: Receber dados do usuário ou de outra fonte.
2.  **Processamento de dados**: Realizar cálculos e manipulações com os dados.
3.  **Saída de dados**: Apresentar os resultados para o usuário ou enviá-los para outra destino.

---

### Entrada de Dados

-   A entrada de dados ocorre quando o **Usuário** (ou outra fonte) fornece informações para o **Programa**.
-   Esses dados são tipicamente armazenados em variáveis.
-   Também é chamada de **LEITURA**. Diz-se que "O programa está lendo dados."

---

### Processamento de Dados

-   É quando o programa realiza os cálculos e manipulações com os dados de entrada para produzir um resultado.
-   O processamento de dados se dá principalmente por um comando chamado **ATRIBUIÇÃO**, onde o resultado de uma expressão é armazenado em uma variável.

Exemplo de atribuição:
```java
double media = (nota1 + nota2) / 2.0;
```

---

### Saída de Dados

-   A saída de dados ocorre quando o **Programa** envia informações (resultados) para o **Usuário** ou outro dispositivo.
-   Também é chamada de **ESCRITA**. Diz-se que "O programa está escrevendo dados."

---

## Saída de Dados em Java

Java oferece várias formas de exibir dados no console. As mais comuns utilizam o objeto `System.out`.

### Para Escrever Texto na Tela

-   **Sem quebra de linha ao final** (o cursor permanece na mesma linha):
    ```java
    System.out.print("Bom dia!");
    System.out.print(" Como vai?");
    // Saída: Bom dia! Como vai?
    ```

-   **Com quebra de linha ao final** (o cursor move-se para a próxima linha):
    ```java
    System.out.println("Bom dia!");
    System.out.println("Tudo bem?");
    // Saída:
    // Bom dia!
    // Tudo bem?
    ```

---

### Para Escrever o Conteúdo de uma Variável

-   **Variáveis de tipo básico:**
    Pode-se usar `println` ou `print` para exibir o conteúdo de variáveis.
    ```java
    int y = 32;
    System.out.println(y); // Saída: 32

    String nome = "Ana";
    System.out.println("Nome: " + nome); // Saída: Nome: Ana
    ```

-   **Variáveis com ponto flutuante (formatação):**
    Para controlar o número de casas decimais e a formatação de números de ponto flutuante, utiliza-se `System.out.printf`.
    ```java
    double x = 10.35784;

    System.out.println(x); // Saída padrão: 10.35784

    // Formatando para 2 casas decimais
    System.out.printf("%.2f%n", x); // Saída: 10,36 (a vírgula depende da localidade do sistema)
                                    // %n é um quebra-linha independente de plataforma

    // Formatando para 4 casas decimais
    System.out.printf("%.4f%n", x); // Saída: 10,3578
    ```
    **Atenção à Localidade:**
    Por padrão, `printf` usa a localidade do sistema para formatar números (ex: vírgula como separador decimal em português). Para usar o ponto como separador decimal consistentemente:
    ```java
    import java.util.Locale;

    // Defina a localidade para US (ponto decimal) no início do seu método main
    Locale.setDefault(Locale.US);

    double x = 10.35784;
    System.out.printf("%.2f%n", x); // Saída: 10.36
    ```

---

### Para Concatenar Vários Elementos em um Mesmo Comando de Escrita

-   **Com `print` e `println`:**
    Utilize o operador `+` para concatenar strings e variáveis.
    ```java
    String produto = "Laptop";
    double preco = 3500.90;
    System.out.println("Produto: " + produto + ", Preço: R$ " + preco);
    // Saída: Produto: Laptop, Preço: R$ 3500.90
    ```

-   **Com `printf`:**
    Use especificadores de formato na string de formatação e passe as variáveis como argumentos subsequentes.
    ```java
    // %f = ponto flutuante
    // %d = inteiro decimal
    // %s = string
    // %c = caractere
    // %n = quebra de linha específica da plataforma

    String nome = "Maria";
    int idade = 31;
    double renda = 4000.0;

    // Definindo Locale para garantir o ponto como separador decimal
    Locale.setDefault(Locale.US);
    System.out.printf("%s tem %d anos e ganha R$ %.2f reais.%n", nome, idade, renda);
    // Saída: Maria tem 31 anos e ganha R$ 4000.00 reais.
    ```
    Para mais informações sobre formatação com `printf`, consulte a documentação do `java.util.Formatter`.

---

### Exercício de Fixação (Saída de Dados)

**Problema:**
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
Computador, cujo preço é $ 2100.00
Mesa de escritório, cujo preço é $ 650.50

Registro: 30 anos de idade, código 5290 e gênero: F

Medida com oito casas decimais: 53.23456700
Arredondado (três casas decimais): 53.235
Ponto decimal US: 53.235
```

**Solução:**
```java
import java.util.Locale;

public class ExercicioSaida {

    public static void main(String[] args) {
        String produto1 = "Computador";
        String produto2 = "Mesa de escritório";
        int idade = 30;
        int codigo = 5290;
        char genero = 'F';
        double preco1 = 2100.0;
        double preco2 = 650.50;
        double medida = 53.234567;

        System.out.println("Produtos:");
        // Configura o Locale para US para a formatação de moeda com ponto e duas casas decimais
        // Temporariamente para esta seção, ou globalmente como mostrado abaixo.
        // Para este exemplo, vamos assumir que o Locale global já está US ou que queremos formatar especificamente.
        // Se não definido globalmente, printf usará o locale padrão do sistema para a formatação de moeda.
        // Para garantir o formato "$ 2100.00", precisamos usar Locale.US.
        // Locale.setDefault(Locale.US); // Se não definido antes.

        System.out.printf("%s, cujo preço é $ %.2f%n", produto1, preco1);
        System.out.printf("%s, cujo preço é $ %.2f%n", produto2, preco2);
        System.out.println(); // Linha em branco

        System.out.printf("Registro: %d anos de idade, código %d e gênero: %c%n", idade, codigo, genero);
        System.out.println(); // Linha em branco

        // Para a medida, a formatação pedida (com vírgula) sugere o locale pt-BR.
        // Se o locale padrão for pt-BR, %.8f resultaria em 53,23456700
        // Para o exercício, vamos assumir que o sistema está em pt-BR para essa linha,
        // ou que o requisito de formatação "53,23456700" implica o separador vírgula.
        // Se precisarmos forçar a vírgula:
        // NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
        // nf.setMinimumFractionDigits(8);
        // System.out.println("Medida com oito casas decimais: " + nf.format(medida));
        // Ou, se o Locale.getDefault() já for pt-BR:
        System.out.printf(new Locale("pt", "BR"), "Medida com oito casas decimais: %.8f%n", medida);
        System.out.printf(new Locale("pt", "BR"), "Arredondado (três casas decimais): %.3f%n", medida);
        
        // Para a saída com ponto decimal US:
        Locale.setDefault(Locale.US); // Garante o ponto decimal
        System.out.printf("Ponto decimal US: %.3f%n", medida);
    }
}
```

---

### Atalhos Úteis em IDEs (VS Code e IntelliJ IDEA)

-   **Comentários de Linha**:
    -   Adicionar/Remover comentário de linha: `Ctrl + /` (Windows/Linux) ou `Cmd + /` (Mac) em ambas as IDEs.

-   **Importar Classes Automaticamente**:
    -   **IntelliJ IDEA**: Geralmente importa automaticamente. Para otimizar imports: `Ctrl + Alt + O`.
    -   **VS Code**: Oferece sugestões de importação ao digitar o nome da classe. Para organizar imports: `Shift + Alt + O`. Pode usar `Ctrl + .` (ou `Cmd + .`) sobre um nome de classe não importado para ver opções.

-   **Auto-indentação (Formatar Código)**:
    -   **IntelliJ IDEA**: `Ctrl + Alt + L` (Reformat Code).
    -   **VS Code**: `Shift + Alt + F` (Format Document).

-   **Snippets para `System.out.println()`**:
    -   **IntelliJ IDEA**: Digite `sout` e pressione `Tab`.
    -   **VS Code**: Digite `sout` (ou similar, dependendo dos snippets configurados) e pressione `Tab` ou `Enter`.

---

## Processamento de Dados em Java e Casting

### Processamento de Dados

O comando fundamental para o processamento de dados é o **comando de atribuição**.

**Sintaxe:**
`<variavel> = <expressao>;`

Lê-se: "A variável `<variavel>` **recebe** o resultado da `<expressao>`".

**Regra de Funcionamento:**
1.  Primeiro, a `<expressao>` à direita do `=` é calculada.
2.  Depois, o resultado dessa expressão é armazenado na `<variavel>` à esquerda.

**Exemplo 1: Atribuição Simples**
```java
int x, y;
x = 5;        // x recebe 5
y = 2 * x;    // Expressão 2*x é calculada (2*5 = 10), y recebe 10

System.out.println(x); // Saída: 5
System.out.println(y); // Saída: 10
```

**Exemplo 2: Atribuição com Tipos Diferentes (Promoção Numérica)**
```java
int x;
double y;
x = 5;
y = x; // O valor int 5 de x é promovido para double 5.0 e atribuído a y

System.out.println(x); // Saída: 5
System.out.println(y); // Saída: 5.0

y = 2 * x; // 2 * x (2 * 5 = 10) resulta em um int, que é promovido a double para y
System.out.println(y); // Saída: 10.0
```

**Exemplo 3: Cálculo de Área de Trapézio**
A fórmula da área de um trapézio é Area = \frac{(baseMenor + baseMaior) \times altura}{2}.

```java
double baseMenor, baseMaior, altura, area;

baseMenor = 6.0;
baseMaior = 8.0;
altura = 5.0;

area = (baseMenor + baseMaior) / 2.0 * altura;
// (6.0 + 8.0) / 2.0 * 5.0
// 14.0 / 2.0 * 5.0
// 7.0 * 5.0
// 35.0

System.out.println(area); // Saída: 35.0
```

**Boa Prática ao Trabalhar com Literais de Ponto Flutuante:**
-   Sempre indique o tipo do número se a expressão for de ponto flutuante (não inteira).
    -   Para `double`, use `.0` (ex: `2.0`, `0.0`) ou a ausência de sufixo se houver parte decimal (ex: `3.14`).
    -   Para `float`, use o sufixo `f` ou `F` (ex: `2.5f`, `0.0F`).

```java
// Exemplo com float
float bMenorF, bMaiorF, altF, areaF;
bMenorF = 6f;
bMaiorF = 8f;
altF = 5f;
areaF = (bMenorF + bMaiorF) / 2f * altF;
System.out.println(areaF); // Saída: 35.0
```

---

### Casting (Conversão Explícita de Tipos)

**Casting** é a conversão explícita de um tipo de dado para outro. É necessário quando o compilador não é capaz de "adivinhar" que o resultado de uma expressão deve ser de outro tipo, ou quando há uma conversão que pode resultar em perda de informação (narrowing conversion).

**Exemplo 4: Problema com Divisão Inteira**
Se dividirmos dois inteiros, o resultado será um inteiro (a parte fracionária é truncada).
```java
int a, b;
double resultado;

a = 5;
b = 2;

// resultado = a / b; // Aqui, a / b é 5 / 2, que resulta em 2 (divisão inteira)
                     // Então, 2 é convertido para double 2.0 e armazenado em resultado.
// System.out.println(resultado); // Saída: 2.0
```
Para obter o resultado decimal correto (2.5), precisamos converter um dos operandos para `double` *antes* da divisão:
```java
// ...
resultado = (double) a / b; // 'a' é convertido para double (5.0) antes da divisão
                             // 5.0 / 2 resulta em 2.5 (divisão de ponto flutuante)
System.out.println(resultado); // Saída: 2.5
```
Alternativamente:
```java
// resultado = a / (double) b; // Também funciona
// resultado = (double) a / (double) b; // Também funciona, mas um cast é suficiente
```

**Exemplo 5: Casting de `double` para `int` (Perda de Informação)**
Converter um `double` para `int` requer um cast explícito, pois pode haver perda da parte fracionária (truncamento).
```java
double numeroDecimal = 5.7;
int numeroInteiro;

// numeroInteiro = numeroDecimal; // ERRO DE COMPILAÇÃO! Não pode converter double para int implicitamente.

numeroInteiro = (int) numeroDecimal; // Cast explícito. A parte decimal é truncada.
System.out.println(numeroInteiro);    // Saída: 5
```

---

## Entrada de Dados em Java

Para ler dados do teclado (entrada padrão) em Java, utiliza-se a classe `Scanner` do pacote `java.util`.

### Configurando o `Scanner`

1.  **Importe a classe `Scanner`**:
    ```java
    import java.util.Scanner;
    ```
2.  **Crie um objeto `Scanner` associado à entrada padrão (`System.in`)**:
    ```java
    Scanner sc = new Scanner(System.in);
    // É uma boa prática definir o Locale para entrada, especialmente para números decimais
    // sc.useLocale(Locale.US); // Para garantir que o ponto seja o separador decimal na entrada
    ```
3.  **Feche o `Scanner` quando não for mais necessário** para liberar os recursos do sistema:
    ```java
    sc.close();
    ```
    **Importante:** Geralmente, você cria *um único* objeto `Scanner` para `System.in` por aplicação e o fecha no final do programa (ou quando não há mais entrada a ser lida). Fechar um `Scanner` que encapsula `System.in` também fecha `System.in`, o que significa que você não poderá mais ler da entrada padrão pelo restante da execução do programa.

---

### Métodos Comuns do `Scanner`

-   **Para ler uma palavra (texto sem espaços):**
    ```java
    System.out.print("Digite seu primeiro nome: ");
    String primeiroNome = sc.next(); // Lê a próxima sequência de caracteres até um espaço
    System.out.println("Olá, " + primeiroNome + "!");
    ```

-   **Para ler um número inteiro:**
    ```java
    System.out.print("Digite sua idade: ");
    int idade = sc.nextInt();
    System.out.println("Você tem " + idade + " anos.");
    ```
    **Atenção à Localidade para `nextDouble()`:** Se você não configurar o `Scanner` para usar `Locale.US` (com `sc.useLocale(Locale.US);`), ele esperará o separador decimal de acordo com a localidade padrão do sistema (ex: vírgula no Brasil). Se o usuário digitar com ponto, pode ocorrer um `InputMismatchException`.
    ```java
    // Configurando para aceitar ponto como separador decimal na entrada
    sc.useLocale(Locale.US);
    System.out.print("Digite sua altura (ex: 1.75): ");
    double altura = sc.nextDouble();
    System.out.println("Sua altura é " + altura + "m.");
    ```

-   **Para ler um caractere:**
    O `Scanner` não tem um método `nextChar()`. Para ler um único caractere, leia a próxima palavra (`next()`) e pegue o primeiro caractere dela (`charAt(0)`).
    ```java
    System.out.print("Digite seu gênero (M/F): ");
    char genero = sc.next().charAt(0);
    System.out.println("Gênero: " + genero);
    ```

-   **Para ler vários dados na mesma linha:**
    Se os dados estiverem separados por espaços na mesma linha, você pode fazer chamadas consecutivas aos métodos `next()`, `nextInt()`, `nextDouble()`, etc.
    ```java
    System.out.print("Digite seu nome, idade e altura separados por espaço: ");
    // Exemplo de entrada: Carlos 25 1.80
    String nome = sc.next();
    int idadeUsuario = sc.nextInt();
    double alturaUsuario = sc.nextDouble(); // Lembre-se do Locale para o decimal
    System.out.printf("Nome: %s, Idade: %d, Altura: %.2f%n", nome, idadeUsuario, alturaUsuario);
    ```

---

### Para Ler uma Linha Inteira de Texto (Até a Quebra de Linha)

Utilize o método `sc.nextLine()`.

```java
System.out.print("Digite seu nome completo: ");
String nomeCompleto = sc.nextLine();
System.out.println("Nome completo: " + nomeCompleto);
```

**Atenção: Problema da "Quebra de Linha Pendente"**
Quando você lê um número (`nextInt()`, `nextDouble()`, etc.) e depois tenta ler uma linha inteira com `nextLine()`, um problema comum ocorre.
O `nextInt()` (ou similar) lê apenas o número, deixando o caractere de quebra de linha (pressionado Enter) "pendente" no buffer de entrada. A chamada subsequente a `nextLine()` consome essa quebra de linha pendente e retorna uma string vazia, sem esperar pela entrada do usuário.

**Exemplo do Problema:**
```java
System.out.print("Digite um número: ");
int numero = sc.nextInt(); // Lê o número, deixa o \n no buffer
System.out.print("Digite uma frase: ");
String frase = sc.nextLine(); // Consome o \n pendente, frase fica vazia

System.out.println("Número: " + numero);
System.out.println("Frase: '" + frase + "'"); // Frase será vazia
```

**Solução:**
Consuma a quebra de linha pendente com uma chamada extra a `sc.nextLine()` antes de ler a linha de interesse.

```java
System.out.print("Digite um número: ");
int numero = sc.nextInt();
sc.nextLine(); // <-- Linha extra para consumir o \n pendente
System.out.print("Digite uma frase: ");
String frase = sc.nextLine(); // Agora lê a entrada do usuário corretamente

System.out.println("Número: " + numero);
System.out.println("Frase: '" + frase + "'");
```

---

## Funções Matemáticas em Java

A classe `java.lang.Math` (que é importada automaticamente) fornece métodos estáticos para realizar operações matemáticas comuns.

### Algumas Funções Matemáticas Comuns

| Exemplo de Uso         | Significado                                        |
| :--------------------- | :------------------------------------------------- |
| `A = Math.sqrt(x);`  | Variável A recebe a raiz quadrada de `x`.            |
| `A = Math.pow(x, y);` | Variável A recebe o resultado de `x` elevado a `y`. |
| `A = Math.abs(x);`   | Variável A recebe o valor absoluto (módulo) de `x`.|

**Exemplo Prático:**
```java
public class FuncoesMatematicas {
    public static void main(String[] args) {
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double resultadoA, resultadoB, resultadoC;

        // Raiz Quadrada (sqrt)
        resultadoA = Math.sqrt(x);
        resultadoB = Math.sqrt(y);
        resultadoC = Math.sqrt(25.0);
        System.out.println("Raiz quadrada de " + x + " = " + resultadoA); // Aprox. 1.732
        System.out.println("Raiz quadrada de " + y + " = " + resultadoB); // 2.0
        System.out.println("Raiz quadrada de 25 = " + resultadoC);   // 5.0

        // Potenciação (pow)
        resultadoA = Math.pow(x, y); // x elevado a y (3^4)
        resultadoB = Math.pow(x, 2.0); // x elevado ao quadrado (3^2)
        resultadoC = Math.pow(5.0, 2.0); // 5 elevado ao quadrado
        System.out.println(x + " elevado a " + y + " = " + resultadoA);       // 81.0
        System.out.println(x + " elevado ao quadrado = " + resultadoB);   // 9.0
        System.out.println("5 elevado ao quadrado = " + resultadoC);     // 25.0

        // Valor Absoluto (abs)
        resultadoA = Math.abs(y);   // Valor absoluto de y (4.0)
        resultadoB = Math.abs(z);   // Valor absoluto de z (-5.0)
        System.out.println("Valor absoluto de " + y + " = " + resultadoA); // 4.0
        System.out.println("Valor absoluto de " + z + " = " + resultadoB); // 5.0
    }
}
```

---

### Incluindo Funções em Expressões Maiores

Funções matemáticas podem ser combinadas em expressões mais complexas, como no cálculo das raízes de uma equação quadrática (ax^2 + bx + c = 0) usando a fórmula de Bhaskara:
x = \frac{-b \pm \sqrt{\Delta}}{2a}, onde \Delta = b^2 - 4ac.



```java
// Supondo que a, b, c, delta, x1, x2 são declarados como double
// e a, b, c foram inicializados.
double a = 1, b = -3, c = 2; // Exemplo: x^2 - 3x + 2 = 0, raízes são 1 e 2
double delta, x1, x2;

delta = Math.pow(b, 2.0) - 4 * a * c;

if (delta >= 0) {
    x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
    x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
    System.out.println("x1 = " + x1);
    System.out.println("x2 = " + x2);
} else {
    System.out.println("A equação não possui raízes reais.");
}
```

Para mais informações sobre outras funções matemáticas disponíveis, consulte a documentação oficial da classe `java.lang.Math`.

---
## 📚

---

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)
