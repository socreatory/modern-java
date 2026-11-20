package com.socreatory.bettercode2026.module_3_demos.demo_3_1;

/// Demo 3.1 – Throughput-Vergleich Platform Threads vs. Virtual Threads (Java 25)
///
/// Aufwärm-Lauf plus Haupt-Lauf des Throughput-Benchmarks.
///
/// Erwartete Größenordnung beim Haupt-Lauf:
/// - FixedThreadPool(200): ca. 10 s
/// - VirtualThreadPerTaskExecutor: ca. 100 – 200 ms
public class Main {

    void main() {
        IO.println("=== Aufwärm-Lauf (100 Tasks, 50 ms) ===");
        for (int i = 0; i < 3; i++) {
            ThroughputBenchmark.time("VirtualThreads (warm-up)",
                    () -> ThroughputBenchmark.runWithVirtualThreads(100, 50));
            ThroughputBenchmark.time("FixedThreadPool(100) (warm-up)",
                    () -> ThroughputBenchmark.runWithFixedPool(100, 100, 50));
        }

        IO.println();
        IO.println("=== Haupt-Lauf (20.000 Tasks, 100 ms) ===");

        runWithFixedPool(200);
        runWithFixedPool(500);
        runWithFixedPool(1000);
        runWithFixedPool(2000);
        runWithFixedPool(5000);
        runWithFixedPool(10000);

        ThroughputBenchmark.time("VirtualThreadPerTaskExecutor",
                () -> ThroughputBenchmark.runWithVirtualThreads(20_000, 100));
    }

    private void runWithFixedPool(int poolSize) {
        ThroughputBenchmark.time("FixedThreadPool(%d)".formatted(poolSize),
                () -> ThroughputBenchmark.runWithFixedPool(20_000, poolSize, 100));
    }
}
