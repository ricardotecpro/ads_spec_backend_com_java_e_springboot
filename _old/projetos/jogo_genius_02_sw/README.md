### Análise da Tarefa

O objetivo é criar uma réplica do jogo "Genius" (Simon) em Java 21, com foco em uma arquitetura limpa e práticas modernas de desenvolvimento. Como nenhum código foi fornecido, construiremos a solução do zero, seguindo uma abordagem didática.

-----

### Aula 1: Estrutura da GUI (Java Swing)

O primeiro passo é construir a interface gráfica (GUI) baseada na imagem. Usaremos a biblioteca Swing para compatibilidade.

**Princípios:**

  * **Separação de Responsabilidades:** A classe principal (`GeniusGame`) atuará como o "Controlador" (manipulando eventos) e a "Visão" (estendendo `JFrame`). Em aplicações maiores, separaríamos isso, mas para um jogo simples, é aceitável.
  * **Layout Managers:** Evitar posicionamento absoluto (`null` layout). Usaremos `BorderLayout` e `GridLayout` para um design responsivo.

**Passo a Passo:**

1.  **Classe Principal:** Crie `GeniusGame` que herda de `JFrame`.
2.  **Componentes:** Declare os componentes visuais: `JLabel` para pontuação e `JButton` para as cores e o início.
3.  **Layout:**
      * O `JFrame` usará `BorderLayout`.
      * **NORTE (`NORTH`):** Um `JPanel` com `FlowLayout` para os placares (`scoreLabel`, `recordLabel`).
      * **CENTRO (`CENTER`):** Um `JPanel` com `GridLayout(2, 2)` para os quatro botões coloridos.
      * **SUL (`SOUTH`):** Um `JPanel` com `FlowLayout` para o `startButton`.
