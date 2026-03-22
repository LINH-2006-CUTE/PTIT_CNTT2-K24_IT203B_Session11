package btth;

import java.util.Scanner;

import java.sql.Date;

import java.sql.Date;

public class Appointment {
    private int id;
    private String patientName;
    private Date appointmentDate;
    private String doctorName;
    private String status;
    public Appointment(String patientName, Date appointmentDate, String doctorName, String status) {
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.status = status;
    }

    public Appointment(int id, String patientName, Date appointmentDate, String doctorName, String status) {
        this.id = id;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.status = status;
    }

    public int getId() { return id; }
    public String getPatientName() { return patientName; }
    public Date getAppointmentDate() { return appointmentDate; }
    public String getDoctorName() { return doctorName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("| %3d | %20s | %12s | %20s | %10s |",
                id, patientName, appointmentDate, doctorName, status);
    }
}