import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno();

        // Entrada de dados
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do aluno: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o número de matrícula: ");
        int matricula = scanner.nextInt();
        
        System.out.print("Digite a média de notas: ");
        float media = scanner.nextFloat();
        
        aluno.cadastrarDados(nome, idade, matricula, media);
       
        

        // Saída de dados
        aluno.exibirInformacoes();
    }
}