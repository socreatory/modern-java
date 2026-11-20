package com.socreatory.bettercode2026.module_1.exercise_1_2;

/// Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// `NormalizedEmail` erbt von `Contact` und speichert zusätzlich die Domain (Teil hinter
/// dem `@`). Beide Werte – die normalisierte Mail-Adresse und die Domain – leiten sich
/// aus dem Roh-Eingabe-String ab.
///
/// Aktuell wird die Normalisierung über zwei `static`-Helper umgesetzt: `normalize` für
/// die Mail-Adresse selbst und `extractDomain` für die Domain. `extractDomain` ruft
/// intern wieder `normalize` auf – die Normalisierung passiert also *doppelt*.
///
/// **Dein Job (TODO 2):**
///
/// Stelle den Konstruktor auf Flexible Constructor Bodies um. Berechne den normalisierten
/// Wert *einmal* als lokale Variable im Prolog und gib ihn sowohl an `super(...)` als
/// auch ans eigene Feld `this.domain` weiter. Die zwei `static`-Helper fallen damit weg.
public class NormalizedEmail extends Contact {

    private final String domain;

    public NormalizedEmail(String rawEmail) {
        // TODO 2: Validierung und Normalisierung in den Prolog ziehen.
        //         Den normalisierten Wert als lokale Variable berechnen und an
        //         super(...) sowie an this.domain weitergeben – nur eine Berechnung
        //         statt der aktuellen zwei.
        super(normalize(rawEmail));
        this.domain = extractDomain(rawEmail);
    }

    public String domain() { return domain; }

    @Override
    public String toString() {
        return "NormalizedEmail[email=" + email() + ", domain=" + domain + "]";
    }

    private static String normalize(String rawEmail) {
        if (rawEmail == null || !rawEmail.contains("@")) {
            throw new IllegalArgumentException("invalid email: " + rawEmail);
        }
        return rawEmail.strip().toLowerCase();
    }

    private static String extractDomain(String rawEmail) {
        String normalized = normalize(rawEmail);
        return normalized.substring(normalized.indexOf('@') + 1);
    }
}