4.  **Método Auxiliar:** Crie um método `createColorButton()` para evitar repetição de código (Princípio DRY - Don't Repeat Yourself) ao configurar os botões.
5.  **EDT (Event Dispatch Thread):** A aplicação Swing deve ser iniciada dentro de `SwingUtilities.invokeLater()`.

<!-- end list -->

```java
/* Aula 1: Estrutura da GUI */
import javax.swing.*;
import java.awt.*;

// Usamos um Enum para representar os botões.
// Isso é mais seguro e legível que usar Strings ou números.
enum ColorButton {
    GREEN, RED, YELLOW, BLUE
}

public class GeniusGame extends JFrame {

    private JLabel scoreLabel;
    private JLabel recordLabel;
    private JButton startButton;
    private JButton greenButton, redButton, yellowButton, blueButton;

    public GeniusGame() {
        setTitle("Jogo Genius (Java 21)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // --- 1. Painel de Pontuação (Norte) ---
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        scoreLabel = new JLabel("Pontuação: 0");
        recordLabel = new JLabel("Recorde: 6"); // Valor inicial da imagem
        scorePanel.add(scoreLabel);
        scorePanel.add(recordLabel);
        add(scorePanel, BorderLayout.NORTH);

        // --- 2. Painel de Cores (Centro) ---
        JPanel colorPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        greenButton = createColorButton(Color.GREEN, ColorButton.GREEN);
        redButton = createColorButton(Color.RED, ColorButton.RED);
        yellowButton = createColorButton(Color.YELLOW, ColorButton.YELLOW);
        blueButton = createColorButton(Color.BLUE, ColorButton.BLUE);

        colorPanel.add(greenButton);
        colorPanel.add(redButton);
        colorPanel.add(yellowButton);
        colorPanel.add(blueButton);
        add(colorPanel, BorderLayout.CENTER);

        // --- 3. Painel de Controle (Sul) ---
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        startButton = new JButton("Iniciar Jogo");
        controlPanel.add(startButton);
        add(controlPanel, BorderLayout.SOUTH);
    }

    // Método auxiliar (Princípio DRY)
    private JButton createColorButton(Color color, ColorButton id) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 150));
        // Usamos setActionCommand para identificar o botão no listener
        button.setActionCommand(id.name()); 
        return button;
    }

    public static void main(String[] args) {
        // Correto: Inicia a GUI na Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new GeniusGame().setVisible(true);
        });
    }
}
```

-----

### Aula 2: Lógica e Estado do Jogo

Agora, adicionamos as variáveis de estado e a lógica principal (o "Modelo" do nosso jogo).

**Princípios:**

  * **Estado do Jogo:** Manter o estado claramente definido (sequência do computador, posição do jogador, pontuação).
  * **Máquina de Estados:** O jogo transita entre estados: "Computador Jogando", "Jogador Jogando", "Game Over".

**Passo a Passo:**

1.  **Variáveis de Estado:** Adicione campos à classe `GeniusGame` para:
      * `java.util.List<ColorButton> sequence`: Armazena a sequência de cores.
      * `java.util.Random random`: Gerador de números aleatórios.
      * `int score`, `int highScore`: Pontuação.
      * `int playerIndex`: Onde o jogador está na sequência atual.
      * `boolean isPlayerTurn`: Controla de quem é a vez.
2.  **Inicialização:** No construtor, inicialize as variáveis (ex: `sequence = new ArrayList<>()`).
3.  **Métodos de Lógica:** Crie os métodos que controlam o fluxo:
      * `startGame()`: Reseta o jogo e inicia a primeira rodada.
      * `nextRound()`: Adiciona uma nova cor à sequência e chama `playSequence()`.
      * `playerTurn()`: Ativa os botões para o jogador.
      * `checkPlayerInput(ColorButton pressedColor)`: Verifica se o jogador acertou a cor.
      * `gameOver()`: Finaliza o jogo e atualiza o recorde.
      * `updateScoreboard()`: Atualiza os `JLabels`.
      * `enableColorButtons(boolean enable)`: Habilita/desabilita os botões de cor.

<!-- end list -->

```java
/* Aula 2: Adicionando Lógica e Estado (incremental) */

// Adicionar estes campos ao topo da classe GeniusGame
private java.util.List<ColorButton> sequence;
private java.util.Random random;
private int score;
private int highScore = 6; // Da imagem
private int playerIndex;
private boolean isPlayerTurn;

// Adicionar ao final do construtor GeniusGame()
public GeniusGame() {
    // ... (código da Aula 1) ...
    
    sequence = new java.util.ArrayList<>();
    random = new java.util.Random();
    score = 0;
    playerIndex = 0;
    isPlayerTurn = false;

    // Desabilitar botões coloridos até o jogo começar
    enableColorButtons(false);
    
    // (Ação dos botões será na Aula 3)
}

// --- Métodos de Lógica do Jogo (Adicionar à classe) ---

private void startGame() {
    sequence.clear();
    score = 0;
    playerIndex = 0;
    updateScoreboard();
    isPlayerTurn = false;
    startButton.setEnabled(false);
    nextRound();
}

private void nextRound() {
    isPlayerTurn = false;
    enableColorButtons(false);
    playerIndex = 0;
    
    // Adiciona uma nova cor aleatória à sequência
    sequence.add(ColorButton.values()[random.nextInt(4)]);
    
    // Tocar a sequência (será implementado na Aula 3)
    playSequence(); 
}

private void playerTurn() {
    isPlayerTurn = true;
    enableColorButtons(true);
}

private void checkPlayerInput(ColorButton pressedColor) {
    if (!isPlayerTurn) return;

    if (sequence.get(playerIndex) == pressedColor) {
        // Acerto
        playerIndex++;
        
        if (playerIndex == sequence.size()) {
            // Jogador completou a rodada
            score++;
            updateScoreboard();
            isPlayerTurn = false;
            enableColorButtons(false);
            
            // Pausa antes da próxima rodada (usando Timer Swing)
            javax.swing.Timer nextRoundTimer = new javax.swing.Timer(1000, e -> nextRound());
            nextRoundTimer.setRepeats(false); // Importante: executar apenas uma vez
            nextRoundTimer.start();
        }
    } else {
        // Erro
        gameOver();
    }
}

private void gameOver() {
    isPlayerTurn = false;
    enableColorButtons(false);
    startButton.setEnabled(true);
    
    if (score > highScore) {
        highScore = score;
    }
    updateScoreboard();
    
    JOptionPane.showMessageDialog(this, "Game Over! Pontuação: " + score, "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
}

private void updateScoreboard() {
    scoreLabel.setText("Pontuação: " + score);
    recordLabel.setText("Recorde: " + highScore);
}

private void enableColorButtons(boolean enable) {
    greenButton.setEnabled(enable);
    redButton.setEnabled(enable);
    yellowButton.setEnabled(enable);
    blueButton.setEnabled(enable);
}

// Método placeholder
private void playSequence() {
    // Implementação crucial na próxima aula
    System.out.println("Tocando sequência: " + sequence);
    // Após tocar, deve chamar playerTurn()
    playerTurn(); 
}
```

-----

### Aula 3: Eventos e Feedback Visual (Concorrência em Swing)

Este é o núcleo da aplicação: manipular cliques e fornecer feedback (piscar os botões) sem travar a interface.

**Princípios:**

  * **Não bloquear a EDT:** A Event Dispatch Thread (EDT) é a *única* thread que pode atualizar a GUI. Operações longas (como `Thread.sleep()`) nela irão congelar a aplicação.
  * **Trabalho em Background:** A "reprodução" da sequência (cor, pausa, cor, pausa...) deve ocorrer em uma thread de trabalho (background thread).
  * **SwingWorker (Abordagem Clássica):** A ferramenta padrão do Swing para esta tarefa.
      * `doInBackground()`: Roda na thread de trabalho (aqui usamos `Thread.sleep()`).
      * `publish()`/`process()`: Usado para enviar atualizações parciais da thread de trabalho para a EDT (para piscar o botão).
      * `done()`: Roda na EDT quando `doInBackground()` termina (para chamar `playerTurn()`).

**Passo a Passo:**

1.  **Registrar Listeners:** No construtor, adicione `ActionListener` ao `startButton` (chamando `startGame()`) e aos botões coloridos (chamando `checkPlayerInput()`).
2.  **Método `highlightButton()`:** Crie um método que altera a cor de um botão para "brilhante" (feedback visual).
3.  **Implementar `playSequence()` com `SwingWorker`:**
      * Crie uma classe interna ou anônima que estende `SwingWorker<Void, ColorButton>`.
      * Em `doInBackground()`, itere pela `sequence`.
      * Use `publish(color)` para "acender" o botão.
      * Use `Thread.sleep()` para a pausa.
      * Use `publish(null)` para "apagar" o botão.
      * Em `process()`, chame `highlightButton(color)` para atualizar a GUI.
      * Em `done()`, chame `playerTurn()`.
4.  **Feedback no Clique:** Adicione um feedback visual (piscar) dentro de `checkPlayerInput()`.

<!-- end list -->

```java
/* Aula 3: Eventos e Concorrência (incremental) */
import java.util.List; // Importar java.util.List

// Adicionar ao construtor GeniusGame()
public GeniusGame() {
    // ... (código da Aula 2) ...

    // --- 4. Registro de Eventos ---
    startButton.addActionListener(e -> startGame());
    
    // Listener único para todos os botões coloridos
    java.awt.event.ActionListener colorListener = e -> {
        // Usamos o ActionCommand definido na Aula 1
        checkPlayerInput(ColorButton.valueOf(e.getActionCommand()));
    };
    
    greenButton.addActionListener(colorListener);
    redButton.addActionListener(colorListener);
    yellowButton.addActionListener(colorListener);
    blueButton.addActionListener(colorListener);
}

// --- Novos Métodos de Feedback Visual ---

// Substituir o placeholder da Aula 2
private void playSequence() {
    new SwingWorker<Void, ColorButton>() {
        @Override
        protected Void doInBackground() throws Exception {
            Thread.sleep(1000); // Pausa antes de começar
            
            for (ColorButton color : sequence) {
                publish(color); // Publica a cor para "acender"
                Thread.sleep(600);
                publish(null); // Publica null para "apagar"
                Thread.sleep(200);
            }
            return null;
        }

        @Override
        protected void process(List<ColorButton> chunks) {
            // Este método roda na EDT, seguro para GUI
            for (ColorButton color : chunks) {
                highlightButton(color);
            }
        }

        @Override
        protected void done() {
            // Roda na EDT ao final
            highlightButton(null);
            playerTurn(); // Agora é a vez do jogador
        }
    }.execute();
}

private void highlightButton(ColorButton color) {
    // Reseta todos para a cor base
    greenButton.setBackground(Color.GREEN);
    redButton.setBackground(Color.RED);
    yellowButton.setBackground(Color.YELLOW);
    blueButton.setBackground(Color.BLUE);

    if (color == null) return;

    // Destaca o botão específico
    // Usamos .brighter() para um efeito simples
    switch (color) {
        case GREEN:
            greenButton.setBackground(Color.GREEN.brighter().brighter());
            break;
        case RED:
            redButton.setBackground(Color.RED.brighter().brighter());
            break;
        case YELLOW:
            yellowButton.setBackground(Color.YELLOW.brighter().brighter());
            break;
        case BLUE:
            blueButton.setBackground(Color.BLUE.brighter().brighter());
            break;
    }
}

// --- Atualização no checkPlayerInput (para feedback) ---

private void checkPlayerInput(ColorButton pressedColor) {
    if (!isPlayerTurn) return;

    // --- Adicionar Feedback Visual Imediato ---
    highlightButton(pressedColor);
    // Usamos um Timer para "apagar" o botão após 200ms
    javax.swing.Timer highlightTimer = new javax.swing.Timer(200, e -> highlightButton(null));
    highlightTimer.setRepeats(false);
    highlightTimer.start();
    // --- Fim do Feedback ---

    if (sequence.get(playerIndex) == pressedColor) {
        // (Lógica de acerto da Aula 2)
        // ...
    } else {
        gameOver();
    }
}
```

-----

### Aula 4: Refatoração com Java 21 (Threads Virtuais)

O `SwingWorker` é funcional, mas verboso. Com o Java 21 (Project Loom), podemos simplificar drasticamente a concorrência usando **Threads Virtuais**.

**Princípios:**

  * **Threads Virtuais:** São threads leves gerenciadas pelo JVM. Bloquear uma thread virtual (com `Thread.sleep()`) é barato e não bloqueia a thread do sistema operacional (Kernel Thread).
  * **Sincronização com a EDT:** A regra de ouro *ainda* se aplica: **Nunca toque na GUI de uma thread que não seja a EDT**.
  * **Solução Moderna:** Usamos `Thread.ofVirtual().start()` para rodar a lógica de espera. Quando precisamos atualizar a GUI, usamos `SwingUtilities.invokeLater()` para enviar essa atualização de volta à EDT.

**Passo a Passo (Refatoração):**

1.  **Refatorar `playSequence()`:** Substitua o `SwingWorker` por uma Thread Virtual. O código fica linear e muito mais fácil de ler.
2.  **Refatorar `highlightButton()`:** Use uma *Switch Expression* (Java 14+) para um código mais limpo.
3.  **Usar `var`:** Adote a inferência de tipo para variáveis locais (Java 10+).

<!-- end list -->

```java
/* Aula 4: Refatoração para Java 21 (incremental) */

// 1. Refatorar playSequence() (Substitui o SwingWorker da Aula 3)
private void playSequence() {
    // Java 21: Usando Threads Virtuais (Project Loom)
    Thread.ofVirtual().start(() -> {
        try {
            Thread.sleep(1000);
            
            for (var color : sequence) { // Usando 'var' (Java 10+)
                
                // 1. Atualiza a GUI (pisca) -> Deve ser na EDT
                SwingUtilities.invokeLater(() -> highlightButton(color));
                Thread.sleep(600);
                
                // 2. Atualiza a GUI (apaga) -> Deve ser na EDT
                SwingUtilities.invokeLater(() -> highlightButton(null));
                Thread.sleep(200);
            }
            
            // 3. Habilita o turno do jogador -> Deve ser na EDT
            SwingUtilities.invokeLater(this::playerTurn); // Usando method reference
            
        } catch (InterruptedException e) {
            // Em apps reais, tratar o cancelamento
            Thread.currentThread().interrupt();
        }
    });
}

// 2. Refatorar highlightButton() (Substitui o da Aula 3)
private void highlightButton(ColorButton color) {
    // Reseta todos
    greenButton.setBackground(Color.GREEN);
    redButton.setBackground(Color.RED);
    yellowButton.setBackground(Color.YELLOW);
    blueButton.setBackground(Color.BLUE);

    if (color == null) return;

    // Java 14+: Switch Expression
    // Obtém a cor base do botão que será destacado
    Color baseColor = switch (color) {
        case GREEN -> Color.GREEN;
        case RED -> Color.RED;
        case YELLOW -> Color.YELLOW;
        case BLUE -> Color.BLUE;
    };
    
    // Obtém o botão que será destacado
    JButton buttonToHighlight = switch (color) {
        case GREEN -> greenButton;
        case RED -> redButton;
        case YELLOW -> yellowButton;
        case BLUE -> blueButton;
    };

    // Aplica o brilho
    buttonToHighlight.setBackground(baseColor.brighter().brighter());
}
```

-----

### Código Completo (Versão Final Java 21)

Este é o arquivo `GeniusGame.java` completo, aplicando todas as aulas e refatorações.

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementação do Jogo Genius (Simon) usando Java 21 (Swing e Virtual Threads).
 * Foco: Boas práticas de concorrência em GUI e código moderno.
 */
public class GeniusGame extends JFrame {

    // Enum para estado de cor (type-safe)
    private enum ColorButton {
        GREEN, RED, YELLOW, BLUE
    }

    // --- Componentes da GUI ---
    private final JLabel scoreLabel;
    private final JLabel recordLabel;
    private final JButton startButton;
    private final JButton greenButton, redButton, yellowButton, blueButton;

    // --- Estado do Jogo ---
    private final List<ColorButton> sequence;
    private final Random random;
    private int score;
    private int highScore = 6; // Valor inicial da imagem
    private int playerIndex;
    private boolean isPlayerTurn;

    public GeniusGame() {
        setTitle("Jogo Genius (Java 21)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);
        
        // --- Estado ---
        sequence = new ArrayList<>();
        random = new Random();
        score = 0;
        playerIndex = 0;
        isPlayerTurn = false;

        // --- 1. Painel de Pontuação (Norte) ---
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        scoreLabel = new JLabel("Pontuação: " + score);
        recordLabel = new JLabel("Recorde: " + highScore);
        scorePanel.add(scoreLabel);
        scorePanel.add(recordLabel);
        add(scorePanel, BorderLayout.NORTH);

        // --- 2. Painel de Cores (Centro) ---
        JPanel colorPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        greenButton = createColorButton(Color.GREEN, ColorButton.GREEN);
        redButton = createColorButton(Color.RED, ColorButton.RED);
        yellowButton = createColorButton(Color.YELLOW, ColorButton.YELLOW);
        blueButton = createColorButton(Color.BLUE, ColorButton.BLUE);

        colorPanel.add(greenButton);
        colorPanel.add(redButton);
        colorPanel.add(yellowButton);
        colorPanel.add(blueButton);
        add(colorPanel, BorderLayout.CENTER);

        // --- 3. Painel de Controle (Sul) ---
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        startButton = new JButton("Iniciar Jogo");
        controlPanel.add(startButton);
        add(controlPanel, BorderLayout.SOUTH);

        // --- 4. Registro de Eventos ---
        startButton.addActionListener(e -> startGame());
        
        ActionListener colorListener = e -> {
            checkPlayerInput(ColorButton.valueOf(e.getActionCommand()));
        };
        
        greenButton.addActionListener(colorListener);
        redButton.addActionListener(colorListener);
        yellowButton.addActionListener(colorListener);
        blueButton.addActionListener(colorListener);
        
        // Estado inicial dos botões
        enableColorButtons(false);
    }

    // Método auxiliar (Princípio DRY)
    private JButton createColorButton(Color color, ColorButton id) {
        var button = new JButton(); // 'var'
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 150));
        button.setActionCommand(id.name()); 
        return button;
    }

    // --- Métodos de Lógica do Jogo ---

    private void startGame() {
        sequence.clear();
        score = 0;
        playerIndex = 0;
        updateScoreboard();
        isPlayerTurn = false;
        startButton.setEnabled(false);
        nextRound();
    }

    private void nextRound() {
        isPlayerTurn = false;
        enableColorButtons(false);
        playerIndex = 0;
        
        sequence.add(ColorButton.values()[random.nextInt(4)]);
        
        playSequence(); 
    }

    private void playerTurn() {
        isPlayerTurn = true;
        enableColorButtons(true);
    }

    private void checkPlayerInput(ColorButton pressedColor) {
        if (!isPlayerTurn) return;

        // Feedback visual imediato
        highlightButton(pressedColor);
        var highlightTimer = new Timer(200, e -> highlightButton(null));
        highlightTimer.setRepeats(false);
        highlightTimer.start();

        if (sequence.get(playerIndex) == pressedColor) {
            // Acerto
            playerIndex++;
            
            if (playerIndex == sequence.size()) {
                // Jogador completou a rodada
                score++;
                updateScoreboard();
                isPlayerTurn = false;
                enableColorButtons(false);
                
                var nextRoundTimer = new Timer(1000, e -> nextRound());
                nextRoundTimer.setRepeats(false);
                nextRoundTimer.start();
            }
        } else {
            // Erro
            gameOver();
        }
    }

    private void gameOver() {
        isPlayerTurn = false;
        enableColorButtons(false);
        startButton.setEnabled(true);
        
        if (score > highScore) {
            highScore = score;
        }
        updateScoreboard();
        
        JOptionPane.showMessageDialog(this, "Game Over! Pontuação: " + score, "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateScoreboard() {
        scoreLabel.setText("Pontuação: " + score);
        recordLabel.setText("Recorde: " + highScore);
    }

    private void enableColorButtons(boolean enable) {
        greenButton.setEnabled(enable);
        redButton.setEnabled(enable);
        yellowButton.setEnabled(enable);
        blueButton.setEnabled(enable);
    }

    // --- Concorrência e Feedback Visual (Java 21) ---

    private void playSequence() {
        // Java 21: Usando Threads Virtuais (Project Loom)
        Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(1000); // Pausa antes de começar
                
                for (var color : sequence) { // 'var'
                    
                    // 1. Atualiza a GUI (pisca) -> Deve ser na EDT
                    SwingUtilities.invokeLater(() -> highlightButton(color));
                    Thread.sleep(600);
                    
                    // 2. Atualiza a GUI (apaga) -> Deve ser na EDT
                    SwingUtilities.invokeLater(() -> highlightButton(null));
                    Thread.sleep(200);
                }
                
                // 3. Habilita o turno do jogador -> Deve ser na EDT
                SwingUtilities.invokeLater(this::playerTurn); // Method reference
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    private void highlightButton(ColorButton color) {
        // Reseta todos
        greenButton.setBackground(Color.GREEN);
        redButton.setBackground(Color.RED);
        yellowButton.setBackground(Color.YELLOW);
        blueButton.setBackground(Color.BLUE);

        if (color == null) return;

        // Java 14+: Switch Expression
        var buttonToHighlight = switch (color) {
            case GREEN -> greenButton;
            case RED -> redButton;
            case YELLOW -> yellowButton;
            case BLUE -> blueButton;
        };

        // Pega a cor base e ilumina
        Color baseColor = buttonToHighlight.getBackground();
        buttonToHighlight.setBackground(baseColor.brighter().brighter());
        
        // Opcional: Tocar som
        // Toolkit.getDefaultToolkit().beep();
    }

    // --- Ponto de Entrada ---
    public static void main(String[] args) {
        // Garante a execução na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new GeniusGame().setVisible(true);
        });
    }
}
```


---



### Código Completo (Versão Final Java 21)

Este é o arquivo `GeniusGame.java` completo, aplicando todas as aulas e refatorações.

```java

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.EnumMap;

