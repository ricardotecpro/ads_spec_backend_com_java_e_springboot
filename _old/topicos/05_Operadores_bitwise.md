# Operadores Bitwise em Java: Manipulando Bits Como um Profissional 💡

Em Java, os operadores *bitwise* (ou "bit a bit") são ferramentas de baixo nível que permitem a manipulação direta dos `0`s e `1`s que formam os números inteiros (`int`, `long`, `byte`, etc.).

Pense neles como interruptores. Enquanto operadores lógicos como `&&` e `||` avaliam uma condição inteira como `verdadeira` ou `falsa`, os operadores bitwise olham para cada "interruptor" (bit) individualmente, permitindo um controle muito mais granular sobre os dados.

## Os Operadores Bitwise em Ação 🧮

| Operador | Nome                   | Descrição                                                                   | Exemplo Prático (`5` e `3`)                                                |
|:--------:|:-----------------------|:----------------------------------------------------------------------------|:---------------------------------------------------------------------------|
|   `&`    | **E** (AND)            | O bit do resultado é `1` **apenas se** ambos os bits comparados forem `1`.  | `0101 & 0011` → `0001` (1)                                                 |
|    `     | `                      | **OU** (OR)                                                                 | O bit do resultado é `1` **se pelo menos um** dos bits comparados for `1`. | `0101 | 0011` → `0111` (7) |
|   `^`    | **OU-Exclusivo** (XOR) | O bit do resultado é `1` **apenas se** os bits comparados forem diferentes. | `0101 ^ 0011` → `0110` (6)                                                 |

-----

## Como Cada Operador Funciona?

A maneira mais fácil de visualizar a lógica é através de "tabelas verdade", onde `1` é Verdadeiro e `0` é Falso.

### Operador E (`&`)

Retorna `1` apenas quando ambos os bits de entrada são `1`. É útil para "desligar" bits ou verificar se um bit específico está "ligado".

| Bit A | Bit B | A & B |
|:-----:|:-----:|:-----:|
|   0   |   0   | **0** |
|   0   |   1   | **0** |
|   1   |   0   | **0** |
|   1   |   1   | **1** |

### Operador OU (`|`)

Retorna `1` se um dos bits de entrada (ou ambos) for `1`. É perfeito para "ligar" bits específicos.

| Bit A | Bit B | A | B |
| :-: | :-: | :---: |
| 0 | 0 | **0** |
| 0 | 1 | **1** |
| 1 | 0 | **1** |
| 1 | 1 | **1** |

### Operador OU-Exclusivo (`^` ou XOR)

Retorna `1` apenas se os bits forem opostos. Uma aplicação interessante é a capacidade de alternar o estado de um bit (de `0` para `1` ou de `1` para `0`).

| Bit A | Bit B | A ^ B |
|:-----:|:-----:|:-----:|
|   0   |   0   | **0** |
|   0   |   1   | **1** |
|   1   |   0   | **1** |
|   1   |   1   | **0** |

-----

## Demonstração Prática Aprimorada 💻

Vamos dissecar o funcionamento desses operadores com os números `n1 = 89` e `n2 = 60`.

  - **`n1 = 89`** em binário (8 bits) é `01011001`
  - **`n2 = 60`** em binário (8 bits) é `00111100`

#### **Operação `&` (E)**

```
  01011001  (89)
& 00111100  (60)
-----------------
  00011000  -> Resultado: 24
```

O resultado de `89 & 60` é **24**. Apenas as colunas onde ambos os bits eram `1` (a 4ª e 5ª da direita para a esquerda) resultaram em `1`.

#### **Operação `|` (OU)**

```
  01011001  (89)
| 00111100  (60)
-----------------
  01111101  -> Resultado: 125
```

O resultado de `89 | 60` é **125**. Se uma coluna tivesse ao menos um bit `1`, o resultado naquela coluna era `1`.

#### **Operação `^` (XOR)**

```
  01011001  (89)
^ 00111100  (60)
-----------------
  01100101  -> Resultado: 101
```

O resultado de `89 ^ 60` é **101**. Apenas as colunas onde os bits eram diferentes resultaram em `1`.

### Código de Exemplo Otimizado

Este código não apenas calcula os resultados, mas também exibe as representações binárias para facilitar a visualização e o aprendizado.

