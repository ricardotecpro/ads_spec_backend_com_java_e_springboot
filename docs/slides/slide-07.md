# Aula 07 - Repositories e Banco de Dados 🗄️
## Onde a informação descansa

---

## Agenda 📅

1. Por que Bancos de Dados? <!-- .element: class="fragment" -->
2. PostgreSQL: O Robusto <!-- .element: class="fragment" -->
3. SQL Básico (SELECT, INSERT...) <!-- .element: class="fragment" -->
4. Relacionamentos (1:N, N:N) <!-- .element: class="fragment" -->
5. Camada de Persistence <!-- .element: class="fragment" -->
6. O Padrão Repository <!-- .element: class="fragment" -->

---

## 1. Persistência de Dados 💾

- Sem banco, o servidor esquece tudo ao reiniciar. <!-- .element: class="fragment" -->
- Precisamos de segurança e integridade. <!-- .element: class="fragment" -->
- **Estritamente Tipado**: O banco garante o formato. <!-- .element: class="fragment" -->

---

## 2. Por que PostgreSQL? 🐘

- Código Aberto (Open Source). <!-- .element: class="fragment" -->
- Extremamente confiável (ACID). <!-- .element: class="fragment" -->
- Suporta dados complexos (JSONB). <!-- .element: class="fragment" -->

---

## 3. SQL: A Linguagem Universal 🗣️

```sql
-- Buscar usuários VIP
SELECT * FROM usuarios 
WHERE tipo = 'VIP' 
ORDER BY nome;
```

- **DDL**: Define a estrutura (Tabelas). <!-- .element: class="fragment" -->
- **DML**: Manipula os dados (Linhas). <!-- .element: class="fragment" -->

---

## 4. O Coração: Relacionamentos 🔗

- **1:N**: Um cliente, muitos pedidos. <!-- .element: class="fragment" -->
- **N:N**: Muitos alunos, muitos cursos. <!-- .element: class="fragment" -->
- **Foreign Key**: A âncora que liga tudo. <!-- .element: class="fragment" -->

---

## 5. Camada de Persistence 🧱

- O código que conversa com o driver do banco. <!-- .element: class="fragment" -->
- Onde as queries são traduzidas para o código. <!-- .element: class="fragment" -->

---

## 6. Padrão Repository 📥

- "Não me diga como, diga O QUE você quer". <!-- .element: class="fragment" -->
- Isola o SQL da regra de negócio. <!-- .element: class="fragment" -->

```javascript
// No Service
userRepository.findByEmail(email);
```

---

## 7. Migrations 📜

- Controle de versão para o Banco. <!-- .element: class="fragment" -->
- Permite "voltar no tempo" se algo quebrar. <!-- .element: class="fragment" -->
- Mantém o time em sincronia. <!-- .element: class="fragment" -->

---

## Desafio SQL ⚡

Qual comando você usaria para mudar o preço de todos os produtos da categoria 'Games' para 99.90?

---

## Resumo ✅

- Bancos de dados dão memória ao sistema. <!-- .element: class="fragment" -->
- PostgreSQL é o padrão da indústria. <!-- .element: class="fragment" -->
- SQL é habilidade obrigatória para backend. <!-- .element: class="fragment" -->
- Repository Pattern traz flexibilidade. <!-- .element: class="fragment" -->

---

## Próxima Aula: Integridade! ✅

### Validação e Boas Práticas

- Garantindo que dados "sujos" não entrem no banco. <!-- .element: class="fragment" -->
- Tratamento de exceções de banco. <!-- .element: class="fragment" -->

---

## Dúvidas? 🗄️
