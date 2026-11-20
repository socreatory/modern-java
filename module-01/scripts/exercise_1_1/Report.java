/// Übung 1.1 – Vom klassischen Programm zum Compact Source File (Java 25)
///
/// Dieses Skript ist im klassischen Java-Stil geschrieben und gibt für mehrere Stage-Namen
/// (`dev`, `test`, `prod`) jeweils eine mit `===` gerahmte Zeile in Großbuchstaben aus.
/// Compact Source Files passen nicht ins Maven-Layout, du arbeitest deshalb direkt mit dem
/// `java`-Launcher aus dem Terminal: `java Report.java` in diesem Verzeichnis.
///
/// **Dein Job:**
///
///  - Mach `Report.java` zu einem Compact Source File mit Instance Main Method: Entferne die
///    umschließende `public class Report { ... }`-Klammer, mach aus
///    `public static void main(String[] args)` ein parameterloses `void main()` und ersetze
///    `System.out.println(...)` durch `IO.println(...)`.
///  - Zieh die Rahmen-Logik in eine eigene Methode `frame(String text)` im selben File. Sie
///    braucht kein `static` – sie ist, wie `main`, eine Instanz-Methode der impliziten Klasse.
///  - Verschiebe `frame` in eine reguläre Klasse `Banner` mit einer statischen Methode
///    `frame(String text)` in `Banner.java` im selben Verzeichnis und rufe `Banner.frame(...)`
///    auf. Du startest weiterhin nur `Report.java`.
///  - Verschiebe `Banner.java` in einen Unterordner `shared/`, gib der Klasse die
///    Paket-Deklaration `package shared;` und importiere sie in `Report.java` mit
///    `import shared.Banner;`.
///
/// Nach jedem Schritt: starten und prüfen, dass die Ausgabe unverändert ist.
///
/// **Bonus, wenn Zeit bleibt:**
///
/// Lies in `Report.java` mit `IO.readln(...)` interaktiv einen zusätzlichen Stage-Namen ein und
/// gib ihn als weitere gerahmte Zeile aus – ganz ohne `BufferedReader` und `try`/`catch`. Die
/// Ausgabe bekommt dadurch eine zusätzliche Zeile.
public class Report {

    public static void main(String[] args) {
        String[] stages = {"dev", "test", "prod"};
        for (String stage : stages) {
            System.out.println("=== " + stage.toUpperCase() + " ===");
        }
    }
}
