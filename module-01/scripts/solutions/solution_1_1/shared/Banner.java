package shared;

/// Lösung zu Übung 1.1 – Vom klassischen Programm zum Compact Source File (Java 25)
///
/// Reguläre Klasse im Paket `shared`: Verzeichnis-Name gleich Paket-Name.
public class Banner {

    public static String frame(String text) {
        return "=== " + text.toUpperCase() + " ===";
    }
}
