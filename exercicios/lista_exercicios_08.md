# Lista de Exercícios POO 08

---

### 📌 **Descrição das Atividades**
[Orientação sobre como desenvolver as atividades](lista_exercicios_orientacoes.md)

---

# Java: Exercícios de Fixação ☕

## 🧩 Parte 8: Exercícios em Java: Memória Vetores e Listas

Claro, aqui estão os enunciados dos problemas, formatados em Markdown e sem as citações.

## Problema "negativos"

Faça um programa que leia um número inteiro positivo N (máximo $=10)$ e depois N números inteiros e armazene-os em um vetor. Em seguida, o programa deve mostrar na tela todos os números negativos que foram lidos.

### Exemplo:
> ```
> Quantos numeros voce vai digitar? 6
> Digite um numero: 8
> Digite um numero: -2
> Digite um numero: 9
> Digite um numero: 10
> Digite um numero: -3
> Digite um numero: -7
>
> NUMEROS NEGATIVOS:
> -2
> -3
> -7
> ```

---
## Problema "soma_vetor"

Faça um programa que leia N números reais e os armazene em um vetor. Em seguida, o programa deve:
* Imprimir todos os elementos do vetor.
* Mostrar na tela a soma e a média dos elementos do vetor.

### Exemplo:
> ```
> Quantos numeros voce vai digitar? 4
> Digite um numero: 8.0
> Digite um numero: 4.0
> Digite um numero: 10.0
> Digite um numero: 14.0
>
> VALORES = 8.0 4.0 10.0 14.0
> SOMA = 36.00
> MEDIA = 9.00
> ```

---
## Problema "alturas"

Fazer um programa para ler nome, idade e altura de N pessoas. Depois, o programa deve mostrar na tela a altura média das pessoas e também a porcentagem de pessoas com menos de 16 anos, bem como os nomes dessas pessoas, caso houver.

### Exemplo:
> ```
> Quantas pessoas serao digitadas? 5
> Dados da 1a pessoa:
> Nome: Joao
> Idade: 15
> Altura: 1.82
> Dados da 2a pessoa:
> Nome: Maria
> Idade: 16
> Altura: 1.60
> Dados da 3a pessoa:
> Nome: Teresa
> Idade: 14
> Altura: 1.58
> Dados da 4a pessoa:
> Nome: Carlos
> Idade: 21
> Altura: 1.65
> Dados da 5a pessoa:
> Nome: Paulo
> Idade: 17
> Altura: 1.78
>
> Altura média: 1.69
> Pessoas com menos de 16 anos: 40.0%
> Joao
> Teresa
> ```

---
## Problema "numeros_pares"

Faça um programa que leia N números inteiros e os armazene em um vetor. Em seguida, o programa deve mostrar na tela todos os números pares e também a quantidade de números pares.

### Exemplo:
> ```
> Quantos numeros voce vai digitar? 6
> Digite um numero: 8
> Digite um numero: 2
> Digite um numero: 11
> Digite um numero: 14
> Digite um numero: 13
> Digite um numero: 20
>
> NUMEROS PARES:
> 8 2 14 20
>
> QUANTIDADE DE PARES = 4
> ```

---
## Problema "maior_posicao"

Faça um programa que leia N números reais e os armazene em um vetor. Em seguida, o programa deve mostrar na tela o maior número do vetor (supondo não haver empates) e também a posição do maior elemento, considerando a primeira posição como 0.

### Exemplo:
> ```
> Quantos numeros voce vai digitar? 6
> Digite um numero: 8.0
> Digite um numero: 4.0
> Digite um numero: 10.0
> Digite um numero: 14.0
> Digite um numero: 13.0
> Digite um numero: 7.0
>
> MAIOR VALOR = 14.0
> POSICAO DO MAIOR VALOR = 3
> ```

---
## Problema "soma_vetores"

Faça um programa para ler dois vetores A e B, contendo N elementos cada. Em seguida, gere um terceiro vetor C, onde cada elemento de C é a soma dos elementos correspondentes de A e B. Imprima o vetor C gerado.

### Exemplo:
> ```
> Quantos valores vai ter cada vetor? 6
> Digite os valores do vetor A:
> 8
> 2
> 11
> 14
> 13
> 20
> Digite os valores do vetor B:
> 5
> 10
> 3
> 1
> 10
> 7
>
> VETOR RESULTANTE:
> 13
> 12
> 14
> 15
> 23
> 27
> ```

---
## Problema "abaixo_da_media"

Fazer um programa para ler um número inteiro N e depois um vetor de N números reais. Em seguida, mostrar na tela a média aritmética de todos os elementos com três casas decimais. Depois, mostrar todos os elementos do vetor que estejam abaixo da média, com uma casa decimal cada.

