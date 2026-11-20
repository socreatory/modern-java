package com.socreatory.bettercode2026.module_3.exercise_3_3;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Adapter zwischen REST-Schicht und Use Case. Reine Durchgangs-Schicht für den
/// `user` – nutzt ihn selbst nicht.
///
/// **Dein Job (TODO 3):**
///
/// Entferne den `User`-Parameter aus der Signatur und aus dem Aufruf an den Use Case.
/// Der Adapter soll den User gar nicht mehr sehen.
public final class RestAdapter {

    private final OrderUseCase useCase;

    public RestAdapter(OrderUseCase useCase) {
        this.useCase = useCase;
    }

    public Order process(Payload payload, User user) {
        // TODO 3: User-Parameter weg, useCase-Aufruf entsprechend anpassen.
        return useCase.execute(payload.orderId(), user);
    }
}
