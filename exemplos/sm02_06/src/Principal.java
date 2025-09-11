public class FormulaBhaskara {

    public static void main(String[] args) {

        // Coeficientes da equação: ax² + bx + c = 0
        double a = 1.0;
        double b = -5.0;
        double c = 6.0;

        // Variáveis para armazenar o resultado
        double delta, x1, x2;



        // 1. Calcula o valor de delta: Δ = b² - 4ac
        // Math.pow(b, 2.0) eleva a variável 'b' ao quadrado.
        delta = Math.pow(b, 2.0) - 4 * a * c;

        // 2. Calcula as raízes x1 e x2
        // Math.sqrt(delta) calcula a raiz quadrada de delta.
        x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
        x2 = (-b - Math.sqrt(delta)) / (2.0 * a);



        // Imprime os resultados na tela
        System.out.println("O valor de delta é: " + delta);
        System.out.println("O valor de x1 é: " + x1);
        System.out.println("O valor de x2 é: " + x2);
    }
}