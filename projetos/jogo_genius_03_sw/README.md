# ✅ Lista de Tarefas — Desenvolvimento do Jogo **Genius (Simon)** em Java 21

### Sequência Didática Baseada no Guia de Desenvolvimento

---

## 🧩 **Etapa 1 — Estrutura do Projeto (Configuração Inicial)**

* [ ] Criar o diretório do projeto: `simon-java/`
* [ ] Inicializar projeto Maven (`mvn archetype:generate` ou manualmente)
* [ ] Configurar `pom.xml` com:

  * [ ] `maven.compiler.source` e `target` = 21
  * [ ] Dependência `junit-jupiter` para testes
  * [ ] Plugin `maven-surefire-plugin`
* [ ] Criar estrutura de pacotes:

  ```
  org.simon/
    ├─ model/
    ├─ view/
    ├─ controller/
    └─ util/
  ```
* [ ] Criar classe principal `App.java`
* [ ] Testar build inicial com `mvn package`

---

## 🧠 **Etapa 2 — Implementação do Modelo (Model)**

* [ ] Criar classe `SimonGame` dentro de `org.simon.model`
* [ ] Implementar atributos:

  * [ ] `List<Integer> sequence`
  * [ ] `Random random`
  * [ ] `boolean strictMode`
* [ ] Implementar métodos:

  * [ ] `addRandomStep(int maxButtons)`
  * [ ] `validatePrefix(List<Integer> inputSequence)`
  * [ ] `reset()` e `getSequence()` (imutável)
* [ ] Adicionar `setStrictMode` e `isStrictMode`
* [ ] Criar teste unitário `SimonGameTest` com JUnit 5
* [ ] Validar comportamento determinístico com `Random(0)`

---

## 🎛️ **Etapa 3 — Interface Gráfica (View com Swing)**

* [ ] Criar classe `SimonView` em `org.simon.view`
* [ ] Adicionar componentes:

  * [ ] `JFrame`
  * [ ] 4 botões coloridos (`JButton[] colorButtons`)
  * [ ] Botões de controle: `Start`, `Reset`, `Strict`
  * [ ] `JLabel` para pontuação
* [ ] Criar métodos públicos:

  * [ ] `show()`
  * [ ] `setStartAction(...)`, `setResetAction(...)`
  * [ ] `setButtonPressedListener(...)`
  * [ ] `updateScore(int)`
  * [ ] `lockButtons(boolean)`
  * [ ] `flashButton(...)`, `flashButtonShort(...)`
  * [ ] `showErrorFeedback()` e `showSuccessFeedback()`
* [ ] Garantir execução de atualizações na EDT com `SwingUtilities.invokeLater`
* [ ] Testar visualmente executando `SimonView.main()` provisório

---

## ⚙️ **Etapa 4 — Controlador (Controller)**

* [ ] Criar classe `SimonController` em `org.simon.controller`
* [ ] Injetar `SimonGame` e `SimonView` via construtor
* [ ] Implementar listeners:

  * [ ] `view.setStartAction(...)` → inicia jogo
  * [ ] `view.setButtonPressedListener(...)` → registra jogadas
  * [ ] `view.setStrictModeListener(...)` → ativa/desativa modo estrito
* [ ] Implementar lógica principal:

  * [ ] `start()`, `reset()`, `nextRound()`
  * [ ] `playSequence()` com `ScheduledExecutorService`
  * [ ] `onPlayerPress(int index)` para validar jogadas
* [ ] Usar `SwingUtilities.invokeLater` nas interações com UI
* [ ] Testar ciclo completo: **iniciar → tocar sequência → responder → próxima rodada**

---

## 🧵 **Etapa 5 — Concorrência e Feedback Visual**

* [ ] Garantir que playback da sequência não bloqueie a interface
* [ ] Adicionar delays controlados (600–800ms)
* [ ] Usar `ScheduledExecutorService` para agendamento e `Timer` para flashes
* [ ] Sincronizar reações do jogador com estado `playerTurn`
* [ ] Verificar que UI permanece responsiva durante o playback

---

## 🔁 **Etapa 6 — Modo Estrito e Reinício**

