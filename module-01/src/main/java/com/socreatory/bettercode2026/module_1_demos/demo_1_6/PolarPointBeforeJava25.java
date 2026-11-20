package com.socreatory.bettercode2026.module_1_demos.demo_1_6;

/// Demo 1.6 – Flexible Constructor Bodies (Java 25)
///
/// Der Workaround vor Java 25: Validierung und Umrechnung in statischen Hilfsmethoden,
/// die im `super(…)`-Aufruf stehen.
public class PolarPointBeforeJava25 extends Cartesian {
    private final String name;

    public PolarPointBeforeJava25(double r, double theta, String name) {
        super(toX(r, theta), toY(r, theta));
        this.name = name;
    }

    private static double toX(double r, double theta) {
        if (r < 0) {
            throw new IllegalArgumentException("r < 0: " + r);
        }
        return r * Math.cos(theta);
    }

    private static double toY(double r, double theta) {
        return r * Math.sin(theta);
    }

    @Override
    public String toString() {
        return name + ": " + super.toString();
    }
}
