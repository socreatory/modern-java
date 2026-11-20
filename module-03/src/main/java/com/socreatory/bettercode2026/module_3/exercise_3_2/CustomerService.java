package com.socreatory.bettercode2026.module_3.exercise_3_2;

import java.util.concurrent.ThreadLocalRandom;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Simuliert den Customer-Service. Wie [OrderService]: ~200 ms Latenz, 20 %
/// Fehler-Wahrscheinlichkeit.
public final class CustomerService {

    private CustomerService() {}

    public static Customer getCustomer(int customerId) throws InterruptedException {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
        } catch (InterruptedException e) {
            IO.println("CustomerService: interrupted");
            throw e;
        }
        if (ThreadLocalRandom.current().nextInt(100) < 20) {
            IO.println("CustomerService: throwing 'Service down: customer'");
            throw new RuntimeException("Service down: customer");
        }
        Customer customer = new Customer(customerId, "Anna Müller", "anna.mueller@example.com");
        IO.println("CustomerService: returning " + customer);
        return customer;
    }
}
