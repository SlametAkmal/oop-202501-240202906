package main.java.com.upb.agripos.model;

public class Keyboard extends Produk {

    private String jenis;

    public Keyboard(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return  jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public void deskripsi() {
        System.out.println("Nama Barang : " + getNama() + "\n Jenis Keyboard : " + getJenis() + "\n harga keyboard/140000 :" + getHarga() +"\n");
    }
}
