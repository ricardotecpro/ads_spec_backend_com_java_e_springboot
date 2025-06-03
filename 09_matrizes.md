```markdown
# 🌌 Matrizes em Java

Bem-vindo ao guia sobre matrizes em Java! Aqui, vamos revisar o conceito de matrizes, como declará-las, instanciá-las, acessar seus elementos e utilizar a propriedade `length`.

---

## 🧩 Revisão do Conceito de Matriz

Em programação, **matriz** é o nome dado a arranjos bidimensionais. Pense nelas como uma tabela com linhas e colunas, onde cada célula pode armazenar um dado. Uma forma comum de entender matrizes é como um **"vetor de vetores"**. Isso significa que uma matriz é, na essência, um vetor onde cada elemento é, por sua vez, outro vetor (representando as linhas da matriz).

Um **arranjo (array)**, seja ele unidimensional (vetor) ou bidimensional (matriz), é uma estrutura de dados que possui as seguintes características:

* **Homogênea**: Todos os dados armazenados na matriz devem ser do mesmo tipo (por exemplo, todos inteiros, todos `double`, ou todos `String`).
* **Ordenada**: Os elementos são acessados por meio de suas posições (índices), que geralmente começam em zero. Para uma matriz, você precisará de dois índices: um para a linha e um para a coluna (ex: `minhaMatriz[linha][coluna]`).
* **Alocada de uma vez só**: A memória necessária para armazenar todos os elementos da matriz é reservada em um bloco contíguo quando a matriz é criada.

### Vantagens das Matrizes:

* 👍 **Acesso imediato aos elementos**: Acessar um elemento é rápido se você souber sua posição (índice), pois a localização na memória pode ser calculada diretamente.

### Desvantagens das Matrizes:

* 👎 **Tamanho fixo**: Uma vez que uma matriz é criada, seu tamanho (número de linhas e colunas) não pode ser alterado. Se você precisar de mais ou menos espaço, terá que criar uma nova matriz e, possivelmente, copiar os elementos da antiga.
* 👎 **Dificuldade para realizar inserções e deleções**: Adicionar ou remover elementos no meio de uma matriz pode ser ineficiente, pois pode exigir o deslocamento de muitos outros elementos para manter a estrutura ordenada e contígua.

---

## 🛠️ Declaração e Instanciação de Matrizes em Java

Para usar uma matriz em Java, você primeiro precisa declará-la e depois instanciá-la.

**Declaração**: Aqui você informa ao compilador o nome da sua matriz e o tipo de dados que ela armazenará.

```java
// Declaração de uma matriz de inteiros
int[][] numeros;

// Declaração de uma matriz de Strings
String[][] nomes;

// Declaração de uma matriz de doubles
double[][] salarios;
```

**Instanciação**: Aqui você define o tamanho da matriz (quantas linhas e colunas ela terá) e aloca a memória para ela.

```java
// Instancia uma matriz de inteiros com 3 linhas e 4 colunas
numeros = new int[3][4];

// Declaração e instanciação na mesma linha
String[][] nomes = new String[5][2]; // 5 linhas, 2 colunas

// Você também pode inicializar uma matriz com valores diretamente
double[][] matrizPreenchida = {
    {1.0, 2.5, 3.7}, // Linha 0
    {4.2, 5.1, 6.9}, // Linha 1
    {7.3, 8.6, 9.0}  // Linha 2
};
```

### 🧠 Memória: Stack vs. Heap

Quando você declara uma variável de matriz como `int[][] mat;`, a referência `mat` é armazenada na memória **Stack**.
Quando você instancia a matriz com `mat = new int[3][3];`, o objeto da matriz (que contém os elementos) é criado na memória **Heap**. A variável `mat` na Stack então aponta para a localização desse objeto na Heap.

No exemplo fornecido no material original:
`n` (um inteiro, representando a ordem da matriz) é armazenado na Stack.
`mat` (a referência para a matriz) é armazenada na Stack.
Os dados da matriz `{{5, -3, 10}, {15, 8, 2}, {7, 9, -4}}` são armazenados na Heap.

Visualmente:

```
Memória
+-----------------------------------------------------+
| Stack                   | Heap                        |
| +-------+               |                             |
| |   3   | <--- n        |   +---+---+----+            |
| +-------+               | 0 | 5 | -3| 10 |            |
|                         |   +---+---+----+            |
| +-------+   --------->  | 1 | 15| 8 | 2  |            |
| |  mat  | ----          |   +---+---+----+            |
| +-------+   |           | 2 | 7 | 9 | -4 |            |
|             |           |   +---+---+----+            |
+-----------------------------------------------------+
```

---

## 🚶‍♂️ Acesso aos Elementos e Como Percorrer uma Matriz

Para acessar um elemento específico em uma matriz, você usa seus índices de linha e coluna:

```java
int[][] matriz = {
    {10, 20, 30}, // Linha 0
    {40, 50, 60}, // Linha 1
    {70, 80, 90}  // Linha 2
};

int elemento = matriz[1][2]; // Acessa o elemento na linha 1, coluna 2 (que é 60)
System.out.println(elemento); // Saída: 60

