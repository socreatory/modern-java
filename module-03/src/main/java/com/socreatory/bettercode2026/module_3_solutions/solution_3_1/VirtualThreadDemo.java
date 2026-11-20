package com.socreatory.bettercode2026.module_3_solutions.solution_3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/// Lösung zu Übung 3.1 – Erste Virtuelle Threads (Java 21)
///
/// Beide Run-Methoden umgesetzt: einmal mit dem `Thread.ofVirtual()`-Builder samt manuell
/// gesammelter Thread-Liste und expliziten `join()`-Aufrufen, einmal mit
/// `Executors.newVirtualThreadPerTaskExecutor()` im try-with-resources-Block.
public final class VirtualThreadDemo {

    private VirtualThreadDemo() {}

    public static void runWithBuilder(List<Task> tasks) throws InterruptedException {
        // TODO 1 (gelöst): Builder _einmal_ vor der Schleife angelegt. Der Index in
        //                  `name(prefix, start)` zählt dadurch über alle Tasks hoch.
        Thread.Builder.OfVirtual builder = Thread.ofVirtual().name("virtual-", 1);

        // TODO 2 (gelöst): Pro Task einen Virtual Thread starten und das Thread-Objekt
        //                  in einer Liste sammeln. Ohne Liste wäre das `join()` unten
        //                  nicht möglich – die main-Methode wäre vor den VTs zu Ende.
        List<Thread> threads = new ArrayList<>();
        for (Task task : tasks) {
            threads.add(builder.start(task::execute));
        }

        // TODO 3 (gelöst): Auf alle Threads warten, bevor die Methode returnt.
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void runWithExecutor(List<Task> tasks) {
        // TODO 4 (gelöst): try-with-resources auf dem VirtualThreadPerTaskExecutor.
        //                  Der `close()` am Ende des try-Blocks wartet auf alle Tasks.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (Task task : tasks) {
                executor.submit(task::execute);
            }
        }
    }
}
