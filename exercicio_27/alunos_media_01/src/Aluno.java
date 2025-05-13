public class Aluno {
    // Atributos (variáveis de instância)
    public String nome;
    public int idade;
    public int matricula;
    public float media;

    // Método para cadastrar os dados básicos
    public void cadastrarDados(String nome, int idade, int matricula, float media) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.media = media;
    }

    // Método para cadastrar a média de notas
    public void cadastrarMediaNotas(float media) {
        this.media = media;
    }

    // Método para exibir todas as informações
    public void exibirInformacoes() {
        System.out.println("=== DADOS DO ALUNO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Média de notas: " + media);
    }
}