matriz[0][0] = 5; // Modifica o elemento na linha 0, coluna 0 para 5
```

Para percorrer (ou iterar sobre) todos os elementos de uma matriz, você geralmente usará laços `for` aninhados: um para as linhas e outro para as colunas.

```java
public class PercorrerMatriz {
    public static void main(String[] args) {
        int[][] minhaMatriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Loop externo para as linhas
        for (int i = 0; i < minhaMatriz.length; i++) {
            // Loop interno para as colunas de cada linha
            // minhaMatriz[i].length nos dá o número de colunas na linha i
            for (int j = 0; j < minhaMatriz[i].length; j++) {
                System.out.print(minhaMatriz[i][j] + " ");
            }
            System.out.println(); // Nova linha após cada linha da matriz
        }
    }
}
```
**Saída Esperada:**
```
1 2 3
4 5 6
7 8 9
```

---

## 📏 Propriedade `length`

A propriedade `length` é muito útil ao trabalhar com matrizes.

* `matriz.length`: Retorna o **número de linhas** da matriz.
* `matriz[i].length`: Retorna o **número de colunas** da linha `i` da matriz. Isso é particularmente útil para matrizes "irregulares" ou "denteadas" (jagged arrays), onde cada linha pode ter um número diferente de colunas.

```java
public class TamanhoMatriz {
    public static void main(String[] args) {
        int[][] matriz = new int[3][4]; // 3 linhas, 4 colunas

        System.out.println("Número de linhas: " + matriz.length); // Saída: 3
        System.out.println("Número de colunas na primeira linha: " + matriz[0].length); // Saída: 4

        // Exemplo com matriz irregular (jagged array)
        String[][] jaggedArray = {
            {"Java", "Python"},
            {"C++", "C#", "JavaScript"},
            {"Ruby"}
        };

        System.out.println("\nMatriz Irregular:");
        System.out.println("Número de linhas: " + jaggedArray.length); // Saída: 3
        System.out.println("Colunas na linha 0: " + jaggedArray[0].length); // Saída: 2
        System.out.println("Colunas na linha 1: " + jaggedArray[1].length); // Saída: 3
        System.out.println("Colunas na linha 2: " + jaggedArray[2].length); // Saída: 1
    }
}
```

---

## 🎯 Exercício Resolvido

Vamos analisar um exercício comum para praticar o uso de matrizes.

**Problema**: Fazer um programa para ler um número inteiro N e uma matriz de ordem N (N linhas e N colunas) contendo números inteiros. Em seguida, mostrar a diagonal principal e a quantidade de valores negativos da matriz.

**Exemplo de Entrada e Saída**:

**Entrada:**
```
3
5 -3 10
15 8 2
7 9 -4
```

**Saída:**
```
Diagonal principal:
5 8 -4
Numeros negativos = 2
```

### 💡 Solução em Java

Vamos criar um programa Java para resolver este problema. Usaremos a classe `Scanner` para ler a entrada do usuário.

**Configuração do Ambiente (VS Code ou IntelliJ IDEA):**

1.  **Crie um novo projeto Java.**
    * **VS Code**: Use a extensão "Java Extension Pack". Crie um novo arquivo Java (ex: `ProcessarMatriz.java`).
    * **IntelliJ IDEA**: Crie um novo projeto ("File" > "New" > "Project..."), selecione "Java", e siga as instruções. Crie uma nova classe Java (ex: `ProcessarMatriz`).

2.  **Escreva o código:**

```java
package exercicios; // ou qualquer outro nome de pacote que você preferir

import java.util.Scanner;

public class ProcessarMatriz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a ordem da matriz (N): ");
        int n = sc.nextInt();
        int[][] matriz = new int[n][n];

        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < n; i++) { // ou matriz.length
            System.out.println("Elementos da linha " + i + ":");
            for (int j = 0; j < n; j++) { // ou matriz[i].length
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nDiagonal principal:");
        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println(); // Nova linha

        int contadorNegativos = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] < 0) {
                    contadorNegativos++;
                }
            }
        }
        System.out.println("Numeros negativos = " + contadorNegativos);

        sc.close(); // Boa prática: fechar o Scanner quando não for mais necessário
    }
}
```

**Explicação do Código:**

1.  **Importação do `Scanner`**: `import java.util.Scanner;` permite que usemos a classe `Scanner` para ler dados do teclado.
2.  **Leitura da Ordem N**: O programa solicita ao usuário o tamanho `N` da matriz.
3.  **Instanciação da Matriz**: `int[][] matriz = new int[n][n];` cria uma matriz quadrada de `N` linhas e `N` colunas.
4.  **Preenchimento da Matriz**: Dois laços `for` aninhados são usados para percorrer cada célula da matriz e solicitar ao usuário que insira um valor.
5.  **Diagonal Principal**: Para encontrar os elementos da diagonal principal, os índices da linha e da coluna são iguais (`matriz[i][i]`). Um laço `for` simples percorre esses elementos.
6.  **Contagem de Números Negativos**: Dois laços `for` aninhados verificam cada elemento da matriz. Se um elemento for menor que zero, o `contadorNegativos` é incrementado.
7.  **Fechamento do `Scanner`**: `sc.close();` libera os recursos do sistema associados ao `Scanner`.

Este exemplo demonstra os conceitos fundamentais de declaração, instanciação, preenchimento, acesso e processamento de elementos em uma matriz Java.
```
---
## 📚