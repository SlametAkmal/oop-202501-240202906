-- Table: Kategori Produk
CREATE TABLE categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: Produk Pertanian
CREATE TABLE products (
    product_id VARCHAR(10) PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

-- Table: User
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    nama_lengkap VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
   Create Indexes
CREATE INDEX idx_category_id ON products(category_id);
CREATE INDEX idx_username ON users(username
CREATE INDEX idx_category_id ON products(category_id);
CREATE INDEX idx_product_id ON sales(product_id);
CREATE INDEX idx_sale_date ON sales(sale_date);
CREATE INDEX idx_stock_product ON stock_history(product_id);
