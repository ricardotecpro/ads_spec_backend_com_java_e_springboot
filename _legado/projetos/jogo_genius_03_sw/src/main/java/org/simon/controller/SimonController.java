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
