import java.util.Locale;
import java.util.Scanner;

public class    Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        double xA, xB, yA, yC, areaX, areaY;

        System.out.println("Digite a largura e altura do retângulo X:");
        xA = sc.nextDouble();
        xB = sc.nextDouble();

        System.out.println("Digite a largura e altura do retângulo Y:");
        yA = sc.nextDouble();
        yC = sc.nextDouble();

        areaX = xA * xB;
        areaY = yA * yC;

        System.out.printf("Área do retângulo X: %.2f%n", areaX);
        System.out.printf("Área do retângulo Y: %.2f%n", areaY);

        if (areaX > areaY) {
            System.out.println("O retângulo X tem a maior área.");
        } else if (areaY > areaX) {
            System.out.println("O retângulo Y tem a maior área.");
        } else {
            System.out.println("Ambos os retângulos têm áreas iguais.");
        }

        sc.close();
    }
}
