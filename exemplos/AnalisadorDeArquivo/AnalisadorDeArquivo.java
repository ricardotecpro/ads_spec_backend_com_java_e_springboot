import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AnalisadorDeArquivo {
    public void analisar(String caminhoDoArquivo) {
        int totalLinhas = 0;
        int totalPalavras = 0;
        int totalCaracteres = 0;

        try {
            File arquivo = new File(caminhoDoArquivo);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                totalLinhas++;
                totalPalavras += linha.split("\\s+").length;
                totalCaracteres += linha.length();
            }

            scanner.close();

            System.out.println("Total de linhas: " + totalLinhas);
            System.out.println("Total de palavras: " + totalPalavras);
            System.out.println("Total de caracteres: " + totalCaracteres);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AnalisadorDeArquivo analisador = new AnalisadorDeArquivo();
        analisador.analisar("entrada.txt");
    }
}
