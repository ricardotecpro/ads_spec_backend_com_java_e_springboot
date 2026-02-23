# Aula 08 - Boas Práticas e Validação ✅
## Qualidade e Segurança no Backend

---

## Agenda 📅

1. Por que Validar Tudo? { .fragment }
2. Validação vs Sanitização { .fragment }
3. Schema Validation (Ex: Zod) { .fragment }
4. Clean Code (Código Limpo) { .fragment }
5. Tratamento de Erros Profissional { .fragment }
6. Middlewares Globais { .fragment }

---

## 1. Regra de Ouro: Desconfiança 🛡️

- O cliente é o "lado perigoso" da aplicação. { .fragment }
- Validações evitam dados corrompidos. { .fragment }
- **Defesa em Profundidade**: Garanta a regra no banco E no código. { .fragment }

---

## 2. Validar vs Sanitizar 🧼

- **Validar**: Checar (Idade > 18?). { .fragment }
- **Sanitizar**: Limpar (Remover `<script>`). { .fragment }

---

## 3. Schema Validation 📐

- Crie "moldes" para seus dados. { .fragment }
- Validação centralizada e reutilizável. { .fragment }

```javascript
const userSchema = {
    nome: string().min(3),
    email: string().email()
};
```

---

## 4. O Backend Elegante (Clean Code) ✨

- **DRY**: Don't Repeat Yourself (Não repita lógica). { .fragment }
- **KISS**: Keep It Simple, Stupid (Mantenha o simples). { .fragment }
- Nomes de funções que explicam o que está acontecendo. { .fragment }

---

## 5. Tratamento de Erros 🚨

- Controller trata o fluxo, não o detalhe técnico. { .fragment }
- **Try/Catch Global**: Evite crashes. { .fragment }
- Mensagens amigáveis para o cliente. { .fragment }

---

## 6. Logs vs Mensagens 📜

- **Terminal/Log**: Detalhe técnico completo. { .fragment }
- **Cliente (JSON)**: Apenas o que ele precisa saber. { .fragment }

> "Ocorreu um erro interno" (Cliente) ✅
> "Query failed at line 42 due to NULL constraint" (Logs) ✅

---

## 7. Prática: O Schema Perfeito 💻

- Validando um produto complexo. { .fragment }
- Tratando erros de tipo (String no lugar de Number). { .fragment }

---

## Desafio: Limpeza ⚡

Se você recebe um texto de um post com muitos espaços em branco no final, você deve **Validar** ou **Sanitizar**?

---

## Resumo ✅

- Backend robusto exige validação rigorosa. { .fragment }
- Limpe os dados antes de salvar (Sanitize). { .fragment }
- Middleware Global centraliza a gestão de falhas. { .fragment }
- Código limpo economiza meses de manutenção. { .fragment }

---

## Próxima Aula: Módulo 3! 🔐

### Segurança e Autenticação

- Quem é você? (Authentication). { .fragment }
- O que você pode fazer? (Authorization). { .fragment }

---

## Dúvidas? ✅