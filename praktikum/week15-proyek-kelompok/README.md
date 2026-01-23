# AgriPOS - Agricultural Point of Sale System

<div align="center">

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=flat)](https://gluonhq.com/products/javafx/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13+-336791?style=flat&logo=postgresql)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-Build-yellow?style=flat&logo=apache-maven)](https://maven.apache.org/)

</div>

## 📋 Overview

**AgriPOS** adalah sistem Point of Sale (POS) desktop berbasis Java untuk mengelola penjualan produk pertanian seperti pupuk, buah-buahan, dan umbi-umbian. Sistem ini menyediakan solusi terintegrasi untuk transaksi penjualan, manajemen stok, dan pelaporan.

### 🎯 Fitur Utama

- ✅ **Multi-Role Authentication** - Otentikasi dengan role Kasir dan Admin
- ✅ **Manajemen Produk** - CRUD produk dengan kategori, harga, dan stok real-time
- ✅ **Manajemen Pengguna** - Admin dapat mengelola user dan role
- ✅ **Keranjang Belanja** - Add/remove produk, update quantity
- ✅ **Metode Pembayaran** - Support Tunai dan E-Wallet
- ✅ **Struk Digital** - Tampilan struk otomatis setelah pembayaran
- ✅ **Riwayat Transaksi** - Filter berdasarkan kasir dan metode pembayaran
- ✅ **Laporan Penjualan** - Laporan dengan date range filter dan statistik
- ✅ **Export Excel** - Export data transaksi ke format Excel

---

## 🛠️ Teknologi

| Komponen | Versi |
|----------|--------|
| **Java** | 17 LTS |
| **JavaFX** | 21.0.1 |
| **Database** | PostgreSQL 13+ |
| **Build Tool** | Maven |
| **JDBC Driver** | PostgreSQL 42.6.0 |
| **Excel Library** | Apache POI 5.2.3 |

---

## 📋 Prasyarat Sistem

- **Java Runtime Environment (JRE)**: 17 atau lebih tinggi
- **PostgreSQL**: 13 atau lebih tinggi
- **RAM**: Minimum 2GB (4GB recommended)
- **Disk Space**: 500MB
- **OS**: Windows, macOS, atau Linux

---

## 🚀 Quick Start

### 1. Setup Database PostgreSQL

```bash
# Buka PostgreSQL dan buat database baru
psql -U postgres

# Di PostgreSQL prompt:
CREATE DATABASE agripos;
\c agripos
```

### 2. Import Schema

Jalankan file SQL untuk membuat struktur tabel:

```bash
psql -U postgres -d agripos -f docs/schema.sql
```

### 3. Clone dan Build Proyek

```bash
# Clone repository
git clone <repository-url>
cd week15-proyek-kelompok

# Build dengan Maven
mvn clean package
```

### 4. Konfigurasi Database

Edit file `src/main/java/com/upb/agripos/config/EnvConfig.java`:

```java
public static final String DB_URL = "jdbc:postgresql://localhost:5432/agripos";
public static final String DB_USER = "postgres";
public static final String DB_PASSWORD = "your_password";
```

### 5. Jalankan Aplikasi

```bash
# Gunakan Maven plugin JavaFX
mvn javafx:run

# Atau dengan Java command
java -cp target/classes:target/lib/* com.upb.agripos.AppJavaFX
```

---

## 👥 Test Credentials

Gunakan akun berikut untuk login:

### Kasir Account
```
Username: kasir
Password: 12345
Role: Kasir (Cashier)
```

### Admin Account
```
Username: admin
Password: 12345
Role: Admin
```

---

## 📂 Struktur Proyek

```
agripos/
├── src/
│   ├── main/
│   │   ├── java/com/upb/agripos/
│   │   │   ├── AppJavaFX.java              # Entry point aplikasi
│   │   │   ├── config/
│   │   │   │   └── EnvConfig.java          # Konfigurasi database
│   │   │   ├── controller/
│   │   │   │   ├── LoginController.java    # Kontrol login
│   │   │   │   ├── KasirController.java    # Kontrol transaksi kasir
│   │   │   │   └── AdminController.java    # Kontrol admin
│   │   │   ├── dao/
│   │   │   │   ├── DatabaseConnection.java # Koneksi DB
│   │   │   │   ├── IUserDAO.java           # Interface User DAO
│   │   │   │   ├── IProductDAO.java        # Interface Product DAO
│   │   │   │   ├── UserDAOImpl.java         # Implementasi User DAO
│   │   │   │   └── ProductDAOImpl.java      # Implementasi Product DAO
│   │   │   ├── exception/
│   │   │   │   ├── DatabaseException.java  # Exception database
│   │   │   │   ├── LoginException.java     # Exception login
│   │   │   │   ├── ValidationException.java # Exception validasi
│   │   │   │   └── OutOfStockException.java # Exception stok habis
│   │   │   ├── model/
│   │   │   │   ├── User.java               # Model pengguna
│   │   │   │   ├── Product.java            # Model produk
│   │   │   │   ├── Cart.java               # Model keranjang
│   │   │   │   ├── CartItem.java           # Model item keranjang
│   │   │   │   ├── Transaction.java        # Model transaksi
│   │   │   │   └── TransactionHistory.java # Model history
│   │   │   ├── service/
│   │   │   │   ├── AuthService.java        # Service autentikasi
│   │   │   │   ├── ProductService.java     # Service produk
│   │   │   │   ├── CategoryService.java    # Service kategori
│   │   │   │   ├── CartService.java        # Service cart
│   │   │   │   ├── TransactionService.java # Service transaksi
│   │   │   │   ├── PaymentMethod.java      # Interface pembayaran
│   │   │   │   ├── CashPayment.java        # Pembayaran tunai
│   │   │   │   ├── EWalletPayment.java     # Pembayaran e-wallet
│   │   │   │   ├── ReportService.java      # Service laporan
│   │   │   │   └── ExcelExportService.java # Service export Excel
│   │   │   ├── view/
│   │   │   │   ├── LoginView.java          # View login
│   │   │   │   ├── KasirView.java          # View kasir
│   │   │   │   ├── AdminView.java          # View admin
│   │   │   │   └── ReceiptDialog.java      # Dialog struk
│   │   │   └── styles/
│   │   │       └── StyleConstants.java     # Konstanta styling
│   │   └── resources/
│   │       └── styles/
│   │           ├── main.css                # CSS styling
│   │           └── javafx.css              # JavaFX styling
│   └── test/
│       └── java/com/upb/agripos/
│           └── CartServiceTest.java        # Unit test
├── docs/
│   ├── 01_srs.md                  # Software Requirements Specification
│   ├── 02_arsitektur.md           # Dokumentasi arsitektur
│   ├── 03_database.md             # Schema database
│   ├── 04_test_plan.md            # Rencana testing
│   ├── 05_test_report.md          # Laporan testing
│   ├── 06_user_guide.md           # Panduan pengguna
│   ├── 07_runbook.md              # Runbook operasional
│   └── 08_contribution.md         # Panduan kontribusi
├── laporan_week15.md              # Laporan minggu 15
├── pom.xml                        # Maven configuration
└── README.md                      # File ini
```

---

## 🏗️ Arsitektur Sistem

### Layer Architecture

```
┌─────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                   │
│  LoginView  │  KasirView  │  AdminView  │  ReceiptDialog│
└────────────────────┬────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────┐
│                    CONTROLLER LAYER                     │
│         (LoginCtrl, KasirCtrl, AdminCtrl)               │
└────────────────────┬────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────┐
│                    SERVICE LAYER                        │
│  Auth  │ Product │ Category │ Cart │ Transaction │      │
│  Report │ Excel Export │ Payment Methods               │
└────────────────────┬────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────┐
│                    DATA ACCESS LAYER (DAO)              │
│  UserDAOImpl  │  ProductDAOImpl  │  DatabaseConnection   │
└────────────────────┬────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────┐
│                    DATABASE LAYER                       │
│                    PostgreSQL                           │
└─────────────────────────────────────────────────────────┘
```

### Database Schema

Terdiri dari 4 tabel utama:

- **users** - Data pengguna (kasir, admin)
- **products** - Data produk dengan kategori
- **transactions** - Catatan transaksi penjualan
- **cart** - Data keranjang belanja sementara

Lihat [docs/03_database.md](docs/03_database.md) untuk detail lengkap.

---

## 📖 Panduan Pengguna

### Untuk Kasir (Cashier)

1. **Login** dengan credentials kasir
2. **Search Produk** menggunakan search field
3. **Add to Cart** dengan menentukan quantity
4. **Review Cart** dan modify jika diperlukan
5. **Checkout** dan pilih metode pembayaran
6. **Proses Pembayaran** dan lihat struk

Lihat [docs/06_user_guide.md](docs/06_user_guide.md#for-cashier-users-kasir) untuk detail lengkap.

### Untuk Admin

1. **Login** dengan credentials admin
2. **Manajemen Produk** - CRUD produk dan kategori
3. **Manajemen Pengguna** - Tambah/edit/hapus user
4. **Lihat Laporan** - Filter transaksi berdasarkan tanggal
5. **Export ke Excel** - Export laporan untuk analisis

Lihat [docs/06_user_guide.md](docs/06_user_guide.md#for-admin-users) untuk detail lengkap.

---

## 🧪 Testing

### Menjalankan Unit Tests

```bash
# Jalankan semua test
mvn test

# Jalankan test spesifik
mvn test -Dtest=CartServiceTest
```

### Test Coverage

- **CartService** - Unit test untuk shopping cart logic
- **Integration Test** - Testing database connectivity
- **UI Test** - Manual testing untuk semua workflow

Lihat [docs/04_test_plan.md](docs/04_test_plan.md) dan [docs/05_test_report.md](docs/05_test_report.md) untuk detail lengkap.

---

## 📊 Functional Requirements

| ID | Fitur | Status |
|----|-------|--------|
| FR-1 | Login System | ✅ Implemented |
| FR-2 | Product Management | ✅ Implemented |
| FR-3 | Category Management | ✅ Implemented |
| FR-4 | User Management | ✅ Implemented |
| FR-5 | Shopping Cart | ✅ Implemented |
| FR-6 | Payment Methods | ✅ Implemented |
| FR-7 | Transaction Receipt | ✅ Implemented |
| FR-8 | Transaction History | ✅ Implemented |
| FR-9 | Sales Report | ✅ Implemented |
| FR-10 | Excel Export | ✅ Implemented |

---

## 🔒 Security

- ✅ Password handling dengan proper masking
- ✅ Input validation untuk semua form
- ✅ SQL injection protection dengan prepared statements
- ✅ Role-based access control
- ✅ Exception handling dengan pesan user-friendly

---

## 📦 Build & Deployment

### Development Build

```bash
mvn clean compile
mvn javafx:run
```

### Production Build

```bash
mvn clean package
# JAR akan tersedia di target/week15-proyek-kelompok-1.0-SNAPSHOT.jar
```

### Running JAR

```bash
java -cp target/classes:target/lib/* com.upb.agripos.AppJavaFX
```

---

## 🤝 Team

| No | Nama | NIM | Peran |
|---|---|---|---|
| 1 | Wahyu Tri Cahya | 240202889 | Payment Processing, Reports & System Integration |
| 2 | Abu Zaki | 240202892 | Login & Authentication |
| 3 | Slamet Akmal | 240202906 | Product Management & Service Layer |
| 4 | Tyas Nurshika Damaia | 240202887 | Transaction UI & Cart Management |

---

## 📚 Dokumentasi Lengkap

- [SRS - Software Requirements Specification](docs/01_srs.md)
- [Arsitektur Sistem](docs/02_arsitektur.md)
- [Database Schema](docs/03_database.md)
- [Test Plan](docs/04_test_plan.md)
- [Test Report](docs/05_test_report.md)
- [User Guide](docs/06_user_guide.md)
- [Runbook](docs/07_runbook.md)
- [Contribution Guidelines](docs/08_contribution.md)
- [Project Report](laporan_week15.md)

---

## 📝 License

Project ini dikembangkan sebagai bagian dari mata kuliah Object-Oriented Programming di Universitas Putra Bangsa.

---

## ❓ FAQ

### Q: Bagaimana cara reset password admin?
A: Hubungi administrator sistem atau query langsung ke database PostgreSQL.

### Q: Apakah sistem mendukung multi-branch?
A: Tidak, saat ini hanya single-store. Multi-branch adalah future enhancement.

### Q: Bagaimana cara backup database?
A: Gunakan `pg_dump` untuk PostgreSQL:
```bash
pg_dump agripos > backup.sql
```

### Q: Apakah ada payment gateway integration?
A: Saat ini hanya mock payment. Real payment gateway bisa di-integrate di masa depan.

---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| **Database Connection Error** | Pastikan PostgreSQL running dan credentials benar di EnvConfig.java |
| **JavaFX Display Issue** | Pastikan JavaFX libraries di classpath dan Java 17+ installed |
| **Port 5432 Already in Use** | Ganti port di connection string atau stop PostgreSQL service lain |
| **OutOfMemory Error** | Increase JVM heap size: `java -Xmx2g ...` |

---

## 📞 Support

Untuk pertanyaan atau issue, silakan buka GitHub issue atau hubungi tim development.

---

**Last Updated**: January 23, 2026  
**Version**: 1.0-SNAPSHOT
