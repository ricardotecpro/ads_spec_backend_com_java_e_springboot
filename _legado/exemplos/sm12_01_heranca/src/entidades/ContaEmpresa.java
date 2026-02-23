
package entidades;

public class ContaEmpresa extends Conta {
    private Double limiteEmprestimo;

    public ContaEmpresa(Integer numero, String titular, Double saldo, Double limiteEmprestimo) {
        super(numero, titular, saldo);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void emprestar(double valor) {
        if (valor <= limiteEmprestimo) {
            saldo += valor;
        }
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor + 2.0;
    }
}
