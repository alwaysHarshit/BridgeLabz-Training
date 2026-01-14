package hospital.patient.management.system;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{

    private final String id;
    private String department;
    private String specialization;
    private int experience;
    private List<Appointment> appointmentList;

    public Doctor(String name, int age, String gender, String contactNumber,
                  String address, String id,
                  String department, String specialization, int experience) {

        super(name, age, gender, contactNumber, address);
        this.id = id;
        this.department = department;
        this.specialization = specialization;
        this.experience = experience;
        this.appointmentList = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Doctor";
    }


    public void displayInfo() {
        super .displayBasicInfo();
        System.out.println("Doctor ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experience + " years");

    }


    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    public void diagnosePatient(Patient patient) {
        System.out.println("Dr. " + super.getName()+ " is diagnosing patient ID: " + patient.getPatientId());
        System.out.println("Diagnosis completed.");
    }


    public void prescribeMedicine(Patient patient, String medicineName, String dosage) {
        System.out.println("Dr. " + getName() + " prescribed medicine to Patient ID: " + patient.getPatientId());
        System.out.println("Medicine: " + medicineName);
        System.out.println("Dosage: " + dosage);
    }


    public void writeMedicalReport(Patient patient, String diagnosis, String treatment) {
        System.out.println("=== MEDICAL REPORT ===");
        System.out.println("Doctor: " + getName() + " (" + id + ")");
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Treatment: " + treatment);
        System.out.println("Date: " + java.time.LocalDate.now());
        System.out.println("======================");
    }


    public void approveDischarge(InPatient patient) {
        System.out.println("Dr. " + getName() + " approved discharge for Patient ID: " + patient.getPatientId());
        patient.discharge();
        System.out.println("Patient discharged successfully.");
    }


    public void viewAppointments() {
        System.out.println("=== Appointments for Dr. " + getName() + " ===");
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appointment : appointmentList) {
                appointment.displayInfo();
            }
        }
    }
}
