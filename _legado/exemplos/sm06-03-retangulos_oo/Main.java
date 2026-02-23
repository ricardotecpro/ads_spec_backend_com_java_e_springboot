import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        // criar dois objetos do tipo retangulo
        Retangulo x, y;
        
        // instanciar os objetos
        
        x = new Retangulo();
        y = new Retangulo();     
        

        // calcular a a area do primeiro retangulo

        System.out.println("Entre com a base e altura do primeiro retangulo: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        
        double areaX = x.a * x.b;

        // calcular a area do segundo retangulo

        System.out.println("Entre com a base e altura do segundo retangulo: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        
        double areaY = y.a * y.b;

        System.out.printf("Area do primeiro retangulo: %.4f%n", areaX);
        System.out.printf("Area do segundo retangulo: %.4f%n", areaY);

        //comparar as areas

        if (areaX > areaY) {
            System.out.println("O primeiro retangulo tem a maior area");
        } else if (areaX < areaY) {
            System.out.println("O segundo retangulo tem a maior area");
        } else {
            System.out.println("Os dois retangulos tem a mesma area");
        }

        sc.close();

    }
}
