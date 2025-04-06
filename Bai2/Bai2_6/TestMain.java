package Bai2_6;

public class TestMain {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();   // Kiểm tra hàm tạo
        System.out.println(p1);       // Kiểm tra toString()
        p1.setX(8
        ); // Kiểm tra các hàm thiết lập p1.setY(6)
        ; System.out.println("x là: " + p1.getX());   // Kiểm tra các hàm lấy
        System.out.println("y là: " + p1.getY());
        p1.setXY(3, 0);    // Kiểm tra setXY()
        System.out.println(p1.getXY()[0]);   // Kiểm tra getXY()
        System.out.println(p1.getXY()[1]);
        System.out.println(p1);
        MyPoint p2 = new MyPoint(0, 4);   // Kiểm tra một hàm tạo khác
        System.out.println(p2); // Kiểm tra các phương thức quá tải distance()
        System.out.println(p1.distance(p2));     // phiên bản nào?
        System.out.println(p2.distance(p1));     // phiên bản nào?
        System.out.println(p1.distance(5, 6));   // phiên bản nào?
        System.out.println(p1.distance());       // phiên bản nào?


    }
}
