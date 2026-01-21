package com.upb.agripos.service;

import com.upb.agripos.exception.InsufficientStockException;
import com.upb.agripos.model.Cart;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

import java.util.List;

/**
 * Service layer untuk logika bisnis Cart
 * Bab 7 - Collections
 * Bab 9 - Exception Handling
 */
public class CartService {
    private final Cart cart;

    public CartService() {
        this.cart = new Cart();
    }

    public void addToCart(Product product, int quantity) throws InsufficientStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        }

        if (quantity > product.getStock()) {
            throw new InsufficientStockException(
                    String.format("Stok tidak cukup. Tersedia: %d, Diminta: %d",
                            product.getStock(), quantity)
            );
        }

        cart.addItem(product, quantity);
    }

    public void removeFromCart(String productCode) {
        cart.removeItem(productCode);
    }

    public void clearCart() {
        cart.clear();
    }

    public List<CartItem> getCartItems() {
        return cart.getItems();
    }

    public double calculateTotal() {
        return cart.getTotal();
    }

    public int getItemCount() {
        return cart.getItemCount();
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    public String getCartSummary() {
        if (cart.isEmpty()) {
            return "Keranjang kosong";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== RINGKASAN KERANJANG ===\n");

        for (CartItem item : cart.getItems()) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("---------------------------\n");
        sb.append(String.format("TOTAL: Rp %.2f\n", cart.getTotal()));
        sb.append(String.format("Jumlah Item: %d", cart.getItemCount()));

        return sb.toString();
    }
}
