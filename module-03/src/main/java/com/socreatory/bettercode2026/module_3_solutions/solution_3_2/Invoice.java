package com.socreatory.bettercode2026.module_3_solutions.solution_3_2;

/// Lösung zu Übung 3.2 – `StructuredTaskScope` (JEP 505 · 5th Preview · Java 25)
///
/// Das Endprodukt der Rechnungserstellung.
public record Invoice(Order order, Customer customer, InvoiceTemplate template, String pdfText) {

    public static Invoice generate(Order order, Customer customer, InvoiceTemplate template) {
        String pdf = template.header() + "\n"
                   + "Customer: " + customer.name() + " (" + customer.email() + ")\n"
                   + "Order #" + order.orderId() + " · total: " + order.total() + "\n"
                   + template.footer();
        return new Invoice(order, customer, template, pdf);
    }
}
