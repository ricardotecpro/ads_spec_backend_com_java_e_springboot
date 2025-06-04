Lista de Exercícios Java (Adaptada de C/C++)
1. Métodos (equivalente a Funções)

1.1   Calculadora Simples:
   Crie uma classe Calculadora com métodos para as quatro operações básicas (soma, subtração, multiplicação, divisão). O programa principal deve permitir ao usuário inserir dois números e escolher a operação desejada. Exiba o resultado.

1.2 Verificador de Palíndromos:
Escreva um método que receba uma String como entrada e verifique se ela é um palíndromo (lê-se da mesma forma de trás para frente, desconsiderando espaços e maiúsculas/minúsculas). Peça ao usuário para inserir uma palavra e use o método para verificar.

1.3 Fatorial (Usar método recursivo):
Implemente um método recursivo para calcular o fatorial de um número inteiro não negativo. Solicite ao usuário que insira um número e use o método para calcular e exibir o fatorial.

1.4 Conversor de Temperaturas:
Crie uma classe ConversorTemperatura com dois métodos: um para converter Celsius para Fahrenheit e outro para converter Fahrenheit para Celsius. Permita que o usuário escolha a direção da conversão, insira a temperatura e veja o resultado.

Fórmula C -> F: F = (C * 9/5) + 32

Fórmula F -> C: C = (F - 32) * 5/9

2. Arrays Multidimensionais (equivalente a Matrizes)
2.1   Maior e Menor Elemento em uma Matriz:
   Implemente um programa que crie e preencha uma matriz (array bidimensional) de inteiros com dimensões m x n (informadas pelo usuário). Em seguida, encontre e exiba o maior e o menor elemento presente na matriz.

2.2 Soma das Diagonais de uma Matriz Quadrada:
Escreva um programa que crie e preencha uma matriz quadrada de inteiros de ordem n (informada pelo usuário). Calcule e exiba a soma dos elementos da diagonal principal e da diagonal secundária.

3. Manipulação de Objetos e Referências (abordagem Java para Ponteiros)
   Observação: Java não usa ponteiros explicitamente como C/C++. Em vez disso, Java usa referências para objetos. Os exercícios abaixo são adaptados para refletir essa diferença, focando na manipulação de objetos e seus dados.

3.1 Manipulando Dados de um Objeto:
Crie uma classe Numero que tenha um atributo inteiro. No método main:

Crie uma instância (objeto) da classe Numero.

Atribua um valor ao atributo do objeto.

Crie um método na classe Numero que imprima o valor do atributo. Chame este método.

Para simular a ideia de "endereço de memória", você pode imprimir o resultado do método hashCode() do objeto ou o resultado de System.identityHashCode(objeto). Embora não seja o endereço de memória real, é um identificador único do objeto.

3.2 Trocando Valores entre Objetos (simulado):
Crie uma classe ValorContainer com um atributo inteiro valor.

No main, crie duas instâncias de ValorContainer, objA e objB.

Peça ao usuário para inserir um valor para objA.valor e objB.valor.

Imprima os valores de objA.valor e objB.valor.

Crie um método estático trocarValores(ValorContainer refA, ValorContainer refB) que receba duas referências de ValorContainer e troque os seus atributos valor.

Chame trocarValores(objA, objB).

Imprima novamente os valores de objA.valor e objB.valor para verificar a troca.

4. Classes e Objetos (equivalente a Structs)
4.1   Sistema de Gerenciamento de Funcionários:
   Crie uma classe chamada Funcionario com os seguintes atributos: nome (String), id (int), salario (double) e departamento (String).
   Implemente um programa principal que permita ao usuário:

Cadastrar informações de vários funcionários (armazenando-os em um ArrayList<Funcionario>).

Calcular e exibir o total de salários de um departamento específico (o usuário informa o departamento).

Listar todos os funcionários cadastrados com seus respectivos dados.

4.2 Agenda de Contatos:
Crie uma classe chamada Contato com os atributos: nome (String), telefone (String) e email (String).
Escreva um programa que permita ao usuário:

Adicionar até 10 contatos a um ArrayList<Contato>.

Listar todos os contatos armazenados.

Procurar e exibir o telefone e email de um contato, dado o seu nome.