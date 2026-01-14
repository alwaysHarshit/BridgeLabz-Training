package hospital.patient.management.system;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("HOSPITAL PATIENT MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        // Creating 3 doctors
        Doctor d1 = new Doctor("Dr. Amit Kumar", 30, "Male", "9876543210", "Delhi", "DC001", "Cardiology", "Heart Surgeon", 5);
        Doctor d2 = new Doctor("Dr. Priya Singh", 31, "Female", "9876543211", "Mumbai", "DC002", "Ophthalmology", "Eye Specialist", 3);
        Doctor d3 = new Doctor("Dr. Rajesh Verma", 32, "Male", "9876543212", "Chennai", "DC003", "Neurology", "Brain Surgeon", 10);

        System.out.println(">>> Doctors registered in the system:");
        d1.displayInfo();
        d2.displayInfo();
        d3.displayInfo();
        System.out.println();

        // Creating 3 patients
        InPatient p1 = new InPatient("Rahul Sharma", 35, "Male", "9876543210", "Delhi", 101);
        InPatient p2 = new InPatient("Anita Verma", 28, "Female", "9123456789", "Mumbai", 102);
        InPatient p3 = new InPatient("Suresh Kumar", 50, "Male", "9988776655", "Chennai", 103);

        System.out.println(">>> Patients registered in the system:");
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        System.out.println();

        // Booking appointments
        System.out.println(">>> Booking Appointments:");
        Appointment a1 = new Appointment(p1, d1, LocalDate.of(2026, 1, 10), "10:00 AM");
        p1.bookAppointment(a1);

        Appointment a2 = new Appointment(p2, d2, LocalDate.of(2026, 1, 11), "11:30 AM");
        p2.bookAppointment(a2);

        Appointment a3 = new Appointment(p3, d3, LocalDate.of(2026, 1, 12), "02:00 PM");
        p3.bookAppointment(a3);
        System.out.println();

        // Doctor viewing their appointments
        System.out.println(">>> Doctor's Appointments:");
        d1.viewAppointments();
        d2.viewAppointments();
        d3.viewAppointments();
        System.out.println();

        // Doctor diagnosing patients
        System.out.println(">>> Doctor Diagnosing Patients:");
        d1.diagnosePatient(p1);
        d1.prescribeMedicine(p1, "Aspirin", "1 tablet twice daily");
        d1.writeMedicalReport(p1, "Heart condition", "Medication and regular checkups");
        System.out.println();

        d2.diagnosePatient(p2);
        d2.prescribeMedicine(p2, "Eye Drops", "2 drops thrice daily");
        d2.writeMedicalReport(p2, "Mild eye infection", "Eye drops for 7 days");
        System.out.println();

        // Completing appointments
        System.out.println(">>> Completing Appointments:");
        a1.complete();
        System.out.println("Appointment " + a1.getAppointmentId() + " marked as COMPLETED");
        a2.complete();
        System.out.println("Appointment " + a2.getAppointmentId() + " marked as COMPLETED");
        System.out.println();

        // Discharging patients and generating bills
        System.out.println(">>> Patient Discharge Process:");
        d1.approveDischarge(p1);
        double p1Bill = p1.calculateBill();
        p1.generateBill(p1Bill + 500); // Room charges + consultation
        System.out.println();

        d2.approveDischarge(p2);
        double p2Bill = p2.calculateBill();
        p2.generateBill(p2Bill + 300); // Room charges + consultation
        System.out.println();

        // Patient viewing all appointments
        System.out.println(">>> Patient's Appointment History:");
        p1.showAllAppointments();
        System.out.println();

        // Patient viewing all bills
        System.out.println(">>> Patient's Bill History:");
        p1.showAllBills();
        p2.showAllBills();
        System.out.println();

        // Patient paying bills
        System.out.println(">>> Payment Process:");
        if (!p1.bills.isEmpty()) {
            p1.payBill(p1.bills.get(0));
        }
        if (!p2.bills.isEmpty()) {
            p2.payBill(p2.bills.get(0));
        }
        System.out.println();

        // Display final bill status
        System.out.println(">>> Final Bill Status:");
        p1.showAllBills();
        p2.showAllBills();

        System.out.println("\n========================================");
        System.out.println("HOSPITAL WORKFLOW COMPLETED");
        System.out.println("========================================");

        sc.close();
    }
}
