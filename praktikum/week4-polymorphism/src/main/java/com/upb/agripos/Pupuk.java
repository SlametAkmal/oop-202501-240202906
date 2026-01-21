package com.upb.agripos;

import com.upb.agripos.Produk;

public class Pupuk extends Produk {

    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return  "Nama: " + super.getInfo() + ", jenis: " + jenis;
    }
}
