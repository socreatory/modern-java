package com.socreatory.bettercode2026.module_1_solutions.solution_1_2;

/// Lösung zu Übung 1.2 – Flexible Constructor Bodies (Java 25)
///
/// Basisklasse zu `NormalizedEmail`. Unverändert.
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
