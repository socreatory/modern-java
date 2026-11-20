package com.socreatory.bettercode2026.module_1.exercise_1_2;

/// Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `Range` erbt von `NumericInterval`. Heute *ohne* Validierung – `new Range(10, 5)`
/// produziert einen invaliden Zustand.
///
/// **Bonus-Job:**
///
/// Ergänze einen Prolog mit Cross-Field-Validierung, der `min > max` ablehnt. Die
/// `Main` ruft `new Range(10, 5)` bereits auf – beobachte die Exception nach deiner Änderung.
public class Range extends NumericInterval {

    public Range(int min, int max) {
        // Bonus: hier einen Prolog mit Cross-Field-Validierung ergänzen.
        super(min, max);
    }
}
