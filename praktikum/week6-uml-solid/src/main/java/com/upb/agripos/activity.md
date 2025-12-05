classDiagram

%% ===========================
%%        MODELS
%% ===========================
class Produk {
-String nama
-double harga
+Produk(String, double)
+getNama() String
+getHarga() double
}

%% ===========================
%%        ABSTRACT USER
%% ===========================
class User {
<<abstract>>
-String nama
+User(String)
+tampilkanRole() void
}

class Admin {
+Admin(String)
+tampilkanRole() void
+kelolaProduk() void
+lihatLaporan() void
}

class Kasir {
+Kasir(String)
+tampilkanRole() void
+cetakStruk() void
}

User <|-- Admin
User <|-- Kasir


%% ===========================
%%        PAYMENT INTERFACE
%% ===========================
class Pembayaran {
<<interface>>
+prosesPembayaran(double) void
}

class PembayaranTunai {
+prosesPembayaran(double) void
}
class PembayaranEWallet {
+prosesPembayaran(double) void
}

Pembayaran <|.. PembayaranTunai
Pembayaran <|.. PembayaranEWallet


%% ===========================
%%        CHECKOUT PROCESS
%% ===========================
class Checkout {
-List~Produk~ keranjang
+tambahProduk(Produk) void
+hitungTotal() double
+bayar(Pembayaran) void
}

Checkout --> Produk
Checkout --> Pembayaran


%% ===========================
%%        MAIN APP
%% ===========================
class Main {
+main(String[]) void
}