// Importações para áudio
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Jogo Genius (Simon) Clássico
 * Versão: Java 21
 * Features: GUI Swing com renderização 2D customizada, Threads Virtuais, Áudio.
 * Baseado no código original de GeniusGame.
 */
public class GeniusGameClassic extends JFrame {

    // Enum para estado de cor (type-safe)
    private enum ColorButton {
        GREEN, RED, YELLOW, BLUE
    }

    // --- Componentes da GUI ---
    private final JLabel scoreLabel;
    private final JLabel recordLabel;
    private final JButton startButton;
    private final ColorPanel colorPanel; // <--- MUDANÇA: Substitui os 4 botões

    // --- Estado do Jogo ---
    private final List<ColorButton> sequence;
    private final Random random;
    private int score;
    private int highScore = 6;
    private int playerIndex;
    private boolean isPlayerTurn;

    // --- Paleta de Cores ---
    private final Map<ColorButton, Color> baseColors;
    private final Map<ColorButton, Color> highlightColors;

    // --- Clips de Áudio ---
    private final Map<ColorButton, Clip> audioClips;

    public GeniusGameClassic() {
        setTitle("Genius Clássico (Java 21)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tamanho ajustado para o layout circular
        setSize(450, 550);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);
        // Cor de fundo da janela para combinar com o painel
        getContentPane().setBackground(Color.DARK_GRAY.darker());

        // --- Estado ---
        sequence = new ArrayList<>();
        random = new Random();
        score = 0;
        playerIndex = 0;
        isPlayerTurn = false;

        // --- Inicializa a Paleta de Cores ---
        baseColors = new EnumMap<>(Map.of(
            ColorButton.GREEN, new Color(0, 150, 0),
            ColorButton.RED, new Color(200, 0, 0),
            ColorButton.YELLOW, new Color(200, 200, 0),
            ColorButton.BLUE, new Color(0, 0, 200)
        ));

        highlightColors = new EnumMap<>(Map.of(
            ColorButton.GREEN, new Color(144, 238, 144), // Light Green
            ColorButton.RED, new Color(240, 128, 128), // Light Coral
            ColorButton.YELLOW, new Color(255, 255, 224), // Light Yellow
            ColorButton.BLUE, new Color(173, 216, 230)  // Light Blue
        ));

        // --- Inicializa e pré-carrega os sons ---
        audioClips = new EnumMap<>(ColorButton.class);
        loadSounds();

        // --- 1. Painel de Pontuação (Norte) ---
        var scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        scoreLabel = new JLabel("Pontuação: " + score);
        recordLabel = new JLabel("Recorde: " + highScore);
        scorePanel.add(scoreLabel);
        scorePanel.add(recordLabel);
        add(scorePanel, BorderLayout.NORTH);

        // --- 2. Painel de Cores (Centro) ---
        // <--- MUDANÇA: Substitui o GridLayout por nosso painel customizado ---
        colorPanel = new ColorPanel();
        add(colorPanel, BorderLayout.CENTER);
        // --- FIM DA MUDANÇA ---

        // --- 3. Painel de Controle (Sul) ---
        var controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        startButton = new JButton("Iniciar Jogo");
        controlPanel.add(startButton);
        add(controlPanel, BorderLayout.SOUTH);

        // --- 4. Registro de Eventos ---
        startButton.addActionListener(e -> startGame());

        // <--- MUDANÇA: Os ActionListeners dos botões foram removidos ---
        // A detecção de clique agora é feita dentro da classe ColorPanel.

        // Estado inicial
        enableColorButtons(false);
    }

