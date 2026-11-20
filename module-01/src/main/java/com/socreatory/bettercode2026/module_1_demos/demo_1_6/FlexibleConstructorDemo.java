package com.socreatory.bettercode2026.module_1_demos.demo_1_6;

/// Demo 1.6 – Flexible Constructor Bodies (Java 25)
///
/// `PolarPoint extends Cartesian` zweimal: mit statischen Hilfsmethoden wie vor
/// Java 25 und mit Code vor `super(…)`. Beide validieren `r`, bevor `Cartesian`
/// konstruiert wird.
public class FlexibleConstructorDemo {

    void main() {
        IO.println(new PolarPointBeforeJava25(5, Math.PI / 3, "P1"));
        IO.println(new PolarPoint(5, Math.PI / 3, "P1"));

        try {
            new PolarPoint(-1, 0, "P2");
        } catch (IllegalArgumentException e) {
            IO.println(e);
        }
    }
}
