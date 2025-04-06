package Bai6_7;

public class Dog extends Animal {

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog[" + super.toString() + ']';
    }

    @Override
    public void greeting() {
        System.out.println("Woof!");
    }

    public void greeting(Dog another) {
        System.out.println("Woooooooooof!");
    }

}