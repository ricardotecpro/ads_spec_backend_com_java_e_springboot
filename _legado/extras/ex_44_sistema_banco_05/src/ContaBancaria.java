public class ContaBancaria {
    private static int contadorContas = 1;

    private int numero;
    private Cliente titular;
    private double saldo;
    private int estado; // 0 = válido

    public ContaBancaria() {
        this.numero = contadorContas++;
        this.saldo = 0.0;
        this.estado = 0;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getNumero() { return numero; }

    public double getSaldo() { return saldo; }

    public Cliente getTitular() { return titular; }

    public void depositar(double valor, Cliente cliente, int numeroInformado) {
        if (numero != numeroInformado || !cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Depósito negado. Conta não pertence ao cliente.");
            return;
        }
        if (estado != 0) {
            System.out.println("Conta inválida.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$%.2f na conta %d realizado com sucesso.\n", valor, numero);
    }

    public void sacar(double valor, Cliente cliente, int numeroInformado) {
        if (numero != numeroInformado || !cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Saque negado. Conta não pertence ao cliente.");
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
        System.out.printf("Saque de R$%.2f da conta %d realizado com sucesso.\n", valor, numero);
    }

    public void extrato(Cliente cliente, int numeroInformado) {
        if (numero != numeroInformado || !cliente.getCpf().equals(titular.getCpf())) {
            System.out.println("Extrato negado. Conta não pertence ao cliente.");
            return;
        }
        System.out.printf("Extrato da conta %d - Titular: %s\n", numero, titular.getNome());
        System.out.printf("Saldo atual: R$%.2f\n", saldo);
    }
}
