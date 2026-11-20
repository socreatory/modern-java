package com.socreatory.bettercode2026.module_1_demos.demo_1_7;

/// Demo 1.7 – Polymorphismus-Falle im Konstruktor (Java 25)
///
/// Was gibt `new PolarPoint(5, Math.PI / 3, "P1")` aus? Mit der Zuweisung nach
/// `super(…)` steht `null` vor den Koordinaten, mit der Zuweisung davor `P1`.
public class ConstructorPolymorphismDemo {

    void main() {
        IO.println("--- name nach super(…)");
        new PolarPointNameAfterSuper(5, Math.PI / 3, "P1");

        IO.println("--- name vor super(…)");
        new PolarPoint(5, Math.PI / 3, "P1");
    }
}
