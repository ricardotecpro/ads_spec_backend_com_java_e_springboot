# Aula 06 - Services e Regras de Negócio 🧠
## O Cérebro da Aplicação

---

## Agenda 📅

1. Por que separar as coisas? <!-- .element: class="fragment" -->
2. Responsabilidades do Service <!-- .element: class="fragment" -->
3. O Fluxo: Controller -> Service <!-- .element: class="fragment" -->
4. Tratamento de Erros Profissional <!-- .element: class="fragment" -->
5. DTOs: Protegendo os Dados <!-- .element: class="fragment" -->
6. Service vs ViewModel (Mobile) <!-- .element: class="fragment" -->

---

## 1. O Problema: "Controller Gordo" 🍔

- Lógica de negócio misturada com HTTP. <!-- .element: class="fragment" -->
- Código impossível de reutilizar. <!-- .element: class="fragment" -->
- Difícil de testar. <!-- .element: class="fragment" -->

---

## 2. A Solução: Layered Architecture 🧱

- **Controller**: Trata o transporte (HTTP). <!-- .element: class="fragment" -->
- **Service**: Trata a regra (O QUE fazer). <!-- .element: class="fragment" -->

---

## 3. O que vai no Service? ⚖️

- Validações complexas. <!-- .element: class="fragment" -->
- Cálculos de valores. <!-- .element: class="fragment" -->
- Envio de e-mails/notificações. <!-- .element: class="fragment" -->
- Integração com repositórios. <!-- .element: class="fragment" -->

---

## 4. Tratamento de Erros ⚠️

- O Service **Lança** (Throws). <!-- .element: class="fragment" -->
- O Controller **Captura** (Catches). <!-- .element: class="fragment" -->

```javascript
// Service
if (!saldo) throw new Error("Saldo Insuficiente");

// Controller
try { ... } catch (e) { res.status(400)... }
```

---

## 5. DTOs: Filtrando a Saída 📦

- Nunca envie "tudo" do banco para o cliente. <!-- .element: class="fragment" -->
- Proteja campos sensíveis (Ex: `senha_hash`). <!-- .element: class="fragment" -->
- Melhore a performance (menos dados trafegados). <!-- .element: class="fragment" -->

---

## 6. Service vs ViewModel 🆚

- No Backend: **Service** é o cérebro. <!-- .element: class="fragment" -->
- No Mobile/Front: **ViewModel** é o cérebro. <!-- .element: class="fragment" -->
- Ambos servem para "limpar" a camada de visualização. <!-- .element: class="fragment" -->

---

## 7. Prática: Validando um Cadastro 💻

- Verificando se o e-mail é válido. <!-- .element: class="fragment" -->
- Verificando se o usuário já existe. <!-- .element: class="fragment" -->
- Lançando erros específicos. <!-- .element: class="fragment" -->

---

## Desafio: Onde colocar? ⚡

Se uma regra diz: "Usuários VIP ganham 20% de desconto", essa regra deve ficar no **Controller** ou no **Service**?

---

## Resumo ✅

- Controllers recebem, Services processam. <!-- .element: class="fragment" -->
- Mantenha seus Controllers "finos" (Slim Controllers). <!-- .element: class="fragment" -->
- Centralize as regras para facilitar a manutenção. <!-- .element: class="fragment" -->
- DTOs são as fronteiras dos dados. <!-- .element: class="fragment" -->

---

## Próxima Aula: Onde os dados vivem! 🗄️

### Repositories e Banco de Dados

- PostgreSQL e SQL básico. <!-- .element: class="fragment" -->
- Camada de persistência. <!-- .element: class="fragment" -->

---

## Dúvidas? 🧠
