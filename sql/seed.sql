-- Seed: Kategori Produk
INSERT INTO categories (category_name) VALUES
('Alat-alat'),
('Bibit'),
('Pestisida'),
('Pupuk');

-- Seed: Produk
INSERT INTO products (product_id, product_name, category_id, price) VALUES
('P001', 'Pupuk Organik', 4, 50000),
('P002', 'Bibit Padi', 2, 75000),
('P003', 'Pestisida Alami', 3, 120000),
('P004', 'Pupuk NPK', 4, 85000),
('P005', 'Bibit Jagung', 2, 45000),
('P006', 'Cangkul', 1, 150000);

-- Seed: User
INSERT INTO users (username, nama_lengkap, role) VALUES
('admin', 'Administrator', 'ADMIN'),
('kasir', 'Andi Wijaya', 'KASIR'),
('kasir2', 'Budi Santoso', 'KASIR');
