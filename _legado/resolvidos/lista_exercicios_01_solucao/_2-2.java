import java.util.Scanner;
import java.util.Random;

class SomaDiagonaisMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--- Soma das Diagonais de uma Matriz Quadrada ---");

        // Solicita a ordem da matriz
        System.out.print("Digite a ordem da matriz quadrada (n): ");
        int n = scanner.nextInt();

        // Validação da ordem
        if (n <= 0) {
            System.out.println("A ordem da matriz deve ser positiva.");
            scanner.close();
            return;
        }

        int[][] matriz = new int[n][n];

        // Opção de preenchimento: manual ou automático
        System.out.print("Deseja preencher a matriz manualmente (M) ou automaticamente (A)? ");
        char opcaoPreenchimento = scanner.next().toUpperCase().charAt(0);

        // Preenche a matriz
        System.out.println("\nPreenchendo a matriz " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (opcaoPreenchimento == 'M') {
                    System.out.print("Digite o elemento matriz[" + i + "][" + j + "]: ");
                    matriz[i][j] = scanner.nextInt();
                } else { // Preenchimento automático
                    matriz[i][j] = random.nextInt(100); // Números entre 0 e 99
                }
            }
        }

        // Exibe a matriz
        System.out.println("\nMatriz informada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // Calcula a soma da diagonal principal
        // Elementos onde i == j
        long somaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            somaDiagonalPrincipal += matriz[i][i];
        }

        // Calcula a soma da diagonal secundária
        // Elementos onde i + j == n - 1
        long somaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            somaDiagonalSecundaria += matriz[i][n - 1 - i];
        }

        // Exibe os resultados
        System.out.println("\nSoma da diagonal principal: " + somaDiagonalPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaDiagonalSecundaria);

        scanner.close();
        System.out.println("--- Fim do Cálculo das Diagonais ---");
    }
}
