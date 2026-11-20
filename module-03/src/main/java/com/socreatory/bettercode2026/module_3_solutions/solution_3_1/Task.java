package com.socreatory.bettercode2026.module_3_solutions.solution_3_1;

/// Lösung zu Übung 3.1 – Erste Virtuelle Threads (Java 21)
///
/// Eine kleine Aufgabe, die zweimal ihren aktuellen Thread auf die Konsole schreibt –
/// einmal vor und einmal nach einem kurzen `Thread.sleep`.
public record Task(String label) {

    public void execute() {
        IO.println("%-10s · vor sleep  · %s".formatted(label, Thread.currentThread()));
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        IO.println("%-10s · nach sleep · %s".formatted(label, Thread.currentThread()));
    }
}
