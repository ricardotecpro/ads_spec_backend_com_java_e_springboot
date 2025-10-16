public class Funcionario {
    private String nome;
    private String cpf;
    private Cargo cargo;
    private Setor setor;
    private int experiencia; // em anos

    public Funcionario(String nome, String cpf, int experiencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.experiencia = experiencia;
        this.cargo = Cargo.OPERADOR_CAIXA;
    }

    public void contratar(Setor setor) {
        if (setor.temVaga()) {
            this.setor = setor;
            setor.incrementaFunc();
            System.out.println(nome + " contratado(a) como " + cargo + " no setor " + setor.getNome());
        } else {
            System.out.println("Setor sem vagas para contratação.");
        }
    }

    public void promover() {
        switch (cargo) {
            case OPERADOR_CAIXA:
                if (experiencia >= 10) {
                    cargo = Cargo.GERENTE_AGENCIA;
                    System.out.println(nome + " promovido(a) a GERENTE_AGENCIA");
                } else if (experiencia >= 2) {
                    cargo = Cargo.GERENTE_CONTA;
                    System.out.println(nome + " promovido(a) a GERENTE_CONTA");
                } else {
                    System.out.println("Experiência insuficiente para promoção.");
                }
                break;
            case GERENTE_CONTA:
                if (experiencia >= 10) {
                    cargo = Cargo.GERENTE_AGENCIA;
                    System.out.println(nome + " promovido(a) a GERENTE_AGENCIA");
                } else {
                    System.out.println("Experiência insuficiente para promoção.");
                }
                break;
            case GERENTE_AGENCIA:
                System.out.println("Cargo mais alto já atingido.");
                break;
        }
    }

    public void demitir() {
        if (this.setor != null) {
            setor.decrementaFunc();
            this.setor = null;
            System.out.println(nome + " foi demitido(a).");
        } else {
            System.out.println("Funcionário não está alocado a nenhum setor.");
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public Cargo getCargo() { return cargo; }
    public Setor getSetor() { return setor; }
    public int getExperiencia() { return experiencia; }

    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }
}
