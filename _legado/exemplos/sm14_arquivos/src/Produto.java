public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibir() {
        System.out.printf("Produto: %s - R$ %.2f%n", nome, preco);
    }
}
