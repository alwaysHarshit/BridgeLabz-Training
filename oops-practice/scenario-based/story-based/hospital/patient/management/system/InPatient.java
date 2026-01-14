package hospital.patient.management.system;

import java.time.LocalDate;

public class InPatient extends Patient implements IPayable {

    private int roomNumber;
    private int daysAdmitted;
    private static final double ROOM_CHARGE_PER_DAY = 500.00;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    public InPatient(String name, int age, String gender,
                     String contactNumber, String address,
                     int roomNumber) {

        super(name, age, gender, contactNumber, address);
        this.roomNumber = roomNumber;
        this.admissionDate = LocalDate.now();
    }

    public void discharge() {
        this.dischargeDate = LocalDate.now();
        this.daysAdmitted = Math.max(1,
                (int) (dischargeDate.toEpochDay() - admissionDate.toEpochDay()));
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * ROOM_CHARGE_PER_DAY;
    }


    public void displayInfo() {
        super.displayBasicInfo();
        System.out.println("Patient Type : InPatient");
        System.out.println("Room Number  : " + roomNumber);
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("Total Bill   : " + calculateBill());
        System.out.println("--------------------------------");
    }
}
