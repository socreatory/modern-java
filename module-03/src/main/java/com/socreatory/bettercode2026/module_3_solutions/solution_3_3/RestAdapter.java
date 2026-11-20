package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// `RestAdapter`.
///
/// Auch hier ist der `User`-Parameter weg. Der Adapter weiß nichts vom User.
public final class RestAdapter {

    private final OrderUseCase useCase;

    public RestAdapter(OrderUseCase useCase) {
        this.useCase = useCase;
    }

    public Order process(Payload payload) {
        // TODO 3 (gelöst): Kein User-Parameter mehr.
        return useCase.execute(payload.orderId());
    }
}
