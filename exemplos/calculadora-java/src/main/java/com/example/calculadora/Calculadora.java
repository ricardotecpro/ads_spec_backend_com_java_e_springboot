// src/main/java/com/example/calculadora/Calculadora.java
package com.example.calculadora;

public class Calculadora {
    public static void main(String[] args) {
        System.out.println("Soma de 5 + 3 = " + soma(5, 3));
        System.out.println("Subtração de 5 - 3 = " + subtrai(5, 3));
        System.out.println("Multiplicação de 5 * 3 = " + multiplica(5, 3));
        System.out.println("Divisão de 5 / 3 = " + divide(5, 3));
    }

    public static int soma(int a, int b) {
        return a + b;
    }

    public static int subtrai(int a, int b) {
        return a - b;
    }

    public static int multiplica(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divisão por zero não é permitida.");
        return (double) a / b;
    }
}
