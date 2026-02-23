# API de Streams do Java

Este documento oferece uma série de aulas sobre a API de Streams do Java, introduzida no Java 8. As Streams revolucionaram a forma como coleções de dados são processadas, permitindo um estilo de programação mais funcional, declarativo e expressivo.

-----

## Aula 1: Introdução à API de Streams

Nesta primeira aula, vamos entender o que são Streams, seus conceitos fundamentais e as vantagens de utilizá-las.

### O que é uma Stream?

Uma Stream é uma sequência de elementos provenientes de uma fonte de dados que suporta operações de agregação. É importante frisar que uma Stream não é uma estrutura de dados, mas sim um fluxo de dados que pode ser processado.

**Características Principais:**

  * **Fonte de Dados:** Streams consomem dados de fontes como coleções (Lists, Sets, Maps), arrays ou recursos de I/O.
  * **Pipeline de Operações:** As operações em uma Stream são encadeadas, formando um pipeline. Esse pipeline consiste em uma fonte, zero ou mais operações intermediárias e uma operação terminal.
  * **Não armazena dados:** Uma Stream não armazena seus elementos. Ela os transporta da fonte através do pipeline de operações.
  * **Imutabilidade da fonte:** As operações em uma Stream não modificam sua fonte de dados original. Elas produzem um novo resultado.
  * **Execução "Lazy" (Preguiçosa):** As operações intermediárias em uma Stream são "preguiçosas", ou seja, elas só são executadas quando uma operação terminal é invocada.
  * **Consumível uma única vez:** Uma vez que uma operação terminal é executada em uma Stream, ela não pode ser reutilizada. Para processar os mesmos dados novamente, uma nova Stream deve ser criada.

### Vantagens de usar Streams

  * **Código mais legível e conciso:** Reduz a verbosidade do código em comparação com os loops tradicionais.
  * **Programação Funcional:** Facilita a aplicação de conceitos de programação funcional, como funções lambda e referências de método.
  * **Processamento Paralelo Simplificado:** Permite a paralelização de operações de forma simples, melhorando o desempenho em sistemas com múltiplos núcleos de processamento.
  * **Otimizações Internas:** O pipeline de operações pode ser otimizado internamente pelo Java.

### Criando uma Stream

Existem várias maneiras de se obter uma Stream. As mais comuns são:

  * **A partir de uma Coleção:**
    ```java
    List<String> lista = Arrays.asList("a", "b", "c");
    Stream<String> stream = lista.stream();
    ```
  * **A partir de um Array:**
    ```java
    String[] array = {"a", "b", "c"};
    Stream<String> stream = Arrays.stream(array);
    ```
  * **A partir de valores estáticos:**
    ```java
    Stream<String> stream = Stream.of("a", "b", "c");
    ```
  * **Streams de tipos primitivos:** Para evitar o custo de "boxing" e "unboxing", existem especializações para tipos primitivos: `IntStream`, `LongStream` e `DoubleStream`.
    ```java
    IntStream intStream = IntStream.of(1, 2, 3);
    ```

-----

## Aula 2: Operações Intermediárias

As operações intermediárias transformam uma Stream em outra. Elas são sempre "lazy" e são encadeadas para formar um pipeline.

### Principais Operações Intermediárias

  * `filter(Predicate<T>)`: Retorna uma Stream consistindo dos elementos que correspondem ao predicado fornecido.

    ```java
    List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie", "David");
    nomes.stream()
         .filter(nome -> nome.startsWith("A"))
         .forEach(System.out::println); // Imprime: Alice
    ```

  * `map(Function<T, R>)`: Retorna uma Stream consistindo dos resultados da aplicação da função fornecida aos elementos desta Stream.

    ```java
    List<String> palavras = Arrays.asList("java", "stream", "api");
    palavras.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println); // Imprime: JAVA STREAM API
    ```

  * `flatMap(Function<T, Stream<R>>)`: Semelhante ao `map`, mas a função de mapeamento retorna uma Stream. O `flatMap` "achata" essas Streams em uma única Stream.

    ```java
    List<List<String>> listaDeListas = Arrays.asList(
        Arrays.asList("a", "b"),
        Arrays.asList("c", "d")
    );
    listaDeListas.stream()
                 .flatMap(Collection::stream)
                 .forEach(System.out::println); // Imprime: a b c d
    ```

  * `distinct()`: Retorna uma Stream com os elementos distintos (de acordo com `Object.equals(Object)`).

    ```java
    List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
    numeros.stream()
           .distinct()
           .forEach(System.out::println); // Imprime: 1 2 3 4
    ```

  * `sorted()`: Retorna uma Stream com os elementos classificados em ordem natural.

    ```java
    List<String> nomes = Arrays.asList("Charlie", "Alice", "Bob");
    nomes.stream()
         .sorted()
         .forEach(System.out::println); // Imprime: Alice Bob Charlie
    ```

  * `peek(Consumer<T>)`: Retorna uma Stream que consiste nos elementos da Stream original, realizando uma ação adicional em cada elemento. É útil para depuração.

    ```java
    List<String> nomes = Arrays.asList("um", "dois", "tres");
    nomes.stream()
         .peek(s -> System.out.println("Elemento original: " + s))
         .map(String::toUpperCase)
         .peek(s -> System.out.println("Elemento maiúsculo: " + s))
         .collect(Collectors.toList());
    ```

  * `limit(long maxSize)`: Retorna uma Stream que não é maior que o tamanho máximo fornecido.

  * `skip(long n)`: Retorna uma Stream que descarta os primeiros `n` elementos.

