# Compilando e Executando Java com Vários Arquivos
# Este guia mostra como compilar e executar um projeto Java com vários arquivos usando o terminal.
# =============================


Para compilar um projeto Java com vários arquivos como `Main.java` e `Aluno.java` usando o terminal, siga estes passos:

### 🗂️ Suponha que sua estrutura de arquivos seja:

```
projeto/
├── Main.java
└── Aluno.java
```

### ✅ Passo a passo para compilar e executar:

1. **Abra o terminal e navegue até a pasta onde estão os arquivos:**
    

```bash
cd /caminho/para/seu/projeto
```

2. **Compile os dois arquivos com `javac`:**
    

```bash
javac Main.java Aluno.java
```

> Isso vai gerar os arquivos `Main.class` e `Aluno.class` no mesmo diretório.

3. **Execute a aplicação com `java` (sem a extensão `.class`):**
    

```bash
java Main
```

> Isso assume que o método `main` está dentro da classe `Main`.

---
