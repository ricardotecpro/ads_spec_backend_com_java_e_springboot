public class Aluno {
    // Atributos (variáveis de instância)
    private String nome;
    private int idade;
    
    
    private int matricula;
    private double prova1;
    private double prova2;

    // Método para cadastrar os dados básicos
    public void cadastrarDados(String Nome, int Idade, int Matricula) {
        this.nome = Nome;
        this.idade = Idade;
        this.matricula = Matricula;
    }

    // Método para cadastrar as notas das provas
    public void setNotas(double notaProva1, double notaProva2){
        this.prova1 = notaProva1;
        this.prova2 = notaProva2;
    }

    // Método para calcular a média de notas
    public  double calcularMedia() {
        return (prova1 + prova2)/2;
    }

    // Método para exibir todas as informações
    public void exibirInformacoes() {
        System.out.println("=== DADOS DO ALUNO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Média de notas: " + calcularMedia());
    }
}