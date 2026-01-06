import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

class InPatient extends Patient {
    private double dailyRate;
    private int daysAdmitted;

    InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    double calculateBill() {
        return dailyRate * daysAdmitted;
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class Hospital implements MedicalRecord {
    private List<String> records;

    Hospital() {
        records = new ArrayList<>();
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John Doe", 30, 200, 5);
        Patient outPatient = new OutPatient("P002", "Jane Smith", 25, 150);

        System.out.println(inPatient.getPatientDetails() + ", Bill: " + inPatient.calculateBill());
        System.out.println(outPatient.getPatientDetails() + ", Bill: " + outPatient.calculateBill());

        Hospital hospital = new Hospital();
        hospital.addRecord("Patient P001 admitted.");
        hospital.addRecord("Patient P002 consultation completed.");

        System.out.println("Medical Records:");
        for (String record : hospital.viewRecords()) {
            System.out.println(record);
        }
    }
}