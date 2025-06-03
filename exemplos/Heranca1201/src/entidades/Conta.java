
package entidades;

public class Conta {
    private Integer numero;
    private String titular;
    protected Double saldo;

    public Conta(Integer numero, String titular, Double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor + 5.0;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String toString() {
        return numero + ", Titular: " + titular + ", Saldo: R$ " + String.format("%.2f", saldo);
    }
}
