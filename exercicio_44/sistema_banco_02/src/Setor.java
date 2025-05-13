public class Setor {
    private String codigo;
    private String nome;
    private int qtdMaxFunc;
    private int qtdFunc;

    public Setor(String codigo, String nome, int qtdMaxFunc) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdMaxFunc = qtdMaxFunc;
        this.qtdFunc = 0;
    }

    public boolean temVaga() {
        return qtdFunc < qtdMaxFunc;
    }

    public void incrementaFunc() {
        if (temVaga()) {
            qtdFunc++;
        } else {
            System.out.println("Setor cheio. Não é possível adicionar mais funcionários.");
        }
    }

    public void decrementaFunc() {
        if (qtdFunc > 0) {
            qtdFunc--;
        }
    }

    // Getters e Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getQtdMaxFunc() { return qtdMaxFunc; }
    public void setQtdMaxFunc(int qtdMaxFunc) { this.qtdMaxFunc = qtdMaxFunc; }

    public int getQtdFunc() { return qtdFunc; }
}
