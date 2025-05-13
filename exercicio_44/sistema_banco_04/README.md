# Gerenciamento de Contas Bancárias p.49

Este projeto implementa um sistema de gerenciamento de contas bancárias utilizando uma variável global para garantir que cada conta tenha um número único.

## Funcionalidades

- Utilização de uma variável global (`int`) para incrementar novos números de conta.
- Instanciação de duas contas bancárias.
- Inicialização do saldo como zero e estado como ativo (`true`).
- Instanciação de dois clientes e associação com suas respectivas contas.
- Solicitação das informações dos clientes.


---

### ✅ Objetivo:

1. Usar uma **variável global (estática)** para garantir que **cada conta tenha um número único**.
2. Criar **duas contas bancárias**.
3. Passar o número da conta no **construtor da conta**.
4. Inicializar o **saldo = 0** e **estado = true (0)**.
5. Criar **dois clientes**, associando cada um a uma conta.
6. Solicitar (via terminal) as **informações do cliente**.

---

### 🧱 Etapas:

#### 🔹 1. Atualizar `ContaBancaria` com ID automático e construtor adequado:

```java
public class ContaBancaria {
    private static int contadorContas = 1;

    private int numero;
    private Cliente titular;
    private double saldo;
    private int estado; // 0 = válido, outros = inválido

    public ContaBancaria() {
        this.numero = contadorContas++;
        this.saldo = 0.0;
        this.estado = 0;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() { return titular; }

    public int getNumero() { return numero; }

    public double getSaldo() { return saldo; }

    public int getEstado() { return estado; }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void depositar(double valor, Cliente cliente) {
        if (!cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Depósito negado. Apenas o titular pode operar.");
            return;
        }
        if (estado != 0) {
            System.out.println("Conta inválida.");
            return;
        }
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado na conta " + numero);
    }

    public void sacar(double valor, Cliente cliente) {
        if (!cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Saque negado. Apenas o titular pode operar.");
            return;
        }
        if (estado != 0) {
            System.out.println("Conta inválida.");
            return;
        }
        if (valor % 15 != 0) {
            System.out.println("Valor deve ser múltiplo de 15.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado da conta " + numero);
    }
}
```

---

#### 🔹 2. Atualizar `Cliente` com entrada de dados e vínculo à conta

```java
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaBancaria conta;

    public Cliente(Scanner sc, ContaBancaria conta) {
        System.out.print("Digite o nome do cliente: ");
        this.nome = sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        this.cpf = sc.nextLine();
        this.conta = conta;
        conta.setTitular(this); // vincula a conta ao cliente
        System.out.println("Conta " + conta.getNumero() + " criada para " + nome + "\n");
    }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public ContaBancaria getConta() { return conta; }
}
```

---

#### 🔹 3. Classe `Main` instanciando tudo

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instanciando 2 contas
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();

        // Instanciando 2 clientes, cada um com sua conta
        Cliente cliente1 = new Cliente(sc, conta1);
        Cliente cliente2 = new Cliente(sc, conta2);

        // Teste: depósito e saque
        conta1.depositar(150, cliente1);
        conta1.sacar(45, cliente1);
        conta2.depositar(90, cliente2);
        conta2.sacar(30, cliente2);

        System.out.printf("Saldo da conta %d (%s): R$%.2f\n",
                conta1.getNumero(), cliente1.getNome(), conta1.getSaldo());
        System.out.printf("Saldo da conta %d (%s): R$%.2f\n",
                conta2.getNumero(), cliente2.getNome(), conta2.getSaldo());

        sc.close();
    }
}
```

---

### ✅ Exemplo de execução no terminal:

```
Digite o nome do cliente: João
Digite o CPF do cliente: 111.222.333-44
Conta 1 criada para João

Digite o nome do cliente: Maria
Digite o CPF do cliente: 222.333.444-55
Conta 2 criada para Maria

Depósito de R$150.0 realizado na conta 1
Saque de R$45.0 realizado da conta 1
Depósito de R$90.0 realizado na conta 2
Saque de R$30.0 realizado da conta 2
Saldo da conta 1 (João): R$105.00
Saldo da conta 2 (Maria): R$60.00
```

---


