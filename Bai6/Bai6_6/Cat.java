package Bai6_6;

public abstract class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat[" + super.toString() + ']';
    }
}