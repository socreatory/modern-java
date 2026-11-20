package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

import java.math.BigDecimal;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Eine Bestellung – Id, Kund:innen-Id und Gesamtbetrag.
public record Order(int orderId, int customerId, BigDecimal total) {
}
