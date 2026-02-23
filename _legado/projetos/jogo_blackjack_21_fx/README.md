# Jogo **Blackjack (21)**

Vamos construir um **Blackjack (21)** profissional, com arquitetura MVC (Model-View-Controller).

---

### 🏗️ 1. Preparação do Ambiente e Estrutura

Você precisará do **JDK 21** instalado e de uma IDE (IntelliJ IDEA ou Eclipse). Vamos usar o **Maven** para gerenciar as dependências.

**Estrutura de Pastas Recomendada:**

```text
blackjack21/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── blackjack/
│   │   │           ├── Main.java          (Entrada)
│   │   │           ├── model/             (Lógica: Carta, Baralho, Mão)
│   │   │           └── controller/        (Interface e Regras de Jogo)
│   │   └── resources/
│   │       └── styles.css                 (Estilo Moderno)
└── pom.xml
```

**Dependências no `pom.xml`:**
Precisamos das bibliotecas do JavaFX.

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>21</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>21</version>
    </dependency>
</dependencies>
```

---

### 🚀 2. Configuração e Execução no Windows

#### Pré-requisitos

- **JDK 21** instalado
- **Maven** instalado globalmente (ou use o Maven Wrapper incluído)

#### Problema Comum: Maven Wrapper

Se você encontrar o erro:

```
Get-Content : Cannot find path '.mvn\wrapper\maven-wrapper.properties' because it does not exist.
```

**Solução:**

1. Abra o PowerShell no diretório do projeto
2. Execute o comando para regenerar o Maven Wrapper:
   ```powershell
   mvn -N wrapper:wrapper
   ```

#### Como Executar o Projeto

```powershell
# Navegar para o diretório do projeto
cd "caminho\para\jogo_blackjack_21_fx"

# Executar a aplicação JavaFX
.\mvnw javafx:run

# Ou limpar e executar
.\mvnw clean javafx:run
```

#### Outros Comandos Úteis

```powershell
# Apenas compilar
.\mvnw compile

# Limpar arquivos compilados
.\mvnw clean

# Executar testes (se houver)
.\mvnw test
```

---

### 🃏 4. O Modelo (Model)

Aqui ficam as regras de negócio, independentes da interface visual.

**Classe `Carta.java` e Enums:**

```java
package com.blackjack.model;

public record Carta(Nipe nipe, Rank rank) {
    public enum Nipe { COPAS, OUROS, PAUS, ESPADAS }
    public enum Rank {
        DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10),
        VALETE(10), DAMA(10), REI(10), AS(11);

        final int valor;
        Rank(int valor) { this.valor = valor; }
    }

    @Override
    public String toString() {
        return rank + " de " + nipe;
    }
}
```

**Classe `Baralho.java`:**

```java
package com.blackjack.model;

import java.util.*;

public class Baralho {
    private final Stack<Carta> cartas = new Stack<>();

    public Baralho() {
        reiniciar();
    }

