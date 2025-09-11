import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // Variáveis com nomes e valores em português
        String produto1 = "Computador";
        String produto2 = "Mesa de escritório";

        int idade = 30;
        int codigo = 5290;
        char genero = 'F';

        double preco1 = 2100.0;
        double preco2 = 650.50;
        double medida = 53.234567;

        // Locale para formatação brasileira (com vírgula decimal)
        Locale localBrasil = new Locale("pt", "BR");

        // Saída no console com as mensagens traduzidas
        System.out.println("Produtos:");
        // A formatação %.2f continua a mesma, mudando apenas o texto
        System.out.printf(localBrasil, "%s, cujo preço é R$ %.2f%n", produto1, preco1);
        System.out.printf(localBrasil, "%s, cujo preço é R$ %.2f%n", produto2, preco2);
        System.out.println(); // Linha em branco

        System.out.printf("Registro: %d anos de idade, código %d e gênero: %c%n", idade, codigo, genero);
        System.out.println(); // Linha em branco

        System.out.printf(localBrasil, "Medida com oito casas decimais: %.8f%n", medida);
        System.out.printf(localBrasil, "Arredondado (três casas decimais): %.3f%n", medida);

        // Altera o Locale para o padrão americano para mostrar o ponto decimal
        Locale.setDefault(Locale.US);
        System.out.printf("Ponto decimal americano: %.3f%n", medida);
    }
}