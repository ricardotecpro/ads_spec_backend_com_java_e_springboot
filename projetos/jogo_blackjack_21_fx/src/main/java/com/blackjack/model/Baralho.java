package com.blackjack.model;

import java.util.Collections;
import java.util.Stack;

public class Baralho {
    private final Stack<Carta> cartas = new Stack<>();

    public void reiniciar() {
        cartas.clear();
        for (Nipe n : Nipe.values()) {
            for (Rank r : Rank.values()) {
                cartas.push(new Carta(n, r));
            }
        }
        Collections.shuffle(cartas); // O shuffle do Java é mais otimizado que o manual
    }

    public Carta comprar() {
        return cartas.isEmpty() ? null : cartas.pop();
    }
}