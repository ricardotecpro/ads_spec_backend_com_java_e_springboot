import java.util.Scanner;

class Fatorial {

    // Método recursivo para calcular o fatorial de um número
    // n! = n * (n-1)! para n > 0
    // 0! = 1
    public long calcularFatorial(int n) {
        // Caso base: fatorial de 0 é 1
        if (n == 0) {
            return 1;
        }
        // Caso base: números negativos não têm fatorial definido (pode-se lançar exceção)
        if (n < 0) {
            // Em uma aplicação real, seria melhor lançar uma exceção.
            // Ex: throw new IllegalArgumentException("Número não pode ser negativo para fatorial.");
            System.out.println("Erro: Fatorial não definido para números negativos.");
            return -1; // Indicador de erro, ou poderia ser Long.MIN_VALUE
        }
        // Passo recursivo
        return n * calcularFatorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fatorial calcFatorial = new Fatorial();

        System.out.println("--- Cálculo de Fatorial (Recursivo) ---");
        System.out.print("Digite um número inteiro não negativo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("Por favor, insira um número não negativo.");
        } else {
            long resultado = calcFatorial.calcularFatorial(numero);
            if (resultado != -1) { // Verifica se não houve erro (retorno -1 do método)
                System.out.println("O fatorial de " + numero + " (" + numero + "!) é: " + resultado);
            }
        }

        scanner.close();
        System.out.println("--- Fim do Cálculo ---");
    }
}
