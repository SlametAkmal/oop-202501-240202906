package main.java.com.upb.agripos;

public class Pupuk extends Produk {

    private  String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return  jenis; }
    public  void  setJenis(String varietas) { this.jenis = varietas; }

    public void deskripsi() {
        System.out.println("Nama Barang : " + getNama() + "\n   Jenis Pupuk : " + getJenis() + "\n    harga pupuk/20kg :" + getHarga() +"\n");
    }
}
