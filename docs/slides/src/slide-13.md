# Aula 13 - Estado e Hooks 🎣
## Tornando seu App Interativo

---

## Agenda 📅

1. O que é o Estado (State)? { .fragment }
2. Hook `useState` { .fragment }
3. Lidando com Cliques e Eventos { .fragment }
4. Inputs Controlados { .fragment }
5. Imutabilidade e Arrays { .fragment }

---

## 1. O Problema da Estática 🧱

- Variáveis comuns mudam nos bastidores... { .fragment }
- ...mas a tela continua a mesma! { .fragment }
- O React precisa de um sinal para re-desenhar. { .fragment }

---

## 2. useState: O Motor de Mudança 🚀

```jsx
const [cont, setCont] = useState(0);
```

1. **cont**: O valor atual. { .fragment }
2. **setCont**: A função que atualiza. { .fragment }
3. **0**: O ponto de partida. { .fragment }

---

## 3. Eventos no React ⚡

- `onClick={funcao}` { .fragment }
- `onChange={(e) => ...}` { .fragment }
- Sempre em **CamelCase**! { .fragment }

---

## 4. Inputs Controlados ⌨️

- O React é quem manda no valor do input. { .fragment }
- `value={estado}` + `onChange`. { .fragment }
- Facilita validação e limpeza de campos. { .fragment }

---

## 5. Imutabilidade (Muito Importante!) 💎

- Nunca altere o estado original: `lista.push(x)` ❌ { .fragment }
- Sempre crie uma cópia nova: `setLista([...lista, x])` ✅ { .fragment }

---

## 6. Fluxo de Dados 🌊

- O estado flui do Pai para o Filho via Props. { .fragment }
- Se o estado do Pai muda, todo mundo abaixo dele atualiza. { .fragment }

---

## Desafio de Estado ⚡

Se eu tenho um botão que soma +1 ao contador, o que acontece com a interface se eu esquecer de importar o `useState` e usar uma variável global `let contador = 0`?

---

## Resumo ✅

- `useState` traz vida aos componentes. { .fragment }
- Mudança de estado = Re-renderização. { .fragment }
- Use sempre funções disparadoras (`set...`). { .fragment }

---

## Próxima Aula: Efeitos e APIs 🌐

### Buscando dados no mundo real!

- Hook: `useEffect`. { .fragment }
- Consumindo nossa API Backend. { .fragment }

---

## Dúvidas? 🎣
