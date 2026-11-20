package com.socreatory.bettercode2026.module_3.exercise_3_2;

import java.util.concurrent.ThreadLocalRandom;

/// Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Simuliert den Template-Service. Wie [OrderService]: ~200 ms Latenz, 20 %
/// Fehler-Wahrscheinlichkeit.
public final class InvoiceTemplateService {

    private InvoiceTemplateService() {}

    public static InvoiceTemplate getTemplate(String language) throws InterruptedException {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
        } catch (InterruptedException e) {
            IO.println("InvoiceTemplateService: interrupted");
            throw e;
        }
        if (ThreadLocalRandom.current().nextInt(100) < 20) {
            IO.println("InvoiceTemplateService: throwing 'Service down: template'");
            throw new RuntimeException("Service down: template");
        }
        InvoiceTemplate template = switch (language) {
            case "de" -> new InvoiceTemplate("de",
                    "=== RECHNUNG ===",
                    "Vielen Dank für Ihren Einkauf.");
            case "en" -> new InvoiceTemplate("en",
                    "=== INVOICE ===",
                    "Thank you for your purchase.");
            default   -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
        IO.println("InvoiceTemplateService: returning " + template);
        return template;
    }
}
