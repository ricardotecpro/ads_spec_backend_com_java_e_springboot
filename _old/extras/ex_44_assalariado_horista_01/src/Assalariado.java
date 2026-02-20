// Classe derivada Assalariado
public class Assalariado extends Funcionario {
    public Assalariado(String nome, int id, double salarioMensal) {
        super(nome, id);
        this.salario = salarioMensal;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}