* [ ] Implementar lógica de erro:

  * [ ] Se `strictMode == true` → reiniciar o jogo após erro
  * [ ] Se `strictMode == false` → repetir sequência
* [ ] Adicionar `view.showErrorFeedback()` (piscar em vermelho + beep)
* [ ] Validar com testes manuais diferentes cenários de erro

---

## 🧪 **Etapa 7 — Testes e Boas Práticas**

* [ ] Criar testes unitários adicionais para `SimonGame`:

  * [ ] Validação de sequência incompleta
  * [ ] Sequência incorreta
  * [ ] Reinício com `reset()`
* [ ] Refatorar código para:

  * [ ] Métodos curtos e coesos
  * [ ] Nenhum acesso direto ao modelo a partir da visão
  * [ ] Responsabilidade única por classe
* [ ] Garantir uso de `final` e coleções imutáveis onde possível

---

## 🎨 **Etapa 8 — Extensões (Projeto Final)**

* [ ] Adicionar sons aos botões (`javax.sound.sampled.Clip`)
* [ ] Implementar níveis de dificuldade (velocidade crescente)
* [ ] Adicionar persistência de recordes (JSON, arquivo ou `Preferences`)
* [ ] Criar tema de cores configurável (modo noturno, retrô etc.)
* [ ] Portar a interface para **JavaFX** (desafio bônus)

---

## 📚 **Etapa 9 — Empacotamento e Entrega**

* [ ] Testar o projeto completo com `mvn test`
* [ ] Executar via `mvn package` e rodar `java -jar target/simon-java-1.0.0.jar`
* [ ] Criar `README.md` com instruções de compilação e execução
* [ ] Publicar o projeto em repositório Git
* [ ] Preparar slides curtos de apresentação com:

  * [ ] Arquitetura (MVC)
  * [ ] Demonstração visual
  * [ ] Possíveis melhorias futuras

---

## 🧭 **Resumo Sequencial (check rápido para uso em aula)**

| Ordem | Foco                      | Entrega Esperada                     |
| :---: | :------------------------ | :----------------------------------- |
|  1️⃣  | Estrutura Maven + pacotes | Projeto compila                      |
|  2️⃣  | Modelo (lógica pura)      | `SimonGame` funcional + testável     |
|  3️⃣  | Interface (Swing)         | UI visual e interativa               |
|  4️⃣  | Controlador               | Fluxo completo (rodadas + validação) |
|  5️⃣  | Concorrência (EDT)        | UI responsiva                        |
|  6️⃣  | Modo estrito + feedback   | Reações corretas a erros             |
|  7️⃣  | Testes e refatoração      | Código limpo e coberto               |
|  8️⃣  | Extensões opcionais       | Sons, níveis, persistência, JavaFX   |
|  9️⃣  | Empacotamento e entrega   | Jar final + documentação + GitHub    |


---


# Estrutura do projeto (Maven, Java 21) — **PT / EN**

**PT**

```
simon-java/
├─ pom.xml
└─ src/
   ├─ main/
   │  └─ java/org/simon/
   │     ├─ App.java
   │     ├─ controller/SimonController.java
   │     ├─ model/SimonGame.java
   │     ├─ view/SimonView.java
   │     └─ util/SwingUtils.java
   └─ test/
      └─ java/org/simon/model/SimonGameTest.java
```

**EN**

```
simon-java/
├─ pom.xml
└─ src/
   ├─ main/
   │  └─ java/org/simon/
   │     ├─ App.java
   │     ├─ controller/SimonController.java
   │     ├─ model/SimonGame.java
   │     ├─ view/SimonView.java
   │     └─ util/SwingUtils.java
   └─ test/
      └─ java/org/simon/model/SimonGameTest.java
```

---

# `pom.xml` (Maven) — **PT / EN**

**PT**

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.simon</groupId>
  <artifactId>simon-java</artifactId>
  <version>1.0.0</version>
  <properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.10.0</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.1.2</version>
      </plugin>
    </plugins>
  </build>
