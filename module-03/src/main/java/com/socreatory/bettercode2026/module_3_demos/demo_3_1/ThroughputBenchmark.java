package com.socreatory.bettercode2026.module_3_demos.demo_3_1;

import java.util.concurrent.Executors;

/// Demo 3.1 – Throughput-Vergleich Platform Threads vs. Virtual Threads (Java 25)
///
/// Die zwei Run-Methoden teilen sich exakt dieselbe Struktur – einziger Unterschied ist
/// die Executor-Factory. Genau das ist die Botschaft: ein Refactoring von Platform Threads
/// auf Virtual Threads ist meist eine einzige Zeile.
public final class ThroughputBenchmark {

    private ThroughputBenchmark() {}

    /// Misst die Laufzeit von `task` und gibt sie als formatierte Konsolen-Zeile aus.
    public static void time(String label, Runnable task) {
        long start = System.nanoTime();
        task.run();
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        IO.println("%-50s %6d ms".formatted(label, elapsedMs));
    }

    public static void runWithFixedPool(int taskCount, int poolSize, int sleepMs) {
        try (var executor = Executors.newFixedThreadPool(poolSize)) {
            for (int i = 0; i < taskCount; i++) {
                executor.submit(() -> sleepQuietly(sleepMs));
            }
        }
    }

    public static void runWithVirtualThreads(int taskCount, int sleepMs) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < taskCount; i++) {
                executor.submit(() -> sleepQuietly(sleepMs));
            }
        }
    }

    private static void sleepQuietly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