-----

## Aula 3: Operações Terminais

As operações terminais produzem um resultado ou um "side-effect". Uma vez que uma operação terminal é executada, a Stream é consumida e não pode ser reutilizada.

### Principais Operações Terminais

  * `forEach(Consumer<T>)`: Realiza uma ação para cada elemento da Stream.

    ```java
    List<String> nomes = Arrays.asList("Ana", "Bia", "Carol");
    nomes.stream().forEach(System.out::println);
    ```

  * `collect(Collector<T, A, R>)`: Realiza uma mutação redutora dos elementos. É uma das operações terminais mais versáteis.

    ```java
    List<String> nomes = Arrays.asList("um", "dois", "tres");
    List<String> maiusculas = nomes.stream()
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toList());
    System.out.println(maiusculas); // [UM, DOIS, TRES]
    ```

  * `reduce(BinaryOperator<T>)`: Realiza uma redução nos elementos da Stream, usando um operador binário associativo.

    ```java
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> soma = numeros.stream().reduce((a, b) -> a + b);
    soma.ifPresent(System.out::println); // 15
    ```

  * `count()`: Retorna a contagem de elementos na Stream.

  * `anyMatch(Predicate<T>)`: Retorna se algum elemento da Stream corresponde ao predicado fornecido.

  * `allMatch(Predicate<T>)`: Retorna se todos os elementos da Stream correspondem ao predicado fornecido.

  * `noneMatch(Predicate<T>)`: Retorna se nenhum elemento da Stream corresponde ao predicado fornecido.

  * `findFirst()`: Retorna um `Optional` descrevendo o primeiro elemento da Stream, ou um `Optional` vazio se a Stream estiver vazia.

  * `findAny()`: Retorna um `Optional` descrevendo algum elemento da Stream, ou um `Optional` vazio se a Stream estiver vazia. Este é particularmente útil em Streams paralelas.

-----

## Aula 4: Exemplos do Mundo Real e Casos de Uso Complexos

Vamos aplicar o que aprendemos em cenários mais práticos.

### Exemplo 1: Processando uma Lista de Funcionários

```java
class Funcionario {
    private String nome;
    private double salario;
    private String departamento;

    // construtores, getters e setters
}

List<Funcionario> funcionarios = ...; // Inicializa a lista

// Encontrar os 3 funcionários com os maiores salários do departamento de "TI"
List<Funcionario> top3TI = funcionarios.stream()
    .filter(f -> "TI".equals(f.getDepartamento()))
    .sorted(Comparator.comparingDouble(Funcionario::getSalario).reversed())
    .limit(3)
    .collect(Collectors.toList());

// Calcular o salário médio de todos os funcionários
double mediaSalarial = funcionarios.stream()
    .mapToDouble(Funcionario::getSalario)
    .average()
    .orElse(0.0);

// Agrupar funcionários por departamento
Map<String, List<Funcionario>> porDepartamento = funcionarios.stream()
    .collect(Collectors.groupingBy(Funcionario::getDepartamento));
```

### Exemplo 2: Análise de Dados de Log

Imagine um arquivo de log com linhas no formato `[NÍVEL] MENSAGEM`.

```java
List<String> linhasLog = ...; // Lê as linhas do arquivo

// Contar o número de erros
long numeroDeErros = linhasLog.stream()
    .filter(linha -> linha.startsWith("[ERRO]"))
    .count();

// Extrair as mensagens de erro
List<String> mensagensDeErro = linhasLog.stream()
    .filter(linha -> linha.startsWith("[ERRO]"))
    .map(linha -> linha.substring(linha.indexOf("]") + 2))
    .collect(Collectors.toList());
```

