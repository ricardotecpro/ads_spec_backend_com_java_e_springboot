"DESAFIO Bar OO"
---

````markdown
# Desafio: Bar OO

## Objetivo

Desenvolver uma aplicação orientada a objetos que simule o cálculo da conta de um cliente em um bar, utilizando classes, atributos e métodos.

Este desafio tem como foco testar seus conhecimentos em **Programação Orientada a Objetos (POO)**, especialmente o uso correto de **classes**, **atributos**, **métodos** e a aplicação das **convenções de nomenclatura em Java**.

## Regras do Bar

- Ingresso:
  - Homens: R$ 10,00
  - Mulheres: R$ 8,00

- Consumo:
  - Cerveja: R$ 5,00
  - Refrigerante: R$ 3,00
  - Espetinho: R$ 7,00

- Couvert artístico:
  - R$ 4,00
  - **Isento se o consumo for superior a R$ 30,00**

---

## Classe: `ClienteDoBar`

### Atributos

| Nome do Atributo       | Tipo   | Descrição                                   |
|------------------------|--------|---------------------------------------------|
| `sexo`                 | `char` | Sexo do cliente ('M' para masculino ou 'F' para feminino) |
| `qtdCervejas`          | `int`  | Quantidade de cervejas consumidas           |
| `qtdRefrigerantes`     | `int`  | Quantidade de refrigerantes consumidos      |
| `qtdEspetinhos`        | `int`  | Quantidade de espetinhos consumidos         |

---

## Métodos

### `double calcularConsumo()`
Retorna o valor total do consumo com base nas quantidades informadas:

```java
return qtdCervejas * 5.0 + qtdRefrigerantes * 3.0 + qtdEspetinhos * 7.0;
````

---

### `double calcularCouvert()`

Retorna o valor do couvert artístico:

* R\$ 4,00 se o consumo for **menor ou igual a R\$ 30,00**
* R\$ 0,00 caso contrário

---

### `double calcularIngresso()`

Retorna o valor do ingresso:

* R\$ 10,00 para homens
* R\$ 8,00 para mulheres

---

### `double calcularTotal()`

Retorna o valor total a ser pago, somando:

* Consumo
* Couvert artístico (se aplicável)
* Ingresso

---

## Exemplo de Uso

### Exemplo 1

**Entrada:**

```plaintext
Sexo: F
Cervejas: 3
Refrigerantes: 0
Espetinhos: 1
```

**Saída esperada:**

```plaintext
RELATÓRIO:
Consumo = R$ 22.00
Couvert = R$ 4.00
Ingresso = R$ 8.00
Valor a pagar = R$ 34.00
```

---

### Exemplo 2

**Entrada:**

```plaintext
Sexo: M
Cervejas: 7
Refrigerantes: 1
Espetinhos: 2
```

**Saída esperada:**

```plaintext
RELATÓRIO:
Consumo = R$ 52.00
Isento de Couvert
Ingresso = R$ 10.00
Valor a pagar = R$ 62.00
```

---

## Critérios de Avaliação

Para obter a nota máxima, **todos os critérios abaixo devem ser atendidos**:

1. Uso correto das **convenções de nomenclatura em Java** (classe com letra maiúscula, atributos e métodos em *camelCase*).
2. Definição adequada de todos os **atributos da classe**.
3. Implementação correta de todos os **métodos** solicitados.
4. Comportamento do programa em conformidade com os **exemplos fornecidos**.

---
