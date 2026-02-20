# Aula 05 - Implementação de APIs ⚙️
## Controllers e Rotas

---

## Agenda 📅

1. Camadas do Backend <!-- .element: class="fragment" -->
2. O Papel do Controller <!-- .element: class="fragment" -->
3. Rotas e Handlers <!-- .element: class="fragment" -->
4. Capturando Dados (Params/Body) <!-- .element: class="fragment" -->
5. Status Codes na Prática <!-- .element: class="fragment" -->
6. Injeção de Dependência <!-- .element: class="fragment" -->

---

## 1. Organização em Camadas 🧱

- **Controller**: Trata a entrada (HTTP). <!-- .element: class="fragment" -->
- **Service**: Regras de negócio. <!-- .element: class="fragment" -->
- **Repository**: Acesso ao banco. <!-- .element: class="fragment" -->

---

## 2. O Papel do Controller 🎮

- Ele é o ponto de entrada. <!-- .element: class="fragment" -->
- **Não deve ter lógica complexa!** <!-- .element: class="fragment" -->
- Deve apenas orquestrar a execução. <!-- .element: class="fragment" -->

> **Controller** = Garçom 🤵
> **Service** = Cozinheiro 👨‍🍳

---

## 3. Rotas e Handlers 📍

- **Rota**: Verbo HTTP + Path. <!-- .element: class="fragment" -->
- **Handler**: Função executada. <!-- .element: class="fragment" -->

```javascript
router.post('/login', controller.realizarLogin);
```

---

## 4. Capturando Dados 📥

- **Path Params**: `/id/123` (Identificação). <!-- .element: class="fragment" -->
- **Query Params**: `?q=busca` (Filtro). <!-- .element: class="fragment" -->
- **Body**: Enviando JSON (Criação/Update). <!-- .element: class="fragment" -->

---

## 5. Respostas de Qualidade 📤

- Nunca esqueça o Status Code! <!-- .element: class="fragment" -->
- Sucesso: 200, 201, 204. <!-- .element: class="fragment" -->
- Erro: 400, 401, 404, 500. <!-- .element: class="fragment" -->

---

## 6. Injeção de Dependência 💉

- Receber serviços prontos. <!-- .element: class="fragment" -->
- Facilita testar o Controller "isolado". <!-- .element: class="fragment" -->

---

## 7. Prática: O Primeiro Endpoint 💻

- Mapeando um `GET /ping`. <!-- .element: class="fragment" -->
- Retornando um `pong` em JSON. <!-- .element: class="fragment" -->
- Testando no Insomnia/Postman. <!-- .element: class="fragment" -->

---

## Desafio: Params vs Query ⚡

Se você quer listar todos os alunos de uma sala com o nome "Pedro", qual tipo de parâmetro você usaria para o nome?

---

## Resumo ✅

- Controllers são a porta de entrada. <!-- .element: class="fragment" -->
- Devem ser leves e objetivos. <!-- .element: class="fragment" -->
- Capturam dados e retornam status/JSON. <!-- .element: class="fragment" -->
- Seguem as rotas definidas. <!-- .element: class="fragment" -->

---

## Próxima Aula: Regras de Negócio! 🧠

### Services e Validações

- Onde o cálculo acontece. <!-- .element: class="fragment" -->
- Isolando o código do "mundo externo". <!-- .element: class="fragment" -->

---

## Dúvidas? ⚙️
