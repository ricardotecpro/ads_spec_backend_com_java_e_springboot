import java.util.Scanner;

// Classe principal para executar a calculadora
class PrincipalCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        double num1, num2;
        int escolhaOperacao;

        System.out.println("--- Calculadora Simples ---");

        // Solicita os números ao usuário
        System.out.print("Digite o primeiro número: ");
        num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        num2 = scanner.nextDouble();

        // Menu de operações
        System.out.println("\nEscolha a operação:");
        System.out.println("1. Soma (+)");
        System.out.println("2. Subtração (-)");
        System.out.println("3. Multiplicação (*)");
        System.out.println("4. Divisão (/)");
        System.out.print("Opção: ");
        escolhaOperacao = scanner.nextInt();

        double resultado = 0;
        boolean operacaoValida = true;

        // Realiza a operação escolhida
        switch (escolhaOperacao) {
            case 1:
                resultado = calc.somar(num1, num2);
                System.out.println("Resultado da Soma: " + num1 + " + " + num2 + " = " + resultado);
                break;
            case 2:
                resultado = calc.subtrair(num1, num2);
                System.out.println("Resultado da Subtração: " + num1 + " - " + num2 + " = " + resultado);
                break;
            case 3:
                resultado = calc.multiplicar(num1, num2);
                System.out.println("Resultado da Multiplicação: " + num1 + " * " + num2 + " = " + resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = calc.dividir(num1, num2);
                    System.out.println("Resultado da Divisão: " + num1 + " / " + num2 + " = " + resultado);
                } else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                    operacaoValida = false;
                }
                break;
            default:
                System.out.println("Opção inválida!");
                operacaoValida = false;
                break;
        }

        scanner.close();
        System.out.println("--- Fim da Calculadora ---");
    }
}

// Classe com os métodos de cálculo
class Calculadora {

    // Método para somar dois números
    public double somar(double a, double b) {
        return a + b;
    }

    // Método para subtrair dois números
    public double subtrair(double a, double b) {
        return a - b;
    }

    // Método para multiplicar dois números
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para dividir dois números
    // Retorna Double.NaN (Not a Number) se o divisor for zero para tratamento no chamador,
    // ou poderia lançar uma exceção (IllegalArgumentException).
    public double dividir(double a, double b) {
        if (b == 0) {
            // Em uma aplicação real, seria melhor lançar uma exceção.
            // Ex: throw new IllegalArgumentException("Divisor não pode ser zero.");
            System.out.println("Erro: Tentativa de divisão por zero.");
            return Double.NaN; // Not a Number
        }
        return a / b;
    }
}
