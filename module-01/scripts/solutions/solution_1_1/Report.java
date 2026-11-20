import shared.Banner;

/// Lösung zu Übung 1.1 – Vom klassischen Programm zum Compact Source File (Java 25)
///
/// Compact Source File mit Instance Main Method; die Rahmen-Logik liegt in `shared/Banner.java`,
/// die der `java`-Launcher über den Import findet. Der Bonus liest mit `IO.readln(...)` eine
/// weitere Stage ein.
void main() {
    String[] stages = {"dev", "test", "prod"};
    for (String stage : stages) {
        IO.println(Banner.frame(stage));
    }

    String extra = IO.readln("Weitere Stage: ");
    if (extra != null && !extra.isBlank()) {
        IO.println(Banner.frame(extra));
    }
}
