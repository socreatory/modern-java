package com.socreatory.bettercode2026.module_3.exercise_3_3;

import java.math.BigDecimal;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Eine geladene Bestellung – bei ADMIN-Rolle zusätzlich mit Admin-Informationen.
public record Order(int orderId, String description, BigDecimal amount, String adminInfo) {

    public Order(int orderId, String description, BigDecimal amount) {
        this(orderId, description, amount, null);
    }

    public Order withAdminInfo(String info) {
        return new Order(orderId, description, amount, info);
    }
}
