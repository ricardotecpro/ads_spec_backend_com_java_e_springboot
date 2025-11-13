package com.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Mao {
    private final List<Carta> cartas = new ArrayList<>();

    public void adicionar(Carta c) {
        cartas.add(c);
    }

    public void limpar() {
        cartas.clear();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int calcularPontuacao() {
        int pontos = 0;
        int ases = 0;

        for (Carta c : cartas) {
            pontos += c.rank().valorBase;
            if (c.rank() == Rank.AS) ases++;
        }

        // Lógica do Ás: se estourar 21, conta como 1 (subtrai 10)
        while (pontos > 21 && ases > 0) {
            pontos -= 10;
            ases--;
        }
        return pontos;
    }
}