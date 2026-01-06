package main.java.com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) throws InvalidQuantityException {
        System.out.println("Hello, I am Slamet Akmal-240202906 (Week9)");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 11);
        Product p2 = new Product("P02", "benih mentimun", -1000,20);

        try {
            cart.addProduct(p1, -1);
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
        try {
            cart.addProduct(p2,2);
        } catch (Exception e) {
            System.out.println("kesalahan: "+ e.getMessage());
        }
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        try {
            cart.checkout();
        } catch (Exception e) {
            System.out.println("kesalahan: "+ e.getMessage());
        }


        try {
            cart.addProduct(p1, 20);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}

