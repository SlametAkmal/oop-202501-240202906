package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.AlatPertanian;
import main.java.com.upb.agripos.model.Benih;
import main.java.com.upb.agripos.model.Pupuk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Pupuk b = new Pupuk("BNH-001", "Banih Padi IR64", 25000,100, "IR64");
        Benih p = new Benih("PPK-101", "Pupuk Urea", 350000, 40, "Komputer");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        b.deskripsi();
        p.deskripsi();
        a.deskripsi();


        CreditBy.print("240202906", "Slamet Akmal");
    }
}
