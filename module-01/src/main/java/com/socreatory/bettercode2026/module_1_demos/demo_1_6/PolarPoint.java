package com.socreatory.bettercode2026.module_1_demos.demo_1_6;

/// Demo 1.6 – Flexible Constructor Bodies (Java 25)
///
/// Seit Java 25: Validierung und Umrechnung stehen im Konstruktor vor `super(…)`.
public class PolarPoint extends Cartesian {

    private final String name;

    public PolarPoint(double r, double theta, String name) {
        if (r < 0) {
            throw new IllegalArgumentException("r < 0: " + r);
        }
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);

        super(x, y);

        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + super.toString();
    }
}
