package hospital.patient.management.system;

import java.time.LocalDate;
import java.util.UUID;

public class Bill {

    private final String billId;
    private final int patientId;
    private final double amount;
    private final LocalDate billDate;
    private boolean paid;

    public Bill(int patientId, double amount) {
        this.billId = UUID.randomUUID().toString();
        this.patientId = patientId;
        this.amount = amount;
        this.billDate = LocalDate.now();
        this.paid = false;
    }

    public void pay() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getAmount() {
        return amount;
    }

    public void displayBill() {
        System.out.println("Bill ID    : " + billId);
        System.out.println("Patient ID : " + patientId);
        System.out.println("Amount     : " + amount);
        System.out.println("Bill Date  : " + billDate);
        System.out.println("Status     : " + (paid ? "PAID" : "UNPAID"));
        System.out.println("--------------------------------");
    }
}
