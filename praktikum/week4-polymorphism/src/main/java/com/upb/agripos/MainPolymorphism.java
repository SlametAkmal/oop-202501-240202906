package com.upb.agripos;
import com.upb.agripos.model.AlatPertanian;
import com.upb.agripos.model.Benih;
import com.upb.agripos.model.ObatHama;
import com.upb.agripos.model.Produk;
import com.upb.agripos.model.Pupuk;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
                new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
                new Pupuk("PPK-101", "Pupuk Urea", 35000, 40, "Urea"),
                new AlatPertanian("ALT-501", "Cangkul Baja", 9000, 15, "Baja"),
                new ObatHama("OBT-220", "Wastak", 25000, 4, "basmi wereng")
        };

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }

        CreditBy.print("240202906", "Slamet Akmal");
    }
}