    // <--- REMOVIDO: createColorButton() não é mais necessário ---

    // --- Métodos de Lógica do Jogo (A MAIORIA PERMANECE IDÊNTICA) ---

    private void startGame() {
        sequence.clear();
        score = 0;
        playerIndex = 0;
        updateScoreboard();
        isPlayerTurn = false;
        startButton.setEnabled(false);
        nextRound();
    }

    private void nextRound() {
        isPlayerTurn = false;
        enableColorButtons(false);
        playerIndex = 0;

        sequence.add(ColorButton.values()[random.nextInt(4)]);

        playSequence();
    }

    private void playerTurn() {
        isPlayerTurn = true;
        enableColorButtons(true);
    }

    // Este método é chamado pelo ColorPanel agora, não por ActionListeners
    private void checkPlayerInput(ColorButton pressedColor) {
        if (!isPlayerTurn) return;

        // Feedback visual e auditivo imediato
        // (O feedback visual agora é mais rápido, lidado pelo MouseListener,
        // mas vamos manter um pisque rápido para consistência)
        highlightButton(pressedColor);
        var highlightTimer = new Timer(200, e -> highlightButton(null));
        highlightTimer.setRepeats(false);
        highlightTimer.start();

        if (sequence.get(playerIndex) == pressedColor) {
            // Acerto
            playerIndex++;

            if (playerIndex == sequence.size()) {
                // Jogador completou a rodada
                score++;
                updateScoreboard();
                isPlayerTurn = false;
                enableColorButtons(false);

                var nextRoundTimer = new Timer(1000, e -> nextRound());
                nextRoundTimer.setRepeats(false);
                nextRoundTimer.start();
            }
        } else {
            // Erro
            gameOver();
        }
    }

