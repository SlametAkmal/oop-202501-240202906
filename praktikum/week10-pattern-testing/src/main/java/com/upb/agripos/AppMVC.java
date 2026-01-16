package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsolView;

public class AppMVC {
    public static void main(String[] args) {
        System.out.println("Hello, I am Slamet Akmal-240202906 (Week10)");
        Product product = new Product("P01", "Pupuk Organik");
        ConsolView view = new ConsolView();
        ProductController controller = new ProductController(product, view);
        controller.showProduct();
    }
}