import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);
        // Adicionar Print
        System.out.print(" Digite o numero de pessoas: ");
        int n = leitor.nextInt();
        double[] vect = new double[n];

        for (int i = 0; i < n; i++) {
            // Adicionar Print
            System.out.print(" Digite as Alturas: ");
            vect[i] = leitor.nextDouble();
        }

        double SomaAlturas = 0.0;
        for (int i = 0; i < n; i++) {
            SomaAlturas += vect[i];
        }
        double mediaAlturas = SomaAlturas / n;

        System.out.printf("Altura Média: %.2f%n", mediaAlturas);

        leitor.close();
    }
}
