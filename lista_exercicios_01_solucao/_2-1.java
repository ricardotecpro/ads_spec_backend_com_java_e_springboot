import java.util.Scanner;
import java.util.Random; // Para preenchimento automático opcional

class MatrizMaiorMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Opcional, para gerar números aleatórios

        System.out.println("--- Maior e Menor Elemento em uma Matriz ---");

        // Solicita as dimensões da matriz
        System.out.print("Digite o número de linhas (m): ");
        int m = scanner.nextInt();
        System.out.print("Digite o número de colunas (n): ");
        int n = scanner.nextInt();

        // Validação básica das dimensões
        if (m <= 0 || n <= 0) {
            System.out.println("As dimensões da matriz devem ser positivas.");
            scanner.close();
            return;
        }

        int[][] matriz = new int[m][n];

        // Opção de preenchimento: manual ou automático
        System.out.print("Deseja preencher a matriz manualmente (M) ou automaticamente (A)? ");
        char opcaoPreenchimento = scanner.next().toUpperCase().charAt(0);

        // Preenche a matriz
        System.out.println("\nPreenchendo a matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (opcaoPreenchimento == 'M') {
                    System.out.print("Digite o elemento matriz[" + i + "][" + j + "]: ");
                    matriz[i][j] = scanner.nextInt();
                } else { // Preenchimento automático (default)
                    matriz[i][j] = random.nextInt(101); // Gera números entre 0 e 100
                }
            }
        }

        // Exibe a matriz (opcional, mas bom para verificação)
        System.out.println("\nMatriz informada:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // Encontra o maior e o menor elemento
        int maior = matriz[0][0];
        int menor = matriz[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
            }
        }

        // Exibe os resultados
        System.out.println("\nMaior elemento da matriz: " + maior);
        System.out.println("Menor elemento da matriz: " + menor);

        scanner.close();
        System.out.println("--- Fim da Análise da Matriz ---");
    }
}
