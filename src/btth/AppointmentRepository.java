package btth;

import java.util.Scanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    public void addAppointment(Appointment app) {
        String sql = "INSERT INTO appointments (patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, app.getPatientName());
            pstmt.setDate(2, app.getAppointmentDate());
            pstmt.setString(3, app.getDoctorName());
            pstmt.setString(4, app.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi thêm: " + e.getMessage());
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"), rs.getString("patient_name"),
                        rs.getDate("appointment_date"), rs.getString("doctor_name"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateAppointment(Appointment app) {
        String sql = "UPDATE appointments SET patient_name=?, appointment_date=?, doctor_name=?, status=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, app.getPatientName());
            pstmt.setDate(2, app.getAppointmentDate());
            pstmt.setString(3, app.getDoctorName());
            pstmt.setString(4, app.getStatus());
            pstmt.setInt(5, app.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}