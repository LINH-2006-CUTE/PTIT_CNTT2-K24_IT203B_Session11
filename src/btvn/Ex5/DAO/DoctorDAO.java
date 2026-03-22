package btvn.Ex5.DAO;

import btvn.Ex5.model.Doctor;

import java.sql.*;
import java.util.*;

public class DoctorDAO {
    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("id"), rs.getString("fullname"), rs.getString("specialty")));
            }
        }
        return list;
    }

    // Thêm bác sĩ
    public void addDoctor(Doctor d) throws SQLException {
        String sql = "INSERT INTO Doctors (id, fullname, specialty) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, d.getId());
            pstmt.setString(2, d.getFullname());
            pstmt.setString(3, d.getSpecialty());
            pstmt.executeUpdate();
        }
    }

    public void getSpecialtyStats() throws SQLException {
        String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("khoa: " + rs.getString("specialty"));
                System.out.printf("Số lượng:%d".formatted(rs.getInt("total"));
            }
        }
    }
}