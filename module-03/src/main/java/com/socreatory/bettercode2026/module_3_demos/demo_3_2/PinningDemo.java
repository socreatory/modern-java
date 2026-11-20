package com.socreatory.bettercode2026.module_3_demos.demo_3_2;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;

/// Demo 3.2 – Pinning-Effekt sichtbar machen (Java 24)
///
/// Demo zu Modul 3, Teil 2. Läuft bewusst in der klassischen Form, damit sie auch mit Java 21 startet.
///
/// 360 virtuelle Threads, jeder mit einer eigenen `Service`-Instanz. Da `synchronized`
/// an einer Methode auf `this` lockt und jede VT auf einer anderen Instanz arbeitet,
/// gibt es **keine** inhaltliche Lock-Contention zwischen den VTs. Die einzige
/// Serialisierung kommt – pre-Java-24 – aus dem Pinning.
///
/// **Erwartete Laufzeiten (Beispielwerte auf einem 18-Core-Rechner):**
///
///  - Java 21 – 23: ca. 4,0 s. Jeder VT pinnt während `sleep` seinen Carrier;
///    es sind nur so viele VTs gleichzeitig im `synchronized`-Block wie Carrier
///    vorhanden sind (≈ CPU-Cores). 360 / 18 × 200 ms ≈ 4,0 s.
///  - Java 24+: ca. 200 ms. Jeder VT unmountet während `sleep`, alle 360 VTs
///    schlafen parallel.
public final class PinningDemo {

    static class Service {
        public synchronized void doWork() throws InterruptedException {
            Thread.sleep(Duration.ofMillis(200));
        }
    }

    private PinningDemo() {}

    public static void main(String[] args) {
        Instant start = Instant.now();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 360; i++) {
                Service service = new Service();      // 360 separate Locks!
                executor.submit(() -> { service.doWork(); return null; });
            }
        }

        System.out.println("Dauer: " + Duration.between(start, Instant.now()));
    }
}
