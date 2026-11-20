package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Bei Erfolg läuft `createInvoice` in ~250–300 ms durch – drei parallele Calls à 100 bis
/// 300 ms, es zählt der langsamste – statt in ~600 ms wie die sequentielle Ursprungs-Variante.
public class Main {

    void main() throws InterruptedException {
        long start = System.nanoTime();
        try {
            Invoice invoice = InvoiceGenerator.createInvoice(42, 4711, "de");
            long elapsedMs = (System.nanoTime() - start) / 1_000_000;

            IO.println("createInvoice took %d ms%n".formatted(elapsedMs));
            IO.println(invoice.pdfText());
        } catch (RuntimeException e) {
            long elapsedMs = (System.nanoTime() - start) / 1_000_000;
            IO.println("createInvoice failed after %d ms".formatted(elapsedMs));
            e.printStackTrace(System.out);
        }
    }
}
