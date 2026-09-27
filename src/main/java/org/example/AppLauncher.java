package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppLauncher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(AppLauncher.class.getResource("/org/example/main.fxml"));
        Scene scene = new Scene(loader.load(), 1240, 800);
        scene.getStylesheets().add(AppLauncher.class.getResource("/org/example/styles.css").toExternalForm());
        stage.setTitle("Nexa · Gestión inteligente");
        stage.setMinWidth(1024);
        stage.setMinHeight(680);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
