import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.EnumMap;

// Importações para áudio
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Jogo Genius (Simon) Completo
 * Versão: Java 21
 * Features: GUI Swing, Threads Virtuais, Feedback Visual Aprimorado e Áudio.
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

    // --- Paleta de Cores (Aula 5) ---
    private final Map<ColorButton, Color> baseColors;
    private final Map<ColorButton, Color> highlightColors;

    // --- Clips de Áudio (Aula 6) ---
    private final Map<ColorButton, Clip> audioClips;

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

        // --- Inicializa a Paleta de Cores (Aula 5) ---
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

        // --- Inicializa e pré-carrega os sons (Aula 6) ---
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
        var colorPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        greenButton = createColorButton(ColorButton.GREEN);
        redButton = createColorButton(ColorButton.RED);
        yellowButton = createColorButton(ColorButton.YELLOW);
        blueButton = createColorButton(ColorButton.BLUE);

        colorPanel.add(greenButton);
        colorPanel.add(redButton);
        colorPanel.add(yellowButton);
        colorPanel.add(blueButton);
        add(colorPanel, BorderLayout.CENTER);

        // --- 3. Painel de Controle (Sul) ---
        var controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
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

    // Método auxiliar (DRY) - Modificado Aula 5
    private JButton createColorButton(ColorButton id) {
        var button = new JButton();
        button.setBackground(baseColors.get(id)); // Usa cor base
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

        // Feedback visual e auditivo imediato
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

    // --- Concorrência e Feedback Visual/Auditivo ---

    // (Aula 4: Java 21 Virtual Threads)
    private void playSequence() {
        Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(1000); // Pausa antes de começar

                for (var color : sequence) {

                    // 1. Atualiza a GUI (pisca) -> Deve ser na EDT
                    SwingUtilities.invokeLater(() -> highlightButton(color));
                    Thread.sleep(600);

                    // 2. Atualiza a GUI (apaga) -> Deve ser na EDT
                    SwingUtilities.invokeLater(() -> highlightButton(null));
                    Thread.sleep(200);
                }

                // 3. Habilita o turno do jogador -> Deve ser na EDT
                SwingUtilities.invokeLater(this::playerTurn);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // (Aula 6: Feedback Visual e Auditivo)
    private void highlightButton(ColorButton color) {
        // 1. Reseta todos os botões para a cor base
        greenButton.setBackground(baseColors.get(ColorButton.GREEN));
        redButton.setBackground(baseColors.get(ColorButton.RED));
        yellowButton.setBackground(baseColors.get(ColorButton.YELLOW));
        blueButton.setBackground(baseColors.get(ColorButton.BLUE));

        // 2. Se 'color' não for nulo, acende o botão e toca o som
        if (color != null) {
            var buttonToHighlight = switch (color) {
                case GREEN -> greenButton;
                case RED -> redButton;
                case YELLOW -> yellowButton;
                case BLUE -> blueButton;
            };

            buttonToHighlight.setBackground(highlightColors.get(color));

            // Toca o som
            playSoundFor(color);
        }
    }

    // (Aula 6: Carregamento de Áudio)
    private void loadSounds() {
        for (var color : ColorButton.values()) {
            try {
                // Caminho relativo à raiz do classpath (src/main/resources)
                String soundName = "/" + color.name().toLowerCase() + ".wav";

                var resource = GeniusGame.class.getResource(soundName);
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

    // (Aula 6: Execução de Áudio)
    private void playSoundFor(ColorButton color) {
        Clip clip = audioClips.get(color);

        if (clip != null) {
            clip.stop(); // Para o som se estiver tocando
            clip.setFramePosition(0); // "Rebobina"
            clip.start();
        } else {
            // Fallback: Se o .wav falhou ao carregar
            Toolkit.getDefaultToolkit().beep();
        }
    }

    // --- Ponto de Entrada ---
    public static void main(String[] args) {
        // Garante a execução na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new GeniusGame().setVisible(true);
        });
    }
}