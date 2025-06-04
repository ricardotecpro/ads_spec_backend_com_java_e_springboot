### [ricardotecpro.github.io](https://ricardotecpro.github.io/)

# ☕ Java e Orientação a Objetos: Generics, Set, Map

Este documento aborda conceitos avançados em Java, incluindo Generics, as coleções Set e Map, e a importância dos métodos `hashCode` e `equals`.

## 📜 Introdução aos Generics

Generics em Java permitem que classes, interfaces e métodos sejam parametrizados por tipo. Isso significa que você pode criar componentes que funcionam com diversos tipos de dados de forma segura e eficiente.

**Benefícios dos Generics:**
* **Reuso de Código**: Escreva uma classe ou método uma vez e use-o com diferentes tipos.
* **Type Safety (Segurança de Tipo)**: Erros de tipo são detectados em tempo de compilação, em vez de em tempo de execução. Isso evita `ClassCastException` inesperadas.
* **Performance**: Evitam a necessidade de *casts* explícitos, o que pode levar a um código mais limpo e, em alguns casos, ligeiramente mais performático, pois o *overhead* do *casting* é eliminado.
* **Uso Comum**: Amplamente utilizados em coleções do Java Collections Framework.

**Exemplo Básico:**
```java
// Lista de Strings parametrizada com Generics
List<String> lista = new ArrayList<>();
lista.add("Maria");
String nome = lista.get(0); // Não é necessário cast
// lista.add(10); // Erro de compilação, garantindo type safety
````

### Problema Motivador 1: Reuso

**Cenário:** Deseja-se fazer um programa que leia uma quantidade N de valores (inicialmente, inteiros), imprima esses valores de forma organizada e, em seguida, informe qual foi o primeiro valor inserido.

**Exemplo de Interação:**

```
Quantos valores? 3
10
8
23
[10, 8, 23]
Primeiro: 10
```

**Solução Inicial (sem Generics):**
Seria necessário criar um serviço de impressão específico para inteiros.

```java
// Classe PrintService para inteiros
public class ServicoDeImpressaoInt {
    private List<Integer> valores = new ArrayList<>();

    public void adicionarValor(int valor) {
        valores.add(valor);
    }

    public int primeiro() {
        if (valores.isEmpty()) {
            throw new IllegalStateException("Serviço está vazio");
        }
        return valores.get(0);
    }

    public void imprimir() {
        System.out.print("[");
        if (!valores.isEmpty()) {
            System.out.print(valores.get(0));
            for (int i = 1; i < valores.size(); i++) {
                System.out.print(", " + valores.get(i));
            }
        }
        System.out.println("]");
    }
}
```

Se precisássemos de um serviço similar para Strings, ou qualquer outro tipo, teríamos que duplicar a classe, mudando apenas os tipos.

### Solução com Generics (para o Problema 1)

Com Generics, podemos criar um `ServicoDeImpressao` reutilizável para qualquer tipo.

```java
// Classe PrintService genérica
public class ServicoDeImpressao<T> { // T é um parâmetro de tipo
    private List<T> valores = new ArrayList<>();

    public void adicionarValor(T valor) {
        valores.add(valor);
    }

    public T primeiro() {
        if (valores.isEmpty()) {
            throw new IllegalStateException("Serviço está vazio");
        }
        return valores.get(0);
    }

    public void imprimir() {
        System.out.print("[");
        if (!valores.isEmpty()) {
            System.out.print(valores.get(0));
            for (int i = 1; i < valores.size(); i++) {
                System.out.print(", " + valores.get(i));
            }
        }
        System.out.println("]");
    }
}
```

**Utilização:**

```java
ServicoDeImpressao<Integer> servicoInt = new ServicoDeImpressao<>();
servicoInt.adicionarValor(10);
servicoInt.adicionarValor(8);
System.out.println("Primeiro inteiro: " + servicoInt.primeiro()); // Primeiro inteiro: 10

ServicoDeImpressao<String> servicoStr = new ServicoDeImpressao<>();
servicoStr.adicionarValor("Maria");
servicoStr.adicionarValor("Bob");
System.out.println("Primeira string: " + servicoStr.primeiro()); // Primeira string: Maria
```

### Problema Motivador 2: Type Safety e Performance

**Cenário:** Se, em vez de Generics, usássemos `Object` para tentar generalizar o `ServicoDeImpressao`, perderíamos a segurança de tipo e a clareza.

**Solução com `Object` (problemática):**

```java
public class ServicoDeImpressaoObject {
    private List<Object> valores = new ArrayList<>();

    public void adicionarValor(Object valor) {
        valores.add(valor);
    }

