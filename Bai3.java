public class Bai3 {
    public static void main(String[] args) {
        Thread high = new Thread(() -> {
           for(int i = 0; i < 5; i++) System.out.println("High priority thread");
        });

        Thread low = new Thread (() -> {
           for (int i = 0; i < 5 ; i++) System.out.println("Low priority thread");
        });
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        low.start();
        high.start();
    }
}
