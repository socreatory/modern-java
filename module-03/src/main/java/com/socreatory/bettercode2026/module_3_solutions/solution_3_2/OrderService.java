package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Simuliert einen Order-Microservice-Aufruf: ~200 ms Latenz, 20 % Fehlerquote.
public final class OrderService {

    private OrderService() {}

    public static Order getOrder(int orderId) throws InterruptedException {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
        } catch (InterruptedException e) {
            IO.println("OrderService: interrupted");
            throw e;
        }
        if (ThreadLocalRandom.current().nextInt(100) < 20) {
            IO.println("OrderService: throwing 'Service down: order'");
            throw new RuntimeException("Service down: order");
        }
        Order order = new Order(orderId, 4711, new BigDecimal("199.95"));
        IO.println("OrderService: returning " + order);
        return order;
    }
}
