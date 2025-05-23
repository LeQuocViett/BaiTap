package BanhMy;

import java.util.LinkedList;
import java.util.List;

class Store {
    private List<Long> store = new LinkedList<>();
    private final int size = 10;

    public synchronized boolean put(long index) {
        while (store.size() >= size) {
            try {
                System.out.println("Kho đầy! Thợ sản xuất chờ...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        store.add(index);
        System.out.println("Sản phẩm " + index + " đã được sản xuất.");
        notify();
        return true;
    }

    public synchronized long get() {
        while (store.isEmpty()) {
            try {
                System.out.println("Kho trống! Người tiêu dùng chờ...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long product = store.remove(0);
        System.out.println("Người tiêu dùng đã lấy sản phẩm " + product);
        notify();
        return product;
    }
}