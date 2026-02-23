import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaBancaria conta;

    public Cliente(Scanner sc, ContaBancaria conta) {
        System.out.print("Digite o nome do cliente: ");
        this.nome = sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        this.cpf = sc.nextLine();
        this.conta = conta;
        conta.setTitular(this); // vincula a conta ao cliente
        System.out.println("Conta " + conta.getNumero() + " criada para " + nome + "\n");
    }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public ContaBancaria getConta() { return conta; }
}
