package Baitoankinhdien;
class Philosopher extends Thread {
    private final int id;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
    }

    private void think() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang suy nghĩ...");
        Thread.sleep((int) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang ăn...");
        Thread.sleep((int) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();


                if (leftChopstick.pickUp()) {
                    if (rightChopstick.pickUp()) {
                        eat();
                        rightChopstick.putDown();
                    }
                    leftChopstick.putDown();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Triết gia " + id + " bị gián đoạn!");
        }
    }
}