    public Object primeiro() {
        if (valores.isEmpty()) {
            throw new IllegalStateException("Serviço está vazio");
        }
        return valores.get(0);
    }
    // ... método imprimir ...
}
```

**Problemas:**

1.  **Falta de Type Safety:**
    ```java
    ServicoDeImpressaoObject servico = new ServicoDeImpressaoObject();
    servico.adicionarValor("Maria");
    servico.adicionarValor(10); // Permite adicionar tipos diferentes

    String nome = (String) servico.primeiro(); // Necessário cast
    // Se o primeiro elemento fosse 10, ocorreria ClassCastException em tempo de execução
    ```
2.  **Performance:** *Casts* podem introduzir um pequeno *overhead*.

Generics resolvem esses problemas, garantindo que apenas os tipos corretos sejam usados e eliminando a necessidade de *casts*.

## 📐 Genéricos Delimitados (Bounded Generics)

Às vezes, queremos restringir os tipos que podem ser usados como argumentos de tipo. Por exemplo, um método que calcula o maior entre elementos precisa que esses elementos sejam comparáveis.

**Problema:** Encontrar o maior elemento em uma lista.
Fazer um programa que leia um conjunto de produtos a partir de um arquivo e depois mostre o mais caro deles.

**Exemplo de Entrada (arquivo):**

```
Computador,890.50
IPhone X,910.00
Tablet,550.00
```

**Saída Esperada:**

```
Mais caro:
IPhone X, 910.00
```

Para isso, o tipo `T` deve implementar a interface `Comparable<T>`. Usamos `extends` na declaração do tipo genérico.

```java
// Entidade Produto
package entidades;

public class Produto implements Comparable<Produto> {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return nome + ", " + String.format("%.2f", preco);
    }

    @Override
    public int compareTo(Produto outro) {
        // Compara produtos pelo preço
        return preco.compareTo(outro.getPreco());
    }
}
```

```java
// Serviço de Cálculo
package servicos;

import java.util.List;

public class ServicoDeCalculo {

    // T é qualquer tipo que implementa Comparable<T>
    public static <T extends Comparable<T>> T max(List<T> lista) {
        if (lista.isEmpty()) {
            throw new IllegalStateException("A lista não pode estar vazia");
        }
        T maximo = lista.get(0);
        for (T item : lista) {
            if (item.compareTo(maximo) > 0) {
                maximo = item;
            }
        }
        return maximo;
    }
}

// Exemplo de uso
// List<Produto> produtos = ... carregar de um arquivo ...
// Produto maisCaro = ServicoDeCalculo.max(produtos);
// System.out.println("Mais caro: " + maisCaro);
```

**Nota:** O Java já oferece `Collections.max(list)` para essa finalidade.

**Versão Alternativa (mais flexível para hierarquias de herança):**
`public static <T extends Comparable<? super T>> T max(List<T> list)`
Isso permite que `T` seja comparável com `T` ou qualquer supertipo de `T`. Por exemplo, se `B extends A` e `A implements Comparable<A>`, um `List<B>` poderia usar `max` porque `B` herda a comparabilidade de `A`.

## ❓ Tipos Curinga (Wildcard Types)

Generics são **invariantes**. Isso significa que `List<Object>` **não** é um supertipo de `List<String>`.

```java
List<Object> meusObjetos = new ArrayList<Object>();
List<Integer> meusNumeros = new ArrayList<Integer>();
// meusObjetos = meusNumeros; // ERRO DE COMPILAÇÃO!
```

O supertipo de qualquer tipo de lista é `List<?>` (lista de "qualquer tipo desconhecido").

```java
List<?> meusObjetosGenericos;
List<Integer> meusNumeros = new ArrayList<Integer>();
meusObjetosGenericos = meusNumeros; // OK
```

**Uso em Métodos:** Podemos criar métodos que recebem uma lista de qualquer tipo.

```java
public class Programa {
    public static void main(String[] args) {
        List<Integer> meusInteiros = Arrays.asList(5, 2, 10);
        imprimirLista(meusInteiros);

        List<String> minhasStrings = Arrays.asList("Maria", "Alex", "Bob");
        imprimirLista(minhasStrings);
    }

    // Este método pode imprimir listas de qualquer tipo
    public static void imprimirLista(List<?> lista) {
        for (Object obj : lista) {
            System.out.println(obj);
        }
    }
}
```

**Limitação de `List<?>`:** Não é possível adicionar dados a uma coleção de tipo curinga (exceto `null`), pois o compilador não sabe qual é o tipo específico do qual a lista foi instanciada.

```java
List<?> lista = new ArrayList<Integer>();
// lista.add(3); // ERRO DE COMPILAÇÃO
```

### Curingas Delimitados (Bounded Wildcards)

Permitem mais flexibilidade com `get` e `put` em coleções genéricas.

**Problema 1: Somar áreas de figuras**
Temos uma interface `Forma` e classes `Circulo`, `Retangulo`. Queremos um método `areaTotal` que some as áreas de uma lista de formas.

```java
// Interface Forma
public interface Forma {
    double area();
}

