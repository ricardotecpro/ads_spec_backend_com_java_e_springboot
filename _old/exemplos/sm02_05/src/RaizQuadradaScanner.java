import java.util.Locale;
import java.util.Scanner;

public class RaizQuadradaScanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Locale.setDefault(Locale.US);

        // print
        System.out.println("### Cálculo da Raiz Quadrada ###");

        Double x, A;

        System.out.println("Digite um valor: ");
        x = sc.nextDouble();
        A = Math.sqrt(x);

        // printF
        System.out.printf("Valor de entrada =  %.2f%n", x);

        // print F
        System.out.printf(" A Raiz Quadrada é  =  %.4f%n", A);

        sc.close();

    }

}
