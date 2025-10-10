package com.example.pos;

import javafx.scene.Scene;

public class ThemeApplier {
    public static void applyTheme(Scene scene, Theme theme) {
        if (scene == null || theme == null) {
            return;
        }
        // Use looked-up colors as variables on the scene root
        var root = scene.getRoot();
        root.setStyle(String.join(" ",
                cssVar("-color-primary", theme.getPrimary()),
                cssVar("-color-secondary", theme.getSecondary()),
                cssVar("-color-background", theme.getBackground()),
                cssVar("-color-text", theme.getText())
        ));
    }

    private static String cssVar(String name, String value) {
        if (value == null || value.isBlank()) {
            return ""; // keep prior value
        }
        return name + ": " + value + ";";
    }
}
