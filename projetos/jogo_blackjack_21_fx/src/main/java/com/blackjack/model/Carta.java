package com.blackjack.model;

public record Carta(Nipe nipe, Rank rank) {
    @Override
    public String toString() {
        return rank.display + nipe.simbolo;
    }
}