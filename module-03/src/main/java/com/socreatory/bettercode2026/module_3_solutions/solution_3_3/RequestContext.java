package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// `RequestContext` mit `ScopedValue<User>`.
///
/// Der `User` wird einmal im `Server` gebunden und tief unten im `OrderRepository`
/// gelesen. Die Mittelschicht (`RestAdapter`, `OrderUseCase`) sieht ihn nicht.
public final class RequestContext {

    // TODO 1 (gelöst): ScopedValue<User> als public static final Konstante.
    //                  Aufrufer binden per where(USER, user).run(...) / .call(...),
    //                  lesen per USER.get().
    public static final ScopedValue<User> USER = ScopedValue.newInstance();

    private RequestContext() {}
}
