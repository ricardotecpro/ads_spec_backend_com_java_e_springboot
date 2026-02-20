// No arquivo Produto.java
package entidades;

public class Produto {
    public String nome;
    public double preco;
    public int quantidade;

    public double valorTotalEmEstoque() {
        return preco * quantidade;
    }

    public void adicionarProdutos(int quantidadeParaAdicionar) {
        // 'this.quantidade' se refere ao atributo da classe
        // 'quantidadeParaAdicionar' se refere ao parâmetro do método
        this.quantidade += quantidadeParaAdicionar;
    }

    public void removerProdutos(int quantidadeParaRemover) {
        this.quantidade -= quantidadeParaRemover;
    }

    // Sobrescrevendo o método toString()
    @Override // Anotação opcional, mas recomendada, para indicar sobrescrita
    public String toString() {
        return nome
            + ", $ "
            + String.format("%.2f", preco) // Formata o preço com 2 casas decimais
            + ", "
            + quantidade
            + " unidades, Total: $ "
            + String.format("%.2f", valorTotalEmEstoque());
    }
}