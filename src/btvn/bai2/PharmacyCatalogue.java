package btvn.bai2;

import java.util.Scanner;
/*
* Phần 1 :
* Lệnh if (rs.next())là  kiểm tra xem tập kết quả có ít nhất một hàng dữ liệu hay không
 Phương thức next() của ResultSet có tác dụng di chuyển con trỏ sang hàng tiếp theo
*  Nó trả về true nếu việc di chuyển thành công (tức là còn hàng để đọc) và trả về false nếu con trỏ đã vượt qua hàng cuối cùng
* Nếu sử dụng If thì đoạn code sẽ thực hiện 1 lần thì con trot sẽ trỏ vào dòng đầu tiên nên nó không kiểm tra được các dòng tiếp theo
* nếu muốn in ra đầy đủ thông tin thì cần một hành động lặp lại cho đến khi in ra hết các hàng

* */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PharmacyCatalogue {
    private static final String URL = "jdbc:mysql://localhost:3306/my_db1";
    private static final String USER = "root";
    private static final String PASS = "Linh190426@";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = java.sql.DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

            System.out.printf("| %-25s | %-10s |%n", "Tên Thuốc", "Số Lượng Tồn");

            while (rs.next()) {
                String medicineName = rs.getString("medicine_name");
                int stockQuantity = rs.getInt("stock");
                System.out.printf("| %-25s | %-10d |%n", medicineName, stockQuantity);
            }

        } catch (SQLException e) {
            System.err.println(" Lỗi xử lý CSDL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.err.println("Lỗi đóng tài nguyên: " + ex.getMessage());
            }
        }
    }
}