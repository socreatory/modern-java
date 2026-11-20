package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

import java.util.function.Supplier;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `Main`.
///
/// Erwartete Ausgabe:
///
/// ```
/// --- BoundedCounter ---
///   ✓ Counter[initial=5, min=0, max=10]
///   ✓ Counter[initial=0, min=0, max=10]
///   ✓ Counter[initial=10, min=0, max=10]
///   ✗ IllegalArgumentException: initial 15 out of bounds [0, 10]
///   ✗ IllegalArgumentException: initial -1 out of bounds [0, 10]
///
/// --- NormalizedEmail ---
///   ✓ NormalizedEmail[email=alice@acme.com, domain=acme.com]
///   ✓ NormalizedEmail[email=bob@globex.io, domain=globex.io]
///   ✗ IllegalArgumentException: invalid email: kein-at-zeichen
///   ✗ IllegalArgumentException: invalid email: null
///
/// --- Range ---
///   ✓ [0, 10]
///   ✗ IllegalArgumentException: min 10 > max 5
/// ```
public class Main {

    void main() {
        IO.println("--- BoundedCounter ---");
        runSafe(() -> new BoundedCounter(5, 0, 10));
        runSafe(() -> new BoundedCounter(0, 0, 10));
        runSafe(() -> new BoundedCounter(10, 0, 10));
        runSafe(() -> new BoundedCounter(15, 0, 10));
        runSafe(() -> new BoundedCounter(-1, 0, 10));

        IO.println();
        IO.println("--- NormalizedEmail ---");
        runSafe(() -> new NormalizedEmail("Alice@Acme.COM"));
        runSafe(() -> new NormalizedEmail("  bob@globex.io  "));
        runSafe(() -> new NormalizedEmail("kein-at-zeichen"));
        runSafe(() -> new NormalizedEmail(null));

        IO.println();
        IO.println("--- Range ---");
        runSafe(() -> new Range(0, 10));
        runSafe(() -> new Range(10, 5));   // Bonus
    }

    private void runSafe(Supplier<Object> ctor) {
        try {
            IO.println("  ✓ " + ctor.get());
        } catch (RuntimeException e) {
            IO.println("  ✗ " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
