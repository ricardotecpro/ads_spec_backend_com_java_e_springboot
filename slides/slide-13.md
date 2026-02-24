# Aula 13 - Estado e Hooks 🎣
## Tornando seu App Interativo

---

## Agenda 📅

1. O que é o Estado (State)? <!-- .element: class="fragment" -->
2. Hook `useState` <!-- .element: class="fragment" -->
3. Lidando com Cliques e Eventos <!-- .element: class="fragment" -->
4. Inputs Controlados <!-- .element: class="fragment" -->
5. Imutabilidade e Arrays <!-- .element: class="fragment" -->

---

## 1. O Problema da Estática 🧱

- Variáveis comuns mudam nos bastidores... <!-- .element: class="fragment" -->
- ...mas a tela continua a mesma! <!-- .element: class="fragment" -->
- O React precisa de um sinal para re-desenhar. <!-- .element: class="fragment" -->

---

## 2. useState: O Motor de Mudança 🚀

```jsx
const [cont, setCont] = useState(0);
```

1. **cont**: O valor atual. <!-- .element: class="fragment" -->
2. **setCont**: A função que atualiza. <!-- .element: class="fragment" -->
3. **0**: O ponto de partida. <!-- .element: class="fragment" -->

---

## 3. Eventos no React ⚡

- `onClick={funcao}` <!-- .element: class="fragment" -->
- `onChange={(e) => ...}` <!-- .element: class="fragment" -->
- Sempre em **CamelCase**! <!-- .element: class="fragment" -->

---

## 4. Inputs Controlados ⌨️

- O React é quem manda no valor do input. <!-- .element: class="fragment" -->
- `value={estado}` + `onChange`. <!-- .element: class="fragment" -->
- Facilita validação e limpeza de campos. <!-- .element: class="fragment" -->

---

## 5. Imutabilidade (Muito Importante!) 💎

- Nunca altere o estado original: `lista.push(x)` ❌ <!-- .element: class="fragment" -->
- Sempre crie uma cópia nova: `setLista([...lista, x])` ✅ <!-- .element: class="fragment" -->

---

## 6. Fluxo de Dados 🌊

- O estado flui do Pai para o Filho via Props. <!-- .element: class="fragment" -->
- Se o estado do Pai muda, todo mundo abaixo dele atualiza. <!-- .element: class="fragment" -->

---

## Desafio de Estado ⚡

Se eu tenho um botão que soma +1 ao contador, o que acontece com a interface se eu esquecer de importar o `useState` e usar uma variável global `let contador = 0`?

---

## Resumo ✅

- `useState` traz vida aos componentes. <!-- .element: class="fragment" -->
- Mudança de estado = Re-renderização. <!-- .element: class="fragment" -->
- Use sempre funções disparadoras (`set...`). <!-- .element: class="fragment" -->

---

## Próxima Aula: Efeitos e APIs 🌐

### Buscando dados no mundo real!

- Hook: `useEffect`. <!-- .element: class="fragment" -->
- Consumindo nossa API Backend. <!-- .element: class="fragment" -->

---

## Dúvidas? 🎣
