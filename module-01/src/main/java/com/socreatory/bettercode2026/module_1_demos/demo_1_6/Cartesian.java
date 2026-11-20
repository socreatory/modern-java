package com.socreatory.bettercode2026.module_1_demos.demo_1_6;

/// Demo 1.6 – Flexible Constructor Bodies (Java 25)
public class Cartesian {

    private final double x, y;

    public Cartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
