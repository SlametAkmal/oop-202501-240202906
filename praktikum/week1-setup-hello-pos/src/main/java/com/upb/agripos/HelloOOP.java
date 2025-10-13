package com.upb.agripos;

class Produk {
    String nama;
    int harga;
    Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        String nim = "240202906";
        String namaMhs = "Slamet Akmal";
        Produk[] daftar = {
                new Produk("Speaker", 180000),
                new Produk("Keyboard", 140000),
                new Produk("Mouse", 95000)
        };
        int total = 0;
        System.out.println("Hello OOP World");
        System.out.println("NIM: " + nim + ", Nama: " + namaMhs);
        System.out.println("Daftar Produk:");
        for (Produk p : daftar) {
            System.out.println("- " + p.nama + ": " + p.harga);
            total += p.harga;
        }
        System.out.println("Total harga semua produk: " + total);
    }

}
