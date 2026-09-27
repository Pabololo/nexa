package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class ChatController {
    @FXML private ListView<String> conversationList;
    @FXML private ComboBox<String> workspaceSelector;
    @FXML private VBox messageList;
    @FXML private TextField messageInput;
    @FXML private HBox conversationHeader;

    @FXML
    private void initialize() {
        conversationList.getItems().setAll("Consulta Stock Mayo", "Optimización de Precios", "Tendencias de venta");
        workspaceSelector.getItems().setAll("Tienda principal", "Línea de accesorios", "Todas las tiendas");
        workspaceSelector.getSelectionModel().selectFirst();
        conversationList.getSelectionModel().selectFirst();
        showWelcomeMessages();
        messageInput.setOnAction(event -> sendMessage());
        conversationList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Label title = new Label(newValue);
                title.getStyleClass().add("card-title");
                conversationHeader.getChildren().setAll(title);
                showWelcomeMessages();
            }
        });
    }

    @FXML
    private void newConversation() {
        conversationList.getSelectionModel().clearSelection();
        Label title = new Label("Nueva conversación");
        title.getStyleClass().add("card-title");
        conversationHeader.getChildren().setAll(title);
        messageList.getChildren().clear();
        addMessage("¡Hola! Soy Nexa AI. ¿En qué puedo ayudarte hoy?", false);
        messageInput.requestFocus();
    }

    @FXML
    private void sendMessage() {
        String message = messageInput.getText().trim();
        if (message.isEmpty()) {
            return;
        }
        addMessage(message, true);
        messageInput.clear();
        addMessage("Esta es una respuesta simulada del bot. Puedo ayudarte a analizar el inventario y encontrar oportunidades para tu negocio.", false);
    }

    private void showWelcomeMessages() {
        messageList.getChildren().clear();
        addMessage("¡Hola! Soy Nexa AI, tu asistente de inventario. Puedo ayudarte a entender el rendimiento de tus productos.", false);
        addMessage("¿Qué productos tienen más riesgo de quedarse sin stock este mes?", true);
        addMessage("Revisando los datos de tu tienda, los auriculares y el teclado mecánico tienen mayor rotación. Te recomiendo revisar sus niveles de reposición esta semana.", false);
    }

    private void addMessage(String text, boolean user) {
        Label bubble = new Label(text);
        bubble.setWrapText(true);
        bubble.getStyleClass().addAll("chat-bubble", user ? "chat-bubble-user" : "chat-bubble-assistant");
        HBox row = new HBox(bubble);
        row.getStyleClass().add(user ? "message-row-user" : "message-row-assistant");
        messageList.getChildren().add(row);
    }
}
