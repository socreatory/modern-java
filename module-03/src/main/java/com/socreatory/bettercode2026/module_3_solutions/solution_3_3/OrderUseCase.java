package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// `OrderUseCase`.
///
/// Der `User`-Parameter ist aus der Signatur und aus dem Repository-Aufruf
/// verschwunden. Der UseCase weiß nichts vom User – reine Durchgangs-Schicht.
public final class OrderUseCase {

    private final OrderRepository repository;

    public OrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(int orderId) {
        // TODO 3 (gelöst): Kein User-Parameter mehr.
        return repository.load(orderId);
    }
}
