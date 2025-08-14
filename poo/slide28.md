# Código completo do cadastro de aluno com entrada de dados e cálculo da média, tudo em um **único arquivo `Main.java`**, com a classe `Aluno` incluída dentro do mesmo arquivo:

```java
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // criar o locale US para usar ponto decimal no lugar de vírgula
        Locale.setDefault(Locale.US);

        // criar o scanner
        Scanner sc = new Scanner(System.in);

        Aluno aluno = new Aluno();

        // Entrada de dados do aluno: nome, idade, matrícula
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do aluno: ");
        int idade = sc.nextInt();

        System.out.print("Digite o número de matrícula: ");
        int matricula = sc.nextInt();
        aluno.cadastrarDados(nome, idade, matricula);

        // Entrada das notas das provas
        System.out.print("Digite a nota da prova 1: ");
        double prova1 = sc.nextDouble();

        System.out.print("Digite a nota da prova 2: ");
        double prova2 = sc.nextDouble();

        // cadastrar notas
        aluno.setNotas(prova1, prova2);

        // exibir as informações do aluno
        aluno.exibirInformacoes();

        // fechar o scanner
        sc.close();
    }
}

// Classe Aluno definida no mesmo arquivo
class Aluno {
    // Atributos
    private String nome;
    private int idade;
    private int matricula;
    private double prova1;
    private double prova2;

    // Método para cadastrar dados do aluno
    public void cadastrarDados(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Método para cadastrar as notas
    public void setNotas(double prova1, double prova2) {
        this.prova1 = prova1;
        this.prova2 = prova2;
    }

    // Método para calcular a média
    public double calcularMedia() {
        return (prova1 + prova2) / 2;
    }

    // Método para exibir as informações
    public void exibirInformacoes() {
        System.out.println("=== DADOS DO ALUNO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Matrícula: " + matricula);
        System.out.printf("Média de notas: %.2f\n", calcularMedia());
    }
}
```

Você pode salvar este código como `Main.java` e compilar normalmente com:

```bash
javac Main.java
java Main
```

