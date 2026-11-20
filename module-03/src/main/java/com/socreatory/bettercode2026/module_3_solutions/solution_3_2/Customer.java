package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Kund:in einer Bestellung – Id, Name und E-Mail-Adresse.
public record Customer(int customerId, String name, String email) {
}
