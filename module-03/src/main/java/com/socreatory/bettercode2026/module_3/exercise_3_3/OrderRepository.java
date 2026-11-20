package com.socreatory.bettercode2026.module_3.exercise_3_3;

import java.math.BigDecimal;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Lädt eine Order und reichert sie um Admin-Informationen an, falls der
/// aktuelle User die `ADMIN`-Rolle hat.
///
/// **Dein Job (TODO 4):**
///
/// Hole den aktuellen User nicht mehr als Parameter, sondern aus dem `ScopedValue`,
/// den du in `RequestContext` deklariert hast. Entferne den `User`-Parameter aus
/// der Signatur.
public final class OrderRepository {

    public Order load(int orderId, User user) {
        Order order = new Order(orderId, "Order #" + orderId,
                BigDecimal.valueOf(orderId * 19.99));

        // TODO 4: User nicht mehr als Parameter, sondern aus dem ScopedValue lesen.
        if (user.hasRole(Role.ADMIN)) {
            return order.withAdminInfo("loaded by " + user.name() + " · internal DB v3");
        }
        return order;
    }
}
