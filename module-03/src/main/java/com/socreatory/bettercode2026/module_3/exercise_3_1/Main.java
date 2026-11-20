package com.socreatory.bettercode2026.module_3.exercise_3_1;

import java.util.List;

/// Übung 3.1 – Erste Virtuelle Threads (Java 21)
///
/// Startet die beiden Run-Methoden aus [VirtualThreadDemo] mit derselben Task-Liste.
///
/// Achtet beim Lauf darauf, wie der Thread-Name und der Carrier Thread (`@ForkJoinPool-1-worker-N`)
/// zwischen den Varianten aussehen.
public class Main {

    void main() throws InterruptedException {
        List<Task> tasks = List.of(
                new Task("task-A"),
                new Task("task-B"),
                new Task("task-C"),
                new Task("task-D"),
                new Task("task-E"));

        IO.println("=== runWithBuilder ===");
        VirtualThreadDemo.runWithBuilder(tasks);

        IO.println();
        IO.println("=== runWithExecutor ===");
        VirtualThreadDemo.runWithExecutor(tasks);
    }
}
