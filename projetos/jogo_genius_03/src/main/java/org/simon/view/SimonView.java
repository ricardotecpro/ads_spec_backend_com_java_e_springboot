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
