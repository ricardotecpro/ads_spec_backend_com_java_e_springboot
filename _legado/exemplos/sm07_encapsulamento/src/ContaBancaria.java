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
