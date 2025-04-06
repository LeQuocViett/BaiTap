class Bai5 {
    private static volatile  boolean flag = true;

    public static void main(String[] args) {
        Thread writer = new Thread(()-> {
           try {
              Thread.sleep(2000);
           } catch (InterruptedException e) {}
           flag = false;
        });

        Thread reader = new Thread(()-> {
           while (flag) {}
            System.out.println("Reader detected flag change!");
        });
        reader.start();
        writer.start();
    }
}