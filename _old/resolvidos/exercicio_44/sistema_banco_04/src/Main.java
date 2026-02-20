import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instanciando 2 contas
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();

        // Instanciando 2 clientes, cada um com sua conta
        Cliente cliente1 = new Cliente(sc, conta1);
        Cliente cliente2 = new Cliente(sc, conta2);

        // Teste: depósito e saque
        conta1.depositar(150, cliente1);
        conta1.sacar(45, cliente1);
        conta2.depositar(90, cliente2);
        conta2.sacar(30, cliente2);

        System.out.printf("Saldo da conta %d (%s): R$%.2f\n",
                conta1.getNumero(), cliente1.getNome(), conta1.getSaldo());
        System.out.printf("Saldo da conta %d (%s): R$%.2f\n",
                conta2.getNumero(), cliente2.getNome(), conta2.getSaldo());

        sc.close();
    }
}
