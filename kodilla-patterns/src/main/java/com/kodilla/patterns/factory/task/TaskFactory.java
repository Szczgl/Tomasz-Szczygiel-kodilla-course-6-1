package com.kodilla.patterns.factory.task;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task task (final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Zakupy", "koszula", 2.0);
            case PAINTING -> new PaintingTask("Malowanie", "czerwony", "samochód");
            case DRIVING -> new DrivingTask("Jazda", "Kraków", "pociąg");
            default -> null;
        };
    }
}
