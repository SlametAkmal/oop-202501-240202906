# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Slamet Akmal]
- NIM   : [240202906]
- Kelas : [3IKRB]

---

## Tujuan
1. Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
2. Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
3. Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma.
   
## Dasar Teori
Paradigma pemrograman adalah cara pandang dalam menyusun program:

1. Prosedural: program dibangun sebagai rangkaian perintah (fungsi/prosedur).
2. OOP (Object-Oriented Programming): program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).
3. Fungsional: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data.

## Langkah Praktikum
1. Menginstall JDK versi terbaru (25) dan cek instalasinya menggunakan perintah java -version.
2. Membuat file program HelloProcedural.java, HelloOOP.java, dan HelloFunctional.java.
3. Menulis kode sesuai paradigma yang diminta.
4. Melakukan eksekusi program.
5. Mengecek hasil eksekusi di terminal.
6. Membuat commit ke repository GitHub dengan pesan commit "week1-setup-hello-pos"


## Kode Program
- Prosedural
```java
// HelloProcedural
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
```
- OOP (Object-Oriented Programming)
```java
// HelloOOP
class Student {
    String nim;
    String name;
    Student(String nim, String name) {
        this.nim = nim;
        this.name = name;
    }

    void introduce() {
        System.out.println("Hello World, I am " + name + " - " + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Student s = new Student("240202906", "Slamet Akmal");
        s.introduce();
    }
}
```
- Fungsional
```java
// HelloFunctional
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        BiConsumer<String, String> introduce =
            (nim, name) -> System.out.println("Hello World, I am " + name + " - " + nim);

        introduce.accept("240202906", "Slamet Akmal");
    }
}
```

---
## Hasil Eksekusi
HelloProcedural
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week1-setup-hello-pos/screenshots/HasilProcedural.png?raw=true)

HelloOOP
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week1-setup-hello-pos/screenshots/HasilOOP.png?raw=true)

HelloFunctional
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week1-setup-hello-pos/screenshots/HasilFunctional.png?raw=true)
## Analisis
  Cara kerja kode:
- Pada paradigma prosedural, kode hanya berupa urutan instruksi tanpa class.
- Pada paradigma OOP, kode dibungkus dalam class Student sehingga data (nim, name) dan perilaku (introduce()) disatukan.
- Pada paradigma fungsional, digunakan lambda expression dan functional interface (BiConsumer) untuk mencetak pesan.

  Perbedaan dengan minggu sebelumnya:
- Minggu ini mulai diperkenalkan perbedaan paradigma, tidak hanya menulis instruksi sederhana.
- Pendekatan OOP membuat program lebih terstruktur, sedangkan functional membuat kode lebih ringkas.

  Kendala:
- Awalnya bingung membedakan kapan harus pakai class vs lambda.
- Solusi: membaca dokumentasi Java tentang java.util.function dan contoh penggunaan OOP sederhana.



## Kesimpulan
- Prosedural fokus pada urutan instruksi (prosedur) dan sederhana untuk program kecil.
- OOP: Program terdiri dari objek (entitas yang punya data dan aksi). Pilihan terbaik untuk sistem besar dan kompleks seperti   POS karena kode lebih terstruktur dan mudah diurus (maintainable).
- Fungsional: Program adalah transformasi data menggunakan fungsi. Cocok untuk memproses data banyak, karena kodenya ringkas    dan aman untuk dieksekusi bersamaan (concurrent).

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

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?

Jawaban: Functional programming lebih cocok digunakan saat:
- Bekerja dengan operasi data yang intensif seperti filter, map, dan reduce (transformasi data koleksi).
- Membutuhkan konkurensi (pemrosesan paralel) yang aman, karena imutabilitas data (immutable state) mengurangi race condition.
- Diperlukan kode yang ringkas dan bug-free (karena fungsi murni lebih mudah diuji dan diverifikasi).

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?
   
Jawaban:
- Prosedural: Mudah dipahami untuk program kecil, tapi sulit di-maintain ketika aplikasi membesar karena logika dan data sering bercampur. Skalabilitas rendah.
- OOP: Lebih maintainable untuk sistem besar karena ada struktur class, encapsulation, inheritance, dan polymorphism. Skalabilitas tinggi karena mudah menambah fitur dengan objek baru.
- Functional: Maintainability tinggi untuk logika kompleks, karena fungsi murni lebih mudah diuji dan dirangkai ulang. Skalabilitas baik di sistem berbasis data atau yang membutuhkan concurrency.
- 
4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
  
Jawaban: 
- Karena OOP sangat baik dalam memodelkan entitas dunia nyata yang kompleks.
- Di POS, ada Produk, Transaksi, dan Pelanggan.
- OOP memungkinkan Anda membuat objek untuk masing-masing entitas tersebut (misalnya, objek Produk memiliki data harga dan perilaku hitungStok()), membuat sistem lebih terorganisasi dan mudah diperluas di masa depan.
  
5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?
   
Jawaban:
- Dengan menggunakan fungsi siap pakai seperti map, filter, dan ekspresi lambda.
- Daripada menulis loop (kode berulang) setiap kali Anda ingin memproses daftar (misalnya, menghitung total atau mencari item),
- Fungsional memungkinkan Anda langsung menentukan logika pemrosesannya dalam satu baris (lambda).
- Ini membuat kode Anda lebih ringkas, ekspresif, dan fokus pada tujuan (apa yang ingin dicapai) daripada detail (bagaimana mencapainya).
