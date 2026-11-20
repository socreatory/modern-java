package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `BoundedCounter` mit Flexible Constructor Bodies.
///
/// Die Cross-Field-Prüfung steht jetzt direkt im Prolog. Die `static checkBounds`-Methode
/// ist weggefallen – Validierung sitzt da, wo sie konzeptionell hingehört.
public class BoundedCounter extends Counter {

    public BoundedCounter(int initial, int min, int max) {
        // TODO 1 (gelöst): if-Prüfung steht jetzt im Prolog, direkt vor super(...).
        //                  Im Prolog dürfen wir Konstruktor-Parameter lesen, lokale
        //                  Variablen anlegen und throw-en.
        if (initial < min || initial > max) {
            throw new IllegalArgumentException(
                    "initial " + initial + " out of bounds [" + min + ", " + max + "]");
        }
        super(initial, min, max);
    }
}