</project>
```

**EN**
Same `pom.xml` — Java 21, JUnit for tests.

---

# Código-fonte principal — **PT / EN**

> Segue a implementação organizada por pacotes (modelo, controlador, visão, util). Código pronto para compilar com `mvn package` e executar com `mvn exec:java` (ou executar a classe `App` na IDE).

---

## `model/SimonGame.java` — **PT / EN**

**PT (código)**

```java
package org.simon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modelo puro do jogo Simon (sem UI). Responsável pela sequência, validação e estado básico.
 */
public final class SimonGame {
    private final List<Integer> sequence = new ArrayList<>();
    private final Random random;
    private boolean strictMode = false;

    public SimonGame() {
        this(new Random());
    }

    public SimonGame(Random rnd) {
        this.random = rnd;
    }

    public void reset() {
        sequence.clear();
    }

    public int size() {
        return sequence.size();
    }

    public List<Integer> getSequence() {
        return List.copyOf(sequence);
    }

    public int addRandomStep(int maxButtons) {
        if (maxButtons <= 0) throw new IllegalArgumentException("maxButtons must be > 0");
        int next = random.nextInt(maxButtons);
        sequence.add(next);
        return next;
    }

    /**
     * Valida o input do jogador passo a passo.
     * @param inputSequence lista com os inputs do jogador para comparar com a sequência.
     * @return true se todos os inputs conferirem até o tamanho de inputSequence.
     */
    public boolean validatePrefix(List<Integer> inputSequence) {
        if (inputSequence == null) throw new IllegalArgumentException("inputSequence null");
        if (inputSequence.size() > sequence.size()) return false;
        for (int i = 0; i < inputSequence.size(); i++) {
            if (!sequence.get(i).equals(inputSequence.get(i))) return false;
        }
        return true;
    }

    public boolean isStrictMode() {
        return strictMode;
    }

    public void setStrictMode(boolean strictMode) {
        this.strictMode = strictMode;
    }
}
```

**EN**
Same file — pure game model, deterministic via injected `Random` for testability.

---

## `controller/SimonController.java` — **PT / EN**

**PT**

```java
package org.simon.controller;

import org.simon.model.SimonGame;
import org.simon.view.SimonView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Controller: coordena fluxo entre modelo e visão.
 * Usa ScheduledExecutorService para tocar a sequência sem bloquear a EDT.
 */
public final class SimonController {
    private final SimonGame model;
    private final SimonView view;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ExecutorService uiExecutor = Executors.newSingleThreadExecutor();
    private final int maxButtons = 4;

    private List<Integer> playerBuffer = new ArrayList<>();
    private boolean playerTurn = false;

    public SimonController(SimonGame model, SimonView view) {
        this.model = model;
        this.view = view;
        attachViewListeners();
    }

    private void attachViewListeners() {
        view.setStartAction(e -> start());
        view.setButtonPressedListener(index -> onPlayerPress(index));
        view.setStrictModeListener(on -> model.setStrictMode(on));
        view.setResetAction(e -> reset());
    }

    public void start() {
        view.lockButtons(true);
        resetRound();
        nextRound();
    }

    private void resetRound() {
        playerBuffer.clear();
        playerTurn = false;
    }

    private void nextRound() {
        // add step
        model.addRandomStep(maxButtons);
        view.updateScore(model.size());
        playSequence();
    }

    private void playSequence() {
        view.lockButtons(true);
        playerBuffer.clear();
        List<Integer> seq = model.getSequence();
        long delayMs = 600;
        long stepDelay = 800;

        for (int i = 0; i < seq.size(); i++) {
            int idx = seq.get(i);
            scheduler.schedule(() -> {
                SwingUtilities.invokeLater(() -> view.flashButton(idx));
            }, delayMs + i * stepDelay, TimeUnit.MILLISECONDS);
        }

        // after playing sequence, allow player input
        scheduler.schedule(() -> {
            playerTurn = true;
            SwingUtilities.invokeLater(() -> view.lockButtons(false));
        }, delayMs + seq.size() * stepDelay, TimeUnit.MILLISECONDS);
    }

