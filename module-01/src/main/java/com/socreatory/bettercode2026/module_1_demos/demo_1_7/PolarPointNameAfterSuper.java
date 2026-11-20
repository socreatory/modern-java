package com.socreatory.bettercode2026.module_1_demos.demo_1_7;

/// Demo 1.7 – Polymorphismus-Falle im Konstruktor (Java 25)
///
/// `name` wird nach `super(…)` zugewiesen. Der `Cartesian`-Konstruktor ruft aber
/// schon das überschriebene `label()` auf – und `name` ist dort noch `null`.
public class PolarPointNameAfterSuper extends Cartesian {

    private final String name;

    public PolarPointNameAfterSuper(double r, double theta, String name) {
        if (r < 0) {
            throw new IllegalArgumentException("r < 0: " + r);
        }
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);
        super(x, y);
        this.name = name;
    }

    @Override
    public String label() {
        return name + ": " + super.label();
    }
}
