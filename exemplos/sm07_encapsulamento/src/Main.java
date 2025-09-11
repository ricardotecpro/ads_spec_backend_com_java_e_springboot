import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContaBancaria conta;

        System.out.print("Informe o número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        System.out.print("Informe o nome do titular: ");
        String titular = sc.nextLine();

        System.out.print("Deseja fazer um depósito inicial? (s/n): ");
        char resposta = sc.next().charAt(0);

        if (resposta == 's' || resposta == 'S') {
            System.out.print("Informe o valor do depósito inicial: R$ ");
            double depositoInicial = sc.nextDouble();
            conta = new ContaBancaria(numero, titular, depositoInicial);
        } else {
            conta = new ContaBancaria(numero, titular);
        }

        System.out.println("\nDados da conta:");
        System.out.println(conta);

        System.out.print("\nInforme um valor para depósito: R$ ");
        double valorDeposito = sc.nextDouble();
        conta.depositar(valorDeposito);
        System.out.println("Dados atualizados da conta:");
        System.out.println(conta);

        System.out.print("\nInforme um valor para saque: R$ ");
        double valorSaque = sc.nextDouble();
        conta.sacar(valorSaque);
        System.out.println("Dados atualizados da conta:");
        System.out.println(conta);

        sc.close();
    }
}
