import java.util.Locale;
import java.util.Scanner;

public class PlanoTelefonico {

    public static void main(String[] args) {
        // Define o Locale para US para garantir que o ponto seja o separador decimal na leitura
        Locale.setDefault(Locale.US);
        // Cria um objeto Scanner para ler a entrada do teclado
        Scanner sc = new Scanner(System.in);

        // 1. Ler a quantidade de minutos
        System.out.print("Digite a quantidade de minutos consumidos: ");
        int minutos = sc.nextInt();

        // 2. Calcular o valor a ser pago
        double valorAPagar = 50.00; // O valor base é sempre R$ 50,00

        // Verifica se excedeu a franquia de 100 minutos
        if (minutos > 100) {
            // Calcula os minutos excedentes e adiciona R$ 2,00 por cada um
            int minutosExcedentes = minutos - 100;
            valorAPagar += minutosExcedentes * 2.00;
            // A linha acima é um atalho para: valorAPagar = valorAPagar + (minutosExcedentes * 2.00);
        }

        // 3. Mostrar o valor a ser pago
        // System.out.printf é usado para formatar a saída com duas casas decimais
        System.out.printf("Valor a pagar: R$ %.2f%n", valorAPagar);

        // Fecha o objeto Scanner para liberar recursos
        sc.close();
    }
}