import java.util.Scanner;

class VerificadorPalindromos {

    // Método para verificar se uma string é um palíndromo
    // Desconsidera espaços e diferenças entre maiúsculas/minúsculas
    public boolean ehPalindromo(String texto) {
        // 1. Remover espaços e converter para minúsculas para uma comparação case-insensitive
        String textoTratado = texto.replaceAll("\\s+", "").toLowerCase();

        // 2. Comparar a string original tratada com sua versão invertida
        String textoInvertido = new StringBuilder(textoTratado).reverse().toString();

        return textoTratado.equals(textoInvertido);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VerificadorPalindromos verificador = new VerificadorPalindromos();

        System.out.println("--- Verificador de Palíndromos ---");
        System.out.print("Digite uma palavra ou frase para verificar: ");
        String entrada = scanner.nextLine();

        if (verificador.ehPalindromo(entrada)) {
            System.out.println("'" + entrada + "' É um palíndromo.");
        } else {
            System.out.println("'" + entrada + "' NÃO é um palíndromo.");
        }

        scanner.close();
        System.out.println("--- Fim da Verificação ---");
    }
}