// Classe Circulo
public class Circulo implements Forma {
    private double raio;
    // construtor, getters, setters...
    @Override public double area() { return Math.PI * raio * raio; }
}

// Classe Retangulo
public class Retangulo implements Forma {
    private double largura, altura;
    // construtor, getters, setters...
    @Override public double area() { return largura * altura; }
}
```

Soluções impróprias para `areaTotal`:

* `public double areaTotal(List<Forma> lista)`: Muito restritivo. Não aceitaria `List<Circulo>`.
* `public double areaTotal(List<?> lista)`: Muito genérico. Não poderíamos chamar `forma.area()` dentro do método, pois `Object` não tem `area()`.

**Solução com Curinga Delimitado Superior (`extends`):**

```java
// Aceita List<Forma>, List<Circulo>, List<Retangulo>, etc.
public double areaTotal(List<? extends Forma> lista) {
    double soma = 0.0;
    for (Forma f : lista) { // Podemos ler (get) como Forma
        soma += f.area();
    }
    // lista.add(new Circulo(...)); // ERRO: não podemos adicionar (put)
    return soma;
}
```

* `? extends Tipo`: **Covariância**. Pode-se *obter* (`get`) elementos como `Tipo`, mas não se pode *adicionar* (`put`) elementos (exceto `null`), pois não se sabe o subtipo exato. Útil para coleções "produtoras" (de onde você lê dados).

**Problema 2: Princípio GET/PUT (Covariância e Contravariância)**
Vamos fazer um método que copia os elementos de uma lista para uma outra lista que pode ser mais genérica que a primeira.

```java
List<Integer> meusInteiros = Arrays.asList(1, 2, 3, 4);
List<Double> meusDecimais = Arrays.asList(3.14, 6.28);
List<Object> meusObjetos = new ArrayList<Object>();

copiar(meusInteiros, meusObjetos); // Copia Integers para uma lista de Objects
copiar(meusDecimais, meusObjetos); // Copia Doubles para uma lista de Objects
```

O método `copiar` precisa:

1.  Ler de uma lista de origem (`source`) onde os elementos são subtipos de `Number` (e.g., `Integer`, `Double`).
2.  Escrever em uma lista de destino (`destiny`) onde os elementos são supertipos de `Number` (e.g., `Number`, `Object`).

**Implementação com `extends` e `super`:**

```java
public static void copiar(List<? extends Number> origem, List<? super Number> destino) {
    for (Number numero : origem) { // GET da origem (covariância)
        destino.add(numero);      // PUT no destino (contravariância)
    }
}

public static void imprimirListaCopiada(List<?> lista) {
    for (Object obj : lista) {
        System.out.print(obj + " ");
    }
    System.out.println();
}

// No main:
// ...
// List<Object> meusObjetos = new ArrayList<Object>();
// copiar(meusInteiros, meusObjetos);
// imprimirListaCopiada(meusObjetos); // Saída: 1 2 3 4
//
// List<Number> meusNumeros = new ArrayList<Number>();
// copiar(meusInteiros, meusNumeros);
// imprimirListaCopiada(meusNumeros); // Saída: 1 2 3 4
```

* `? extends Tipo` (Covariância - GET é OK, PUT é ERRO): Use quando a estrutura genérica é um **produtor** de `T`. Você pode ler `T`s dela, mas não pode adicionar `T`s a ela.
* `? super Tipo` (Contravariância - PUT é OK, GET é ERRO (retorna `Object`)): Use quando a estrutura genérica é um **consumidor** de `T`. Você pode adicionar `T`s (ou subtipos de `T`) a ela, mas ao ler, você só tem a garantia de que é um `Object`.

**PECS (Producer Extends, Consumer Super):**

* Se você está lendo de uma coleção (produtor), use `extends`.
* Se você está escrevendo em uma coleção (consumidor), use `super`.
* Se você faz ambos, não use curingas (use o tipo exato).

### Hierarquia dos Tipos Primitivos Wrapper em Java

```
Object
  |-- Number
  |     |-- Integer
  |     |-- Byte
  |     |-- Long
  |     |-- Short
  |     |-- Float
  |     |-- Double
  |-- Boolean
  |-- Character
