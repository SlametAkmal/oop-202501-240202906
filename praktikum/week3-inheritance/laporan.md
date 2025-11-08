# Laporan Praktikum Minggu 3 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Slamet Akmal]
- NIM   : [240202906]
- Kelas : [3IKRB]

---

## Tujuan
(- Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
- Mahasiswa mampu membuat superclass dan subclass untuk produk komputer.
- Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
- Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
- Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.*)

---

## Dasar Teori
(Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.

- Superclass: class induk yang mendefinisikan atribut umum.
- Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
- super digunakan untuk memanggil konstruktor atau method superclass.)

---

## Langkah Praktikum
(embuat Superclass Produk

Gunakan class Produk dari Bab 2 sebagai superclass.
Membuat Subclass

Speaker.java → atribut tambahan: varietas.
Keyboard.java → atribut tambahan: jenis komputer (ram, mouse, dll).
AlatKomputer.java → atribut tambahan: material (ram).
Membuat Main Class

Instansiasi minimal satu objek dari tiap subclass.
Tampilkan data produk dengan memanfaatkan inheritance.
Menambahkan CreditBy

Panggil class CreditBy untuk menampilkan identitas mahasiswa.
Commit dan Push

Commit dengan pesan: week3-inheritance.)

---

## Benih.java

```java
package main.java.com.upb.agripos.model;

import main.java.main.java.com.upb.agripos.model.Produk;

public class Benih extends Produk {

    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() {
        return varietas;
    }

    public void setVarietas(String jenis) {
        this.varietas = varietas;
    }

    public void deskripsi() {
        System.out.println("Nama Barang : " + getNama() + "\n Varietas benih : " + getVarietas() + "\n harga Benih/bungkus :" + getHarga() + "\n");
    }
}
```
## Pupuk.java

```java
package main.java.com.upb.agripos.model;

import main.java.main.java.com.upb.agripos.model.Produk;

public class Pupuk extends Produk {

    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String varietas) {
        this.jenis = varietas;
    }

    public void deskripsi() {
        System.out.println("Nama Barang : " + getNama() + "\n   Jenis Pupuk : " + getJenis() + "\n    harga pupuk/20kg :" + getHarga() + "\n");
    }
}
```
## AlatKomputer.java
```java
public class AlatPertanian extends Produk{

    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama,harga,stok );
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public void deskripsi(){
        System.out.println("Nama Barang : "+ getNama() + "\n Mterial yang dipakai : " + getMaterial() + "\n harga barang :" + getHarga() +"\n");
    }
}

```
## MainInheitance.java

```java
package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Pupuk;
import main.java.com.upb.agripos.util.MainPolymorphism;

public class MainInheritance {
    public static void main(String[] args) {
        Pupuk b = new Pupuk("BNH-001", "Banih Padi IR64", 25000, 100, "IR64");
        Benih p = new Benih("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        b.deskripsi();
        p.deskripsi();
        a.deskripsi();


        CreditBy.print("240202906", "Slamet Akmal");
    }
}
```
---

## Hasil Eksekusi
![alt text](https://github.com/SlametAkmal/oop-202501-240202906/blob/main/praktikum/week3-inheritance/screenshots/Hasil.png?raw=true)
---

## Analisis
Penjelasan Cara Kerja Kode
Kode ini bekerja dengan menerapkan inheritance, di mana tiga subclass (Speaker, Keyboard, dan AlatKomputer) mewarisi semua properti dasar dari superclass (Produk). Setiap subclass memanggil konstruktor superclass menggunakan super() untuk menginisialisasi atribut umum, kemudian menambahkan dan menampilkan atribut uniknya masing-masing seperti varietas, jenis, atau material.

Perbedaan Pendekatan Minggu Ini
Pendekatan minggu ini menggunakan pewarisan untuk menciptakan hierarki yang terstruktur, yang memungkinkan reuse kode dan spesialisasi produk. Berbeda dengan minggu sebelumnya yang menggunakan class tunggal atau class-class terpisah, pendekatan ini menghindari duplikasi atribut umum seperti nama dan harga di setiap jenis produk.

---

## Kesimpulan
(implementasi Inheritance (Pewarisan) dalam OOP dengan membuat hierarki class untuk produk pertanian. Superclass Produk mendefinisikan atribut dasar yang umum (kode, nama, harga, stok), sementara Subclass (seperti Benih, Pupuk Urea, dan AlatPertanian) mewarisi atribut tersebut dan menambahkan properti yang spesifik (varietas, jenis, material). Penggunaan keyword super() dalam konstruktor subclass memastikan inisialisasi yang efisien terhadap data superclass, yang pada akhirnya menghasilkan kode yang lebih reusable, terstruktur, dan mudah dipelihara dibandingkan dengan pendekatan class tunggal. Pendekatan ini adalah pondasi penting untuk sistem Agri-POS agar dapat mengelola berbagai jenis produk secara modular.

*)

---

## Quiz
(1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
Jawaban: Keuntungan utamanya adalah Reusabilitas Kode (Code Reusability), karena atribut dan method umum hanya perlu didefinisikan sekali di superclass dan secara otomatis tersedia di semua subclass. Selain itu, inheritance menciptakan struktur hierarkis yang jelas (Is-A relationship), yang membuat kode lebih mudah dipelihara (pemeliharaan) dan lebih mudah untuk dikembangkan atau dispesialisasikan (misalnya, menambahkan atribut khusus).

 …  

2. Bagaimana cara subclass memanggil konstruktor superclass?
Jawaban: Subclass memanggil konstruktor superclass menggunakan keyword super() di dalam konstruktornya sendiri. Panggilan super(...) ini menjadi baris perintah pertama dalam konstruktor subclass dan argumen yang diteruskan harus sesuai dengan parameter konstruktor yang didefinisikan di superclass. …  

3. Berikan contoh kasus di POS Komputer selain Speaker, Keyboard, dan Alat Komputer yang bisa dijadikan subclass.
Jawaban: Contoh kasus lain yang bisa dijadikan subclass dari Produk adalah Pestisida dan Obat Hewan. Pestisida dapat memiliki atribut tambahan seperti TargetHama atau BahanAktif, sedangkan Obat Hewan dapat memiliki atribut seperti JenisTernak atau Dosis. …  )