    private void gameOver() {
        isPlayerTurn = false;
        enableColorButtons(false);
        startButton.setEnabled(true);

        if (score > highScore) {
            highScore = score;
        }
        updateScoreboard();

        JOptionPane.showMessageDialog(this, "Game Over! Pontuação: " + score, "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateScoreboard() {
        scoreLabel.setText("Pontuação: " + score);
        recordLabel.setText("Recorde: " + highScore);
    }

    // <--- MUDANÇA: Lógica de habilitar botões atualizada ---
    private void enableColorButtons(boolean enable) {
        // Agora apenas informa o painel se a entrada está ativa
        colorPanel.setInputEnabled(enable);
    }

    // --- Concorrência e Feedback Visual/Auditivo ---

    // (Lógica do Virtual Thread permanece IDÊNTICA)
    private void playSequence() {
        Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(1000);

                for (var color : sequence) {
                    SwingUtilities.invokeLater(() -> highlightButton(color));
                    Thread.sleep(600);

                    SwingUtilities.invokeLater(() -> highlightButton(null));
                    Thread.sleep(200);
                }

                SwingUtilities.invokeLater(this::playerTurn);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // <--- MUDANÇA: Lógica de destaque atualizada ---
    private void highlightButton(ColorButton color) {
        // 1. Informa ao painel qual cor destacar
        colorPanel.setHighlight(color);

        // 2. Se 'color' não for nulo, toca o som
        if (color != null) {
            // Toca o som
            playSoundFor(color);
        }
    }

    // (Lógica de Áudio permanece IDÊNTICA)
    private void loadSounds() {
        for (var color : ColorButton.values()) {
            try {
                String soundName = "/" + color.name().toLowerCase() + ".wav";
                var resource = GeniusGameClassic.class.getResource(soundName);
                if (resource == null) {
                    System.err.println("Arquivo de som não encontrado: " + soundName);
                    continue;
                }
                var audioIn = AudioSystem.getAudioInputStream(resource);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                audioClips.put(color, clip);
            } catch (Exception e) {
                System.err.println("Erro ao carregar som " + color + ": " + e.getMessage());
            }
        }
    }

    // (Lógica de Áudio permanece IDÊNTICA)
    private void playSoundFor(ColorButton color) {
        Clip clip = audioClips.get(color);
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    // --- Ponto de Entrada (IDÊNTICO) ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GeniusGameClassic().setVisible(true);
        });
    }

