package com.upb.agripos;

import main.java.com.upb.agripos.Product;

public class Benih extends Product {

    public Benih(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String getInfo() {
        return "Benih: " + nama + " | Harga: " + harga;
    }
}