```

## ⚖️ `hashCode` e `equals`

São métodos fundamentais da classe `Object`, usados para comparar objetos.

* **`equals(Object obj)`**:

    * Compara se o objeto atual é igual a `obj`.
    * Retorna `true` ou `false`.
    * A comparação padrão (herdada de `Object`) verifica se as referências dos objetos são as mesmas (apontam para o mesmo local na memória).
    * Para classes personalizadas, geralmente precisa ser sobrescrito para fornecer uma comparação baseada no conteúdo (estado) dos objetos.
    * É mais lento, mas oferece uma resposta 100% precisa sobre a igualdade lógica.

  <!-- end list -->

  ```java
  String a = new String("Maria");
  String b = new String("Maria");
  String c = a;

  System.out.println(a.equals(b)); // true (conteúdo é igual)
  System.out.println(a == b);       // false (referências diferentes)
  System.out.println(a == c);       // true (mesma referência)
  ```

* **`hashCode()`**:

    * Retorna um número inteiro (código hash) gerado a partir das informações do objeto.
    * É usado por coleções baseadas em hash (como `HashSet`, `HashMap`, `LinkedHashSet`) para organizar e localizar objetos de forma eficiente.
    * É rápido.
    * **Regra de Ouro do HashCode (Contrato entre `equals` e `hashCode`):**
        1.  Se `obj1.equals(obj2)` é `true`, então `obj1.hashCode()` **deve** ser igual a `obj2.hashCode()`.
        2.  Se `obj1.hashCode()` é diferente de `obj2.hashCode()`, então `obj1.equals(obj2)` **deve** ser `false`.
        3.  Se `obj1.hashCode()` é igual a `obj2.hashCode()`, não necessariamente `obj1.equals(obj2)` é `true` (isso é uma **colisão de hash**). `equals()` é então usado para confirmar a igualdade.

* **Tipos Comuns**: `String`, `Date`, `Integer`, `Double`, etc., já possuem implementações corretas e otimizadas de `equals` e `hashCode`.

* **Classes Personalizadas**: Se você sobrescrever `equals`, **você deve** sobrescrever `hashCode` para manter o contrato. Caso contrário, coleções baseadas em hash não funcionarão corretamente com seus objetos.

**Exemplo de Classe Personalizada (sem `equals`/`hashCode` inicialmente):**

```java
package entidades;

public class Cliente {
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    // Getters e Setters omitidos para brevidade

    // SEM equals() e hashCode() implementados:
    // Cliente c1 = new Cliente("Maria", "maria@gmail.com");
    // Cliente c2 = new Cliente("Maria", "maria@gmail.com");
    // System.out.println(c1.equals(c2)); // false (compara referências)
    // Set<Cliente> set = new HashSet<>();
    // set.add(c1);
    // set.add(c2);
    // System.out.println(set.size()); // 2 (considera como objetos diferentes)
}
```

**Implementando `equals` e `hashCode` (exemplo básico):**

```java
package entidades;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mesma referência
        if (o == null || getClass() != o.getClass()) return false; // Null ou classe diferente
        Cliente cliente = (Cliente) o; // Cast seguro
        // Compara campos relevantes
        return Objects.equals(nome, cliente.nome) &&
               Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        // Gera hashCode a partir dos mesmos campos usados em equals
        return Objects.hash(nome, email);
    }
}

