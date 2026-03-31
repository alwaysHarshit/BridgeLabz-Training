import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class NotificationFiltering {

    public static void main(String[] args) {

        Patient patient = new Patient("PID1","Mia");
        HospitalApp hospitalApp = new HospitalApp();
        hospitalApp.addPatient(patient);

        hospitalApp.addAlert(patient, new Alert("Medicine time","Time to take your medicine"));
        hospitalApp.addAlert(patient, new Alert("Blood Pressure Measurement","Time to measure your blood pressure"));
        hospitalApp.addAlert(patient, new Alert("Doctor visit","Date of visiting the doctor"));
        hospitalApp.addAlert(patient, new Alert("Drink water","Time to drink water"));

        hospitalApp.setPreference(patient, "Medicine time");
        hospitalApp.setPreference(patient, "Blood Pressure Measurement");
        hospitalApp.setPreference(patient, "Drink water");

        hospitalApp.displayFilteredAlerts(patient);
    }
    
    
}

class HospitalApp{
    private final Map<Patient, List<Alert>> allPatients;
    private final Map<Patient, List<Predicate<Alert>>> notificationPreferences;
    Set<Alert> allAlerts;

    public HospitalApp() {
        this.allPatients = new HashMap<>();
        this.allAlerts = new HashSet<>();
        this.notificationPreferences = new HashMap<>();
    }

    public void addPatient(Patient patient){
        allPatients.putIfAbsent(patient,new ArrayList<>());
    }

    public void addAlert(Patient patient, Alert alert){
        if(allPatients.containsKey(patient)){
            if(!allPatients.get(patient).contains(alert)){
                allPatients.get(patient).add(alert);
            }
        }
    }

    public void setPreference(Patient patient, String alertType){
        if(allPatients.containsKey(patient)){
            notificationPreferences.putIfAbsent(patient, new ArrayList<>());
            notificationPreferences.get(patient).add(alert -> alert.getType().equalsIgnoreCase(alertType));
        }
    }
    public void displayFilteredAlerts(Patient patient){
        if(allPatients.containsKey(patient) && notificationPreferences.containsKey(patient)){
            List<Alert> alerts = allPatients.get(patient);
            List<Predicate<Alert>> preferences = notificationPreferences.get(patient);

            for(Alert alert: alerts){
                for(Predicate<Alert> p: preferences){
                    if(p.test(alert)){
                        System.out.println(alert);
                    }
                }
            }
        }
    }
     
}

class Patient{
    String patientID;
    String patientName;

    public Patient(String patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName;
    }
    

}

class Alert{
    private String type;
    private String message;

    public Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[Alert type: "+type+", Message: "+message+"]";
    }


}