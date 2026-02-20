# Aula 15 - React Router 🚦
## Criando Apps Multi-Página

---

## Agenda 📅

1. O que são SPAs? <!-- .element: class="fragment" -->
2. Multi-páginas (Simuladas) <!-- .element: class="fragment" -->
3. Componentes de Rota <!-- .element: class="fragment" -->
4. Navegação (`Link` e `useNavigate`) <!-- .element: class="fragment" -->
5. Parâmetros dinâmicos (`:id`) <!-- .element: class="fragment" -->

---

## 1. O Mundo do SPA ⚛️

- O site é uma única página HTML. <!-- .element: class="fragment" -->
- O Javascript "troca" a tela sem recarregar. <!-- .element: class="fragment" -->
- UX rápida e fluida. <!-- .element: class="fragment" -->

---

## 2. React Router Dom ⚙️

```bash
npm install react-router-dom
```

- A biblioteca padrão para web. <!-- .element: class="fragment" -->
- Permite que a URL combine com o que aparece na tela. <!-- .element: class="fragment" -->

---

## 3. A Estrutura Básica 🏗️

- **BrowserRouter**: O container principal. <!-- .element: class="fragment" -->
- **Routes**: O seletor de rotas. <!-- .element: class="fragment" -->
- **Route**: Define o caminho (`path`) e o componente (`element`). <!-- .element: class="fragment" -->

---

## 4. Navegando sem Recarregar! 🏃‍♂️

- Use `<Link to="/contato">` <!-- .element: class="fragment" -->
- **NUNCA** use `<a href="...">` para rotas internas. <!-- .element: class="fragment" -->

---

## 5. Navegação Programática 🚀

```javascript
const navigate = useNavigate();

onClick={() => navigate("/dashboard")}
```

- Ideal para redirecionar após ações (Login, Clique em Card). <!-- .element: class="fragment" -->

---

## 6. Rotas Dinâmicas (URL Params) 🆔

- `path="/perfil/:username"` <!-- .element: class="fragment" -->
- Hook `useParams()` captura o valor. <!-- .element: class="fragment" -->
- Uma única página que se adapta a mil perfis. <!-- .element: class="fragment" -->

---

## 7. Página 404 (Not Found) 👻

- `path="*"` <!-- .element: class="fragment" -->
- Garante que o usuário nunca caia em uma tela em branco. <!-- .element: class="fragment" -->

---

## Desafio de Roteamento ⚡

Se eu digitar `www.meusite.com/asdfg` e não tiver uma rota configurada para isso, o que o usuário vai ver se eu NÃO colocar uma rota com o `path="*"`?

---

## Resumo ✅

- Roteamento traz a sensação de um site real. <!-- .element: class="fragment" -->
- Hooks `useNavigate` e `useParams` são essenciais. <!-- .element: class="fragment" -->
- SPAs são o padrão da indústria moderna. <!-- .element: class="fragment" -->

---

## Próxima Aula: O Grande Final 🏆

### Projeto Integrado: Backend + Frontend!

- Conectando nossa API Node ao site React. <!-- .element: class="fragment" -->
- O Projeto Final do Curso! <!-- .element: class="fragment" -->

---

## Dúvidas? 🚦