### Exemplo:
> ```
> Quantos elementos vai ter o vetor? 4
> Digite um numero: 10.0
> Digite um numero: 15.5
> Digite um numero: 13.2
> Digite um numero: 9.8
>
> MEDIA DO VETOR = 12.125
> ELEMENTOS ABAIXO DA MEDIA:
> 10.0
> 9.8
> ```

---
## Problema "media_pares"

Fazer um programa para ler um vetor de N números inteiros. Em seguida, mostrar na tela a média aritmética somente dos números pares lidos, com uma casa decimal. Se nenhum número par for digitado, mostrar a mensagem "NENHUM NUMERO PAR".

### Exemplo 1:
> ```
> Quantos elementos vai ter o vetor? 6
> Digite um numero: 8
> Digite um numero: 2
> Digite um numero: 11
> Digite um numero: 14
> Digite um numero: 13
> Digite um numero: 20
>
> MEDIA DOS PARES = 11.0
> ```

### Exemplo 2:
> ```
> Quantos elementos vai ter o vetor? 3
> Digite um numero: 7
> Digite um numero: 9
> Digite um numero: 11
>
> NENHUM NUMERO PAR
> ```

---
## Problema "mais_velho"

Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas idades. Os nomes devem ser armazenados em um vetor, e as idades em um outro vetor. Depois, mostrar na tela o nome da pessoa mais velha.

### Exemplo:
> ```
> Quantas pessoas voce vai digitar? 5
> Dados da 1a pessoa:
> Nome: Joao
> Idade: 16
> Dados da 2a pessoa:
> Nome: Maria
> Idade: 21
> Dados da 3a pessoa:
> Nome: Teresa
> Idade: 15
> Dados da 4a pessoa:
> Nome: Carlos
> Idade: 23
> Dados da 5a pessoa:
> Nome: Paulo
> Idade: 17
>
> PESSOA MAIS VELHA: Carlos
> ```

---
## Problema "aprovados"

Fazer um programa para ler um conjunto de N nomes de alunos, bem como as notas que eles tiraram no 1º e 2º semestres. Cada uma dessas informações deve ser armazenada em um vetor. Depois, imprimir os nomes dos alunos aprovados, considerando aprovados aqueles cuja média das notas seja maior ou igual a 6.0 (seis).

### Exemplo:
> ```
> Quantos alunos serao digitados? 4
> Digite nome, primeira e segunda nota do 1o aluno:
> Joao Silva
> 7.0
> 8.5
> Digite nome, primeira e segunda nota do 2o aluno:
> Maria Teixeira
> 9.2
> 6.5
> Digite nome, primeira e segunda nota do 3o aluno:
> Carlos Carvalho
> 5.0
> 6.0
> Digite nome, primeira e segunda nota do 4o aluno:
> Teresa Pires
> 5.5
> 6.5
>
> Alunos aprovados:
> Joao Silva
> Maria Teixeira
> Teresa Pires
> ```

---
## Problema "dados_pessoas"

Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N pessoas. Fazer um programa que calcule e escreva a maior e a menor altura do grupo, a média de altura das mulheres e o número de homens.

### Exemplo:
> ```
> Quantas pessoas serao digitadas? 5
> Altura da 1a pessoa: 1.70
> Genero da 1a pessoa: F
> Altura da 2a pessoa: 1.83
> Genero da 2a pessoa: M
> Altura da 3a pessoa: 1.54
> Genero da 3a pessoa: M
> Altura da 4a pessoa: 1.61
> Genero da 4a pessoa: F
> Altura da 5a pessoa: 1.75
> Genero da 5a pessoa: F
>
> Menor altura = 1.54
> Maior altura = 1.83
> Media das alturas das mulheres = 1.69
> Numero de homens = 2
> ```

---
## Problema "comerciante"

Um comerciante deseja fazer o levantamento do lucro das mercadorias que ele comercializa. Para isto, mandou digitar um conjunto de N mercadorias, cada uma contendo nome, preço de compra e preço de venda das mesmas. Fazer um programa que leia tais dados e determine e escreva quantas mercadorias proporcionaram:
* lucro < 10%
* $10\% \le lucro \le 20\%$
* $lucro > 20\%$

O programa também deve determinar e escrever o valor total de compra e de venda de todas as mercadorias, assim como o lucro total.

### Exemplo:
> ```
> Serao digitados dados de quantos produtos? 4
> Produto 1:
> Nome: Feijao
> Preco de compra: 10.00
> Preco de venda: 11.00
> Produto 2:
> Nome: Arroz
> Preco de compra: 12.00
> Preco de venda: 12.80
> Produto 3:
> Nome: Oleo
> Preco de compra: 5.00
> Preco de venda: 5.70
> Produto 4:
> Nome: Sal
> Preco de compra: 3.00
> Preco de venda: 4.00
>
> RELATORIO:
> Lucro abaixo de 10%: 1
> Lucro entre 10% e 20%: 2
> Lucro acima de 20%: 1
> Valor total de compra: 30.00
> Valor total de venda: 33.50
> Lucro total: 3.50
> ```

---

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)
