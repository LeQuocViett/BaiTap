import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        while (true) {
            System.out.println("\n1. Đăng ký\n2. Đăng nhập\n3. Xuất XML\n4. Nhập XML\n5. Hiển thị\n0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        // Đăng ký
                        System.out.print("Tên đăng nhập: ");
                        String user = sc.nextLine();
                        System.out.print("Mật khẩu: ");
                        String pass = sc.nextLine();
                        if (userManager.registerUser(user, pass)) {
                            System.out.println("Đăng ký thành công!");
                        } else {
                            System.out.println("Tên người dùng đã tồn tại.");
                        }
                        break;
                    case 2:
                        // Đăng nhập
                        System.out.print("Tên đăng nhập: ");
                        user = sc.nextLine();
                        System.out.print("Mật khẩu: ");
                        pass = sc.nextLine();
                        if (userManager.loginUser(user, pass)) {
                            System.out.println("Đăng nhập thành công!");
                        } else {
                            System.out.println("Sai thông tin đăng nhập.");
                        }
                        break;
                    case 3:
                        // Xuất XML
                        userManager.exportToXML("users.xml");
                        System.out.println("Xuất XML thành công!");
                        break;
                    case 4:
                        // Nhập XML
                        if (userManager.importFromXML("users.xml")) {
                            System.out.println("Nhập XML thành công!");
                        } else {
                            System.out.println("File XML không hợp lệ.");
                        }
                        break;
                    case 5:
                        // Hiển thị danh sách
                        userManager.printUsers();
                        break;
                    case 0:
                        // Thoát chương trình
                        return;
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
}
