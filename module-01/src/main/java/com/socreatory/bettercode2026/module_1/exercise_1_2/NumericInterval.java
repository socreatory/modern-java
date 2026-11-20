package com.socreatory.bettercode2026.module_1.exercise_1_2;

/// Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// Basisklasse für `Range` (Bonus-Aufgabe). Diese Klasse musst du nicht anfassen.
public class NumericInterval {

    private final int min;
    private final int max;

    public NumericInterval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int min() { return min; }
    public int max() { return max; }

    @Override
    public String toString() {
        return "[" + min + ", " + max + "]";
    }
}
