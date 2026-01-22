package com.upb.agripos.controller;

import com.upb.agripos.exception.DatabaseException;
import com.upb.agripos.exception.InsufficientStockException;
import com.upb.agripos.exception.InvalidProductException;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;

import java.util.List;

/**
 * Controller layer - menghubungkan View dengan Service
 * Bab 6 - SOLID (Dependency Inversion Principle)
 */
public class PosController {
    private final ProductService productService;
    private final CartService cartService;

    public PosController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    // Product Operations
    public List<Product> loadProducts() throws DatabaseException {
        return productService.getAllProducts();
    }

    public void addProduct(String code, String name, double price, int stock)
            throws InvalidProductException, DatabaseException {
        Product product = new Product(code, name, price, stock);
        productService.addProduct(product);
    }

    public void deleteProduct(String code) throws InvalidProductException, DatabaseException {
        productService.deleteProduct(code);
    }

    // Cart Operations
    public void addToCart(Product product, int quantity) throws InsufficientStockException {
        cartService.addToCart(product, quantity);
    }

    public void removeFromCart(String productCode) {
        cartService.removeFromCart(productCode);
    }

    public void clearCart() {
        cartService.clearCart();
    }

    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    public double getCartTotal() {
        return cartService.calculateTotal();
    }

    public int getCartItemCount() {
        return cartService.getItemCount();
    }

    public String getCartSummary() {
        return cartService.getCartSummary();
    }
}