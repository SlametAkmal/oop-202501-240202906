package main.java.com.upb.agripos.model;

public class Speaker extends Produk {
    private  String varietas;

    public Speaker(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return  varietas; }
    public  void  setVarietas(String varietas) { this.varietas = varietas; }

    public void deskripsi() {
        System.out.println("Nama Barang : " + getNama() + "\n variates speaker : " + getVarietas() + "\n harga Speaker/bungkus :" + getHarga() +"\n");
    }
}
