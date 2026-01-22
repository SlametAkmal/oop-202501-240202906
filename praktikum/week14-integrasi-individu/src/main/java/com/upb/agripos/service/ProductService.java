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
        try {
            return productDAO.findAll();
        } catch (Exception e) {
            throw new DatabaseException("Gagal mengambil data produk", e);
        }
    }

    public Product getProductByCode(String code) throws DatabaseException {
        try {
            return productDAO.findByCode(code);
        } catch (Exception e) {
            throw new DatabaseException("Gagal mengambil produk dengan kode: " + code, e);
        }
    }


    public void addProduct(Product product)
            throws InvalidProductException, DatabaseException {
        try {
            productDAO.insert(product);
        } catch (InvalidProductException e) {
            throw e; // validasi, teruskan
        } catch (Exception e) {
            throw new DatabaseException("Gagal menambah produk", e);
        }
    }


    public void updateProduct(Product product) throws DatabaseException {
        try {
            productDAO.update(product);
        } catch (Exception e) {
            throw new DatabaseException("Gagal update produk", e);
        }
    }


    public void deleteProduct(String code) throws DatabaseException {
        try {
            productDAO.delete(code);
        } catch (Exception e) {
            throw new DatabaseException("Gagal hapus produk", e);
        }
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
