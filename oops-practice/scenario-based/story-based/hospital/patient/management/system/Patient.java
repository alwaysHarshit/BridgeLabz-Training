package hospital.patient.management.system;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Patient extends Person {

    protected final int patientId;
    protected List<Bill> bills;
    protected List<Appointment> appointmentList;

    protected Patient(String name, int age, String gender,
                      String contactNumber, String address) {

        super(name, age, gender, contactNumber, address);
        this.patientId = new Random().nextInt(1,50);
        this.bills = new ArrayList<>();
        this.appointmentList=new LinkedList<>();
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public int getPatientId() {
        return patientId;
    }

    public void bookAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        appointment.getDoctor().addAppointment(appointment);
        System.out.println("Appointment booked successfully!");
        System.out.println("Appointment ID: " + appointment.getAppointmentId());
    }

    public void showAllAppointments() {
        System.out.println("=== All Appointments for Patient ID: " + patientId + " ===");
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointmentList) {
                appointment.displayInfo();
            }
        }
    }

    public void showAllBills(){
        System.out.println("=== All Bills for Patient ID: " + patientId + " ===");
        if (bills.isEmpty()) {
            System.out.println("No bills found.");
        } else {
            for (Bill bill : bills) {
                bill.displayBill();
            }
        }
    }

    public void generateBill(double amount) {
        Bill bill = new Bill(this.patientId, amount);
        bills.add(bill);
        System.out.println("Bill generated successfully!");
        bill.displayBill();
    }

    public void payBill(Bill bill) {
        if (bills.contains(bill)) {
            bill.pay();
            System.out.println("Bill paid successfully!");
        } else {
            System.out.println("Bill not found for this patient.");
        }
    }

}

