// Classe principal para testar
public class Principal {
    public static void main(String[] args) {
        Funcionario f1 = new Assalariado("João Silva", 101, 3000.0);
        Funcionario f2 = new Horista("Maria Souza", 102, 50.0, 160);

        System.out.println("== Funcionário Assalariado ==");
        f1.exibirDados();

        System.out.println("\n== Funcionário Horista ==");
        f2.exibirDados();
    }
}
