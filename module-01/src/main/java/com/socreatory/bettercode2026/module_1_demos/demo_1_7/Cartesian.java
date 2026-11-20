package com.socreatory.bettercode2026.module_1_demos.demo_1_7;

/// Demo 1.7 – Polymorphismus-Falle im Konstruktor (Java 25)
public class Cartesian {

    private final double x, y;

    public Cartesian(double x, double y) {
        this.x = x;
        this.y = y;
        IO.println("Constructed " + label());
    }

    public String label() {
        return "(" + x + ", " + y + ")";
    }
}
