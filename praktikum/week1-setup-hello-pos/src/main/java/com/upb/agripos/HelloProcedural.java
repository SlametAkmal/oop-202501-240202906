package com.upb.agripos;

public class HelloProcedural {
    public static void main(String[] args) {
        String nim = "240202906";
        String nama = "Slamet Akmal";
        String[] produk = {"Speaker", "Keyboard", "Mouse"};
        int[] harga = {180000, 140000, 95000};
        int total = 0;
        System.out.println("Hello POS World");
        System.out.println("NIM: " + nim + ", Nama: " + nama);
        System.out.println("Daftar Produk:");
        for (int i = 0; i < produk.length; i++) {
            System.out.println("- " + produk[i] + ": " + harga[i]);
            total += harga[i];
        }
        System.out.println("Total harga semua produk: " + total);
    }
}
