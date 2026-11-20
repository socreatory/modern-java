package com.socreatory.bettercode2026.module_1_demos.demo_1_7;

/// Demo 1.7 – Polymorphismus-Falle im Konstruktor (Java 25)
///
/// Der Fix: `name` wird vor `super(…)` zugewiesen und ist gesetzt, wenn der
/// `Cartesian`-Konstruktor `label()` aufruft.
public class PolarPoint extends Cartesian {

    private final String name;

    public PolarPoint(double r, double theta, String name) {
        if (r < 0) {
            throw new IllegalArgumentException("r < 0: " + r);
        }
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);

        this.name = name;

        super(x, y);
    }

    @Override
    public String label() {
        return name + ": " + super.label();
    }
}