```java
package curso;

public class Programa {
    public static void main(String[] args) {
        int n1 = 89;
        int n2 = 60;

        // Exibe os números iniciais em formato decimal e binário
        System.out.println("n1 = " + n1 + " (Binário: " + Integer.toBinaryString(n1) + ")");
        System.out.println("n2 = " + n2 + " (Binário: " + Integer.toBinaryString(n2) + ")");
        System.out.println("----------------------------------------");
        
        // Operação E (&)
        int resultadoE = n1 & n2;
        System.out.println(n1 + " & " + n2 + " = " + resultadoE + " (Binário: " + Integer.toBinaryString(resultadoE) + ")");

        // Operação OU (|)
        int resultadoOU = n1 | n2;
        System.out.println(n1 + " | " + n2 + " = " + resultadoOU + " (Binário: " + Integer.toBinaryString(resultadoOU) + ")");

        // Operação OU-Exclusivo (^)
        int resultadoXOR = n1 ^ n2;
        System.out.println(n1 + " ^ " + n2 + " = " + resultadoXOR + " (Binário: " + Integer.toBinaryString(resultadoXOR) + ")");
    }
}
```

-----

## Uso Avançado: Verificando um Bit com Máscaras 🕵️‍♀️

Uma das aplicações mais poderosas de operadores bitwise é usar uma **máscara de bits** para isolar e verificar o estado de um bit específico.

**Objetivo:** Queremos saber se o 6º bit de um número está "ligado" (`1`) ou "desligado" (`0`).

1.  **Crie a Máscara**: Precisamos de um número que tenha `1` **apenas** na 6ª posição. As posições dos bits começam em 0 da direita para a esquerda. A 6ª posição corresponde a `2^5`, que é `32`. Em binário, `32` é `100000`. Essa é a nossa máscara.
2.  **Aplique o Operador `&`**: Realizamos a operação `&` entre o número original e a máscara.
3.  **Interprete o Resultado**:
      * Se o 6º bit do número original for `0`, o resultado da operação `&` será `0`.
      * Se o 6º bit do número original for `1`, o resultado da operação `&` será a própria máscara (`32`), que é um valor diferente de zero.

### Código de Exemplo Interativo

Este programa pede um número ao usuário e, em seguida, usa uma máscara para verificar e informar o estado do 6º bit, mostrando a representação binária para maior clareza.

```java
package curso;

import java.util.Scanner;

public class ProgramaVerificaBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // A máscara 0b100000 é uma forma literal em Java de escrever o número 32.
        // Ela possui o 6º bit (posição 5) "ligado", e todos os outros "desligados".
        int mascara = 0b100000;

        System.out.print("Digite um número inteiro: ");
        int numero = sc.nextInt();

        // Converte o número e a máscara para binário para fácil visualização
        String binarioNumero = String.format("%8s", Integer.toBinaryString(numero)).replace(' ', '0');
        String binarioMascara = String.format("%8s", Integer.toBinaryString(mascara)).replace(' ', '0');
        
        System.out.println("Número em binário : " + binarioNumero);
        System.out.println("Máscara em binário: " + binarioMascara);
        System.out.println("------------------------- (&)");

        // A mágica acontece aqui: usamos o operador '&'
        if ((numero & mascara) != 0) {
            System.out.println("Resultado: O 6º bit é VERDADEIRO (1)!");
        } else {
            System.out.println("Resultado: O 6º bit é FALSO (0).");
        }

        sc.close();
    }
}
```

-----

## Executando o Código no VS Code e IntelliJ IDEA 🚀

Para compilar e rodar estes exemplos, certifique-se de ter o **JDK (Java Development Kit)** instalado em sua máquina.

### Visual Studio Code

1.  Instale o pacote de extensões **"Extension Pack for Java"** da Microsoft.
2.  Crie um novo arquivo (ex: `Programa.java`) e cole o código.
3.  Clique no ícone de "play" (▶️) no canto superior direito ou clique com o botão direito no código e selecione **"Run Java"**.

### IntelliJ IDEA

1.  Crie um novo projeto (`File` \> `New` \> `Project...`).
2.  Selecione `Java` e seu JDK.
3.  Dentro da pasta `src`, clique com o botão direito e escolha `New` \> `Java Class`.
4.  Nomeie a classe (ex: `Programa`) e cole o código dentro dela.
5.  Clique na seta verde (▶️) ao lado do método `main` para executar.

---
