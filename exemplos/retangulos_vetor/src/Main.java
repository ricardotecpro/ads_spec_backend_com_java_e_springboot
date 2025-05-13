import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de retângulos: ");
        int n = sc.nextInt();

        Retangulo[] retangulos = new Retangulo[n];
        
        // Preenche o vetor de retângulos

        for (int i = 0; i < n; i++) {
            retangulos[i] = new Retangulo();
            System.out.printf("Retângulo %d - Base e Altura: ", i + 1);
            retangulos[i].a = sc.nextFloat();
            retangulos[i].b = sc.nextFloat();
        }

        int indiceMaior = 0;
        float maiorArea = retangulos[0].calcularArea();

        for (int i = 1; i < n; i++) {
            float areaAtual = retangulos[i].calcularArea();
            if (areaAtual > maiorArea) {
                maiorArea = areaAtual;
                indiceMaior = i;
            }
        }

        System.out.printf("Maior área é do Retângulo %d: %.2f%n", indiceMaior + 1, maiorArea);

        sc.close();
    }
}
