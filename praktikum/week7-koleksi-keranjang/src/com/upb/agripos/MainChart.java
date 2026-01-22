package com.upb.agripos;

import com.upb.agripos.model.Product;

public class MainChart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Slamet Akmal-240202906 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        ShoppingChart cart = new ShoppingChart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
        CreditBy.print("240202906", "Slamet Akmal");
    }
}