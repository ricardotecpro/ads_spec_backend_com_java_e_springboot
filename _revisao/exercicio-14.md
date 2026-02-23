# Exercícios 14 - Efeitos e Chamadas de API 🌐

## 🟢 Fáceis

1.  **Conceito**: O que é um "Efeito Colateral" (Side Effect) no desenvolvimento Frontend?
2.  **useEffect**: O que acontece se passarmos um array de dependências vazio `[]` para o `useEffect`?

## 🟡 Médios

3.  **Dependências**:
    Se eu quiser que o `useEffect` rode sempre que a variável `usuarioID` mudar, como deve ficar o array de dependências?
4.  **Fetch**:
    Explique a ordem de execução do código abaixo:
    ```javascript
    console.log("A");
    fetch("url").then(() => console.log("B"));
    console.log("C");
    ```
5.  **Estados de Rede**:
    Por que é importante ter um estado de `loading` (carregando) em aplicações que buscam dados na internet?

## 🔴 Desafio

6.  **Ciclo de Efeitos**:
    Imagine que seu efeito faz um `fetch` e, dentro do `.then()`, você chama um `setData(dados)`.
    *   O que acontece se você NÃO passar o array `[]`? Explique o loop infinito que isso gera.
    *   Como você faria para exibir uma mensagem "Nenhum resultado encontrado" caso a API retorne um array vazio?