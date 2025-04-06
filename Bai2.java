class Resource {
     String name;

     Resource(String name) {
        this.name = name;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Resource res1 = new Resource("A");
        Resource res2 = new Resource("B");

        Thread t1 = new Thread (() -> {
           synchronized(res1) {
               System.out.println("T1 locked " + res1.name);
               synchronized(res2) {
                   System.out.println("T1 locked " + res2.name);
               }
           }
        });

        Thread t2 = new Thread (() -> {
            synchronized(res1) {
                System.out.println("T2 locked " + res1.name);
                synchronized(res2) {
                    System.out.println("T2 locked " + res2.name);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
