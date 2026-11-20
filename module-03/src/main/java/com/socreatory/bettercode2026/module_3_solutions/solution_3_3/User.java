package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

import java.util.Set;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Ein authentifizierter User mit Id, Name und Rollen.
public record User(String id, String name, Set<Role> roles) {

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }
}
