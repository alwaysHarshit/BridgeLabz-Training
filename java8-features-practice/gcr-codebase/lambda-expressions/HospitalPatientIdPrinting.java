import java.util.LinkedHashSet;
import java.util.Set;

public class HospitalPatientIdPrinting {
    
    private final Set<String> patientIDs;

    public HospitalPatientIdPrinting() {
        this.patientIDs = new LinkedHashSet<>();
    }

    public void addPatientId(String patientID){
        patientIDs.add(patientID);
    }

    public void displayAllPatientIds(){
        patientIDs.forEach(System.out::println);
    }

    public static void main(String[] args) {
        HospitalPatientIdPrinting hospital = new HospitalPatientIdPrinting();

        hospital.addPatientId("P123");
        hospital.addPatientId("P456");
        hospital.addPatientId("P789");
        hospital.addPatientId("P147");
        hospital.addPatientId("P258");
        hospital.addPatientId("P369");
        hospital.addPatientId("P159");
        hospital.addPatientId("P357");

        hospital.displayAllPatientIds();

    }
    
}
