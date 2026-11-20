package com.socreatory.bettercode2026.module_3.exercise_3_3;

import java.util.Set;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Empfängt einen Request, authentifiziert den User, delegiert an den `RestAdapter`
/// und gibt die geladene Order auf der Konsole aus.
///
/// **Dein Job (TODO 2):**
///
/// Lege einen `ScopedValue`-Scope um den `restAdapter.process(...)`-Aufruf, in dem
/// `USER` an `user` gebunden ist. Den `user`-Parameter aus dem `process`-Aufruf
/// entfernen – die Mittelschicht soll den User nicht mehr sehen. Das `println` wandert
/// in das `run`-Lambda hinein.
public final class Server {

    private final RestAdapter restAdapter;

    public Server(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    public void handle(Request request) {
        User user = authenticateUser(request);

        // TODO 2: USER mit einem ScopedValue-Scope binden.
        //         Der restAdapter-Aufruf und das println wandern in das Lambda.
        Order order = restAdapter.process(request.payload(), user);
        IO.println(order);
    }

    /// Stub-Authentifizierung: liefert anhand des Auth-Tokens einen Test-User.
    private static User authenticateUser(Request request) {
        return switch (request.authToken()) {
            case "user-token"  -> new User("u-1", "alice",    Set.of(Role.USER));
            case "admin-token" -> new User("u-2", "the boss", Set.of(Role.USER, Role.ADMIN));
            default -> throw new IllegalArgumentException("unknown token: " + request.authToken());
        };
    }
}