// Agora, com equals e hashCode:
// Cliente c1 = new Cliente("Maria", "maria@gmail.com");
// Cliente c2 = new Cliente("Maria", "maria@gmail.com");
// System.out.println(c1.equals(c2)); // true
// Set<Cliente> set = new HashSet<>();
// set.add(c1);
// set.add(c2);
// System.out.println(set.size()); // 1
```

**Dica para IDEs (VS Code, IntelliJ IDEA):** Ambas as IDEs podem gerar automaticamente implementações de `equals()` e `hashCode()` com base nos campos da classe.

* **IntelliJ IDEA:** `Alt + Insert` (ou `Cmd + N` no Mac) -\> `equals() and hashCode()`
* **VS Code (com Java Extension Pack):** Clique com o botão direito no código -\> Source Action -\> Generate hashCode() and equals()...

## Set\<T\>

A interface `Set<T>` representa um conjunto de elementos, similar ao conceito da Álgebra.

**Características Principais:**

* **Não admite repetições**: Se você tentar adicionar um elemento que já existe (conforme definido por `equals()`), a adição é ignorada.
* **Elementos não possuem posição (índice)**: O acesso não é feito por um índice numérico.
* **Acesso, inserção e remoção de elementos são geralmente rápidos.**
* **Oferece operações eficientes de conjunto**: União, interseção, diferença.

**Principais Implementações:**

* `HashSet<T>`:
    * Mais rápida (operações geralmente em tempo constante, $O(1)$, se não houver muitas colisões de hash).
    * Não garante a ordem dos elementos.
    * Usa `hashCode()` para organizar os elementos em uma tabela hash e `equals()` para verificar igualdade em caso de colisão.
* `TreeSet<T>`:
    * Mais lenta (operações em tempo logarítmico, $O(\\log n)$).
    * Mantém os elementos ordenados. A ordenação é definida pelo `compareTo()` do objeto (se a classe implementar `Comparable<T>`) ou por um `Comparator<T>` fornecido no construtor do `TreeSet`.
    * Se os elementos não forem `Comparable` e nenhum `Comparator` for fornecido, uma `ClassCastException` pode ocorrer ao tentar adicionar elementos.
* `LinkedHashSet<T>`:
    * Velocidade intermediária (entre `HashSet` e `TreeSet`).
    * Mantém os elementos na ordem em que foram adicionados.
    * Combina uma tabela hash com uma lista duplamente encadeada.

**Como `Set` (especialmente `HashSet`) testa igualdade?**

1.  Primeiro, calcula o `hashCode()` do objeto a ser adicionado/verificado.
2.  Usa esse `hashCode` para encontrar um "balde" (bucket) na tabela hash.
3.  Se o balde estiver vazio, o objeto é adicionado (se for uma operação de adição).
4.  Se o balde contiver um ou mais objetos (colisão de hash ou objeto já existente):
    * Compara o objeto com cada objeto no balde usando `equals()`.
    * Se `equals()` retornar `true` para algum objeto no balde, o `Set` considera que o elemento já existe.
    * Se `equals()` retornar `false` para todos, o novo objeto é adicionado ao balde (tratando a colisão).

<!-- end list -->

* Se `hashCode()` e `equals()` **não** estiverem implementados corretamente na sua classe personalizada, `HashSet` comparará as referências dos objetos, o que geralmente não é o comportamento desejado.

**Alguns Métodos Importantes de `Set<T>`:**

* `boolean add(T obj)`: Adiciona o elemento. Retorna `true` se o elemento foi adicionado (não existia), `false` caso contrário.
* `boolean remove(Object obj)`: Remove o elemento. Retorna `true` se o elemento existia e foi removido.
* `boolean contains(Object obj)`: Verifica se o elemento existe.
* `void clear()`: Remove todos os elementos.
* `int size()`: Retorna o número de elementos.
* `boolean removeIf(Predicate<? super T> filter)`: Remove elementos que satisfazem o predicado.
* `boolean addAll(Collection<? extends T> other)`: **União**. Adiciona todos os elementos de `other` a este `Set`, sem repetição.
* `boolean retainAll(Collection<?> other)`: **Interseção**. Remove de este `Set` os elementos que não estão contidos em `other`.
* `boolean removeAll(Collection<?> other)`: **Diferença**. Remove de este `Set` os elementos que também estão contidos em `other`.

**Exemplo 1: `HashSet` com Strings**

```java
package aplicacao;

import java.util.HashSet;
import java.util.Set;

public class Programa {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();
        conjunto.add("TV");
        conjunto.add("Notebook");
        conjunto.add("Tablet");
        conjunto.add("TV"); // Ignorado, "TV" já existe

        System.out.println(conjunto.contains("Notebook")); // true

        for (String p : conjunto) {
            System.out.println(p); // Ordem não garantida
        }
        // Possível saída:
        // Tablet
        // TV
        // Notebook
    }
}
```

**Exemplo 2: Operações com `TreeSet` de Integers**

```java
package aplicacao;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Programa {
    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        // União
        Set<Integer> c = new TreeSet<>(a); // Copia 'a'
        c.addAll(b);
        System.out.println("União c: " + c); // [0, 2, 4, 5, 6, 7, 8, 9, 10] (ordenado)

        // Interseção
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println("Interseção d: " + d); // [5, 6, 8, 10]

        // Diferença (elementos em 'a' que não estão em 'b')
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println("Diferença e (a - b): " + e); // [0, 2, 4]
    }
}
```

**Exemplo 3: `HashSet` com Objetos `Produto` (sem `equals`/`hashCode` implementados na classe `Produto`)**
Suponha a classe `Produto` definida anteriormente, mas *sem* a sobrescrita de `equals` e `hashCode`.

```java
package aplicacao;

import java.util.HashSet;
import java.util.Set;
import entidades.Produto; // Supondo que Produto não tem equals/hashCode

public class Programa {
    public static void main(String[] args) {
        Set<Produto> conjunto = new HashSet<>();
        conjunto.add(new Produto("TV", 900.0));
        conjunto.add(new Produto("Notebook", 1200.0));
        conjunto.add(new Produto("Tablet", 400.0));

        Produto prod = new Produto("Notebook", 1200.0);

        // Sem equals/hashCode, 'contains' compara referências.
        // 'prod' é uma nova instância, diferente daquela no conjunto.
        System.out.println(conjunto.contains(prod)); // false
    }
}
```

Se `Produto` tivesse `equals` e `hashCode` implementados comparando `nome` e `preco`, `conjunto.contains(prod)` retornaria `true`.

**Como `TreeSet` compara os elementos?**
`TreeSet` requer que seus elementos sejam comparáveis. Isso pode ser alcançado de duas formas:

1.  A classe do elemento implementa a interface `java.lang.Comparable<T>` e sobrescreve o método `int compareTo(T other)`.
2.  Um objeto `java.util.Comparator<T>` é passado para o construtor do `TreeSet`. O método `int compare(T o1, T o2)` do `Comparator` será usado.

**Exemplo: `TreeSet` com Objetos `Produto` (com `Comparable`)**
Usando a classe `Produto` que implementa `Comparable<Produto>` (comparando por nome ou preço, conforme definido no `compareTo`).

```java
package aplicacao;

