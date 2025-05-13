import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Retangulo x, y;
        x = new Retangulo();
        y = new Retangulo();

        System.out.println("Entre com as medidas do retângulo X:");
        x.a = sc.nextFloat();
        x.b = sc.nextFloat();

        System.out.println("Entre com as medidas do retângulo Y:");
        y.a = sc.nextFloat();
        y.b= sc.nextFloat();
        
        float areaX = x.a * x.b;
        float areaY = y.a * y.b;
        
        // calculo da area
        
        areaX  = x.a * x.b;
        areaY  = y.a * y.b;

        System.out.println("Area X: " + areaX);
        
        System.out.println("Area Y: " + areaY);
        

        


        sc.close();
    }
}
