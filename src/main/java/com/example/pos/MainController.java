package com.example.pos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    private void onFetchTheme(ActionEvent event) {
        Scene scene = ((javafx.scene.Node) event.getSource()).getScene();
        try {
            ThemeService service = new ThemeService();
            Theme theme = service.fetchTheme();
            ThemeApplier.applyTheme(scene, theme);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
            alert.showAndWait();
        }
    }
}
