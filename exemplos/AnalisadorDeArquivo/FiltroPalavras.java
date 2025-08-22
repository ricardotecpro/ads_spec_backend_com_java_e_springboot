import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FiltroPalavras {

    public List<String> filtrarPalavras(String caminhoEntrada) {
        List<String> resultado = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(caminhoEntrada))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] palavras = linha.split("\\s+");

                for (String palavra : palavras) {
                    if (palavra.toLowerCase().startsWith("a")) {
                        resultado.add(palavra);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return resultado;
    }

    public void salvarPalavras(List<String> palavras, String caminhoSaida) {
        try (PrintWriter writer = new PrintWriter(caminhoSaida)) {
            for (String palavra : palavras) {
                writer.println(palavra);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FiltroPalavras filtro = new FiltroPalavras();
        List<String> palavrasFiltradas = filtro.filtrarPalavras("entrada.txt");
        filtro.salvarPalavras(palavrasFiltradas, "saida.txt");
    }
}
