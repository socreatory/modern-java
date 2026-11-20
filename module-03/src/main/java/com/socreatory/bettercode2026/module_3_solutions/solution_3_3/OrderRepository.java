package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

import java.math.BigDecimal;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// `OrderRepository`.
///
/// Liest den aktuellen `User` aus `RequestContext.USER.get()` statt als Parameter.
/// Der `ADMIN`-Check selbst ist unverändert.
public final class OrderRepository {

    public Order load(int orderId) {
        Order order = new Order(orderId, "Order #" + orderId,
                BigDecimal.valueOf(orderId * 19.99));

        // TODO 4 (gelöst): User direkt aus dem ScopedValue lesen. .get() wirft eine
        //                  NoSuchElementException, falls niemand vorher den Scope
        //                  geöffnet hat – das ist die Lifetime-Garantie.
        User user = RequestContext.USER.get();
        if (user.hasRole(Role.ADMIN)) {
            return order.withAdminInfo("loaded by " + user.name() + " · internal DB v3");
        }
        return order;
    }
}
