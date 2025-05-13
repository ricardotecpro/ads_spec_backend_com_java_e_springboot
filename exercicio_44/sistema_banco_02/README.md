Claro! Vou simplificar o cenário para você. Aqui está uma versão mais direta e objetiva:

---

# 🧪 Cenário 1 – p.46

## 🔧 Objetivos:

1. Instanciar dois **setores** (Pessoa Física e Pessoa Jurídica).
2. Instanciar três **funcionários** e cadastrá-los conforme as vagas disponíveis nos setores.
3. Tentar **promover** os funcionários, mesmo que não cumpram todos os requisitos.

---

## 🚀 Etapas:

### 1️⃣ Instanciar Setores:

* **Pessoa Física** (máximo de 1 funcionário)
* **Pessoa Jurídica** (máximo de 2 funcionários)

### 2️⃣ Instanciar Funcionários:

* Crie **3 funcionários** e cadastre-os nos setores com vagas usando o método `temVaga()`.

### 3️⃣ Promoção:

* Tente **promover** todos os funcionários com o método `promover()`.
  (O funcionário pode ou não ser promovido, dependendo da experiência.)

---

## ✅ Requisitos do Código:

* Usar **vetores** para setores e funcionários.
* Verificar a disponibilidade de vagas com o método `temVaga()`.
* Usar o método `promover()` para tentar promover os funcionários.

---

Isso é o essencial! Se quiser, posso te ajudar com a implementação do código em Java. O que acha?

---

### 📦 Estrutura de Classes

* `Setor`
* `Funcionario`
* `Cargo` (enum para melhor controle dos cargos)

---

### ✅ Classe `Cargo.java` (enum)

```java
public enum Cargo {
    OPERADOR_CAIXA,
    GERENTE_CONTA,
    GERENTE_AGENCIA;
}
```

---

### ✅ Classe `Setor.java`

```java
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
```

---

### ✅ Classe `Funcionario.java`

```java
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
```

---

### ✅ Exemplo de Uso (`Main.java`)

```java
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
```

---

### 📌 Possíveis Extensões Futuras
