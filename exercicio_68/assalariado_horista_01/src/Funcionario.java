// Classe base Funcionario
public abstract class Funcionario {
    protected String nome;
    protected int id;
    protected double salario;

    public Funcionario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public abstract double calcularSalario();

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Salário: R$ " + calcularSalario());
    }
}
