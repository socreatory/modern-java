package com.socreatory.bettercode2026.module_3.exercise_3_2;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Sprachabhängige Rechnungs-Vorlage mit Kopf- und Fußzeile.
public record InvoiceTemplate(String language, String header, String footer) {
}
