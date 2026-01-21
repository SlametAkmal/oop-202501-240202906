package com.upb.agripos.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model untuk keranjang belanja
 * Bab 7 - Collections (List dan Map)
 */
public class Cart {
    private List<CartItem> items;
    private Map<String, Integer> productQuantities;

    public Cart() {
        this.items = new ArrayList<>();
        this.productQuantities = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        String code = product.getCode();

        if (productQuantities.containsKey(code)) {
            // Update quantity jika sudah ada
            int newQty = productQuantities.get(code) + quantity;
            productQuantities.put(code, newQty);

            // Update di list
            for (CartItem item : items) {
                if (item.getProduct().getCode().equals(code)) {
                    item.setQuantity(newQty);
                    break;
                }
            }
        } else {
            // Tambah item baru
            CartItem item = new CartItem(product, quantity);
            items.add(item);
            productQuantities.put(code, quantity);
        }
    }

    public void removeItem(String productCode) {
        items.removeIf(item -> item.getProduct().getCode().equals(productCode));
        productQuantities.remove(productCode);
    }

    public void clear() {
        items.clear();
        productQuantities.clear();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
