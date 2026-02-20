# Aula 09 - Segurança e Autenticação com JWT 🔐
## Portas trancadas e Crachás Digitais

---

## Agenda 📅

1. Autenticação vs Autorização { .fragment }
2. O Fim das Sessões (Stateful) { .fragment }
3. O que é JWT? { .fragment }
4. Estrutura: Header, Payload, Signature { .fragment }
5. Fluxo de Login completo { .fragment }
6. Melhores Práticas de Segurança { .fragment }

---

## 1. Quem é Você? (Autenticação) 🚦

- Validar a identidade do usuário. { .fragment }
- Login e Senha. { .fragment }
- **Autorização**: O que você PODE fazer? (Níveis de acesso). { .fragment }

---

## 2. Por que JWT? 🤔

- Abordagem **Stateless** (Sem estado). { .fragment }
- O servidor não guarda sessão na memória (escalável!). { .fragment }
- Perfeito para Microserviços e Mobile. { .fragment }

---

## 3. Estrutura do Token 🎫

```text
[Header].[Payload].[Signature]
```

- **Header**: Algoritmo (ex: HS256). { .fragment }
- **Payload**: Os dados (id, role, nome). { .fragment }
- **Signature**: O lacre de segurança. { .fragment }

---

## 4. O Coração do JWT: A Assinatura 🖋️

- Usa uma `SECRET_KEY` no servidor. { .fragment }
- Garante que o token não foi "hackeado" ou alterado. { .fragment }

---

## 5. Fluxo de Login 🌊

1. Envia credenciais -> 2. Servidor valida -> 3. Gera JWT -> 4. Frontend guarda o Token -> 5. Envia no Header em cada requisição.

---

## 6. Segurança em Mobile 📱

- Nunca guarde em arquivos de texto! { .fragment }
- Use **EncryptedSharedPreferences** (Android) ou **Keychain** (iOS). { .fragment }

---

## 7. Melhores Práticas 🏆

- Use chaves secretas longas e seguras. { .fragment }
- Defina tempo de expiração (`expiresIn`). { .fragment }
- Protocolo **HTTPS** é obrigatório! { .fragment }

---

## Desafio de Segurança ⚡

O Payload do JWT é criptografado ou apenas codificado? Posso guardar a senha do usuário lá?

---

## Resumo ✅

- JWT permite autenticação rápida e escalável. { .fragment }
- Header + Payload + Signature. { .fragment }
- Stateless = Servidor mais leve. { .fragment }

---

## Próxima Aula: Controle de Acesso 🛡️

### Quem manda aqui? (RBAC)

- Middlewares de autorização. { .fragment }
- Protegendo rotas por nível de usuário. { .fragment }

---

## Dúvidas? 🔐
