package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

import java.util.Set;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// `Server`.
///
/// Authentifiziert den User, öffnet einen `ScopedValue`-Scope um `USER` und ruft
/// den `RestAdapter` *innerhalb* des `run`-Lambdas auf. Die geladene Order wird
/// ebenfalls im Lambda ausgegeben.
public final class Server {

    private final RestAdapter restAdapter;

    public Server(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    public void handle(Request request) {
        User user = authenticateUser(request);

        // TODO 2 (gelöst): where(USER, user).run(() -> ...) öffnet den Scope. Die
        //                  Bindung gilt für die Dauer des Lambdas, danach wieder
        //                  ungebunden. Aufruf an restAdapter.process und println
        //                  liegen drin – beide laufen im gebundenen Scope.
        ScopedValue.where(RequestContext.USER, user).run(() -> {
            Order order = restAdapter.process(request.payload());
            IO.println(order);
        });
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
