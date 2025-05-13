
# 📘 Cliente e Conta Bancária p.47

## 💡 Descrição
Este projeto implementa um sistema de gerenciamento de clientes e contas bancárias, seguindo regras específicas para abertura de contas, depósitos e saques.

## 🏦 Funcionalidades

- Cadastro de clientes no momento da abertura de conta 📝
- Criação de contas com saldo inicial zerado 💰
- Realização de depósitos e saques seguindo regras específicas 🔄

## ⚖️ Regras

1️⃣ **Cadastro de Cliente**: Todo cliente deve ser registrado no sistema ao abrir uma conta.  
2️⃣ **Saldo Inicial**: Todas as contas começam com saldo zerado.  
3️⃣ **Transações Permitidas**:
- ✅ **Saques**: Só podem ser realizados se:
    - O valor for múltiplo de 15 💵
    - Existir saldo suficiente 💳
    - O estado da conta for válido (estado = 0) ✅
    - Apenas o próprio cliente pode realizar saques e depósitos 👤

---

### ✅ Regras para `ContaBancaria`

1. Toda conta começa com **saldo zerado**.
2. **Saques** só são permitidos se:

    * O **valor for múltiplo de 15**.
    * **Houver saldo suficiente**.
    * O **estado da conta** for **0** (válido).
    * O **cliente que opera a conta** for o **dono da conta**.
3. **Depósitos** também devem ser feitos **pelo próprio cliente**.

---

### 📦 Classes que vamos criar:

* `Cliente`
* `ContaBancaria`

---

### ✅ Classe `Cliente.java`

```java
public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
}
```

---

### ✅ Classe `ContaBancaria.java`

```java
public class ContaBancaria {
    private Cliente titular;
    private double saldo;
    private int estado; // 0 = válido, outros = inválido

    public ContaBancaria(Cliente titular) {
        this.titular = titular;
        this.saldo = 0.0;
        this.estado = 0;
    }

    public void depositar(double valor, Cliente cliente) {
        if (!cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Depósito negado. Apenas o titular pode realizar operações.");
            return;
        }
        if (estado != 0) {
            System.out.println("Conta inválida para operações.");
            return;
        }
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor, Cliente cliente) {
        if (!cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Saque negado. Apenas o titular pode realizar operações.");
            return;
        }
        if (estado != 0) {
            System.out.println("Conta inválida para saque.");
            return;
        }
        if (valor % 15 != 0) {
            System.out.println("Valor do saque deve ser múltiplo de 15.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque.");
            return;
        }
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
}
```

---

### ✅ Exemplo de Uso no `main`

```java
public class Main {
    public static void main(String[] args) {
        // Criando cliente e conta
        Cliente cliente1 = new Cliente("Lucas", "999.888.777-66");
        ContaBancaria conta1 = new ContaBancaria(cliente1);

        // Cliente certo faz depósito
        conta1.depositar(150.0, cliente1);

        // Cliente errado tenta sacar
        Cliente invasor = new Cliente("Invasor", "000.000.000-00");
        conta1.sacar(45.0, invasor); // Deve negar

        // Cliente certo tenta sacar valor inválido
        conta1.sacar(40.0, cliente1); // Não múltiplo de 15

        // Cliente certo faz saque válido
        conta1.sacar(45.0, cliente1); // OK

        // Verificar saldo final
        System.out.println("Saldo final: R$" + conta1.getSaldo());
    }
}
```

---

### ✅ Saída esperada:

```
Depósito de R$150.0 realizado com sucesso.
Saque negado. Apenas o titular pode realizar operações.
Valor do saque deve ser múltiplo de 15.
Saque de R$45.0 realizado com sucesso.
Saldo final: R$105.0
```

---