-----

## Aula 5: Streams Paralelas e Considerações de Desempenho

As Streams podem ser processadas em paralelo para aproveitar o hardware de múltiplos núcleos.

### Streams Paralelas

A conversão de uma Stream sequencial para paralela é simples:

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Stream Sequencial
numeros.stream().forEach(System.out::print); // Ordem garantida

System.out.println();

// Stream Paralela
numeros.parallelStream().forEach(System.out::print); // A ordem não é garantida
```

**Quando usar Streams Paralelas?**

  * **Grandes conjuntos de dados:** Os benefícios do paralelismo superam a sobrecarga de gerenciamento de threads.
  * **Operações com uso intensivo de CPU:** Tarefas como cálculos complexos se beneficiam do processamento paralelo.
  * **Operações independentes:** As operações em cada elemento não devem depender do estado de outros elementos.

**Quando evitar Streams Paralelas?**

  * **Pequenos conjuntos de dados:** A sobrecarga pode tornar o processamento mais lento.
  * **Operações com I/O:** O gargalo será a operação de entrada/saída, não a CPU.
  * **Operações com estado e dependência de ordem:** A natureza não determinística do processamento paralelo pode levar a resultados incorretos.

### Operações com e sem estado (Stateful vs. Stateless)

  * **Stateless (Sem estado):** Operações como `filter` e `map` não retêm informações sobre os elementos processados anteriormente. Cada elemento é tratado de forma independente.
  * **Stateful (Com estado):** Operações como `distinct`, `sorted`, `limit` e `skip` podem precisar reter o estado dos elementos vistos para produzir o resultado correto. Essas operações podem impactar o desempenho em Streams paralelas.

### Considerações de Desempenho

  * **Evite operações desnecessárias:** O encadeamento excessivo pode adicionar sobrecarga.
  * **Use operações de curto-circuito:** Operações como `anyMatch`, `findFirst` e `limit` podem encerrar o processamento antecipadamente.
  * **Minimize o boxing/unboxing:** Use Streams de tipos primitivos (`IntStream`, `LongStream`, `DoubleStream`) sempre que possível.
  * **Escolha os coletores corretos:** Alguns coletores são mais eficientes que outros para determinadas tarefas.

-----

## Aula 6: Coletores (Collectors) Avançados e Personalizados

A classe `Collectors` oferece uma ampla gama de funcionalidades para coletar os resultados de uma Stream.

### Coletores Avançados

  * `groupingBy(Function)`: Agrupa elementos de acordo com uma função de classificação.
  * `partitioningBy(Predicate)`: Particiona os elementos em um `Map<Boolean, List<T>>` com base em um predicado.
  * `joining(CharSequence)`: Une os elementos de uma `Stream<CharSequence>` em uma única String.
  * `summarizingInt(ToIntFunction)`, `summarizingLong(ToLongFunction)`, `summarizingDouble(ToDoubleFunction)`: Retorna um objeto de estatísticas (contagem, soma, média, mínimo, máximo).

### Criando um Coletor Personalizado

Para cenários muito específicos, você pode criar seu próprio `Collector` implementando a interface `java.util.stream.Collector`. Um `Collector` é definido por quatro funções:

1.  `supplier()`: Cria um novo contêiner de resultado mutável.
2.  `accumulator()`: Incorpora um novo elemento de dados em um contêiner de resultado.
3.  `combiner()`: Combina dois contêineres de resultado em um. Essencial para Streams paralelas.
4.  `finisher()`: Realiza uma transformação final opcional no contêiner de resultado.

**Exemplo: Um coletor que cria uma String de elementos separados por vírgula e entre colchetes.**

```java
import java.util.StringJoiner;
import java.util.stream.Collector;

public class StringCollector {
    public static Collector<CharSequence, StringJoiner, String> toStringCollector() {
        return Collector.of(
                () -> new StringJoiner(", ", "[", "]"), // supplier
                StringJoiner::add,                      // accumulator
                StringJoiner::merge,                    // combiner
                StringJoiner::toString                  // finisher
        );
    }
}

// Uso
List<String> itens = Arrays.asList("Maçã", "Banana", "Laranja");
String resultado = itens.stream().collect(StringCollector.toStringCollector());
System.out.println(resultado); // [Maçã, Banana, Laranja]
```

---

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)

