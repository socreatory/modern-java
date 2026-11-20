package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Der `createInvoice` öffnet einen Scope mit dem Default-Joiner
/// `awaitAllSuccessfulOrThrow`. Drei `fork(...)` für die drei Service-Aufrufe, dann
/// `scope.join()`, dann die Ergebnisse aus den Subtasks holen und an `Invoice.generate`
/// übergeben.
///
/// Bei einem Fehler in einem der Subtasks wirft `scope.join()` eine `FailedException`
/// – die anderen Subtasks werden vom Joiner automatisch interrupted.
///
/// Mit JDK 26 geht es auch, wenn du `maven.compiler.release` in der `pom.xml` auf 26
/// setzt; die Teile der API, die diese Übung nutzt, sind dort unverändert. Mit JDK 27
/// kompiliert das Modul nicht, denn in Java 27 hat sich die API noch einmal geändert:
/// `StructuredTaskScope` hat einen dritten Typparameter, und `join()` wirft eine checked
/// `ExecutionException` statt der `FailedException`. Mit dieser API wird
/// `StructuredTaskScope` in Java 28 final (JEP 543).
public final class InvoiceGenerator {

    private InvoiceGenerator() {}

    public static Invoice createInvoice(int orderId, int customerId, String language)
            throws InterruptedException {

        // TODO 1 (gelöst): try-with-resources auf StructuredTaskScope.open().
        //                  Default-Joiner ist awaitAllSuccessfulOrThrow – passt für unseren
        //                  Fall ("wir brauchen alle drei, beim ersten Fehler abbrechen").
        try (var scope = StructuredTaskScope.open()) {

            // TODO 2 (gelöst): drei fork-Aufrufe, jeweils ein Service-Call im Lambda.
            //                  fork startet jeden Task in einem eigenen Virtual Thread.
            //                  Subtask-Rückgaben in lokalen Variablen sammeln, sonst
            //                  kommen wir nach dem join() nicht mehr ans Ergebnis.
            Subtask<Order> orderTask =
                    scope.fork(() -> OrderService.getOrder(orderId));
            Subtask<Customer> customerTask =
                    scope.fork(() -> CustomerService.getCustomer(customerId));
            Subtask<InvoiceTemplate> templateTask =
                    scope.fork(() -> InvoiceTemplateService.getTemplate(language));

            // TODO 3 (gelöst): join() wartet auf alle Subtasks. Bei Erfolg geht's einfach
            //                  weiter; bei Fehler in einem Subtask wirft join() eine
            //                  FailedException, die anderen Subtasks werden interrupted.
            scope.join();

            // TODO 4 (gelöst): Ergebnisse aus den Subtask-Variablen holen und an die
            //                  fachliche generate()-Methode übergeben. subtask.get() ist
            //                  hier nach erfolgreichem join() garantiert non-blocking.
            return Invoice.generate(
                    orderTask.get(),
                    customerTask.get(),
                    templateTask.get());
        }
    }
}
