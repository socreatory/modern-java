package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `NormalizedEmail` mit Flexible Constructor Bodies.
///
/// Der normalisierte Wert wird *einmal* im Prolog als lokale Variable berechnet und
/// dann an `super(...)` sowie an `this.domain` weitergegeben. Die zwei `static`-Helper
/// von vorher sind weggefallen.
public class NormalizedEmail extends Contact {

    private final String domain;

    public NormalizedEmail(String rawEmail) {
        // TODO 2 (gelöst): Validierung und Normalisierung im Prolog.
        //                  `normalized` wird einmal berechnet, zweimal verwendet:
        //                  super(normalized) und this.domain = ...
        if (rawEmail == null || !rawEmail.contains("@")) {
            throw new IllegalArgumentException("invalid email: " + rawEmail);
        }
        String normalized = rawEmail.strip().toLowerCase();

        super(normalized);
        this.domain = normalized.substring(normalized.indexOf('@') + 1);
    }

    public String domain() { return domain; }

    @Override
    public String toString() {
        return "NormalizedEmail[email=" + email() + ", domain=" + domain + "]";
    }
}
