package com.socreatory.bettercode2026.module_1_demos.demo_1_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// Demo 1.8 – Unnamed Variables (Java 22)
///
/// Drei Stellen, an denen eine Variable deklariert werden muss, aber nicht gebraucht
/// wird: der `catch`-Parameter, der Lambda-Parameter und die Schleifenvariable. Seit
/// Java 22 heißen sie `_`.
public class UnnamedVariablesDemo {

    record Order(String id) {}

    void main() {
        IO.println("parse(\"42\"):  " + parse("42"));
        IO.println("parse(\"abc\"): " + parse("abc"));

        Map<String, List<String>> map = new HashMap<>();
        add(map, "fruit", "apple");
        add(map, "fruit", "banana");
        add(map, "vegetable", "carrot");
        IO.println(map);

        Iterable<Order> orders = List.of(new Order("A"), new Order("B"), new Order("C"));
        int counter = 0;
        for (Order _ : orders) {
            counter++;
        }
        IO.println("orders: " + counter);
    }

    private int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException _) {
            return 0;
        }
    }

    private void add(Map<String, List<String>> map, String key, String value) {
        map.computeIfAbsent(key, _ -> new ArrayList<>())
                .add(value);
    }
}
