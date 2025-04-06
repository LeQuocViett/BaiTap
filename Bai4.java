public class Bai4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           while(!Thread.currentThread().isInterrupted()) {
               System.out.println("Runing....");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println("Thread interrupted");
                   break;
               }
           }
        });

        t1.start();
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e ) {}
        t1.interrupt();
    }
}
