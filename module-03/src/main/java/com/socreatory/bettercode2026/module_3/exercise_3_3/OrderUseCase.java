package com.socreatory.bettercode2026.module_3.exercise_3_3;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Fachliche Logik für Order-Abfragen. Reine Durchgangs-Schicht für den `user` –
/// nutzt ihn selbst nicht.
///
/// **Dein Job (TODO 3):**
///
/// Entferne den `User`-Parameter aus der Signatur und aus dem Aufruf ans Repository.
public final class OrderUseCase {

    private final OrderRepository repository;

    public OrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(int orderId, User user) {
        // TODO 3: User-Parameter weg, repository-Aufruf entsprechend anpassen.
        return repository.load(orderId, user);
    }
}
