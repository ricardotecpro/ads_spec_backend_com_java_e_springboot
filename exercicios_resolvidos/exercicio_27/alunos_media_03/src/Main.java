import java.util.Locale;
import java.util.Scanner;

public class    Main {
    public static void main(String[] args) {

        // criar o locale US para usar ponto decimal no lugar de ,
        Locale.setDefault(Locale.US);
        
        // criar o scanner
        Scanner sc = new Scanner(System.in);        
        
        
        Aluno aluno = new Aluno();

        // Entrada de dados do aluno String int int 
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do aluno: ");
        int idade = sc.nextInt();

        System.out.print("Digite o número de matrícula: ");
        int matricula = sc.nextInt();
        aluno.cadastrarDados(nome, idade, matricula);

        // Entrada das notas das provas do aluno double
        System.out.print("Digite a nota da prova 1: ");
        double prova1 = sc.nextDouble();

        System.out.print("Digite a nota da prova 2: ");
        double prova2 = sc.nextDouble();
        
        // chamada das funcoes setNotas e exibir Informacoes
        aluno.setNotas(prova1, prova2);
        

        // Saída de dados
        aluno.exibirInformacoes();
        
        
        // fechar o scannner        
        sc.close();
    }
}