import java.util.Set;
import java.util.TreeSet;
import entidades.Produto; // Produto implementa Comparable<Produto>

public class Programa {
    public static void main(String[] args) {
        // Se Produto.compareTo ordena por nome:
        Set<Produto> conjunto = new TreeSet<>();
        conjunto.add(new Produto("TV", 900.0));
        conjunto.add(new Produto("Notebook", 1200.0));
        conjunto.add(new Produto("Tablet", 400.0)); // "Tablet"
        conjunto.add(new Produto("Abajur", 50.0));  // "Abajur"

        for (Produto p : conjunto) {
            System.out.println(p); // Imprime ordenado pelo critério do compareTo
        }
        // Saída (se ordenado por nome):
        // Abajur, 50.00
        // Notebook, 1200.00
        // Tablet, 400.00
        // TV, 900.00
    }
}
```

A classe `Produto` para este exemplo:

```java
package entidades;

import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + String.format("%.2f", preco) + "]";
    }

    // Implementação de equals e hashCode para consistência,
    // embora TreeSet use primariamente compareTo para ordenação e unicidade.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }

    @Override
    public int compareTo(Produto outro) {
        // Ordena por nome (case-insensitive)
        return nome.toUpperCase().compareTo(outro.getNome().toUpperCase());
        // Para ordenar por preço:
        // return preco.compareTo(outro.getPreco());
    }
}
```

### Exercício Resolvido (Set) 📜

**Problema:** Um site de internet registra um log de acessos dos usuários. Um registro de log consiste no nome de usuário e o instante em que o usuário acessou o site no padrão ISO 8601, separados por espaço. Fazer um programa que leia o log de acessos a partir de um arquivo, e daí informe quantos usuários distintos acessaram o site.

**Arquivo de Entrada (`in.txt`):**

```
amanda 2018-08-26T20:45:08Z
alex86 2018-08-26T21:49:37Z
bobbrown 2018-08-27T03:19:13Z
amanda 2018-08-27T08:11:00Z
jeniffer3 2018-08-27T09:19:24Z
alex86 2018-08-27T22:39:52Z
amanda 2018-08-28T07:42:19Z
```

**Execução Esperada:**

```
Digite o caminho completo do arquivo: c:\temp\in.txt
Total de usuários distintos: 4
```

**Solução:**

```java
package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Entidade para o Log (opcional para este problema específico, mas bom para estrutura)
class RegistroLog {
    private String usuario;
    private Date instante;

    public RegistroLog(String usuario, Date instante) {
        this.usuario = usuario;
        this.instante = instante;
    }

    public String getUsuario() {
        return usuario;
    }
    // hashCode e equals para RegistroLog se precisássemos de registros únicos
    // Para este problema, apenas o nome do usuário é relevante para a contagem distinta.
    // Se fôssemos colocar RegistroLog em um Set, precisaríamos de equals/hashCode.
}


