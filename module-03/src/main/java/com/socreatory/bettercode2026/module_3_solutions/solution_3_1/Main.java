package com.socreatory.bettercode2026.module_3_solutions.solution_3_1;

import java.util.List;

/// Lösung zu Übung 3.1 – Erste Virtuelle Threads (Java 21)
///
/// Startet beide Run-Methoden mit derselben Task-Liste.
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
