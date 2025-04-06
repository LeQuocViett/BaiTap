import java.io.*;

public class Bai4 {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("numbers.dat"));
            dos.writeInt(5);
            dos.writeInt(10);
            dos.writeInt(15);
            dos.close();
            System.out.println("Đã ghi số vào file!");

            DataInputStream dis = new DataInputStream(new FileInputStream("numbers.dat"));
            while (dis.available() > 0) {
                System.out.println("Số: " + dis.readInt());
            }
            dis.close();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
