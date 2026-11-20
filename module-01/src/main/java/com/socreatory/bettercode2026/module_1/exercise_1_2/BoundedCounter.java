package com.socreatory.bettercode2026.module_1.exercise_1_2;

/// Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `BoundedCounter` erbt von `Counter` und prüft im Konstruktor, dass `initial` zwischen
/// `min` und `max` liegt. Aktuell wird die Prüfung über eine `static checkBounds`-
/// Helper-Methode umgesetzt, weil `super(...)` in Java 24- die erste Anweisung sein musste.
///
/// **Dein Job (TODO 1):**
///
/// Stelle den Konstruktor auf Flexible Constructor Bodies (Java 25) um. Die `if`-Prüfung
/// wandert in den Prolog vor `super(...)`. Die `static checkBounds`-Methode wird damit
/// überflüssig und kann komplett entfernt werden.
public class BoundedCounter extends Counter {

    public BoundedCounter(int initial, int min, int max) {
        // TODO 1: if-Prüfung in den Prolog ziehen und super(initial, min, max) aufrufen.
        //         Die static checkBounds-Methode wird dann nicht mehr gebraucht.
        super(checkBounds(initial, min, max), min, max);
    }

    private static int checkBounds(int initial, int min, int max) {
        if (initial < min || initial > max) {
            throw new IllegalArgumentException(
                    "initial " + initial + " out of bounds [" + min + ", " + max + "]");
        }
        return initial;
    }
}
