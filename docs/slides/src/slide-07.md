# Aula 07 - Repositories e Banco de Dados 🗄️
## Onde a informação descansa

---

## Agenda 📅

1. Por que Bancos de Dados? { .fragment }
2. PostgreSQL: O Robusto { .fragment }
3. SQL Básico (SELECT, INSERT...) { .fragment }
4. Relacionamentos (1:N, N:N) { .fragment }
5. Camada de Persistence { .fragment }
6. O Padrão Repository { .fragment }

---

## 1. Persistência de Dados 💾

- Sem banco, o servidor esquece tudo ao reiniciar. { .fragment }
- Precisamos de segurança e integridade. { .fragment }
- **Estritamente Tipado**: O banco garante o formato. { .fragment }

---

## 2. Por que PostgreSQL? 🐘

- Código Aberto (Open Source). { .fragment }
- Extremamente confiável (ACID). { .fragment }
- Suporta dados complexos (JSONB). { .fragment }

---

## 3. SQL: A Linguagem Universal 🗣️

```sql
-- Buscar usuários VIP
SELECT * FROM usuarios 
WHERE tipo = 'VIP' 
ORDER BY nome;
```

- **DDL**: Define a estrutura (Tabelas). { .fragment }
- **DML**: Manipula os dados (Linhas). { .fragment }

---

## 4. O Coração: Relacionamentos 🔗

- **1:N**: Um cliente, muitos pedidos. { .fragment }
- **N:N**: Muitos alunos, muitos cursos. { .fragment }
- **Foreign Key**: A âncora que liga tudo. { .fragment }

---

## 5. Camada de Persistence 🧱

- O código que conversa com o driver do banco. { .fragment }
- Onde as queries são traduzidas para o código. { .fragment }

---

## 6. Padrão Repository 📥

- "Não me diga como, diga O QUE você quer". { .fragment }
- Isola o SQL da regra de negócio. { .fragment }

```javascript
// No Service
userRepository.findByEmail(email);
```

---

## 7. Migrations 📜

- Controle de versão para o Banco. { .fragment }
- Permite "voltar no tempo" se algo quebrar. { .fragment }
- Mantém o time em sincronia. { .fragment }

---

## Desafio SQL ⚡

Qual comando você usaria para mudar o preço de todos os produtos da categoria 'Games' para 99.90?

---

## Resumo ✅

- Bancos de dados dão memória ao sistema. { .fragment }
- PostgreSQL é o padrão da indústria. { .fragment }
- SQL é habilidade obrigatória para backend. { .fragment }
- Repository Pattern traz flexibilidade. { .fragment }

---

## Próxima Aula: Integridade! ✅

### Validação e Boas Práticas

- Garantindo que dados "sujos" não entrem no banco. { .fragment }
- Tratamento de exceções de banco. { .fragment }

---

## Dúvidas? 🗄️
