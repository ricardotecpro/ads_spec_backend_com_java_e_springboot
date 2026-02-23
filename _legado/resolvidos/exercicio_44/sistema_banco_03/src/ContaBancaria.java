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
