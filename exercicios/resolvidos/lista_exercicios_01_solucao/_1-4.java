import java.util.Scanner;

// Classe principal para interação com o usuário
class PrincipalConversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorTemperatura conversor = new ConversorTemperatura();
        int escolha;
        double temperatura;

        System.out.println("--- Conversor de Temperaturas ---");
        System.out.println("Escolha a direção da conversão:");
        System.out.println("1. Celsius para Fahrenheit");
        System.out.println("2. Fahrenheit para Celsius");
        System.out.print("Opção: ");
        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Digite a temperatura em Celsius (°C): ");
                temperatura = scanner.nextDouble();
                double fahrenheit = conversor.celsiusParaFahrenheit(temperatura);
                System.out.printf("%.2f°C equivale a %.2f°F%n", temperatura, fahrenheit);
                break;
            case 2:
                System.out.print("Digite a temperatura em Fahrenheit (°F): ");
                temperatura = scanner.nextDouble();
                double celsius = conversor.fahrenheitParaCelsius(temperatura);
                System.out.printf("%.2f°F equivale a %.2f°C%n", temperatura, celsius);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
        System.out.println("--- Fim do Conversor ---");
    }
}

// Classe com os métodos de conversão
class ConversorTemperatura {

    // Converte Celsius para Fahrenheit
    // Fórmula: F = (C * 9/5) + 32
    public double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Converte Fahrenheit para Celsius
    // Fórmula: C = (F - 32) * 5/9
    public double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}
