import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Paralelepipedo p = new Paralelepipedo();

        System.out.println("Digite a altura, a largura e o comprimento do paralelepípedo:");
        p.altura = sc.nextFloat();
        p.largura = sc.nextFloat();
        p.comprimento = sc.nextFloat();

        float volume = p.calcularVolume();
        System.out.printf("Volume do paralelepípedo: %.2f%n", volume);

        sc.close();
    }
}
