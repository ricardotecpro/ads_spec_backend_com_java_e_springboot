public class Main {
    public static void main(String[] args) {
        // Criando vetor de setores
        Setor[] setores = new Setor[2];
        setores[0] = new Setor("001", "Pessoa Física", 1);
        setores[1] = new Setor("002", "Pessoa Jurídica", 2);

        // Criando vetor de funcionários
        Funcionario[] funcionarios = new Funcionario[3];
        funcionarios[0] = new Funcionario("João", "123.456.789-00", 1);   // não pode ser promovido
        funcionarios[1] = new Funcionario("Maria", "987.654.321-00", 3);  // pode ser promovida a GERENTE_CONTA
        funcionarios[2] = new Funcionario("Carlos", "111.222.333-44", 11); // pode ser promovido a GERENTE_AGENCIA

        // Tentando alocar os funcionários nos setores com vagas
        for (Funcionario f : funcionarios) {
            boolean alocado = false;
            for (Setor s : setores) {
                if (s.temVaga()) {
                    f.contratar(s);
                    alocado = true;
                    break;
                }
            }
            if (!alocado) {
                System.out.println(f.getNome() + " não pôde ser contratado (sem vagas disponíveis).");
            }
        }

        System.out.println("\nTentando promover todos os funcionários:");
        for (Funcionario f : funcionarios) {
            f.promover();
        }
    }
}
