package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.AlatKomputer;
import main.java.com.upb.agripos.model.Speaker;
import main.java.com.upb.agripos.model.Keyboard;
import main.java.com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Speaker s = new Speaker("SPK-001", "Speaker Komputer IR64", 180000,100, "64");
        Keyboard k = new Keyboard("KYB-101", "Keyboard Komputer", 140000, 40, "Komputer");
        AlatKomputer a = new AlatKomputer("ALT-501", "Ram", 90000, 15, "Ram");

        s.deskripsi();
        k.deskripsi();
        a.deskripsi();


        CreditBy.print("240202906", "Slamet Akmal");
    }
}
