# Compilador Java com Estrutura de Pacotes
# =============================
# Este guia mostra como compilar e executar um projeto Java com uma estrutura de pacotes específica, utilizando o comando `javac` e o terminal.

### 🗂️ Estrutura com `fema.edu`:

```
meuprojeto/
└── src/
    └── fema/
        └── edu/
            ├── Main.java
            └── Aluno.java
```

---

### 📄 `Main.java` atualizado:

```java
package fema.edu;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("João", 21);
        aluno.exibir();
    }
}
```

---

### 📄 `Aluno.java` atualizado:

```java
package fema.edu;

public class Aluno {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibir() {
        System.out.println("Aluno: " + nome + ", Idade: " + idade);
    }
}
```

---

### ✅ Compilação via terminal:

```bash
javac -d out src/fema/edu/*.java
```

### ▶️ Execução via terminal:

```bash
java -cp out fema.edu.Main
```

---

 script `.sh` (Linux/macOS) 
 
 
 
 **script `.sh` para Linux/macOS** que compila e executa o projeto com a estrutura `fema.edu`:

---

### 📝 `run.sh`

```bash
#!/bin/bash

# Compila os arquivos Java
echo "Compilando os arquivos..."
javac -d out src/fema/edu/*.java

# Verifica se a compilação foi bem-sucedida
if [ $? -eq 0 ]; then
    echo "Compilação bem-sucedida. Executando programa..."
    java -cp out fema.edu.Main
else
    echo "Erro na compilação."
fi
```

---

### ✅ Como usar:

1. Salve o script como `run.sh` na raiz do projeto.
    
2. Dê permissão de execução:
    
    ```bash
    chmod +x run.sh
    ```
    
3. Execute:
    
    ```bash
    ./run.sh
    ```
    

versão `.bat` também pro Windows?
 
 
script para **Windows** em formato `.bat`:

---

### 📝 `run.bat`

```bat
@echo off
echo Compilando os arquivos Java...
javac -d out src\fema\edu\*.java

IF %ERRORLEVEL% EQU 0 (
    echo Compilação bem-sucedida. Executando programa...
    java -cp out fema.edu.Main
) ELSE (
    echo Erro na compilação.
)
pause
```

---

### ✅ Como usar:

1. Salve esse conteúdo como `run.bat` na raiz do projeto.
    
2. Clique duas vezes no arquivo para rodar, ou execute no terminal (`cmd`).
    

