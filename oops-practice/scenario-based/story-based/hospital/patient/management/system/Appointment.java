package hospital.patient.management.system;

import java.time.LocalDate;
import java.util.Random;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String time;
    private String status; // BOOKED, CANCELLED, COMPLETED

    public Appointment(Patient patient, Doctor doctor,
                       LocalDate date, String time) {
        this.appointmentId = new Random().nextInt(1000, 9999);
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = "BOOKED";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void cancel() {
        this.status = "CANCELLED";
    }

    public void complete() {
        this.status = "COMPLETED";
    }

    public void displayInfo() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID    : " + patient.getPatientId());
        System.out.println("Doctor        : " + doctor.getName());
        System.out.println("Date          : " + date);
        System.out.println("Time          : " + time);
        System.out.println("Status        : " + status);
        System.out.println("===========================");
    }
}
