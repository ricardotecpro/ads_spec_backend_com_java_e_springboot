# Exercícios 13 - Estado e Reatividade (Hooks) 🎣

## 🟢 Fáceis

1.  **Conceito**: Por que uma variável comum (ex: `let x = 0`) não serve para atualizar um contador na tela do React?
2.  **Sintaxe**: O que faz o comando `const [valor, setValor] = useState(0);`? Explique cada um dos 3 elementos.

## 🟡 Médios

3.  **Eventos**:
    Como passamos uma função que deve ser executada apenas quando o usuário clica em um botão? Mostre um exemplo de código.
4.  **Imutabilidade**:
    Por que não podemos fazer `lista.push(item)` e depois `setLista(lista)` no React? Qual o jeito correto de adicionar um item a um array no estado?
5.  **Inputs**:
    O que é um "Input Controlado" e como o atributo `value` e o evento `onChange` trabalham juntos?

## 🔴 Desafio

6.  **Toggle de Visibilidade**:
    Crie a lógica para um componente que esconde ou mostra um texto secreto.
    *   Qual tipo de dado você usaria no `useState` (Boolean, String ou Number)?
    *   Como ficaria a expressão JSX para mostrar o texto apenas se o estado for verdadeiro?