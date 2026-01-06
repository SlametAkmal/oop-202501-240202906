package main.java.com.upb.agripos;

import main.java.com.upb.agripos.kontrak.Receiptable;
import main.java.com.upb.agripos.pembayaran.Cash;
import main.java.com.upb.agripos.pembayaran.Ewalet;
import main.java.com.upb.agripos.pembayaran.Pembayaran;
import main.java.com.upb.agripos.pembayaran.TransferBank;
import main.java.com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("INV-001", 100000, 120000);
        Pembayaran ew = new Ewalet("INV-002", 150000, "user@ewallet", "123456");
        Pembayaran tb = new TransferBank("INV-003", 500000,"2910483989383828",true);

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println(((Receiptable) tb).cetakStruk());

        CreditBy.print("240202906", "Slamet Akmal");
    }
}