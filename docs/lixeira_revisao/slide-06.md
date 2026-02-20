# Aula 06 - Services e Regras de Negócio 🧠
## O Cérebro da Aplicação

---

## Agenda 📅

1. Por que separar as coisas? { .fragment }
2. Responsabilidades do Service { .fragment }
3. O Fluxo: Controller -> Service { .fragment }
4. Tratamento de Erros Profissional { .fragment }
5. DTOs: Protegendo os Dados { .fragment }
6. Service vs ViewModel (Mobile) { .fragment }

---

## 1. O Problema: "Controller Gordo" 🍔

- Lógica de negócio misturada com HTTP. { .fragment }
- Código impossível de reutilizar. { .fragment }
- Difícil de testar. { .fragment }

---

## 2. A Solução: Layered Architecture 🧱

- **Controller**: Trata o transporte (HTTP). { .fragment }
- **Service**: Trata a regra (O QUE fazer). { .fragment }

---

## 3. O que vai no Service? ⚖️

- Validações complexas. { .fragment }
- Cálculos de valores. { .fragment }
- Envio de e-mails/notificações. { .fragment }
- Integração com repositórios. { .fragment }

---

## 4. Tratamento de Erros ⚠️

- O Service **Lança** (Throws). { .fragment }
- O Controller **Captura** (Catches). { .fragment }

```javascript
// Service
if (!saldo) throw new Error("Saldo Insuficiente");

// Controller
try { ... } catch (e) { res.status(400)... }
```

---

## 5. DTOs: Filtrando a Saída 📦

- Nunca envie "tudo" do banco para o cliente. { .fragment }
- Proteja campos sensíveis (Ex: `senha_hash`). { .fragment }
- Melhore a performance (menos dados trafegados). { .fragment }

---

## 6. Service vs ViewModel 🆚

- No Backend: **Service** é o cérebro. { .fragment }
- No Mobile/Front: **ViewModel** é o cérebro. { .fragment }
- Ambos servem para "limpar" a camada de visualização. { .fragment }

---

## 7. Prática: Validando um Cadastro 💻

- Verificando se o e-mail é válido. { .fragment }
- Verificando se o usuário já existe. { .fragment }
- Lançando erros específicos. { .fragment }

---

## Desafio: Onde colocar? ⚡

Se uma regra diz: "Usuários VIP ganham 20% de desconto", essa regra deve ficar no **Controller** ou no **Service**?

---

## Resumo ✅

- Controllers recebem, Services processam. { .fragment }
- Mantenha seus Controllers "finos" (Slim Controllers). { .fragment }
- Centralize as regras para facilitar a manutenção. { .fragment }
- DTOs são as fronteiras dos dados. { .fragment }

---

## Próxima Aula: Onde os dados vivem! 🗄️

### Repositories e Banco de Dados

- PostgreSQL e SQL básico. { .fragment }
- Camada de persistência. { .fragment }

---

## Dúvidas? 🧠
