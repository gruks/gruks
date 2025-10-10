package com.example.pos;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(App.class.getResource("/main-view.fxml"));
        Scene scene = new Scene(root, 1024, 640);
        scene.getStylesheets().add(App.class.getResource("/theme.css").toExternalForm());
        stage.setTitle("RestaurantPOS");
        stage.setScene(scene);
        stage.show();

        // Fetch and apply theme on startup without blocking UI
        new Thread(() -> {
            try {
                Theme theme = new ThemeService().fetchTheme();
                Platform.runLater(() -> ThemeApplier.applyTheme(scene, theme));
            } catch (Exception ignored) {
                // Keep defaults if backend unavailable
            }
        }, "theme-loader").start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
