
package entidades;

public class ContaPoupanca extends Conta {
    private Double taxaJuros;

    public ContaPoupanca(Integer numero, String titular, Double saldo, Double taxaJuros) {
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void atualizarSaldo() {
        saldo += saldo * taxaJuros;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }
}
