import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criação das contas
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();

        // Criação dos clientes
        Cliente cliente1 = new Cliente(sc, conta1);
        Cliente cliente2 = new Cliente(sc, conta2);

        // Depositar valores nas contas
        conta1.depositar(300.0, cliente1, conta1.getNumero());
        conta2.depositar(90.0, cliente2, conta2.getNumero());

        // Realizar saques válidos
        conta1.sacar(45.0, cliente1, conta1.getNumero()); // OK
        conta2.sacar(30.0, cliente2, conta2.getNumero()); // OK

        // Saques inválidos
        conta1.sacar(22.0, cliente1, conta1.getNumero()); // não múltiplo de 15
        conta2.sacar(500.0, cliente2, conta2.getNumero()); // saldo insuficiente
        conta1.sacar(30.0, cliente2, conta1.getNumero()); // cliente errado

        // Mostrar extratos
        conta1.extrato(cliente1, conta1.getNumero()); // OK
        conta2.extrato(cliente2, conta2.getNumero()); // OK

        // Tentativa de extrato por cliente errado
        conta1.extrato(cliente2, conta1.getNumero()); // deve negar

        sc.close();
    }
}
