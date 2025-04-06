package Bai6_7;

public class Cat extends Animal {

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat[" + super.toString() + ']';
    }

    @Override
    public void greeting() {
        System.out.println("Meow!");
    }

}