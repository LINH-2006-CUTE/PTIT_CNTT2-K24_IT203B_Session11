package btvn.Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASS = "Linh190426@";
    public static Connection getHospitalConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER, PASS);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
        }
        return conn;
    }


    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection myConn = getHospitalConn();
        closeConnection(myConn);
    }
}