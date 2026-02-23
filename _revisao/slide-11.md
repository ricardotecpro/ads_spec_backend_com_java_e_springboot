# Aula 11 - Refresh Token e Segurança Avançada 🏗️
## Blindando sua API contra o mundo

---

## Agenda 📅

1. O Problema do Token Curto ⏰ { .fragment }
2. Refresh Tokens (O que são?) { .fragment }
3. CORS: Origens e Destinos { .fragment }
4. Helmet: Headers de Aço { .fragment }
5. Rate Limit: Contra Brute Force { .fragment }
6. Ataques Comuns (XSS, Injection) { .fragment }

---

## 1. Por que Tokens Expiram? ⏰

- Segurança! Se roubarem o token, ele dura pouco. { .fragment }
- **Problema**: O usuário odeia fazer login toda hora. { .fragment }

---

## 2. Refresh Token 🔁

- Um token de longa duração (7 dias+). { .fragment }
- Serve apenas para trocar por um novo Access Token. { .fragment }
- Deve ser invalidado se o usuário deslogar. { .fragment }

---

## 3. CORS: Cross-Origin Resource Sharing 🌍

- "Quem pode me chamar?". { .fragment }
- Resolvido via Headers no Servidor. { .fragment }
- **Nunca** use `origin: '*'` em ambientes reais! { .fragment }

---

## 4. Helmet: Proteção de Headers 🪖

- Remove o `X-Powered-By` (não diz que é Express). { .fragment }
- Adiciona proteção contra Clickjacking e XSS. { .fragment }

---

## 5. Rate Limiting 🔨

- 5 tentativas de login por minuto? Sim. { .fragment }
- Evita que robôs tentem descobrir senhas via "força bruta". { .fragment }

---

## 6. Onde salvar os Tokens? 🛡️

- **Frontend**: LocalStorage? Seguro? { .fragment }
- **Melhor Prática**: Cookies `HttpOnly` + `Secure`. { .fragment }

---

## 7. Melhores Práticas de Segurança 🏆

1. Use HTTPS sempre. { .fragment }
2. Valide TODAS as entradas do usuário. { .fragment }
3. Mantenha as bibliotecas atualizadas. { .fragment }

---

## Desafio de Segurança ⚡

Qual a diferença entre 401 e 403 no contexto de Refresh Tokens? Se eu recebo 401, eu tento o refresh ou deslogo o usuário?

---

## Resumo ✅

- Refresh Token equilibra UX e Segurança. { .fragment }
- CORS e Helmet são as portas do seu castelo. { .fragment }
- Proteja-se contra robôs com Rate Limit. { .fragment }

---

## Próximo Módulo: Front-End Moderno 🎨

### Saindo das APIs e indo para a Web!

- Introdução ao React/Vite. { .fragment }
- Consumindo nossas APIs no navegador. { .fragment }

---

## Dúvidas? 🏗️