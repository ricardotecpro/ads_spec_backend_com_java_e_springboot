import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Classe Funcionario
class Funcionario {
    private String nome;
    private int id;
    private double salario;
    private String departamento;

    // Construtor
    public Funcionario(String nome, int id, double salario, String departamento) {
        this.nome = nome;
        this.id = id;
        this.salario = salario;
        this.departamento = departamento;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    // Setters (opcional, mas bom para futuras modificações)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Método para exibir informações do funcionário
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Salário: R$" + String.format("%.2f", salario) + ", Departamento: " + departamento;
    }
}

// Classe principal para gerenciar os funcionários
class GerenciadorFuncionarios {
    private List<Funcionario> listaFuncionarios;
    private Scanner scanner;

    public GerenciadorFuncionarios() {
        this.listaFuncionarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Sistema de Gerenciamento de Funcionários ---");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Todos os Funcionários");
            System.out.println("3. Calcular Total de Salários por Departamento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        cadastrarFuncionario();
                        break;
                    case 2:
                        listarTodosFuncionarios();
                        break;
                    case 3:
                        calcularTotalSalariosDepartamento();
                        break;
                    case 4:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
                opcao = 0; // Resetar opção para continuar no loop
            }
        } while (opcao != 4);
        scanner.close();
    }

    private void cadastrarFuncionario() {
        System.out.println("\n--- Cadastro de Funcionário ---");
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("ID (número): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Verificar se ID já existe
            for (Funcionario f : listaFuncionarios) {
                if (f.getId() == id) {
                    System.out.println("Erro: ID já cadastrado. Tente novamente com um ID diferente.");
                    return;
                }
            }

            System.out.print("Salário (ex: 2500.75): ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha

            System.out.print("Departamento: ");
            String departamento = scanner.nextLine();

            Funcionario novoFuncionario = new Funcionario(nome, id, salario, departamento);
            listaFuncionarios.add(novoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida para ID ou Salário. Tente novamente.");
            scanner.nextLine(); // Limpar o buffer
        }
    }

    private void listarTodosFuncionarios() {
        System.out.println("\n--- Lista de Todos os Funcionários ---");
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : listaFuncionarios) {
            System.out.println(f.toString());
        }
    }

    private void calcularTotalSalariosDepartamento() {
        System.out.println("\n--- Total de Salários por Departamento ---");
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado para calcular salários.");
            return;
        }
        System.out.print("Digite o nome do departamento para calcular o total de salários: ");
        String deptoBusca = scanner.nextLine();

        double totalSalarios = 0;
        int funcionariosNoDepto = 0;
        for (Funcionario f : listaFuncionarios) {
            if (f.getDepartamento().equalsIgnoreCase(deptoBusca)) {
                totalSalarios += f.getSalario();
                funcionariosNoDepto++;
            }
        }

        if (funcionariosNoDepto > 0) {
            System.out.println("Total de salários para o departamento '" + deptoBusca + "': R$" + String.format("%.2f", totalSalarios));
        } else {
            System.out.println("Nenhum funcionário encontrado no departamento '" + deptoBusca + "' ou o departamento não existe.");
        }
    }

    public static void main(String[] args) {
        GerenciadorFuncionarios sistema = new GerenciadorFuncionarios();
        sistema.exibirMenu();
    }
}
