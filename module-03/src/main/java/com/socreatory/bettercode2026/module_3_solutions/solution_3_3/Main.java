package com.socreatory.bettercode2026.module_3_solutions.solution_3_3;

/// Lösung zu Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// `Main`.
///
/// Erwartete Ausgabe – zeichengenau identisch zur Vorher-Variante (`Server.handle`
/// gibt die Order selbst aus):
///
/// ```
/// --- Request mit USER-Token ---
/// Order[orderId=42, description=Order #42, amount=839.5799999999999, adminInfo=null]
///
/// --- Request mit ADMIN-Token ---
/// Order[orderId=99, description=Order #99, amount=1979.0099999999998, adminInfo=loaded by the boss · internal DB v3]
/// ```
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