    private void onPlayerPress(int index) {
        if (!playerTurn) return;
        view.flashButtonShort(index);
        playerBuffer.add(index);

        boolean ok = model.validatePrefix(playerBuffer);
        if (!ok) {
            playerTurn = false;
            view.lockButtons(true);
            view.showErrorFeedback();
            if (model.isStrictMode()) {
                // strict: reset game
                scheduler.schedule(() -> {
                    SwingUtilities.invokeLater(() -> {
                        model.reset();
                        view.updateScore(0);
                        start();
                    });
                }, 1000, TimeUnit.MILLISECONDS);
            } else {
                // show the same sequence again
                scheduler.schedule(() -> playSequence(), 1000, TimeUnit.MILLISECONDS);
            }
            return;
        }

        // if player completed the full sequence for this round
        if (playerBuffer.size() == model.size()) {
            playerTurn = false;
            view.lockButtons(true);
            view.showSuccessFeedback();
            scheduler.schedule(this::nextRound, 800, TimeUnit.MILLISECONDS);
        }
    }

    public void reset() {
        model.reset();
        playerBuffer.clear();
        playerTurn = false;
        view.updateScore(0);
        view.lockButtons(true);
    }

    public void shutdown() {
        scheduler.shutdownNow();
        uiExecutor.shutdownNow();
    }
}
```

**EN**
Controller coordinates model and view; schedules playback off EDT and marshals UI updates back to Swing thread.

---

## `view/SimonView.java` — **PT / EN**

**PT**

```java
package org.simon.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.IntConsumer;

/**
 * Swing UI minimalista: 4 botões coloridos + controles.
 * Patterns: view exposes listeners, não lida com lógica do jogo.
 */
public final class SimonView {
    private final JFrame frame;
    private final JButton[] colorButtons = new JButton[4];
    private final JButton startButton = new JButton("Start");
    private final JButton resetButton = new JButton("Reset");
    private final JLabel scoreLabel = new JLabel("Score: 0");
    private final JCheckBox strictCheck = new JCheckBox("Strict");

    private IntConsumer buttonPressedListener = i -> {};
    private ActionListener startAction = e -> {};
    private ActionListener resetAction = e -> {};
    private java.util.function.Consumer<Boolean> strictListener = b -> {};

    private final Color[] baseColors = {
            new Color(0xFF5555), // red
            new Color(0x55FF55), // green
            new Color(0x5555FF), // blue
            new Color(0xFFFF55)  // yellow
    };

    public SimonView() {
        frame = new JFrame("Simon - Java 21");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(8, 8));

        JPanel board = new JPanel(new GridLayout(2, 2, 6, 6));
        for (int i = 0; i < 4; i++) {
            JButton b = new JButton();
            b.setOpaque(true);
            b.setBorderPainted(false);
            b.setBackground(baseColors[i]);
            final int idx = i;
            b.addActionListener(e -> buttonPressedListener.accept(idx));
            colorButtons[i] = b;
            board.add(b);
        }
        board.setPreferredSize(new Dimension(400, 400));
        frame.add(board, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        controls.add(startButton);
        controls.add(resetButton);
        controls.add(scoreLabel);
        controls.add(strictCheck);
        frame.add(controls, BorderLayout.SOUTH);

        startButton.addActionListener(e -> startAction.actionPerformed(e));
        resetButton.addActionListener(e -> resetAction.actionPerformed(e));
        strictCheck.addActionListener(e -> strictListener.accept(strictCheck.isSelected()));

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void setStartAction(ActionListener act) {
        this.startAction = act;
    }

    public void setResetAction(ActionListener act) {
        this.resetAction = act;
    }

    public void setStrictModeListener(java.util.function.Consumer<Boolean> listener) {
        this.strictListener = listener;
    }

    public void setButtonPressedListener(IntConsumer listener) {
        this.buttonPressedListener = listener;
    }

    public void updateScore(int score) {
        SwingUtilities.invokeLater(() -> scoreLabel.setText("Score: " + score));
    }

    public void lockButtons(boolean locked) {
        SwingUtilities.invokeLater(() -> {
            for (JButton b : colorButtons) {
                b.setEnabled(!locked);
            }
        });
    }

    public void flashButton(int index) {
        JButton b = colorButtons[index];
        Color orig = b.getBackground();
        Color bright = orig.brighter();
        b.setBackground(bright);
        // small delay then restore on EDT
        Timer t = new Timer(400, e -> b.setBackground(orig));
        t.setRepeats(false);
        t.start();
        Toolkit.getDefaultToolkit().beep();
    }

    public void flashButtonShort(int index) {
        JButton b = colorButtons[index];
        Color orig = b.getBackground();
        Color bright = orig.brighter();
        b.setBackground(bright);
        Timer t = new Timer(140, e -> b.setBackground(orig));
        t.setRepeats(false);
        t.start();
        Toolkit.getDefaultToolkit().beep();
    }

    public void showErrorFeedback() {
        // red flash of frame
        SwingUtilities.invokeLater(() -> {
            Color orig = frame.getContentPane().getBackground();
            frame.getContentPane().setBackground(Color.RED);
            Timer t = new Timer(300, e -> frame.getContentPane().setBackground(orig));
            t.setRepeats(false);
            t.start();
            Toolkit.getDefaultToolkit().beep();
        });
    }

    public void showSuccessFeedback() {
        SwingUtilities.invokeLater(() -> {
            Toolkit.getDefaultToolkit().beep();
        });
    }
}
```

**EN**
View implements Swing UI only; it exposes listeners so controller handles behavior. UI updates are performed on EDT; flash uses `Timer`.

---

## `util/SwingUtils.java` — **PT / EN**

**PT**

```java
package org.simon.util;

import javax.swing.*;

public final class SwingUtils {
    private SwingUtils() {}

