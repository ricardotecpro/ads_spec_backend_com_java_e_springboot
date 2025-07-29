import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Sexo (M/F): ");
        char sexo = sc.next().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int cervejas = sc.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int refrigerantes = sc.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int espetinhos = sc.nextInt();

        ClienteDoBar cliente = new ClienteDoBar(sexo, cervejas, refrigerantes, espetinhos);
        System.out.println();
        cliente.gerarRelatorio();

        sc.close();
    }
}
