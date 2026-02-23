# Aula 10 - Controle de Acesso (RBAC) 🛡️
## Hierarquia e Segurança em Camadas

---

## Agenda 📅

1. O que é RBAC? (Roles) { .fragment }
2. Autenticação vs Autorização { .fragment }
3. O Fluxo do Middleware { .fragment }
4. Erros 401 vs 403 { .fragment }
5. Protegendo rotas na prática { .fragment }
6. Hierarquia de Perfis { .fragment }

---

## 1. Role-Based Access Control 👑

- Permissões ligadas a **Perfis** (Roles). { .fragment }
- Ex: ADMIN, EDITOR, VIEWER. { .fragment }
- Facilita a gestão de milhares de usuários. { .fragment }

---

## 2. A Cancela (Middleware) 🚧

- O middleware checa se o usuário tem a "chave" certa. { .fragment }
- Se não tiver -> 403 Forbidden. { .fragment }
- Se tiver -> `next()`. { .fragment }

---

## 3. O Fluxo de Segurança 🌊

```mermaid
graph LR
    Req[Request] --> Auth[Autenticação]
    Auth --> |OK| Role[Autorização]
    Role --> |OK| Controller[Recurso Final]
```

---

## 4. 401 vs 403: Não confunda! ❌

- **401 (Unauthorized)**: "Quem é você?". Token inválido ou ausente. { .fragment }
- **403 (Forbidden)**: "Eu sei quem você é, mas não deixo entrar". Falta de permissão. { .fragment }

---

## 5. Implementação Dinâmica 🔒

```javascript
// Middleware genérico
router.delete('/usuario/:id', 
    autenticar, 
    autorizar(['ADMIN']), 
    userController.remover
);
```

---

## 6. Hierarquia de Acesso 🏛️

- Um Admin deve poder acessar rotas de User? { .fragment }
- Design de sistema: Roles "Pai" e "Filho". { .fragment }

---

## 7. Melhores Práticas 🏆

- Centralize a lógica em Middlewares. { .fragment }
- Nunca exponha permissões sensíveis no frontend (segurança do lado do servidor). { .fragment }

---

## Desafio: Segurança ⚡

Em um sistema escolar, o Diretor e o Professor podem ver notas. O Aluno só vê as dele. Como você configuraria a Role da rota `GET /notas`?

---

## Resumo ✅

- RBAC organiza permissões por grupos. { .fragment }
- Middlewares são os guardiões das rotas. { .fragment }
- Diferenciar 401 de 403 é vital para Debug. { .fragment }

---

## Próxima Aula: Segurança Avançada 🏗️

### Session vs Token e Refresh Tokens

- O que fazer quando o token expira? { .fragment }
- Protegendo contra ataques comuns (XSS, CSRF). { .fragment }

---

## Dúvidas? 🛡️