    // =======================================================================
    // --- CLASSE INTERNA: O NOVO PAINEL DE CORES ---
    // =======================================================================
    class ColorPanel extends JPanel {

        private ColorButton highlightedColor = null;
        private boolean isInputEnabled = false;

        // Formas dos botões para desenho e detecção de clique
        private final Map<ColorButton, Shape> buttonShapes;

        public ColorPanel() {
            // Fundo preto entre os botões
            setBackground(Color.BLACK);
            buttonShapes = new EnumMap<>(ColorButton.class);

            // Adiciona o listener de mouse para detectar cliques
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // Só processa o clique se for o turno do jogador
                    if (!isInputEnabled) return;

                    // Encontra a cor clicada
                    ColorButton clickedColor = getClickedColor(e.getX(), e.getY());

                    if (clickedColor != null) {
                        // Chama a lógica principal do jogo
                        checkPlayerInput(clickedColor);
                    }
                }
            });
        }

        /**
         * Define qual botão deve ser destacado e agenda um repaint.
         */
        public void setHighlight(ColorButton color) {
            this.highlightedColor = color;
            repaint(); // Diz ao Swing para redesenhar o painel
        }

        /**
         * Habilita ou desabilita a entrada do jogador.
         */
        public void setInputEnabled(boolean enabled) {
            this.isInputEnabled = enabled;
        }

        /**
         * Onde a mágica acontece. Este método desenha os botões.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Ativa o Anti-aliasing para bordas suaves
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);

            // Calcula as dimensões
            int width = getWidth();
            int height = getHeight();
            int size = Math.min(width, height) - 40; // Deixa uma margem de 20px
            int x = (width - size) / 2;
            int y = (height - size) / 2;

            // Define as formas dos arcos
            // Arc2D.PIE define um arco fechado (como uma fatia de pizza)
            buttonShapes.put(ColorButton.GREEN, new Arc2D.Double(x, y, size, size, 90, 90, Arc2D.PIE));
            buttonShapes.put(ColorButton.RED, new Arc2D.Double(x, y, size, size, 0, 90, Arc2D.PIE));
            buttonShapes.put(ColorButton.YELLOW, new Arc2D.Double(x, y, size, size, 270, 90, Arc2D.PIE));
            buttonShapes.put(ColorButton.BLUE, new Arc2D.Double(x, y, size, size, 180, 90, Arc2D.PIE));

            // Desenha cada botão
            drawButton(g2d, ColorButton.GREEN);
            drawButton(g2d, ColorButton.RED);
            drawButton(g2d, ColorButton.YELLOW);
            drawButton(g2d, ColorButton.BLUE);

            // --- Desenha o Círculo Central ---
            int centerSize = size / 2;
            int centerX = (width - centerSize) / 2;
            int centerY = (height - centerSize) / 2;

            // Círculo interno preto
            g2d.setColor(Color.BLACK);
            g2d.fillOval(centerX, centerY, centerSize, centerSize);

            // Borda cinza do círculo (fiel à imagem)
            g2d.setColor(Color.GRAY);
            g2d.setStroke(new BasicStroke(4)); // Borda de 4px
            g2d.drawOval(centerX, centerY, centerSize, centerSize);

            // Simula o logo "Genius" (opcional, pode ser melhorado)
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, centerSize / 6));
            FontMetrics fm = g2d.getFontMetrics();
            String text = "Genius";
            int textX = (width - fm.stringWidth(text)) / 2;
            int textY = (height - fm.getHeight()) / 2 + fm.getAscent();
            g2d.drawString(text, textX, textY);

            g2d.dispose();
        }

        /**
         * Método auxiliar para desenhar um único botão/quadrante.
         */
        private void drawButton(Graphics2D g2d, ColorButton color) {
            // Define a cor: usa a cor de destaque se for o botão destacado
            if (color == highlightedColor) {
                g2d.setColor(highlightColors.get(color));
            } else {
                g2d.setColor(baseColors.get(color));
            }

            // Preenche a forma do arco
            g2d.fill(buttonShapes.get(color));
        }

        /**
         * Verifica qual cor foi clicada com base nas coordenadas (x, y).
         */
        private ColorButton getClickedColor(int x, int y) {
            // Itera sobre as formas dos botões
            for (var entry : buttonShapes.entrySet()) {
                // `contains` verifica se o ponto (x,y) está dentro da forma
                if (entry.getValue().contains(x, y)) {
                    return entry.getKey();
                }
            }
            return null; // Nenhum botão foi clicado (clicou no centro ou fora)
        }
    }
}

