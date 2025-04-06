import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            int count = 0;
            while (br.readLine() != null) {
                count++;
            }
            br.close();
            System.out.println("Số dòng trong file là: " + count);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
