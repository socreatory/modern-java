package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// Basisklasse zu `BoundedCounter`. Unverändert.
public class Counter {

    private final int initial;
    private final int min;
    private final int max;

    public Counter(int initial, int min, int max) {
        this.initial = initial;
        this.min = min;
        this.max = max;
    }

    public int initial() { return initial; }
    public int min()     { return min; }
    public int max()     { return max; }

    @Override
    public String toString() {
        return "Counter[initial=" + initial + ", min=" + min + ", max=" + max + "]";
    }
}
