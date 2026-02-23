import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stream {

    public static void main(String[] args) {

        String filePath = "C:\\temp\\dino_actions_tactical_630k.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Processa a linha aqui
                System.out.println(line); // ou parse CSV, etc.
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
