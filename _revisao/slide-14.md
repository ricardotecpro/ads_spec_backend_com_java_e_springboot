# Aula 14 - Efeitos e APIs 🌐
## Conectando seu App ao Mundo Real

---

## Agenda 📅

1. O que são Side Effects? { .fragment }
2. Hook `useEffect` { .fragment }
3. O Array de Dependências { .fragment }
4. Buscando dados com `fetch` { .fragment }
5. Estados de Carregamento e Erro { .fragment }

---

## 1. Além da Interface 🧪

- Efeitos colaterais são ações que tocam o mundo externo ao componente. { .fragment }
- Ex: Buscar usuários, mudar o título da aba, iniciar um cronômetro. { .fragment }

---

## 2. useState vs useEffect 🥊

- **useState**: Para dados que o usuário vê mudando. { .fragment }
- **useEffect**: Para ações que o componente faz "sozinho". { .fragment }

---

## 3. Os 3 Momentos do useEffect 🕒

1. **Montagem**: Quando o componente nasce. { .fragment }
2. **Atualização**: Quando um dado monitorado muda. { .fragment }
3. **Desmontagem**: Quando o componente morre (Cleanup). { .fragment }

---

## 4. O Array de Dependências `[]` 🗃️

- `[]` -> Roda só uma vez. { .fragment }
- `[cont]` -> Roda sempre que `cont` mudar. { .fragment }
- `Sem array` -> Roda em toda atualização (Perigo!). { .fragment }

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

- **Loading**: Mostre um Spinner enquanto espera. { .fragment }
- **Error**: Avise se a internet caiu ou o usuário não existe. { .fragment }
- **Empty**: Diga se não há resultados. { .fragment }

---

## Desafio de Efeito ⚡

Se você colocar um `alert("Olá")` dentro de um `useEffect` sem o array `[]`, quantas vezes o alerta vai aparecer se o usuário ficar digitando em um campo de texto que atualiza o estado?

---

## Resumo ✅

- `useEffect` organiza as ações assíncronas. { .fragment }
- Controle quando rodar via array de dependências. { .fragment }
- Trate sempre o carregamento e erros para uma boa UX. { .fragment }

---

## Próxima Aula: Navegação 🚦

### Multi-páginas com React Router!

- `/home`, `/perfil`, `/contato`. { .fragment }
- Links e Navegação Programática. { .fragment }

---

## Dúvidas? 🌐