public class ProgramaLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho completo do arquivo: ");
        String caminho = sc.nextLine();

        Set<String> usuariosDistintos = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(" ");
                String nomeUsuario = campos[0];
                // String dataStr = campos[1]; // Data não é usada para a contagem de usuários distintos
                usuariosDistintos.add(nomeUsuario); // HashSet garante que apenas nomes únicos são adicionados
                linha = br.readLine();
            }
            System.out.println("Total de usuários distintos: " + usuariosDistintos.size());

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        sc.close();
    }
}
```

### Exercício Proposto (Set) 📚

Em um portal de cursos online, cada usuário possui um código único (inteiro). Cada instrutor pode ter vários cursos, e um aluno pode se matricular em quantos cursos quiser. O número total de alunos de um instrutor não é a soma dos alunos de todos os cursos, pois pode haver alunos repetidos.
O instrutor Alex possui três cursos: A, B e C. Seu programa deve ler os códigos dos alunos dos cursos A, B e C e, em seguida, mostrar a quantidade total de alunos distintos do instrutor Alex.

**Exemplo de Interação:**

```
Quantos alunos para o curso A? 3
21
35
22
Quantos alunos para o curso B? 2
21
50
Quantos alunos para o curso C? 3
42
35
13
Total de alunos: 6
```

*(Alunos distintos: 21, 35, 22, 50, 42, 13)*

## 🗺️ Map\<K, V\>

A interface `Map<K, V>` representa uma coleção de pares **chave/valor**. `K` é o tipo da chave (Key) e `V` é o tipo do valor (Value).

**Características Principais:**

* **Não admite repetições do objeto chave**: Cada chave em um `Map` é única. Se você tentar inserir um par com uma chave que já existe, o valor antigo associado a essa chave é substituído pelo novo valor.
* **Os elementos são indexados pelo objeto chave**: Não possuem uma posição numérica como listas. O acesso é feito usando a chave.
* **Acesso, inserção e remoção de elementos são geralmente rápidos** (dependendo da implementação).
* **Uso comum**: Cookies (nome do cookie = chave, valor do cookie = valor), *local storage* em navegadores, qualquer modelo de dados chave-valor, representação de objetos JSON, contagem de frequência, etc.

**Principais Implementações:**

* `HashMap<K, V>`:
    * Mais rápida (operações geralmente em tempo constante, $O(1)$ para `put`, `get`, `remove`, assumindo boa distribuição de hash e poucas colisões).
    * Não garante a ordem das chaves.
    * Usa `hashCode()` e `equals()` da chave para armazenar e recuperar pares.
* `TreeMap<K, V>`:
    * Mais lenta (operações em tempo logarítmico, $O(\\log n)$).
    * Mantém os pares ordenados pelas chaves. A ordenação é definida pelo `compareTo()` da chave (se a classe da chave implementar `Comparable<K>`) ou por um `Comparator<K>` fornecido no construtor.
* `LinkedHashMap<K, V>`:
    * Velocidade intermediária.
    * Mantém os pares na ordem em que as chaves foram inseridas (ou na ordem de acesso, se configurado).

**Como `Map` (especialmente `HashMap`) usa `hashCode` e `equals` da Chave?**

* Quando você insere um par `(chave, valor)`:
    1.  O `hashCode()` da `chave` é calculado.
    2.  Esse hash é usado para determinar um "balde" (bucket) na tabela hash interna do `HashMap`.
    3.  Se o balde estiver vazio, o par é armazenado.
    4.  Se o balde já contiver um ou mais pares (colisão de hash ou mesma chave):
        * A `chave` fornecida é comparada com as chaves dos pares existentes no balde usando `equals()`.
        * Se `chave.equals(chaveExistente)` for `true` para alguma chave no balde, o valor associado a essa `chaveExistente` é substituído pelo novo `valor`.
        * Se `equals()` for `false` para todas, o novo par `(chave, valor)` é adicionado ao balde (tratando a colisão).
* Para `get(chave)` e `containsKey(chave)`, um processo similar ocorre para localizar a chave.
* **Importante**: Se a classe usada como chave em um `HashMap` não sobrescrever `equals()` e `hashCode()` corretamente, o `Map` não funcionará como esperado (comparará referências de chave, não conteúdo).

**Alguns Métodos Importantes de `Map<K, V>`:**

* `V put(K key, V value)`: Associa o `value` à `key`. Se a `key` já existir, o valor antigo é substituído e retornado. Se for uma nova `key`, retorna `null`.
* `V get(Object key)`: Retorna o valor associado à `key`, ou `null` se a `key` não existir.
* `V remove(Object key)`: Remove o par associado à `key`. Retorna o valor que foi removido, ou `null` se a `key` não existia.
* `boolean containsKey(Object key)`: Retorna `true` se o `Map` contém a `key`.
* `boolean containsValue(Object value)`: Retorna `true` se o `Map` contém o `value` (geralmente menos eficiente que `containsKey`).
* `void clear()`: Remove todos os pares.
* `int size()`: Retorna o número de pares chave-valor.
* `boolean isEmpty()`: Retorna `true` se o `Map` estiver vazio.
* `Set<K> keySet()`: Retorna um `Set` contendo todas as chaves do `Map`. Útil para iterar sobre as chaves.
* `Collection<V> values()`: Retorna uma `Collection` (não necessariamente um `Set`) contendo todos os valores do `Map`.
* `Set<Map.Entry<K, V>> entrySet()`: Retorna um `Set` de objetos `Map.Entry`. Cada `Map.Entry` representa um par chave-valor e permite acessar a chave e o valor. É a forma mais eficiente de iterar sobre chaves e valores simultaneamente.

**Exemplo 1: `TreeMap` para Cookies**

```java
package aplicacao;

import java.util.Map;
import java.util.TreeMap;

public class ProgramaMap {
    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>(); // TreeMap ordena pelas chaves (Strings)

