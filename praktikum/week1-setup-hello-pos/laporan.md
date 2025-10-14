# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Slamet Akmal]
- NIM   : [240202906]
- Kelas : [3IKRB]

---

## Tujuan
1. Mahasiswa dapat memahami konsep tiga dasar paradigma pemrograman: procedural, oop, dan fungcional. ( dalam bahasa java)

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1. Class adalah blueprint dari objek.  
2. Object adalah instansiasi dari class.  
3. Enkapsulasi digunakan untuk menyembunyikan data.)

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit message yang digunakan.)

---

## Kode Program
Procedural
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
## Hasil Eksekusi
HelloProcedural
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week1-setup-hello-pos/screenshots/HasilProcedural.png?raw=true)

HelloOOP
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week1-setup-hello-pos/screenshots/HasilOOP.png?raw=true)

HelloFunctional
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week1-setup-hello-pos/screenshots/HasilFunctional.png?raw=true)
## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** Procedural HelloProcedural.java
Program ini menggunakan pendekatan prosedural, yaitu semua perintah dijalankan secara berurutan dalam satu fungsi utama main(). Di dalamnya terdapat dua variabel, nama dan nim, yang menyimpan nilai "Slamet Akmal" dan "240202906". Keduanya digabung menggunakan System.out.println("Hello World, I am " + nama + "-" + nim); untuk menampilkan hasil di layar. Semua logika berada di satu tempat tanpa class atau objek tambahan. Pendekatan ini mudah dipahami untuk program kecil namun kurang efisien untuk sistem besar karena tidak terstruktur.
Output:

Hello Functional World
NIM: 240202906, Nama: Slamet Akmal
Daftar Produk:
- Speaker: 180000
- Keyboard: 140000
- Mouse: 95000
Total harga semua produk: 415000 

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
