package com.socreatory.bettercode2026.module_3.exercise_3_2;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Simuliert einen Order-Microservice-Aufruf. Die `getOrder`-Methode blockiert ca. 200 ms
/// (wie ein typischer API-Call) und wirft mit 20 % Wahrscheinlichkeit eine
/// `RuntimeException`, damit ihr den Fehlerfall mit `StructuredTaskScope` beobachten könnt.
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
