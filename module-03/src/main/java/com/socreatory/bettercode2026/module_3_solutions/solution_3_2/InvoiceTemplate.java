package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Sprachabhängige Rechnungs-Vorlage mit Kopf- und Fußzeile.
public record InvoiceTemplate(String language, String header, String footer) {
}
