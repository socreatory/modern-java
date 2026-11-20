package com.socreatory.bettercode2026.module_3.exercise_3_3;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Treiber: baut die Kette `Server → RestAdapter → OrderUseCase → OrderRepository` auf und
/// schickt zwei Requests hindurch. Der `User` wandert aktuell als Parameter durch alle drei
/// Schichten, obwohl ihn nur das `OrderRepository` braucht.
///
/// **Dein Job:**
///
///   - Lass `Main` einmal laufen und merk dir die Ausgabe.
///
///   - TODO 1: Lege in diesem Paket eine neue Klasse `RequestContext` an – mit einer
///     öffentlichen Konstante `USER` vom Typ `ScopedValue<User>`, initialisiert mit
///     `ScopedValue.newInstance()`.
///
///   - TODO 2 bis 4 stehen in [Server], [RestAdapter], [OrderUseCase] und
///     [OrderRepository]: `USER` im `Server` binden, den `User`-Parameter aus den drei
///     Signaturen entfernen und den User im Repository aus dem `ScopedValue` lesen.
///
///   - Lass `Main` noch einmal laufen. Die Ausgabe muss dieselbe sein wie vorher.
public class Main {

    void main() {
        Server server = new Server(new RestAdapter(new OrderUseCase(new OrderRepository())));

        IO.println("--- Request mit USER-Token ---");
        server.handle(new Request("user-token", new Payload(42)));

        IO.println();
        IO.println("--- Request mit ADMIN-Token ---");
        server.handle(new Request("admin-token", new Payload(99)));
    }
}
