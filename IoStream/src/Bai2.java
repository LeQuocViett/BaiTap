import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Bai2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("output.txt");
            System.out.println("Nhap noi dung (go exit de thoat): ");
            String line;
            while (!(line = br.readLine()).equals("exit")) {
                fw.write(line + "\n");
            }
            br.close();
            fw.close();
            System.out.println("Da luu");
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
}
