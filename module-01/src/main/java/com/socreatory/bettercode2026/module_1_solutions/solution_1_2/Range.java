package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `Range` mit Cross-Field-Validierung im Prolog (Bonus).
///
/// Klassisches FCB-Beispiel: Cross-Field-Validierung steht direkt vor `super(...)`.
/// Bei `new Range(10, 5)` fliegt die Exception – `super(...)` wird nie erreicht,
/// das Objekt wird nie konstruiert.
public class Range extends NumericInterval {

    public Range(int min, int max) {
        // Bonus (gelöst): Cross-Field-Prüfung im Prolog.
        if (min > max) {
            throw new IllegalArgumentException("min " + min + " > max " + max);
        }
        super(min, max);
    }
}
