package org.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryController {
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, String> productColumn;
    @FXML private TableColumn<Product, String> stockColumn;
    @FXML private TableColumn<Product, String> categoryColumn;
    @FXML private TableColumn<Product, String> priceColumn;
    private final List<Product> products = new ArrayList<>();
    private boolean lowStockOnly;

    @FXML
    private void initialize() {
        productColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().name()));
        stockColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().stock()));
        categoryColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().category()));
        priceColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().price()));
        products.addAll(List.of(
                new Product("Auriculares Studio Pro", "128", "Electrónica", "$ 149.00"),
                new Product("Botella térmica 750 ml", "84", "Accesorios", "$ 32.50"),
                new Product("Teclado mecánico K2", "56", "Electrónica", "$ 89.00"),
                new Product("Mochila commuter", "42", "Accesorios", "$ 76.00"),
                new Product("Lámpara de escritorio", "19", "Hogar", "$ 45.00"),
                new Product("Soporte aluminio laptop", "0", "Accesorios", "$ 28.00")
        ));
        updateTable();
    }

    @FXML
    private void addProduct() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Añadir producto");
        dialog.setHeaderText("Añade un producto al inventario");
        dialog.setContentText("Nombre del producto:");
        Optional<String> result = dialog.showAndWait();
        result.map(String::trim).filter(name -> !name.isEmpty())
                .ifPresent(name -> {
                    products.add(new Product(name, "0", "Nuevo", "$ 0.00"));
                    updateTable();
                });
    }

    @FXML
    private void filterProducts() {
        lowStockOnly = !lowStockOnly;
        updateTable();
    }

    @FXML
    private void exportProducts() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exportar inventario");
        alert.setHeaderText("Exportación simulada");
        alert.setContentText("Tu inventario está listo para exportarse como archivo CSV.");
        alert.showAndWait();
    }

    private void updateTable() {
        productTable.getItems().setAll(products.stream()
                .filter(product -> !lowStockOnly || Integer.parseInt(product.stock()) < 20)
                .toList());
    }

    private record Product(String name, String stock, String category, String price) {}
}
