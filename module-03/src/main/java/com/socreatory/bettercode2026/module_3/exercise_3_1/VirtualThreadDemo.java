package com.socreatory.bettercode2026.module_3.exercise_3_1;

import java.util.List;
import java.util.concurrent.Executors;

/// Übung 3.1 – Erste Virtuelle Threads (Java 21)
///
/// Diese Klasse hat zwei Run-Methoden, die jeweils dieselbe Liste von [Task]s ausführen –
/// einmal mit dem `Thread.ofVirtual()`-Builder, einmal mit dem
/// `Executors.newVirtualThreadPerTaskExecutor()`. Beide Methoden sind aktuell leer.
///
/// **Dein Job:**
///
///   - Implementiere `runWithBuilder(...)` mit dem Builder `Thread.ofVirtual()`. Vergib einen
///     sprechenden Namens-Präfix mit Index (`name(prefix, start)`). Sammle die Threads,
///     damit du am Ende auf alle joinen kannst.
///
///   - Implementiere `runWithExecutor(...)` mit `Executors.newVirtualThreadPerTaskExecutor()`
///     im try-with-resources-Block – das `close()` wartet automatisch auf alle Tasks.
///
///   - Lass `Main` laufen und vergleicht in der Konsole, wie sich der Thread-Name und der
///     Carrier Thread (`@ForkJoinPool-1-worker-N`) zwischen den beiden Varianten
///     unterscheiden.
public final class VirtualThreadDemo {

    private VirtualThreadDemo() {}

    public static void runWithBuilder(List<Task> tasks) throws InterruptedException {
        // TODO 1: Lege _einmal_ vor der Schleife einen Builder mit
        //         `Thread.ofVirtual().name(prefix, start)` an. In der Schleife angelegt,
        //         würde der Namens-Index nicht hochzählen.

        // TODO 2: Pro Task `start(Runnable)` auf dem Builder aufrufen und die zurückgegebenen
        //         Thread-Objekte sammeln. Sonst kannst du unten nicht `join()` auf ihnen aufrufen.

        // TODO 3: In einer zweiten Schleife auf jeden gesammelten Thread `join()` aufrufen.
    }

    public static void runWithExecutor(List<Task> tasks) {
        // TODO 4: `Executors.newVirtualThreadPerTaskExecutor()` im try-with-resources-Block anlegen
        //         und für jeden Task `submit(...)` aufrufen. Das schließende `}` wartet
        //         auf alle Tasks – kein eigenes awaitTermination, kein eigener join nötig.
    }
}
