Okay, aqui está o conteúdo do arquivo PDF convertido para Markdown, traduzido para o português, enriquecido e formatado conforme suas especificações.

---

# Matrizes em Java ☕

Este material aborda o conceito de matrizes em Java, desde sua definição e declaração até a manipulação de seus elementos, com foco prático para desenvolvedores.

## ✅ Checklist

* Revisão do conceito de matriz
* Declaração e instanciação
* Acesso aos elementos / como percorrer uma matriz
* Propriedade `length`

## 🧱 O que são Matrizes?

Em programação, "matriz" é o nome dado a arranjos bidimensionais. Uma forma intuitiva de pensar em matrizes é como um "vetor de vetores". Imagine uma tabela: ela possui linhas e colunas, e cada célula pode conter um dado.

Uma matriz, como um arranjo (array), é uma estrutura de dados com as seguintes características:

* **Homogênea**: Todos os dados armazenados na matriz devem ser do mesmo tipo (por exemplo, todos `int`, todos `double`, etc.).
* **Ordenada**: Os elementos são acessados por meio de suas posições (índices), geralmente um índice para a linha e outro para a coluna.
* **Alocada de uma vez só**: A memória para a matriz é alocada em um bloco contínuo quando ela é criada.

**Exemplo Visual de uma Matriz:**

A tabela a seguir representa uma matriz de números com 3 linhas e 4 colunas:

|       | 0   | 1    | 2    | 3    |
| :---- | :-- | :--- | :--- | :--- |
| **0** | 3.5 | 17.0 | 12.3 | 8.2  |
| **1** | 4.1 | 6.2  | 7.5  | 2.9  |
| **2** | 11.0| 9.5  | 14.8 | 21.7 |

### Vantagens das Matrizes:

* **Acesso imediato aos elementos**: É muito rápido acessar um elemento se você souber sua posição (índices), pois a localização na memória pode ser calculada diretamente.

### Desvantagens das Matrizes:

* **Tamanho fixo**: Uma vez que uma matriz é criada, seu tamanho (número de linhas e colunas) geralmente não pode ser alterado. Se você precisar de mais ou menos espaço, precisará criar uma nova matriz e copiar os dados.
* **Dificuldade para inserções e deleções**: Adicionar ou remover elementos no meio de uma matriz pode ser ineficiente, pois pode exigir o deslocamento de muitos outros elementos.

### Declaração e Instanciação em Java

Para usar uma matriz em Java, você primeiro precisa declará-la e depois instanciá-la (alocar memória para ela).

```java
// Declaração de uma matriz de inteiros
int[][] minhaMatriz;

// Instanciação: alocando memória para uma matriz com 3 linhas e 4 colunas
minhaMatriz = new int[3][4];

// Declaração e instanciação em uma única linha
double[][] matrizNotas = new double[5][2]; // 5 alunos, 2 notas cada

// Você também pode inicializar uma matriz com valores diretamente
String[][] nomes = {
    {"João", "Silva"},
    {"Maria", "Souza"},
    {"Carlos", "Pereira"}
};
```

### Acesso aos Elementos

Os elementos de uma matriz são acessados usando dois índices: o primeiro para a linha e o segundo para a coluna. Lembre-se que os índices em Java começam em 0.

```java
int[][] matrizExemplo = new int[2][3]; // 2 linhas, 3 colunas

// Atribuindo valores
matrizExemplo[0][0] = 10; // Linha 0, Coluna 0
matrizExemplo[0][1] = 20; // Linha 0, Coluna 1
matrizExemplo[0][2] = 30; // Linha 0, Coluna 2
matrizExemplo[1][0] = 40; // Linha 1, Coluna 0
matrizExemplo[1][1] = 50; // Linha 1, Coluna 1
matrizExemplo[1][2] = 60; // Linha 1, Coluna 2

// Acessando e imprimindo um valor
System.out.println(matrizExemplo[1][1]); // Saída: 50
```

