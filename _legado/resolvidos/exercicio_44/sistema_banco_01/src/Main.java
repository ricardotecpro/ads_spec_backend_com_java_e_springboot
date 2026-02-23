public class Main {
    public static void main(String[] args) {
        Setor financeiro = new Setor("001", "Financeiro", 2);

        Funcionario joao = new Funcionario("João", "123.456.789-00", 3);
        joao.contratar(financeiro);
        joao.promover(); // Deve ser promovido para GERENTE_CONTA

        Funcionario maria = new Funcionario("Maria", "987.654.321-00", 11);
        maria.contratar(financeiro);
        maria.promover(); // Deve ser promovida para GERENTE_AGENCIA

        Funcionario jose = new Funcionario("José", "111.222.333-44", 1);
        jose.contratar(financeiro); // Sem vaga (limite é 2)

        joao.demitir(); // Libera uma vaga

        jose.contratar(financeiro); // Agora consegue ser contratado
    }
}
