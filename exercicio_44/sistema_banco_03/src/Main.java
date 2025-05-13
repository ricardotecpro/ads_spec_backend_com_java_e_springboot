public class Main {
    public static void main(String[] args) {
        // Criando cliente e conta
        Cliente cliente1 = new Cliente("Lucas", "999.888.777-66");
        ContaBancaria conta1 = new ContaBancaria(cliente1);

        // Cliente certo faz depósito
        conta1.depositar(150.0, cliente1);

        // Cliente errado tenta sacar
        Cliente invasor = new Cliente("Invasor", "000.000.000-00");
        conta1.sacar(45.0, invasor); // Deve negar

        // Cliente certo tenta sacar valor inválido
        conta1.sacar(40.0, cliente1); // Não múltiplo de 15

        // Cliente certo faz saque válido
        conta1.sacar(45.0, cliente1); // OK

        // Verificar saldo final
        System.out.println("Saldo final: R$" + conta1.getSaldo());
    }
}