### Como Percorrer uma Matriz

Para percorrer (iterar sobre) todos os elementos de uma matriz, geralmente usamos laços `for` aninhados. O laço externo percorre as linhas e o laço interno percorre as colunas de cada linha.

```java
char[][] tabuleiro = {
    {'X', 'O', 'X'},
    {'O', 'X', 'O'},
    {'X', 'O', 'O'}
};

// Percorrendo e imprimindo todos os elementos
for (int i = 0; i < 3; i++) { // i representa a linha
    for (int j = 0; j < 3; j++) { // j representa a coluna
        System.out.print(tabuleiro[i][j] + " ");
    }
    System.out.println(); // Pula para a próxima linha após imprimir uma linha da matriz
}
// Saída:
// X O X
// O X O
// X O O
```

### Propriedade `length`

A propriedade `length` é muito útil ao trabalhar com matrizes.

* `matriz.length`: Retorna o número de **linhas** da matriz.
* `matriz[i].length`: Retorna o número de **colunas** na linha `i` da matriz. Para matrizes retangulares (onde todas as linhas têm o mesmo número de colunas), `matriz[0].length` é suficiente para obter o número de colunas.

```java
int[][] dados = new int[4][5]; // 4 linhas, 5 colunas

System.out.println("Número de linhas: " + dados.length); // Saída: 4
System.out.println("Número de colunas (da primeira linha): " + dados[0].length); // Saída: 5

// Usando length em laços para percorrer a matriz:
for (int i = 0; i < dados.length; i++) {
    for (int j = 0; j < dados[i].length; j++) {
        // Processa dados[i][j]
        dados[i][j] = i * j;
        System.out.print(dados[i][j] + "\t");
    }
    System.out.println();
}
```

## 💻 Exercício Resolvido

Vamos criar um programa para ler um número inteiro N e uma matriz de ordem N (N linhas e N colunas) contendo números inteiros. Em seguida, o programa deverá mostrar a diagonal principal dessa matriz e a quantidade de valores negativos nela presentes.

**Exemplo:**

**Entrada (Input):**
```
3
5 -3 10
15 8 2
7 9 -4
```

**Saída (Output):**
```
Diagonal Principal:
5 8 -4
Quantidade de números negativos = 2
```

### Solução em Java

```java
package aplicacao;

import java.util.Scanner;

public class ProgramaMatriz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a ordem da matriz (N): ");
        int n = sc.nextInt();

        // Declaração e instanciação da matriz
        int[][] matriz = new int[n][n];

        System.out.println("Digite os elementos da matriz:");
        // Leitura dos elementos da matriz
        for (int i = 0; i < n; i++) { // Percorre as linhas
            System.out.printf("Elementos da linha %d:\n", i);
            for (int j = 0; j < n; j++) { // Percorre as colunas
                matriz[i][j] = sc.nextInt();
            }
        }

        // Mostrando a diagonal principal
        System.out.println("\nDiagonal Principal:");
        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println(); // Pula linha

        // Contando os números negativos
        int contadorNegativos = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] < 0) {
                    contadorNegativos++;
                }
            }
        }
        System.out.printf("Quantidade de números negativos = %d\n", contadorNegativos);

        sc.close();
    }
}
```

## 🧠 Matrizes e Memória

É importante entender como as matrizes são organizadas na memória do computador. Em Java:

* **Stack (Pilha)**: Armazena variáveis de tipos primitivos (como `int`, `double`, `char`) e referências a objetos.
* **Heap (Monte)**: É onde os objetos (incluindo arrays/matrizes) são efetivamente criados e seus dados armazenados.

No contexto do exercício anterior, se `n` for 3 e a matriz `mat` for preenchida com os valores do exemplo:

```
matriz = {{5, -3, 10}, {15, 8, 2}, {7, 9, -4}}
n = 3
```

