package btvn.Ex5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU QUẢN LÝ BÁC SĨ ---");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê số lượng bác sĩ theo chuyên khoa");
            System.out.println("4. Thoát chương trình");
            System.out.print("Vui lòng chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // displayDoctors();
                    break;
                case "2":
                    // addDoctorFromInput(scanner);
                    break;
                case "3":
                    // displayDepartmentStats();
                    break;
                case "4":
                    running = false;
                    System.out.println("thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại");
            }
        }
        scanner.close();
    }
}