package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {
    @FXML private HBox loggedOutBox;
    @FXML private HBox loggedInBox;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label profileName;
    @FXML private StackPane contentArea;
    @FXML private Button inventoryButton;
    @FXML private Button assistantButton;

    @FXML
    private void initialize() {
        showInventory();
    }

    @FXML
    private void login() {
        String username = usernameField.getText().isBlank() ? "Alex Morgan" : usernameField.getText().trim();
        profileName.setText(username);
        loggedOutBox.setVisible(false);
        loggedOutBox.setManaged(false);
        loggedInBox.setVisible(true);
        loggedInBox.setManaged(true);
        passwordField.clear();
    }

    @FXML
    private void logout() {
        loggedInBox.setVisible(false);
        loggedInBox.setManaged(false);
        loggedOutBox.setVisible(true);
        loggedOutBox.setManaged(true);
        usernameField.clear();
    }

    @FXML
    private void showInventory() {
        loadView("/org/example/inventory.fxml");
        setActiveNavigation(inventoryButton, assistantButton);
    }

    @FXML
    private void showAssistant() {
        loadView("/org/example/chat.fxml");
        setActiveNavigation(assistantButton, inventoryButton);
    }

    private void loadView(String resource) {
        try {
            contentArea.getChildren().clear();
            contentArea.getChildren().add(new FXMLLoader(AppLauncher.class.getResource(resource)).load());
        } catch (IOException exception) {
            throw new IllegalStateException("No se pudo cargar la vista " + resource, exception);
        }
    }

    private void setActiveNavigation(Button active, Button inactive) {
        active.getStyleClass().add("nav-button-active");
        inactive.getStyleClass().remove("nav-button-active");
    }
}