* A variável `n` (um tipo primitivo `int`) é armazenada diretamente na memória **Stack**.
* A variável `matriz` (que é uma referência para um objeto array bidimensional) também tem sua referência armazenada na **Stack**. Essa referência "aponta" para o local na memória **Heap** onde os dados da matriz (os arrays que representam as linhas e, por sua vez, os elementos `5, -3, 10, ...`) estão efetivamente guardados.

Objetos (como arrays) em Java são sempre alocados na Heap. A variável na Stack apenas guarda o endereço de memória desse objeto na Heap.

*(Baseado no diagrama da página 7 do PDF, onde 'mat' é a referência na Stack e os valores da matriz estão na Heap).*

## 🚀 Executando o Exemplo

Você pode compilar e executar o código Java do exercício em diversas IDEs ou via linha de comando. Abaixo, instruções para VS Code e IntelliJ IDEA.

### Usando o VS Code:

1.  **Instale o Java Development Kit (JDK)**: Certifique-se de ter o JDK instalado em seu sistema.
2.  **Instale a Extensão Java no VS Code**: Abra o VS Code, vá para a aba de Extensões (Ctrl+Shift+X) e procure por "Extension Pack for Java" da Microsoft. Instale-o.
3.  **Crie um Projeto (Opcional, mas recomendado)**:
    * Abra o VS Code em uma pasta vazia.
    * Pressione `Ctrl+Shift+P` para abrir a paleta de comandos, digite "Java: Create Java Project", selecione "No build tools", escolha o local e dê um nome ao projeto.
4.  **Crie o Arquivo**:
    * Dentro da pasta `src` do seu projeto (ou diretamente na pasta se não criou um projeto formal), crie um novo arquivo chamado `ProgramaMatriz.java`.
5.  **Cole o Código**: Cole o código Java fornecido no arquivo `ProgramaMatriz.java`. Certifique-se que o `package aplicacao;` corresponde à estrutura de pastas (se você criou o pacote `aplicacao` dentro de `src`). Se não usou pacotes, remova a linha `package aplicacao;`.
6.  **Execute**:
    * Abra o arquivo `ProgramaMatriz.java`.
    * Você verá um link "Run" acima do método `main`. Clique nele.
    * Alternativamente, clique com o botão direito no arquivo no explorador de arquivos e selecione "Run Java".
    * A entrada de dados e a saída serão mostradas no terminal integrado do VS Code.

### Usando o IntelliJ IDEA:

1.  **Instale o Java Development Kit (JDK)**: Certifique-se de ter o JDK instalado.
2.  **Crie um Novo Projeto**:
    * Abra o IntelliJ IDEA.
    * Clique em "New Project".
    * Selecione "Java" na lista à esquerda.
    * Escolha o JDK instalado.
    * Clique em "Next" (não precisa de template por enquanto).
    * Dê um nome ao projeto (ex: `EstudoMatrizes`) e defina o local. Clique em "Finish".
3.  **Crie a Classe**:
    * No painel "Project" à esquerda, expanda seu projeto. Clique com o botão direito na pasta `src`.
    * Selecione "New" -> "Java Class".
    * No campo "Name", digite `ProgramaMatriz`. Se quiser usar um pacote (ex: `aplicacao`), digite `aplicacao.ProgramaMatriz`.
    * Clique em "OK" ou pressione Enter.
4.  **Cole o Código**: Cole o código Java fornecido na classe criada. Ajuste a declaração `package` no topo do arquivo para corresponder ao pacote que você criou (ou remova-a se não criou um pacote).
5.  **Execute**:
    * Clique na seta verde ao lado da declaração `public class ProgramaMatriz` ou ao lado do método `public static void main(String[] args)`.
    * Selecione "Run 'ProgramaMatriz.main()'".
    * A entrada de dados e a saída serão mostradas na aba "Run" na parte inferior da IDE.

---
## 📚
