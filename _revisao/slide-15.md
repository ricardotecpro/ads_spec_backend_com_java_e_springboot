# Aula 15 - React Router 🚦
## Criando Apps Multi-Página

---

## Agenda 📅

1. O que são SPAs? { .fragment }
2. Multi-páginas (Simuladas) { .fragment }
3. Componentes de Rota { .fragment }
4. Navegação (`Link` e `useNavigate`) { .fragment }
5. Parâmetros dinâmicos (`:id`) { .fragment }

---

## 1. O Mundo do SPA ⚛️

- O site é uma única página HTML. { .fragment }
- O Javascript "troca" a tela sem recarregar. { .fragment }
- UX rápida e fluida. { .fragment }

---

## 2. React Router Dom ⚙️

```bash
npm install react-router-dom
```

- A biblioteca padrão para web. { .fragment }
- Permite que a URL combine com o que aparece na tela. { .fragment }

---

## 3. A Estrutura Básica 🏗️

- **BrowserRouter**: O container principal. { .fragment }
- **Routes**: O seletor de rotas. { .fragment }
- **Route**: Define o caminho (`path`) e o componente (`element`). { .fragment }

---

## 4. Navegando sem Recarregar! 🏃‍♂️

- Use `<Link to="/contato">` { .fragment }
- **NUNCA** use `<a href="...">` para rotas internas. { .fragment }

---

## 5. Navegação Programática 🚀

```javascript
const navigate = useNavigate();

onClick={() => navigate("/dashboard")}
```

- Ideal para redirecionar após ações (Login, Clique em Card). { .fragment }

---

## 6. Rotas Dinâmicas (URL Params) 🆔

- `path="/perfil/:username"` { .fragment }
- Hook `useParams()` captura o valor. { .fragment }
- Uma única página que se adapta a mil perfis. { .fragment }

---

## 7. Página 404 (Not Found) 👻

- `path="*"` { .fragment }
- Garante que o usuário nunca caia em uma tela em branco. { .fragment }

---

## Desafio de Roteamento ⚡

Se eu digitar `www.meusite.com/asdfg` e não tiver uma rota configurada para isso, o que o usuário vai ver se eu NÃO colocar uma rota com o `path="*"`?

---

## Resumo ✅

- Roteamento traz a sensação de um site real. { .fragment }
- Hooks `useNavigate` e `useParams` são essenciais. { .fragment }
- SPAs são o padrão da indústria moderna. { .fragment }

---

## Próxima Aula: O Grande Final 🏆

### Projeto Integrado: Backend + Frontend!

- Conectando nossa API Node ao site React. { .fragment }
- O Projeto Final do Curso! { .fragment }

---

## Dúvidas? 🚦
