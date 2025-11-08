# Laporan Praktikum Minggu 4 (sesuaikan minggu ke berapa?)
Topik: ["Polymorphism"]

## Identitas
- Nama  : [Slamet Akmal]
- NIM   : [240202906]
- Kelas : [3IKRB]

---

## Tujuan
(Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.  
- Mahasiswa mampu membedakan method overloading dan overriding.
- Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
- Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).)

---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.

- Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
- Overriding → subclass mengganti implementasi method dari superclass.
- Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.
Dalam konteks Agri-POS, misalnya:

Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).
---

## Langkah Praktikum
Overloading

Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.
Overriding

Tambahkan method getInfo() pada superclass Produk.
Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.
Dynamic Binding

Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.
Main Class

Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
CreditBy

Tetap panggil CreditBy.print("<NIM>", "<Nama>").
Commit dan Push

Commit dengan pesan: week4-polymorphism.
---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi

![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week4-polymorphism/screenshots/Hasil.png.png?raw=true)
---

## Analisis
(Tentu, berikut adalah analisis singkat Bab 4 – Polymorphism, diringkas menjadi dua kalimat untuk setiap poin:

Analisis Bab 4 – Polymorphism (Info Produk)
Analisa kode berjalan. Kode ini menggunakan Polymorphism dengan overriding method getInfo() di setiap subclass untuk menampilkan detail spesifik produk. Melalui loop pada array referensi Produk[], dynamic binding secara otomatis memanggil implementasi getInfo() yang benar saat runtime berdasarkan objek aktual, bukan tipe referensi.

perbedaan minggu ini dibanding minggu sebelumnya. Minggu lalu (Inheritance) berfokus pada pewarisan struktur data (attributes), membuat subclass mendapatkan properti umum. Minggu ini (Polymorphism) berfokus pada perilaku yang beragam (methods), di mana satu panggilan method menghasilkan respons yang berbeda-beda, memungkinkan penanganan semua produk secara seragam.)
---

## Kesimpulan
(Polymorphism untuk menciptakan sistem Agri-POS yang fleksibel. Dengan menggunakan Overriding pada getInfo(), objek yang berbeda merespons panggilan method yang sama dengan perilaku yang berbeda, menghasilkan deskripsi produk yang spesifik. Dynamic Binding memungkinkan penanganan berbagai jenis produk (Benih, Pupuk, dll.) secara seragam melalui satu tipe referensi (Produk), menjadikan kode lebih modular dan mudah dikelola.*)

---

## Quiz
(1. [Apa perbedaan overloading dan overriding?]  
   **Jawaban:**
   - Overloading adalah method dengan nama sama, parameter beda, terjadi dalam satu class atau class terkait.
   - Overriding adalah method dengan nama dan parameter sama, terjadi antara superclass dan subclass, tujuannya mengganti implementasi method superclass.

2. [Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?] 
   **Jawaban:** …  
   - Java menentukan saat runtime dengan melihat tipe objek aktual (bukan tipe referensi yang dideklarasikan). Ini memastikan method yang paling spesifik dari subclass yang sedang direferensikan yang akan dieksekusi.

3. [Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.]  
   **Jawaban:** …  Penggunaan method hitungDiskon() pada superclass Item. Subclass seperti FoodItem (makanan) bisa meng-override method tersebut untuk memberikan diskon 10%, sementara ElectronicItem bisa meng-override untuk memberikan diskon musiman 5%.)
