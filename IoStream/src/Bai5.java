import java.io.File;

public class Bai5 {
    public static void main(String[] args) {
        File folder = new File(".");
        File[] files = folder.listFiles();

        if (files != null) {
            System.out.println("Các file trong thư mục:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Không thể đọc thư mục!");
        }
    }
}
