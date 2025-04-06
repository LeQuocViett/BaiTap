package Bai4_6;

public class TestMain {

    public static void main(String[] args) {
        Cat c1 = new Cat("Gia Kinh");
        System.out.println(c1);
        c1.greets();
        Dog d1 = new Dog("Lan Anh");
        Dog d2 = new Dog("Noki");
        System.out.println(d1);
        System.out.println(d2);
        d1.greets();
        d1.greets(d2);
    }
}
