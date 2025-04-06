import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Bai1 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("input.txt");
            FileOutputStream fos = new FileOutputStream("output.txt");

            int data;
            while ((data = fis.read()) != 0) {
                fos.write(data);
            }

            fis.close();
            fos.close();
            System.out.println("Ghi file xong !");
        } catch (Exception e) {
            System.out.println("Loi : " + e.getMessage());

        }
    }
}
