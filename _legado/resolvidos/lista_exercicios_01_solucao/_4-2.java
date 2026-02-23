import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Classe Contato
class Contato {
    private String nome;
    private String telefone;
    private String email;

    // Construtor
    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    // Setters (opcionais)
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
    }
}

// Classe principal para gerenciar a agenda
class AgendaContatos {
    private List<Contato> listaContatos;
    private Scanner scanner;
    private static final int MAX_CONTATOS = 10; // Limite de contatos

    public AgendaContatos() {
        this.listaContatos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Agenda de Contatos (Limite: " + MAX_CONTATOS + ") ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Todos os Contatos");
            System.out.println("3. Procurar Contato (por nome)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        adicionarContato();
                        break;
                    case 2:
                        listarTodosContatos();
                        break;
                    case 3:
                        procurarContato();
                        break;
                    case 4:
                        System.out.println("Saindo da agenda...");
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

    private void adicionarContato() {
        System.out.println("\n--- Adicionar Novo Contato ---");
        if (listaContatos.size() >= MAX_CONTATOS) {
            System.out.println("Erro: Limite de " + MAX_CONTATOS + " contatos atingido. Não é possível adicionar mais.");
            return;
        }

        System.out.print("Nome do contato: ");
        String nome = scanner.nextLine();

        // Verificar se o contato já existe (opcional, mas bom para evitar duplicados exatos)
        for (Contato c : listaContatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aviso: Já existe um contato com este nome. Deseja continuar? (S/N)");
                String confirm = scanner.nextLine();
                if (!confirm.equalsIgnoreCase("S")) {
                    return;
                }
                // Se continuar, pode haver nomes duplicados, o que é permitido aqui.
            }
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contato novoContato = new Contato(nome, telefone, email);
        listaContatos.add(novoContato);
        System.out.println("Contato '" + nome + "' adicionado com sucesso!");
    }

    private void listarTodosContatos() {
        System.out.println("\n--- Lista de Todos os Contatos ---");
        if (listaContatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado na agenda.");
            return;
        }
        for (int i = 0; i < listaContatos.size(); i++) {
            System.out.println((i + 1) + ". " + listaContatos.get(i).toString());
        }
    }

    private void procurarContato() {
        System.out.println("\n--- Procurar Contato por Nome ---");
        if (listaContatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado para procurar.");
            return;
        }
        System.out.print("Digite o nome do contato a ser procurado: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrado = false;
        for (Contato c : listaContatos) {
            if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Contato encontrado:");
                System.out.println(c.toString());
                encontrado = true;
                // Se quiser parar após o primeiro encontrado, adicione 'break;'
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum contato encontrado com o nome '" + nomeBusca + "'.");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();
        agenda.exibirMenu();
    }
}
