import java.util.Scanner;

public class DiaDaSemana {

    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do teclado
        Scanner sc = new Scanner(System.in);

        // 1. Ler o número inteiro
        System.out.print("Digite o número do dia da semana (1 a 7): ");
        int numeroDia = sc.nextInt();

        // Variável para armazenar o nome do dia
        String nomeDoDia;

        // 2. Usar a estrutura switch-case para determinar o nome do dia
        switch (numeroDia) {
            case 1:
                nomeDoDia = "domingo";
                break; // 'break' impede que o código continue para o próximo case
            case 2:
                nomeDoDia = "segunda";
                break;
            case 3:
                nomeDoDia = "terça";
                break;
            case 4:
                nomeDoDia = "quarta";
                break;
            case 5:
                nomeDoDia = "quinta";
                break;
            case 6:
                nomeDoDia = "sexta";
                break;
            case 7:
                nomeDoDia = "sábado";
                break;
            default: // 'default' é executado se nenhum case corresponder
                nomeDoDia = "valor inválido";
                break;
        }

        // 3. Escrever na tela o resultado
        System.out.println("Dia da semana: " + nomeDoDia);

        // Fecha o objeto Scanner
        sc.close();
    }
}