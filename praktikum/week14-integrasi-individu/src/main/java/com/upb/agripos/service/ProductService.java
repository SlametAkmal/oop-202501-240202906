package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.exception.DatabaseException;
import com.upb.agripos.exception.InvalidProductException;
import com.upb.agripos.model.Product;

import java.util.List;

/**
 * Service layer untuk logika bisnis Product
 * Bab 6 - SOLID (Single Responsibility, Dependency Inversion)
 */
public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts() throws DatabaseException {
        return productDAO.findAll();
    }

    public Product getProductByCode(String code) throws DatabaseException {
        return productDAO.findByCode(code);
    }

    public void addProduct(Product product) throws InvalidProductException, DatabaseException {
        validateProduct(product);
        productDAO.insert(product);
    }

    public void updateProduct(Product product) throws InvalidProductException, DatabaseException {
        validateProduct(product);
        productDAO.update(product);
    }

    public void deleteProduct(String code) throws InvalidProductException, DatabaseException {
        if (code == null || code.trim().isEmpty()) {
            throw new InvalidProductException("Kode produk tidak boleh kosong");
        }
        productDAO.delete(code);
    }

    private void validateProduct(Product product) throws InvalidProductException {
        if (product.getCode() == null || product.getCode().trim().isEmpty()) {
            throw new InvalidProductException("Kode produk tidak boleh kosong");
        }

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new InvalidProductException("Nama produk tidak boleh kosong");
        }

        if (product.getPrice() <= 0) {
            throw new InvalidProductException("Harga produk harus lebih dari 0");
        }

        if (product.getStock() < 0) {
            throw new InvalidProductException("Stok produk tidak boleh negatif");
        }
    }
}
