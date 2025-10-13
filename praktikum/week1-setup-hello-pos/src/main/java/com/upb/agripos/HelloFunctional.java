package com.upb.agripos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HelloFunctional {
    public static void main(String[] args) {
        String nim = "240202906";
        String nama = "Slamet Akmal";
        List<String> produk = Arrays.asList("Speaker", "Keyboard", "Mouse");
        List<Integer> harga = Arrays.asList(180000, 140000, 95000);
        System.out.println("Hello Functional World");
        System.out.println("NIM: " + nim + ", Nama: " + nama);
        System.out.println("Daftar Produk:");
        IntStream.range(0, produk.size())
                .forEach(i -> System.out.println("- " + produk.get(i) + ": " + harga.get(i)));
        int total = harga.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total harga semua produk: " + total);
    }
}
