public class Calculadora {

    // Método para multiplicar dois números
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Método para somar dois números
    public int somar(int a, int b) {
        return a + b;
    }
    public int subtrair(int a, int b){
        return  a - b;
    }
    
    public int dividir (int a, int b) { return a / b; }

    // Método principal - ponto de entrada do programa
    public static void main(String[] args) {
        // Cria uma instância da classe Calculadora
        Calculadora calc = new Calculadora();

        // Usa os métodos de cálculo
        int resultadoMultiplicacao = calc.multiplicar(5, 3);
        int resultadoSoma = calc.somar(5, 3);
        int resultadoSubtrair = calc.subtrair(5, 3);
        int resultadoDiv = calc.dividir(5, 3);
        
        // Exibe os resultados
        System.out.println("Resultado da multiplicação: " + resultadoMultiplicacao);
        System.out.println("Resultado da soma: " + resultadoSoma);
        System.out.println("Resultado da subtração: " + resultadoSubtrair);
        System.out.println("Resulatado da divisão: " + resultadoDiv);
    }
}