    public void reiniciar() {
        cartas.clear();
        for (Carta.Nipe nipe : Carta.Nipe.values()) {
            for (Carta.Rank rank : Carta.Rank.values()) {
                cartas.push(new Carta(nipe, rank));
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta comprar() {
        return cartas.isEmpty() ? null : cartas.pop();
    }
}
```

---

### 🧠 5. Lógica de Pontuação (Regra do Ás)

O Ás é "tricky". Ele vale 11, a menos que estoure 21, aí passa a valer 1.

**Classe `Mao.java`:**

```java
package com.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Mao {
    private final List<Carta> cartas = new ArrayList<>();

    public void adicionarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void limpar() {
        cartas.clear();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int calcularPontuacao() {
        int pontos = 0;
        int ases = 0;

        for (Carta c : cartas) {
            pontos += c.rank().valor;
            if (c.rank() == Carta.Rank.AS) ases++;
        }

        while (pontos > 21 && ases > 0) {
            pontos -= 10; // Transforma Ás de 11 para 1
            ases--;
        }
        return pontos;
    }
}
```

---

### 🎨 6. Interface Moderna e Controle (View & Controller)

Em vez de usar HTML/DOM (que é Web), usaremos o **Scenegraph** do JavaFX. Para ser didático, farei a interface via código para você ver a estrutura, mas em projetos grandes usamos arquivos FXML.

**Classe `BlackjackGame.java` (O Coração da UI):**

```java
package com.blackjack.controller;

import com.blackjack.model.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BlackjackGame extends Application {

    private Baralho baralho;
    private Mao maoJogador;
    private Mao maoDealer;

    private HBox mesaDealer;
    private HBox mesaJogador;
    private Label lblStatus;
    private Label lblPontosJogador;

    private Button btnPedir;
    private Button btnParar;
    private Button btnReiniciar;

    @Override
    public void start(Stage stage) {
        baralho = new Baralho();
        maoJogador = new Mao();
        maoDealer = new Mao();

        // --- Layout da Interface (Responsiva) ---
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2E8B57; -fx-padding: 30;"); // Verde Mesa de Jogo

        // Área do Dealer
        Label lblDealer = new Label("Dealer");
        lblDealer.getStyleClass().add("titulo");
        mesaDealer = new HBox(10);
        mesaDealer.setAlignment(Pos.CENTER);

        // Área do Jogador
        Label lblJogador = new Label("Você");
        lblJogador.getStyleClass().add("titulo");
        mesaJogador = new HBox(10);
        mesaJogador.setAlignment(Pos.CENTER);
        lblPontosJogador = new Label("Pontos: 0");
        lblPontosJogador.getStyleClass().add("texto-branco");

        // Botões
        HBox painelBotoes = new HBox(15);
        painelBotoes.setAlignment(Pos.CENTER);
        btnPedir = criarBotao("Pedir Carta", "#3498db");
        btnParar = criarBotao("Parar", "#e74c3c");
        btnReiniciar = criarBotao("Novo Jogo", "#f1c40f");
        btnReiniciar.setVisible(false); // Só aparece no fim

        painelBotoes.getChildren().addAll(btnPedir, btnParar, btnReiniciar);

        lblStatus = new Label("Bem-vindo ao Blackjack!");
        lblStatus.getStyleClass().add("status");

        root.getChildren().addAll(lblDealer, mesaDealer, lblStatus, mesaJogador, lblJogador, lblPontosJogador, painelBotoes);

        // --- Eventos (Interatividade) ---
        btnPedir.setOnAction(e -> comprarCartaJogador());
        btnParar.setOnAction(e -> turnoDealer());
        btnReiniciar.setOnAction(e -> iniciarJogo());

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setTitle("Blackjack Java 21");
        stage.setScene(scene);
        stage.show();

        iniciarJogo();
    }

    private void iniciarJogo() {
        baralho.reiniciar();
        maoJogador.limpar();
        maoDealer.limpar();

        btnPedir.setDisable(false);
        btnParar.setDisable(false);
        btnReiniciar.setVisible(false);
        lblStatus.setText("Sua vez...");

        // Distribuição inicial
        maoJogador.adicionarCarta(baralho.comprar());
        maoDealer.adicionarCarta(baralho.comprar());
        maoJogador.adicionarCarta(baralho.comprar());
        maoDealer.adicionarCarta(baralho.comprar());

        atualizarMesa(false);
    }

    private void comprarCartaJogador() {
        maoJogador.adicionarCarta(baralho.comprar());
        if (maoJogador.calcularPontuacao() > 21) {
            atualizarMesa(false);
            fimDeJogo("Você estourou! Dealer venceu.");
        } else {
            atualizarMesa(false);
        }
    }

    private void turnoDealer() {
        // Dealer compra até ter 17 ou mais
        while (maoDealer.calcularPontuacao() < 17) {
            maoDealer.adicionarCarta(baralho.comprar());
        }
        verificarVencedor();
    }

    private void verificarVencedor() {
        int pJogador = maoJogador.calcularPontuacao();
        int pDealer = maoDealer.calcularPontuacao();

        atualizarMesa(true); // Revela cartas do dealer

        if (pDealer > 21) {
            fimDeJogo("Dealer estourou! Você venceu!");
        } else if (pJogador > pDealer) {
            fimDeJogo("Você venceu!");
        } else if (pJogador < pDealer) {
            fimDeJogo("Dealer venceu.");
        } else {
            fimDeJogo("Empate.");
        }
    }

    private void fimDeJogo(String mensagem) {
        lblStatus.setText(mensagem);
        btnPedir.setDisable(true);
        btnParar.setDisable(true);
        btnReiniciar.setVisible(true);
    }

    // Atualiza a "DOM" do JavaFX
    private void atualizarMesa(boolean mostrarTudoDealer) {
        mesaJogador.getChildren().clear();
        mesaDealer.getChildren().clear();

        // Renderiza Jogador
        for (Carta c : maoJogador.getCartas()) {
            mesaJogador.getChildren().add(criarVisualCarta(c));
        }
        lblPontosJogador.setText("Pontos: " + maoJogador.calcularPontuacao());

        // Renderiza Dealer
        List<Carta> cartasDealer = maoDealer.getCartas();
        for (int i = 0; i < cartasDealer.size(); i++) {
            if (i == 0 && !mostrarTudoDealer) {
                // Carta oculta
                mesaDealer.getChildren().add(criarVisualCartaOculta());
            } else {
                mesaDealer.getChildren().add(criarVisualCarta(cartasDealer.get(i)));
            }
        }
    }

    // Helpers de UI
    private StackPane criarVisualCarta(Carta c) {
        StackPane card = new StackPane();
        card.setPrefSize(80, 120);
        card.getStyleClass().add("carta");
        Label lbl = new Label(c.toString());
        lbl.setWrapText(true);
        card.getChildren().add(lbl);
        return card;
    }

    private StackPane criarVisualCartaOculta() {
        StackPane card = new StackPane();
        card.setPrefSize(80, 120);
        card.getStyleClass().add("carta-oculta");
        return card;
    }

    private Button criarBotao(String texto, String cor) {
        Button btn = new Button(texto);
        btn.setStyle("-fx-background-color: " + cor + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        btn.setPrefWidth(120);
        return btn;
    }

    public static void main(String[] args) {
        launch();
    }
}
```

---

### 💅 5. Estilização CSS (Moderno e Responsivo)

Salve como `src/main/resources/styles.css`. Isso substitui a necessidade de HTML.

```css
.root {
  -fx-font-family: "Segoe UI", sans-serif;
}

.titulo {
  -fx-font-size: 24px;
  -fx-text-fill: white;
  -fx-font-weight: bold;
  -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 5, 0, 0, 1);
}

.texto-branco {
  -fx-text-fill: white;
  -fx-font-size: 18px;
}

.status {
  -fx-font-size: 28px;
  -fx-text-fill: #f1c40f;
  -fx-font-weight: bold;
  -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 10, 0, 0, 0);
}

.carta {
  -fx-background-color: white;
  -fx-background-radius: 10;
  -fx-border-color: #333;
  -fx-border-radius: 10;
  -fx-border-width: 2;
  -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.4), 10, 0, 5, 5);
}

.carta-oculta {
  -fx-background-color: #a93226; /* Vermelho fundo carta */
  -fx-background-radius: 10;
  -fx-border-color: white;
  -fx-border-width: 3;
  -fx-border-style: dashed;
}
```

---

### 🚀 8. Gerar Versão Desktop (Java FX)

No Java moderno, não usamos Electron. Usamos **jpackage** (incluso no JDK 21) para criar um `.exe` ou `.msi` nativo.

1.  **Compile o projeto** (via Maven):
    `mvn clean package`
2.  **Gere a imagem nativa** (Exemplo de comando simplificado):
    ```bash
    jpackage --input target/ --name Blackjack21 --main-jar blackjack-1.0.jar --main-class com.blackjack.controller.BlackjackGame --type app-image
    ```

Isso criará um executável que o usuário pode clicar e jogar sem precisar instalar o Java manualmente.

---

### Próximo Passo

### 🚀 9. Refatoração

Esse erro é um clássico no desenvolvimento moderno com JavaFX (pós-JDK 11).

O motivo: Desde o Java 11, o JavaFX foi removido do JDK padrão e agora vive como módulos separados. Quando você tenta rodar diretamente uma classe que estende `Application` (como a nossa `BlackjackApp`), a JVM tenta carregar os componentes gráficos nativos antes mesmo de olhar para o seu classpath, e falha.

Vou te ensinar o **padrão da indústria** para resolver isso sem precisar ficar configurando argumentos complexos de VM (`--module-path`, etc). Usaremos a técnica do **Launcher (Lançador)**.

Siga estes passos simples:

### ✅ A Solução: O "Truque" do Launcher

Precisamos criar uma classe simples que **não** estenda `Application`, apenas para chamar o `main` da classe principal. Isso engana a JVM e permite que as bibliotecas sejam carregadas corretamente do classpath.

#### 1\. Crie a classe `Launcher.java`

Crie este arquivo na mesma pasta do seu `BlackjackApp.java` (`src/main/java/com/blackjack/Launcher.java`):

```java
package com.blackjack;

public class Launcher {
    public static void main(String[] args) {
        BlackjackApp.main(args);
    }
}
```

#### 2\. Execute pelo Launcher

Agora, em vez de tentar rodar o `BlackjackApp.java`, **execute o `Launcher.java`**.

- **Se estiver no VS Code/IntelliJ:** Clique com o botão direito em `Launcher.java` e selecione "Run".
- **Se estiver via Linha de Comando:** Aponte para essa classe.

---

### 💡 Alternativa: Rodando via Maven (Recomendado)

Se você já configurou o `pom.xml` que te passei anteriormente, você nem precisa criar o Launcher se rodar direto pelo Maven. O plugin do JavaFX cuida disso para você.

Abra o terminal na pasta do projeto (onde está o `pom.xml`) e digite:

```bash
mvn clean javafx:run
```

Isso deve abrir a janela do jogo imediatamente.

### Resumo Técnico (Para seu aprendizado)

O erro acontece porque a classe `BlackjackApp` herda de `javafx.application.Application`. A JVM verifica isso na inicialização e exige que os módulos JavaFX estejam no _Module Path_. Ao usar a classe `Launcher` (que é uma classe Java comum), a aplicação inicia normalmente e, quando chama `BlackjackApp.main()`, as bibliotecas já estão carregadas no _Class Path_, contornando a verificação estrita da inicialização.

---

# Códigos Completos

**Dependências no `pom.xml`:**
Precisamos das bibliotecas do JavaFX.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.blackjack</groupId>
    <artifactId>blackjack-desktop</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <javafx.version>21</javafx.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>${javafx.version}</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>${javafx.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
            </plugin>
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <configuration>
                    <mainClass>com.blackjack.BlackjackApp</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

### 💅 5. Estilização CSS (Moderno e Responsivo)

Salve como `src/main/resources/styles.css`. Isso substitui a necessidade de HTML.

```css
.root {
  -fx-background-color: #0a5c0a; /* Verde clássico */
  -fx-font-family: "Arial";
}

/* Títulos */
.titulo-principal {
  -fx-text-fill: white;
  -fx-font-size: 32px;
  -fx-font-weight: bold;
  -fx-padding: 20;
  -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5), 5, 0, 0, 1);
}

