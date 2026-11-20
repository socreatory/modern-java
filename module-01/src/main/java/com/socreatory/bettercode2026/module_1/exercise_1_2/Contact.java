package com.socreatory.bettercode2026.module_1.exercise_1_2;

/// Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// Basisklasse für `NormalizedEmail`. Speichert die normalisierte Mail-Adresse.
/// Diese Klasse musst du nicht anfassen.
public class Contact {

    private final String email;

    public Contact(String email) {
        this.email = email;
    }

    public String email() { return email; }

    @Override
    public String toString() {
        return "Contact[email=" + email + "]";
    }
}
