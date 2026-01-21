package com.upb.agripos.dao;

import com.upb.agripos.exception.DatabaseException;
import com.upb.agripos.model.Product;
import com.upb.agripos.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementasi JDBC untuk ProductDAO
 * Bab 11 - JDBC & Database
 */
public class JdbcProductDAO implements ProductDAO {

    @Override
    public List<Product> findAll() throws DatabaseException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT code, name, price, stock FROM products ORDER BY code";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
                products.add(p);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching products", e);
        }

        return products;
    }

    @Override
    public Product findByCode(String code) throws DatabaseException {
        String sql = "SELECT code, name, price, stock FROM products WHERE code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding product: " + code, e);
        }

        return null;
    }

    @Override
    public void insert(Product product) throws DatabaseException {
        String sql = "INSERT INTO products (code, name, price, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error inserting product", e);
        }
    }

    @Override
    public void update(Product product) throws DatabaseException {
        String sql = "UPDATE products SET name = ?, price = ?, stock = ? WHERE code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getStock());
            ps.setString(4, product.getCode());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error updating product", e);
        }
    }

    @Override
    public void delete(String code) throws DatabaseException {
        String sql = "DELETE FROM products WHERE code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, code);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error deleting product", e);
        }
    }
}