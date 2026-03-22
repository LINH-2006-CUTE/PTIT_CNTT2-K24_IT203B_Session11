package btvn.Ex4;

import java.util.Scanner;
/*
 * vì OR '1'='1' thì luôn đúng
 * mà SELECT * FROM Patients WHERE full_name = '' OR '1'='1'' có  '' là của full_name
 * mà ' ở cuối câu lệnh nó sẽ hiểu đóng dấu '' của phần đầu nên nó sẽ lấy được dữ liệu của bảng Patients
 * */
import java.sql.*;

public class SQLInjection {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
        String USER = "root";
        String PASS = "Linh190426@";

        String patienName = "' OR '1'='1'";
        String name = patienName.replace("'", "''");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Patients WHERE full_name = '" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;

            while (rs.next()) {
                System.out.println("Tên bệnh nhân: " + rs.getString("full_name"));
                count++;
            }
            if (count == 0) System.out.println("Không tìm thấy bệnh nhân nào");

        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}