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
