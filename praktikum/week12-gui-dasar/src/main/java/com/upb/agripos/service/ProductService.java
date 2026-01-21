package com.upb.agripos.service;

import com.upb.agripos.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void insert(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}