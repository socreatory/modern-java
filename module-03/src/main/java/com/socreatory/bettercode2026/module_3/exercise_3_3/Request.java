package com.socreatory.bettercode2026.module_3.exercise_3_3;

/// Übung 3.3 – Service-Kette refaktorisieren (Java 25)
///
/// Eingehender Request – Auth-Token plus Payload.
public record Request(String authToken, Payload payload) {}
