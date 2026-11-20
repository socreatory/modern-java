package com.socreatory.bettercode2026.module_3.exercise_3_2;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Diese Klasse erstellt eine Rechnung. Aktuell ruft sie die drei Services *sequentiell*
/// auf – `getOrder`, dann `getCustomer`, dann `getTemplate`. Das ist langsam und nutzt
/// die Wartezeiten der drei API-Calls nicht parallel aus.
///
/// **Dein Job:**
///
///   - Lass [Main] einmal laufen und merk dir die Laufzeit als Vergleichswert – etwa
///     600 ms, die drei Service-Calls nacheinander. Zeigt [Main] stattdessen einen
///     Stack-Trace, war das einer der simulierten Fehler: einfach noch einmal starten.
///
///   - Öffne in `createInvoice(...)` einen `StructuredTaskScope.open()` (Default-Joiner
///     `awaitAllSuccessfulOrThrow`) im try-with-resources-Block. Starte darin für *jeden*
///     der drei Service-Aufrufe einen Subtask mit `scope.fork(...)` und speichere die
///     drei Rückgabewerte in lokalen `Subtask`-Variablen.
///
///   - Warte danach *einmal* mit `scope.join()` auf alle Subtasks, hol dann mit
///     `Subtask.get()` die drei Ergebnisse und übergib sie an `Invoice.generate(...)`.
///
///   - Lass [Main] mehrfach laufen. Beobachte: bei Erfolg läuft die Methode in der Zeit
///     der *langsamsten* Antwort durch (~250–300 ms statt ~600 ms); bei einem Fehler in einem
///     der Subtasks bricht der Scope ab und [Main] zeigt den Stack-Trace.
///
/// **Awareness:** `StructuredTaskScope` ist in Java 25 ein Preview-Feature (JEP 505).
/// Das Maven-Modul aktiviert `--enable-preview`. Zeigt IntelliJ trotzdem Fehler, stell
/// unter Project Structure den Language Level dieses Moduls auf „25 (Preview)“.
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
        // ─── Muster: StructuredTaskScope ─────────────────────────────────────
        //
        // try (var scope = StructuredTaskScope.open(Joiner.awaitAllSuccessfulOrThrow())) {
        //     Subtask<ResultType1> subtask1 = scope.fork(() -> ...);
        //     Subtask<ResultType2> subtask2 = scope.fork(() -> ...);
        //     Subtask<ResultType3> subtask3 = scope.fork(() -> ...);
        //
        //     scope.join();
        //
        //     ResultType1 result1 = subtask1.get();
        //     ResultType2 result2 = subtask2.get();
        //     ResultType3 result3 = subtask3.get();
        //
        //     . . .
        // }
        // ─────────────────────────────────────────────────────────────────────

        // TODO 1: Öffne einen StructuredTaskScope per `StructuredTaskScope.open()` im
        //         try-with-resources-Block. Default-Joiner ist `awaitAllSuccessfulOrThrow` –
        //         für unseren Use Case („wir brauchen alle drei, beim ersten Fehler
        //         abbrechen“) genau richtig. `var` für den Scope-Typ ist hier sinnvoll,
        //         der explizite Typ liefert keinen Mehrwert.

        // TODO 2: Innerhalb des Scopes pro Service-Aufruf einmal `scope.fork(...)` mit
        //         dem Service-Call als Lambda. Speichere die Rückgabe in einer lokalen
        //         Subtask-Variable – sonst kommst du im nächsten Schritt nicht mehr an das
        //         Ergebnis. Hinweis: die Service-Methoden werfen `InterruptedException`,
        //         das akzeptiert `fork(Callable)` ohne extra Wrapper.

        // TODO 3: Nach den drei forks `scope.join()` aufrufen. Bei Erfolg läuft die
        //         Methode danach normal weiter; bei Fehler wirft `join()` eine
        //         `FailedException` (ab Java 27: `ExecutionException`) mit der
        //         Original-Exception als Cause – die anderen
        //         Subtasks werden vom Joiner automatisch interrupted.

        // TODO 4: Aus den drei Subtask-Variablen die Ergebnisse holen und damit
        //         `Invoice.generate(...)` aufrufen. Die Invoice zurückgeben.

        // Sequenzielle Ersatz-Implementierung, damit die Klasse zunächst kompiliert.
        // Wird in den TODOs oben komplett ersetzt.
        Order order = OrderService.getOrder(orderId);
        Customer customer = CustomerService.getCustomer(customerId);
        InvoiceTemplate template = InvoiceTemplateService.getTemplate(language);
        return Invoice.generate(order, customer, template);
    }
}
