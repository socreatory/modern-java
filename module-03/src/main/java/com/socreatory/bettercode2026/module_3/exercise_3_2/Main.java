package com.socreatory.bettercode2026.module_3.exercise_3_2;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Treiber für [InvoiceGenerator]. Misst die Laufzeit, gibt die Rechnung aus und behandelt
/// die FailedException, falls einer der drei Services in den 20 % Fehlerfall fällt.
///
/// Mehrfach starten – bei Erfolg zeigt `Main` die Laufzeit und die Rechnung, bei einem
/// simulierten Fehler den Stack-Trace.
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
