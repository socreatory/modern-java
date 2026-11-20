package com.socreatory.bettercode2026.module_3.exercise_3_2;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Kund:in einer Bestellung – Id, Name und E-Mail-Adresse.
public record Customer(int customerId, String name, String email) {
}
