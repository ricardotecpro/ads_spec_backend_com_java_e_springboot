
package aplicacao;

import java.util.ArrayList;
import java.util.List;
import entidades.Conta;
import entidades.ContaEmpresa;
import entidades.ContaPoupanca;

public class Programa {
    public static void main(String[] args) {
        List<Conta> lista = new ArrayList<>();

        lista.add(new ContaPoupanca(1001, "Alex", 1000.0, 0.01));
        lista.add(new ContaEmpresa(1002, "Maria", 1000.0, 500.0));
        lista.add(new ContaPoupanca(1003, "Bob", 1000.0, 0.02));
        lista.add(new ContaEmpresa(1004, "Anna", 1000.0, 400.0));

        double soma = 0.0;
        for (Conta conta : lista) {
            soma += conta.getSaldo();
        }

        System.out.printf("Saldo total: R$ %.2f%n", soma);

        for (Conta conta : lista) {
            conta.sacar(100.0);
        }

        System.out.println("\nApós saque:");
        for (Conta conta : lista) {
            System.out.println(conta);
        }
    }
}