    public static void runOnEDT(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) r.run();
        else SwingUtilities.invokeLater(r);
    }
}
```

**EN**
Small helper for ensuring EDT execution.

---

## `App.java` — **PT / EN**

**PT**

```java
package org.simon;

import org.simon.controller.SimonController;
import org.simon.model.SimonGame;
import org.simon.view.SimonView;

public class App {
    public static void main(String[] args) {
        SimonGame model = new SimonGame();
        SimonView view = new SimonView();
        SimonController controller = new SimonController(model, view);

        view.show();

        // add shutdown hook to stop schedulers
        Runtime.getRuntime().addShutdownHook(new Thread(controller::shutdown));
    }
}
```

**EN**
Bootstrap: creates model, view, controller and shows UI.

---

## Test: `test/SimonGameTest.java` — **PT / EN**

**PT**

```java
package org.simon.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SimonGameTest {

    @Test
    void addAndValidate() {
        // predictable Random
        SimonGame g = new SimonGame(new Random(0));
        int a = g.addRandomStep(4);
        int b = g.addRandomStep(4);
        List<Integer> seq = g.getSequence();
        assertEquals(2, seq.size());
        assertTrue(g.validatePrefix(List.of(seq.get(0))));
        assertTrue(g.validatePrefix(seq));
        assertFalse(g.validatePrefix(List.of(3,3,3)));
    }
}
```

**EN**
Unit test uses injected Random to guarantee deterministic sequence for assertions.

---

# Guia didático passo a passo (aulas) — **PT / EN**

**Observação:** cada aula tem objetivo, conteúdo, exercícios práticos e pontos de avaliação.

## Aula 1 — Arquitetura e projeto (MVC + separação de responsabilidades)

**PT**

* Objetivo: entender separação Model / View / Controller.
* Conteúdo:

  1. Explicar responsabilidades de `SimonGame`, `SimonView`, `SimonController`.
  2. Injeção de dependências simples (construção manual).
  3. Testabilidade: modelo sem UI.
* Exercício:

  * Escrever um teste unitário que valide comportamento de `validatePrefix`.
  * Modificar `SimonGame` para suportar 6 botões (mudar `maxButtons` no controller para tornar configurável).
* Avaliação:

  * Código limpo? Model testável? UI separada?

**EN**

* Goal: understand separation Model/View/Controller.
* Content: responsibilities of classes, DI, testability.
* Exercise: unit test for validatePrefix; change to 6 buttons.
* Assessment: code clarity and testability.

## Aula 2 — Concor­rência e Swing (EDT)

**PT**

* Objetivo: aprender a não bloquear EDT ao tocar a sequência.
* Conteúdo:

  1. Problema de bloquear UI e técnicas para agendar tarefas (`ScheduledExecutorService`, `SwingUtilities.invokeLater`, `javax.swing.Timer`).
  2. Explicar por que atualizações UI ocorrem no EDT.
* Exercício:

  * Modifique o delay de reprodução via campo público/configurável.
  * Implementar um visual progress indicator durante playback.
* Avaliação:

  * UI responsiva durante reprodução? Sem exceções de thread?

**EN**

* Goal: avoid blocking the EDT; use schedulers and `invokeLater`.
* Exercise: configurable delays; progress indicator.
* Assessment: responsive UI, correct thread usage.

## Aula 3 — Boas práticas, testes e modo estrito

**PT**

* Objetivo: consolidar práticas (inversão de controle, testes, logging leve).
* Conteúdo:

  1. Injetar `Random` para determinismo em testes.
  2. Cobertura de testes do modelo; Q/A sobre testes de UI.
  3. Implementar `strictMode` e explicar trade-offs.
* Exercício:

  * Criar testes para `strictMode` (comportamento esperado).
* Avaliação:

  * Testes passam; design limpo.

**EN**

* Goal: consolidate DI, tests, and strict mode tradeoffs.
* Exercise: add tests for strict mode.
* Assessment: passing tests.

## Aula 4 — Extensões sugeridas (projeto final)

**PT**

* Adicionar sons (use `javax.sound.sampled`).
* Persistir recordes (file JSON ou `Preferences`).
* Opção multiplayer (hotseat) ou níveis configuráveis.
* Refatorar UI para JavaFX (opcional).
* Entregar: repositório git com README, instruções de build e testes.

**EN**

* Extensions: sounds, high-score persistence, multiplayer, JavaFX port, deliverable with README and tests.

---

# Melhorias aplicadas e justificativas — **PT / EN**

**PT**

1. **Separação clara de responsabilidades (MVC)** — facilita testes e evolução.
2. **Injeção de `Random` no modelo** — determinismo para testes.
3. **Uso de `ScheduledExecutorService` + `SwingUtilities.invokeLater`** — reproduz sequência sem bloquear UI.
4. **API pública mínima e imutabilidade** (`getSequence()` copia) — evita vazamento de estado.
5. **Strict mode configurável** — comportamento comum do Genius.
6. **Testes unitários** para lógica de jogo.
7. **Boas práticas de thread-safety na UI** (uso de `Timer` e EDT).

**EN**

1. Clear MVC separation for testability and maintainability.
2. Inject `Random` for deterministic tests.
3. Use scheduler + `invokeLater` to avoid blocking UI.
4. Minimal public API and immutability (`getSequence()` returns copy).
5. Configurable strict mode.
6. Unit tests for game logic.
7. Thread-safety in UI (EDT use).

---

# Como compilar e executar — **PT / EN**

**PT**

1. Requisitos: JDK 21, Maven.
2. Compilar: `mvn -DskipTests package`
3. Testar: `mvn test`
4. Executar (IDE) — executar `org.simon.App` ou:

   * adicionar plugin maven-exec se quiser `mvn exec:java -Dexec.mainClass=org.simon.App`

**EN**

1. Requirements: JDK 21, Maven.
2. Build: `mvn -DskipTests package`
3. Test: `mvn test`
4. Run: execute `org.simon.App` in IDE or configure `maven-exec`.

---

# Sugestões de exercícios avaliáveis (para suas aulas) — **PT / EN**

**PT**

1. Implementar sons por botão usando `Clip`.
2. Implementar persistência de high-score em JSON.
3. Refatorar para permitir temas de cores (skins).
4. Mudar UI para JavaFX (desafio).
5. Adicionar níveis de velocidade progressiva.

**EN**

1. Add per-button sounds using `Clip`.
2. Persist high-score in JSON.
3. Add color theme support.
4. Port UI to JavaFX.
5. Add progressive speed levels.

---

# Observações finais técnicas (curtas) — **PT / EN**

**PT**

* O código está pronto para extensões e para demonstração em aula. Posso fornecer a versão com sons (Clip), persistência de scores ou port para JavaFX se desejar — me diga qual extensão prefere.

**EN**

* Code is ready for extensions. I can provide versions with sounds, high-score persistence or a JavaFX port — tell me which extension you want.


