package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.exception.DatabaseException;
import com.upb.agripos.exception.InsufficientStockException;
import com.upb.agripos.exception.InvalidProductException;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * JavaFX View untuk aplikasi POS
 * Bab 12, 13 - JavaFX GUI
 */
public class PosView {
    private final PosController controller;
    private final Stage stage;

    private TableView<Product> productTable;
    private ObservableList<Product> productData;

    private TextField codeField, nameField, priceField, stockField, qtyField;
    private TextArea cartArea;
    private Label totalLabel;

    public PosView(PosController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    public void show() {
        stage.setTitle("Agri-POS - Sistem Kasir Sederhana");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Top: Product Management
        root.setTop(createProductManagementPane());

        // Center: Product Table
        root.setCenter(createProductTablePane());

        // Right: Cart
        root.setRight(createCartPane());

        Scene scene = new Scene(root, 1200, 600);
        stage.setScene(scene);
        stage.show();

        loadProducts();
    }

    private VBox createProductManagementPane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc;");

        Label title = new Label("KELOLA PRODUK");
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);

        grid.add(new Label("Kode:"), 0, 0);
        codeField = new TextField();
        codeField.setPromptText("Kode produk");
        grid.add(codeField, 1, 0);

        grid.add(new Label("Nama:"), 2, 0);
        nameField = new TextField();
        nameField.setPromptText("Nama produk");
        grid.add(nameField, 3, 0);

        grid.add(new Label("Harga:"), 0, 1);
        priceField = new TextField();
        priceField.setPromptText("Harga");
        grid.add(priceField, 1, 1);

        grid.add(new Label("Stok:"), 2, 1);
        stockField = new TextField();
        stockField.setPromptText("Stok");
        grid.add(stockField, 3, 1);

        HBox buttons = new HBox(10);
        Button addBtn = new Button("Tambah Produk");
        addBtn.setOnAction(e -> handleAddProduct());

        Button deleteBtn = new Button("Hapus Produk");
        deleteBtn.setOnAction(e -> handleDeleteProduct());

        Button refreshBtn = new Button("Refresh");
        refreshBtn.setOnAction(e -> loadProducts());

        buttons.getChildren().addAll(addBtn, deleteBtn, refreshBtn);

        vbox.getChildren().addAll(title, grid, buttons);
        return vbox;
    }

    private VBox createProductTablePane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label title = new Label("DAFTAR PRODUK");
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        productTable = new TableView<>();
        productData = FXCollections.observableArrayList();

        TableColumn<Product, String> codeCol = new TableColumn<>("Kode");
        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeCol.setPrefWidth(100);

        TableColumn<Product, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(200);

        TableColumn<Product, Double> priceCol = new TableColumn<>("Harga");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setPrefWidth(120);

        TableColumn<Product, Integer> stockCol = new TableColumn<>("Stok");
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockCol.setPrefWidth(80);

        productTable.getColumns().addAll(codeCol, nameCol, priceCol, stockCol);
        productTable.setItems(productData);

        vbox.getChildren().addAll(title, productTable);
        VBox.setVgrow(productTable, Priority.ALWAYS);

        return vbox;
    }

    private VBox createCartPane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setPrefWidth(350);
        vbox.setStyle("-fx-background-color: #e8f5e9; -fx-border-color: #4caf50;");

        Label title = new Label("KERANJANG BELANJA");
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        HBox addToCartBox = new HBox(10);
        qtyField = new TextField("1");
        qtyField.setPrefWidth(60);
        qtyField.setPromptText("Qty");

        Button addToCartBtn = new Button("Tambah ke Keranjang");
        addToCartBtn.setOnAction(e -> handleAddToCart());

        addToCartBox.getChildren().addAll(new Label("Jumlah:"), qtyField, addToCartBtn);

        cartArea = new TextArea();
        cartArea.setEditable(false);
        cartArea.setPrefHeight(300);
        cartArea.setStyle("-fx-font-family: monospace;");

        totalLabel = new Label("TOTAL: Rp 0.00");
        totalLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        HBox cartButtons = new HBox(10);
        Button clearBtn = new Button("Kosongkan Keranjang");
        clearBtn.setOnAction(e -> handleClearCart());

        Button checkoutBtn = new Button("Checkout");
        checkoutBtn.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white;");
        checkoutBtn.setOnAction(e -> handleCheckout());

        cartButtons.getChildren().addAll(clearBtn, checkoutBtn);

        vbox.getChildren().addAll(title, addToCartBox, cartArea, totalLabel, cartButtons);
        VBox.setVgrow(cartArea, Priority.ALWAYS);

        return vbox;
    }

    private void loadProducts() {
        try {
            productData.clear();
            productData.addAll(controller.loadProducts());
        } catch (DatabaseException e) {
            showError("Database Error", "Gagal memuat produk: " + e.getMessage());
        }
    }

    private void handleAddProduct() {
        try {
            String code = codeField.getText();
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int stock = Integer.parseInt(stockField.getText());

            controller.addProduct(code, name, price, stock);
            showInfo("Sukses", "Produk berhasil ditambahkan");

            clearProductFields();
            loadProducts();

        } catch (NumberFormatException e) {
            showError("Input Error", "Harga dan stok harus berupa angka");
        } catch (InvalidProductException | DatabaseException e) {
            showError("Error", e.getMessage());
        }
    }

    private void handleDeleteProduct() {
        Product selected = productTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("Error", "Pilih produk yang akan dihapus");
            return;
        }

        try {
            controller.deleteProduct(selected.getCode());
            showInfo("Sukses", "Produk berhasil dihapus");
            loadProducts();
        } catch (InvalidProductException | DatabaseException e) {
            showError("Error", e.getMessage());
        }
    }

    private void handleAddToCart() {
        Product selected = productTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("Error", "Pilih produk yang akan ditambahkan ke keranjang");
            return;
        }

        try {
            int qty = Integer.parseInt(qtyField.getText());
            controller.addToCart(selected, qty);
            updateCartDisplay();
            showInfo("Sukses", "Produk ditambahkan ke keranjang");
        } catch (NumberFormatException e) {
            showError("Input Error", "Jumlah harus berupa angka");
        } catch (InsufficientStockException e) {
            showError("Stok Error", e.getMessage());
        }
    }

    private void handleClearCart() {
        controller.clearCart();
        updateCartDisplay();
        showInfo("Info", "Keranjang telah dikosongkan");
    }

    private void handleCheckout() {
        if (controller.getCartItemCount() == 0) {
            showError("Error", "Keranjang kosong");
            return;
        }

        String summary = controller.getCartSummary();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Checkout");
        alert.setHeaderText("Konfirmasi Pembayaran");
        alert.setContentText(summary + "\n\nProses pembayaran?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                controller.clearCart();
                updateCartDisplay();
                showInfo("Sukses", "Pembayaran berhasil!");
            }
        });
    }

    private void updateCartDisplay() {
        cartArea.setText(controller.getCartSummary());
        totalLabel.setText(String.format("TOTAL: Rp %.2f", controller.getCartTotal()));
    }

    private void clearProductFields() {
        codeField.clear();
        nameField.clear();
        priceField.clear();
        stockField.clear();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
