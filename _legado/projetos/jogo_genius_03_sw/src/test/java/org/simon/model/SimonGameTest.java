package org.simon.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SimonGameTest {

    @Test
    void addAndValidate() {
        // predictable Random
        SimonGame g = new SimonGame(new Random(0));
        int a = g.addRandomStep(4);
        int b = g.addRandomStep(4);
        List<Integer> seq = g.getSequence();
        assertEquals(2, seq.size());
        assertTrue(g.validatePrefix(List.of(seq.get(0))));
        assertTrue(g.validatePrefix(seq));
        assertFalse(g.validatePrefix(List.of(3,3,3)));
    }
}
