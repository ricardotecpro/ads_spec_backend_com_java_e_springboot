public class ExemploTernario {
    public static void main(String[] args) {

        double preco = 150.0;
        double desconto;

        // --- 1. Usando a forma tradicional if-else ---
        if (preco > 100.0) {
            desconto = preco * 0.10;
        } else {
            desconto = 0;
        }
        System.out.println("Desconto (com if-else): " + desconto);


        // --- 2. Usando a expressão ternária (mais compacto) ---
  //      Saída de ambos:

//Desconto (com if-else): 15.0
//Desconto (com ternário): 15.0
        //              (condição)       ? valor_se_verdadeiro : valor_se_falso
        double descontoTernario = (preco > 100.0) ? (preco * 0.10)    :       0;
        System.out.println("Desconto (com ternário): " + descontoTernario);
    }
}