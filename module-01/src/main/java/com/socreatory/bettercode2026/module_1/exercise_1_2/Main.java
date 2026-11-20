package com.socreatory.bettercode2026.module_1.exercise_1_2;

import java.util.function.Supplier;

/// Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// Treiber: legt `BoundedCounter`, `NormalizedEmail` und `Range` an und zeigt, wie sich die Validierung heute verhält.
public class Main {

    void main() {
        IO.println("--- BoundedCounter ---");
        runSafe(() -> new BoundedCounter(5, 0, 10));     // ok
        runSafe(() -> new BoundedCounter(0, 0, 10));     // ok (Rand)
        runSafe(() -> new BoundedCounter(10, 0, 10));    // ok (Rand)
        runSafe(() -> new BoundedCounter(15, 0, 10));    // ungültig
        runSafe(() -> new BoundedCounter(-1, 0, 10));    // ungültig

        IO.println();
        IO.println("--- NormalizedEmail ---");
        runSafe(() -> new NormalizedEmail("Alice@Acme.COM"));
        runSafe(() -> new NormalizedEmail("  bob@globex.io  "));
        runSafe(() -> new NormalizedEmail("kein-at-zeichen"));   // ungültig
        runSafe(() -> new NormalizedEmail(null));                // ungültig

        IO.println();
        IO.println("--- Range ---");
        runSafe(() -> new Range(0, 10));                 // ok
        runSafe(() -> new Range(10, 5));                 // Bonus: erst nach Validierung ungültig
    }

    private void runSafe(Supplier<Object> ctor) {
        try {
            IO.println("  ✓ " + ctor.get());
        } catch (RuntimeException e) {
            IO.println("  ✗ " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
