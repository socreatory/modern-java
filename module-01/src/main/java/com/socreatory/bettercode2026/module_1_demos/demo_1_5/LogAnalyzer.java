package com.socreatory.bettercode2026.module_1_demos.demo_1_5;

import module java.base;

/// Demo 1.5 – Module Import Declarations (Java 25)
///
/// Ein einziger `import module java.base` ersetzt zwölf einzelne Imports: `Path`,
/// `Files`, `Map`, `Pattern`, `Collectors` und alle anderen exportierten Typen von
/// `java.base` sind sichtbar.
public class LogAnalyzer {

    private static final Pattern LEVEL = Pattern.compile("\\b(DEBUG|INFO|WARN|ERROR)\\b");

    void main() throws IOException {
        Path file = Files.createTempFile("app", ".log");
        Files.write(file, List.of(
                "2026-12-10 09:00:01 INFO  Server started",
                "2026-12-10 09:00:02 DEBUG Loading configuration",
                "2026-12-10 09:00:05 WARN  Cache miss for key 'user:42'",
                "2026-12-10 09:00:07 INFO  Request GET /orders",
                "2026-12-10 09:00:08 ERROR Database timeout",
                "2026-12-10 09:00:09 INFO  Request GET /customers"));

        Instant start = Instant.now();
        Map<String, Long> counts = countLogLevels(file);
        Duration elapsed = Duration.between(start, Instant.now());

        IO.println(counts);
        IO.println("Dauer: " + elapsed.toMillis() + " ms");

        Files.delete(file);
    }

    public Map<String, Long> countLogLevels(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .map(LEVEL::matcher)
                    .filter(Matcher::find)
                    .collect(Collectors.groupingBy(m -> m.group(1), TreeMap::new,
                            Collectors.counting()));
        }
    }
}
