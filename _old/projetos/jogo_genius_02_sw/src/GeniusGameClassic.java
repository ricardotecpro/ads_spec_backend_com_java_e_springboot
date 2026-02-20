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