.titulo-area {
  -fx-text-fill: #ffc107; /* Dourado */
  -fx-font-size: 18px;
  -fx-font-weight: bold;
}

/* Container das Mãos (Areas) */
.area-jogo {
  -fx-background-color: rgba(0, 0, 0, 0.2);
  -fx-border-color: #ffc107;
  -fx-border-width: 2;
  -fx-border-radius: 10;
  -fx-background-radius: 10;
  -fx-padding: 20;
  -fx-spacing: 15;
  -fx-alignment: center;
  -fx-min-width: 600;
}

/* A Carta Visual */
.carta {
  -fx-background-color: white;
  -fx-background-radius: 8;
  -fx-border-color: #333;
  -fx-border-radius: 8;
  -fx-border-width: 1;
  -fx-pref-width: 80;
  -fx-pref-height: 120;
  -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.4), 8, 0, 2, 2);
}

.carta-texto {
  -fx-font-size: 18px;
  -fx-font-weight: bold;
}

.carta-naipe-grande {
  -fx-font-size: 36px;
}

.red {
  -fx-text-fill: #d90000;
}
.black {
  -fx-text-fill: black;
}

/* Carta Oculta (Verso) */
.carta-oculta {
  -fx-background-color: linear-gradient(to bottom right, #444, #666);
  -fx-background-radius: 8;
  -fx-border-color: white;
  -fx-border-width: 2;
  -fx-border-style: solid;
}

/* Mensagem de Status */
.status-msg {
  -fx-text-fill: white;
  -fx-font-size: 24px;
  -fx-font-weight: bold;
  -fx-padding: 10;
}

/* Botões */
.button {
  -fx-background-color: #ffc107;
  -fx-text-fill: #333;
  -fx-font-size: 14px;
  -fx-font-weight: bold;
  -fx-background-radius: 5;
  -fx-cursor: hand;
  -fx-padding: 10 20;
}

.button:hover {
  -fx-background-color: #ffd54f;
}

.button:disabled {
  -fx-background-color: #999;
  -fx-opacity: 0.7;
}
```

---

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)
