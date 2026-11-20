package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// Basisklasse zu `Range` (Bonus). Unverändert.
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