        cookies.put("username", "maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "99771122");

        cookies.remove("email"); // Remove o par com chave "email"
        cookies.put("phone", "99771133"); // Atualiza o valor da chave "phone"

        System.out.println("Contém a chave 'phone': " + cookies.containsKey("phone")); // true
        System.out.println("Número de telefone: " + cookies.get("phone")); // 99771133
        System.out.println("Email: " + cookies.get("email")); // null (foi removido)
        System.out.println("Tamanho: " + cookies.size()); // 2

        System.out.println("TODOS OS COOKIES (ordenados por chave):");
        for (String chave : cookies.keySet()) {
            System.out.println(chave + ": " + cookies.get(chave));
        }
        // Saída:
        // phone: 99771133
        // username: maria

        // Iterando com entrySet (mais eficiente se precisar de chave e valor)
        System.out.println("\nTODOS OS COOKIES (usando entrySet):");
        for (Map.Entry<String, String> entrada : cookies.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
```

**Exemplo 2: `HashMap` com Objetos `Produto` como Chave**
Suponha a classe `Produto` com `equals` e `hashCode` corretamente implementados (baseados em `nome` e `preco`).

```java
package aplicacao;

import java.util.HashMap;
import java.util.Map;
import entidades.Produto; // Produto com equals/hashCode

public class ProgramaEstoque {
    public static void main(String[] args) {
        Map<Produto, Double> estoque = new HashMap<>();

        Produto p1 = new Produto("Tv", 900.0);
        Produto p2 = new Produto("Notebook", 1200.0);
        Produto p3 = new Produto("Tablet", 400.0);

        estoque.put(p1, 10000.0); // 10000 unidades de Tv
        estoque.put(p2, 20000.0); // 20000 unidades de Notebook
        estoque.put(p3, 15000.0); // 15000 unidades de Tablet

        Produto ps = new Produto("Tv", 900.0); // Outra instância, mas representa o mesmo produto

        // Com equals/hashCode corretos, ps é considerado igual a p1 para fins de chave
        System.out.println("Contém a chave 'ps' (representando Tv)? " + estoque.containsKey(ps)); // true
        System.out.println("Quantidade de 'ps' (Tv) em estoque: " + estoque.get(ps)); // 10000.0
    }
}
```

A classe `Produto` para este exemplo (com `equals` e `hashCode`):

```java
package entidades;

import java.util.Objects;

public class Produto { // Não precisa implementar Comparable para HashMap
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + String.format("%.2f", preco) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }
}
```

### Exercício Proposto (Map) 🗳️

Na contagem de votos de uma eleição, são gerados vários registros de votação em formato `.csv` contendo o nome do candidato e a quantidade de votos que ele obteve em uma urna de votação. Você deve fazer um programa para ler os registros de votação a partir de um arquivo e, daí, gerar um relatório consolidado com os totais de votos de cada candidato.

**Arquivo de Entrada Exemplo (`votacao.csv`):**

```csv
Alex Blue,15
Maria Green,22
Bob Brown,21
Alex Blue,30
Bob Brown,15
Maria Green,27
Maria Green,22
Bob Brown,25
Alex Blue,31
```

**Execução Esperada:**

```
Digite o caminho completo do arquivo de votação: c:\temp\votacao.csv
Resultado da Votação:
Alex Blue: 76
Maria Green: 71
Bob Brown: 61
```

**Dica:** Use um `Map<String, Integer>` onde a chave é o nome do candidato e o valor é o total de votos acumulado.

-----

### 🖥️ Utilizando os Exemplos de Código em IDEs (VS Code, IntelliJ IDEA)

Os exemplos de código Java fornecidos são padrão e podem ser executados em qualquer ambiente de desenvolvimento Java que suporte a versão da linguagem utilizada (geralmente Java 8 ou superior para esses conceitos).

**Para VS Code (com o Java Extension Pack):**

1.  Crie um novo projeto Java: `View > Command Palette... > Java: Create Java Project`.
2.  Selecione `No build tools`.
3.  Escolha um local para o projeto e dê um nome a ele.
4.  Crie os pacotes (`entidades`, `aplicacao`, `servicos`) dentro da pasta `src`.
5.  Crie as classes `.java` dentro dos pacotes correspondentes.
6.  Para executar uma classe com um método `main`, abra o arquivo e clique no botão "Run" que aparece acima do método `main` ou clique com o botão direito no arquivo no explorador e selecione "Run Java".

**Para IntelliJ IDEA:**

1.  Crie um novo projeto: `File > New > Project...`.
2.  Selecione `Java` na lista à esquerda. Escolha um SDK (JDK) apropriado. Clique em `Next` (ou `Create`).
3.  Dê um nome ao projeto e escolha um local.
4.  Na janela do projeto, clique com o botão direito na pasta `src` para criar pacotes (`New > Package`).
5.  Dentro dos pacotes, crie as classes (`New > Java Class`).
6.  Para executar uma classe com um método `main`, abra o arquivo e clique na seta verde ao lado da declaração do método `main` ou clique com o botão direito no arquivo no Project Explorer e selecione "Run 'NomeDaClasse.main()'".

Lembre-se de que, para exemplos que leem arquivos, você precisará fornecer o caminho correto para o arquivo de entrada ou colocar o arquivo no diretório raiz do projeto (o caminho relativo pode variar dependendo da configuração da execução).


---
## 📚