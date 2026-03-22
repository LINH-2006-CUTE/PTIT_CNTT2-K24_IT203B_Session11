package btvn.Ex3;

/*
 * Giá trị trả về của executeUpdate():

 * executeUpdate() sẽ trả về một giá trị số nguyên -> số lượng hàng đã bị thay
 * lớn hơn 0: tìm thấy bản ghi theo điều kiện WHERE và đã cập nhật trạng thái thành công
 * == 0): không có hàng nào trong cơ sở dữ liệu khớp với điều kiện WHERE => mã giường bênhj không tồn tại

 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedManagement {
    private static Connection getConnection() throws SQLException {
        return java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Hospital_DB",
                "root",
                "Linh190426@"
        );
    }

    public static String updateBedStatus(String bedId, String newStatus) {
        String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
        int rows = 0;
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setString(2, bedId);

            rows = pstmt.executeUpdate();
            if (rows > 0) {
                return String.format("Cập nhật thành công: Giường '%s' đã được đặt trạng thái thành '%s'", bedId, newStatus);
            } else {
                return String.format(" Không tìm thấy giường", bedId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi cập nhật trạng thái giường" + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String result1 = updateBedStatus("001", "done");
        System.out.println(result1);

        String result2 = updateBedStatus("Bed_999", "done");
        System.out.println(result2);
    }
}