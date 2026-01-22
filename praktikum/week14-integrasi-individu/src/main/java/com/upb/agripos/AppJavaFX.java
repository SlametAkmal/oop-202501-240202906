package com.upb.agripos;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.dao.JdbcProductDAO;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.PosView;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main Application Class
 * Bab 1 - Hello World
 * Bab 14 - Integrasi End-to-End
 */
public class AppJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Bab 1: Identitas Praktikum
        System.out.println("======================================");
        System.out.println("Hello World, I am Slamet Akmal-240202906");
        System.out.println("Agri-POS - Sistem Kasir Sederhana");
        System.out.println("======================================");

        // Dependency Injection (Bab 6 - DIP)
        ProductDAO productDAO = new JdbcProductDAO();
        ProductService productService = new ProductService(productDAO);
        CartService cartService = new CartService();

        PosController controller = new PosController(productService, cartService);

        // Initialize View
        PosView view = new PosView(controller, primaryStage);
        view.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
