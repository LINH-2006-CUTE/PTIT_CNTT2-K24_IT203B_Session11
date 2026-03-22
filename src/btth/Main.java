package btth;

import java.util.Scanner;

import java.util.Scanner;
import java.sql.Date;
import java.util.List;

public class Main {
    private static AppointmentRepository repo = new AppointmentRepository();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ LỊCH KHÁM BỆNH ---");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm lịch hẹn");
            System.out.println("3. Sửa lịch hẹn");
            System.out.println("4. Xóa lịch hẹn");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showList();
                    break;
                case 2:
                    addApp();
                    break;
                case 3:
                    updateApp();
                    break;
                case 4:
                    deleteApp();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void showList() {
        List<Appointment> list = repo.getAllAppointments();
        System.out.println("| ID| Tên bệnh nhân| Ngày khám| Tên bác sĩ| Trạng thái|");
        for (Appointment a : list) System.out.println(a);
    }

    private static void addApp() {
        System.out.print("Tên bệnh nhân: ");
        String name = sc.nextLine();
        System.out.print("Ngày khám: ");
        Date date = Date.valueOf(sc.nextLine());
        System.out.print("Tên bác sĩ: ");
        String doc = sc.nextLine();
        System.out.print("Trạng thái: ");
        String status = sc.nextLine();
        repo.addAppointment(new Appointment(name, date, doc, status));
        System.out.println("Đã thêm thành công");
    }

    private static void updateApp() {
        System.out.print("Nhập ID cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Tên mới: ");
        String name = sc.nextLine();
        System.out.print("Ngày mới: ");
        Date date = Date.valueOf(sc.nextLine());
        System.out.print("Bác sĩ mới: ");
        String doc = sc.nextLine();
        System.out.print("Trạng thái mới: ");
        String status = sc.nextLine();
        repo.updateAppointment(new Appointment(id, name, date, doc, status));
        System.out.println("Cập nhật thành công");
    }

    private static void deleteApp() {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        repo.deleteAppointment(id);
        System.out.println("Đã xóa!");
    }
}