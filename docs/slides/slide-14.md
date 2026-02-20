# Aula 14 - Efeitos e APIs 🌐
## Conectando seu App ao Mundo Real

---

## Agenda 📅

1. O que são Side Effects? <!-- .element: class="fragment" -->
2. Hook `useEffect` <!-- .element: class="fragment" -->
3. O Array de Dependências <!-- .element: class="fragment" -->
4. Buscando dados com `fetch` <!-- .element: class="fragment" -->
5. Estados de Carregamento e Erro <!-- .element: class="fragment" -->

---

## 1. Além da Interface 🧪

- Efeitos colaterais são ações que tocam o mundo externo ao componente. <!-- .element: class="fragment" -->
- Ex: Buscar usuários, mudar o título da aba, iniciar um cronômetro. <!-- .element: class="fragment" -->

---

## 2. useState vs useEffect 🥊

- **useState**: Para dados que o usuário vê mudando. <!-- .element: class="fragment" -->
- **useEffect**: Para ações que o componente faz "sozinho". <!-- .element: class="fragment" -->

---

## 3. Os 3 Momentos do useEffect 🕒

1. **Montagem**: Quando o componente nasce. <!-- .element: class="fragment" -->
2. **Atualização**: Quando um dado monitorado muda. <!-- .element: class="fragment" -->
3. **Desmontagem**: Quando o componente morre (Cleanup). <!-- .element: class="fragment" -->

---

## 4. O Array de Dependências `[]` 🗃️

- `[]` -> Roda só uma vez. <!-- .element: class="fragment" -->
- `[cont]` -> Roda sempre que `cont` mudar. <!-- .element: class="fragment" -->
- `Sem array` -> Roda em toda atualização (Perigo!). <!-- .element: class="fragment" -->

---

## 5. Chamadas de API (Fetch) 📨

```javascript
useEffect(() => {
  fetch("https://api...")
    .then(res => res.json())
    .then(data => setData(data));
}, []);
```

---

## 6. UX: Estados de Rede 🛡️

- **Loading**: Mostre um Spinner enquanto espera. <!-- .element: class="fragment" -->
- **Error**: Avise se a internet caiu ou o usuário não existe. <!-- .element: class="fragment" -->
- **Empty**: Diga se não há resultados. <!-- .element: class="fragment" -->

---

## Desafio de Efeito ⚡

Se você colocar um `alert("Olá")` dentro de um `useEffect` sem o array `[]`, quantas vezes o alerta vai aparecer se o usuário ficar digitando em um campo de texto que atualiza o estado?

---

## Resumo ✅

- `useEffect` organiza as ações assíncronas. <!-- .element: class="fragment" -->
- Controle quando rodar via array de dependências. <!-- .element: class="fragment" -->
- Trate sempre o carregamento e erros para uma boa UX. <!-- .element: class="fragment" -->

---

## Próxima Aula: Navegação 🚦

### Multi-páginas com React Router!

- `/home`, `/perfil`, `/contato`. <!-- .element: class="fragment" -->
- Links e Navegação Programática. <!-- .element: class="fragment" -->

---

## Dúvidas? 🌐
