package Bai20_3;
import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while (br.readLine() != null) {
                lineCount++;
            }
            System.out.println("Số dòng trong file: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
