
---

### ✅ **Enunciado:**

Em uma agência bancária, clientes podem abrir uma nova conta fornecendo o número da conta e o nome do titular. Opcionalmente, é possível realizar um depósito inicial no momento da abertura. Caso esse valor não seja informado, o saldo inicial será zero.

O número da conta é imutável após a criação. Já o nome do titular pode ser alterado (por exemplo, em caso de casamento). O saldo da conta, no entanto, só pode ser modificado por meio de métodos específicos de depósito e saque. Para cada saque, o banco cobra uma taxa fixa de R\$ 5,00. Mesmo que o saldo fique negativo, a operação de saque pode ser realizada.

Implemente um programa que permita cadastrar uma conta (com ou sem depósito inicial), realizar um depósito, depois um saque, sempre exibindo os dados atualizados da conta após cada operação.

---

### ✅ **Código Java:**

```java
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContaBancaria conta;

        System.out.print("Informe o número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        System.out.print("Informe o nome do titular: ");
        String titular = sc.nextLine();

        System.out.print("Deseja fazer um depósito inicial? (s/n): ");
        char resposta = sc.next().charAt(0);

        if (resposta == 's' || resposta == 'S') {
            System.out.print("Informe o valor do depósito inicial: R$ ");
            double depositoInicial = sc.nextDouble();
            conta = new ContaBancaria(numero, titular, depositoInicial);
        } else {
            conta = new ContaBancaria(numero, titular);
        }

        System.out.println("\nDados da conta:");
        System.out.println(conta);

        System.out.print("\nInforme um valor para depósito: R$ ");
        double valorDeposito = sc.nextDouble();
        conta.depositar(valorDeposito);
        System.out.println("Dados atualizados da conta:");
        System.out.println(conta);

        System.out.print("\nInforme um valor para saque: R$ ");
        double valorSaque = sc.nextDouble();
        conta.sacar(valorSaque);
        System.out.println("Dados atualizados da conta:");
        System.out.println(conta);

        sc.close();
    }
}
```

---

### ✅ **Classe ContaBancaria:**

```java
public class ContaBancaria {
    private final int numeroConta;
    private String titular;
    private double saldo;
    private static final double TAXA_SAQUE = 5.0;

    // Construtor com depósito inicial
    public ContaBancaria(int numeroConta, String titular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        depositar(depositoInicial);
    }

    // Construtor sem depósito inicial (sobrecarga)
    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) {
        this.saldo -= (valor + TAXA_SAQUE);
    }

    // Getter e setter
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String novoTitular) {
        this.titular = novoTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("Conta %d, Titular: %s, Saldo: R$ %.2f", 
                numeroConta, titular, saldo);
    }
}
```

---

### ✅ **Conceitos abordados:**

* Encapsulamento (`private`, `get`, `set`)
* Construtores com e sem parâmetros (sobrecarga)
* Uso de `this` para distinguir atributos
* Método `toString()` para exibir informações formatadas
* Lógica de saque com taxa
