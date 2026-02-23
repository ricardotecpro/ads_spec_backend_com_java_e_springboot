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
