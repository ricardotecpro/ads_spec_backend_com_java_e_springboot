// O nome da classe deve ser o mesmo do arquivo (Exemplo4.java)
public class Exemplo4 {

    // Método 'main', onde o programa começa
    public static void main(String[] args) {



        // 1. Declaração das variáveis
        int a, b;
        double resultado;

        // 2. Atribuição de valores inteiros
        a = 5;
        b = 2;

        // 3. Cálculo com Casting
        // (double) a -> Converte temporariamente 'a' para double (de 5 para 5.0)
        // A conta se torna 5.0 / 2, resultando em 2.5
        resultado = (double) a / b;

        // 4. Impressão do resultado
        System.out.println(resultado);


    }
}