```


-----

### Análise de Arquitetura e Melhorias

  * **Arquitetura Atual (MVC Simplificado):**

      * **Modelo:** As variáveis de estado (`sequence`, `score`, `isPlayerTurn`) e a lógica (`checkPlayerInput`, `nextRound`).
      * **Visão:** Os componentes Swing (`JFrame`, `JButton`, `JLabel`).
      * **Controlador:** Os `ActionListeners` e os métodos de lógica (`startGame`).
      * Neste código, as três camadas estão misturadas na classe `GeniusGame`. Para um projeto desta escala, é aceitável.

  * **Pontos de Melhoria (Próximos Passos):**

    1.  **Separação de Camadas (Refatoração):** Criar classes distintas:
          * `GameLogic` (Modelo): Conteria `sequence`, `score`, `highScore` e os métodos `nextRound`, `checkInput`. Não teria nenhuma referência ao Swing.
          * `GameView` (Visão): Conteria o `JFrame` e os componentes. Exporia métodos como `highlight(ColorButton c)` e `updateScore(int s)`.
          * `GameController` (Controlador): Conteria os `ActionListeners` e faria a ponte: "Quando `startButton` for clicado, chame `gameLogic.start()` e atualize `gameView`".
    2.  **JavaFX:** Substituir Swing por JavaFX, a plataforma de GUI moderna do Java. O gerenciamento de concorrência é similar (usando `Platform.runLater()` em vez de `SwingUtilities.invokeLater()`).
    3.  **Som:** Adicionar feedback de áudio. O clássico `Toolkit.getDefaultToolkit().beep()` é limitado. Seria melhor usar `javax.sound.sampled` para tocar arquivos `.wav` específicos para cada cor.
    4.  **Testes Unitários:** A lógica do `GameLogic` (se separada) poderia ser facilmente testada unitariamente (JUnit 5) sem depender da GUI, verificando se `checkInput` retorna o resultado correto para uma sequência conhecida.

---


