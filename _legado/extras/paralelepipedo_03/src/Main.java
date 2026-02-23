import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Criação dos três paralelepípedos
        Paralelepipedo p1 = new Paralelepipedo();
        Paralelepipedo p2 = new Paralelepipedo();
        Paralelepipedo p3 = new Paralelepipedo();

        // Entrada de dados para o primeiro paralelepípedo
        System.out.println("Digite a altura, a largura e o comprimento do primeiro paralelepípedo:");
        p1.altura = sc.nextFloat();
        p1.largura = sc.nextFloat();
        p1.comprimento = sc.nextFloat();

        // Entrada de dados para o segundo paralelepípedo
        System.out.println("Digite a altura, a largura e o comprimento do segundo paralelepípedo:");
        p2.altura = sc.nextFloat();
        p2.largura = sc.nextFloat();
        p2.comprimento = sc.nextFloat();

        // Entrada de dados para o segundo paralelepípedo
        System.out.println("Digite a altura, a largura e o comprimento do segundo paralelepípedo:");
        p3.altura = sc.nextFloat();
        p3.largura = sc.nextFloat();
        p3.comprimento = sc.nextFloat();

        // Calcular o volume dos tres  paralelepípedos
        float volumeP1 = p1.calcularVolume();
        float volumeP2 = p2.calcularVolume();
        float volumeP3 = p3.calcularVolume();

        System.out.printf("Volume do primeiro paralelepípedo: %.2f%n", volumeP1);
        System.out.printf("Volume do segundo paralelepípedo: %.2f%n", volumeP2);
        System.out.printf("Volume do terceiro paralelepído %.4f%n", volumeP3);

        // Comparar os volumes
        Paralelepipedo.compararVolumes(p1, p2, p3);

        sc.close();
    }
}
