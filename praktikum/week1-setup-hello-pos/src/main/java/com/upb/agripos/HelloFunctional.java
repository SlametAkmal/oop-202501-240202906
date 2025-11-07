class Student {
    String nim;
    String name;
    Student(String nim, String name) {
        this.nim = nim;
        this.name = name;
    }

    void introduce() {
        System.out.println("Hello Word, I am " + name + " - ");
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        com.upb.agripos.Student s = new com.upb.agripos.Student("240202906", "Slamet Akmal");
    }

}

