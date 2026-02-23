# Aula 05 - Implementação de APIs ⚙️
## Controllers e Rotas

---

## Agenda 📅

1. Camadas do Backend { .fragment }
2. O Papel do Controller { .fragment }
3. Rotas e Handlers { .fragment }
4. Capturando Dados (Params/Body) { .fragment }
5. Status Codes na Prática { .fragment }
6. Injeção de Dependência { .fragment }

---

## 1. Organização em Camadas 🧱

- **Controller**: Trata a entrada (HTTP). { .fragment }
- **Service**: Regras de negócio. { .fragment }
- **Repository**: Acesso ao banco. { .fragment }

---

## 2. O Papel do Controller 🎮

- Ele é o ponto de entrada. { .fragment }
- **Não deve ter lógica complexa!** { .fragment }
- Deve apenas orquestrar a execução. { .fragment }

> **Controller** = Garçom 🤵
> **Service** = Cozinheiro 👨‍🍳

---

## 3. Rotas e Handlers 📍

- **Rota**: Verbo HTTP + Path. { .fragment }
- **Handler**: Função executada. { .fragment }

```javascript
router.post('/login', controller.realizarLogin);
```

---

## 4. Capturando Dados 📥

- **Path Params**: `/id/123` (Identificação). { .fragment }
- **Query Params**: `?q=busca` (Filtro). { .fragment }
- **Body**: Enviando JSON (Criação/Update). { .fragment }

---

## 5. Respostas de Qualidade 📤

- Nunca esqueça o Status Code! { .fragment }
- Sucesso: 200, 201, 204. { .fragment }
- Erro: 400, 401, 404, 500. { .fragment }

---

## 6. Injeção de Dependência 💉

- Receber serviços prontos. { .fragment }
- Facilita testar o Controller "isolado". { .fragment }

---

## 7. Prática: O Primeiro Endpoint 💻

- Mapeando um `GET /ping`. { .fragment }
- Retornando um `pong` em JSON. { .fragment }
- Testando no Insomnia/Postman. { .fragment }

---

## Desafio: Params vs Query ⚡

Se você quer listar todos os alunos de uma sala com o nome "Pedro", qual tipo de parâmetro você usaria para o nome?

---

## Resumo ✅

- Controllers são a porta de entrada. { .fragment }
- Devem ser leves e objetivos. { .fragment }
- Capturam dados e retornam status/JSON. { .fragment }
- Seguem as rotas definidas. { .fragment }

---

## Próxima Aula: Regras de Negócio! 🧠

### Services e Validações

- Onde o cálculo acontece. { .fragment }
- Isolando o código do "mundo externo". { .fragment }

---

## Dúvidas? ⚙️
