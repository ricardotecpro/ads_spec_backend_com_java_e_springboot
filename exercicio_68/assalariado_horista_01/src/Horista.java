// Classe derivada Horista
public class Horista extends Funcionario {
    private double valorHora;
    private int horasTrabalhadas;

    public Horista(String nome, int id, double valorHora, int horasTrabalhadas) {
        super(nome, id);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularSalario() {
        return valorHora * horasTrabalhadas;
    }
}
