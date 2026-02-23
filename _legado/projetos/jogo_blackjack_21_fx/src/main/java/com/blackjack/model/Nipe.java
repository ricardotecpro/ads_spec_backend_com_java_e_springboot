package com.blackjack.model;

public enum Nipe {
    COPAS("♥", "red"),
    OUROS("♦", "red"),
    PAUS("♣", "black"),
    ESPADAS("♠", "black");

    public final String simbolo;
    public final String corCss;

    Nipe(String simbolo, String corCss) {
        this.simbolo = simbolo;
        this.corCss = corCss;
    }
}