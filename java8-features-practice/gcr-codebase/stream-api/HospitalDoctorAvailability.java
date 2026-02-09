import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HospitalDoctorAvailability {

    public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();

        manager.addDoctor(new Doctor("DOC1", "Ava", "Neurologist", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY}))));
        manager.addDoctor(new Doctor("DOC2", "Mia", "Cardiologist", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.MONDAY, Days.TUESDAY, Days.THURSDAY, Days.FRIDAY, Days.SUNDAY}))));
        manager.addDoctor(new Doctor("DOC3", "Lisa", "Eye Specialist", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.SATURDAY, Days.SUNDAY}))));
        manager.addDoctor(new Doctor("DOC4", "Bella", "Neurologist", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.MONDAY, Days.THURSDAY, Days.FRIDAY, Days.SATURDAY, Days.SUNDAY}))));
        manager.addDoctor(new Doctor("DOC5", "Alexa", "Neurologist", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.TUESDAY, Days.WEDNESDAY, Days.FRIDAY, Days.SATURDAY, Days.SUNDAY}))));
        manager.addDoctor(new Doctor("DOC6", "Luna", "Pediatrician", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY}))));
        manager.addDoctor(new Doctor("DOC7", "Anna", "Cardiologist", new LinkedHashSet<>(Arrays.asList(new Days[]{Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY, Days.SATURDAY, Days.SUNDAY}))));

        manager.findDoctorsAvailableOnWeekends();

    }
    
}

enum Days{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; 
}

class Doctor{
    String id;
    String name;
    String specialization;
    Set<Days> availableDays;

    public Doctor(String id, String name, String specialization, Set<Days> availableDays) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availableDays = availableDays;
    }

    @Override
    public String toString() {
        return String.format("[Doctor id: %s, Name: %s, Specialization: %s, Available Days: %s]", id, name, specialization, availableDays);
    }
}

class HospitalManager{
    private List<Doctor> doctors;

    public HospitalManager() {
        this.doctors = new ArrayList<>();
    }

    

    public void addDoctor(Doctor doctor){
        if(doctor!=null && !doctors.contains(doctor)){
            doctors.add(doctor);
        }
    }

    public void findDoctorsAvailableOnWeekends(){
        List<Doctor> availableDoctors = doctors.stream()
                                        .filter(doctor -> doctor.availableDays.contains(Days.SUNDAY) || doctor.availableDays.contains(Days.SATURDAY))
                                        .sorted(Comparator.comparing(doctor -> doctor.specialization.toLowerCase()))
                                        .collect(Collectors.toList());

        if(availableDoctors.isEmpty()){
            System.out.println("No doctors available");
            return;
        }
        System.out.println("Available doctors: ");
        for(Doctor doctor: availableDoctors){
            System.out.println(doctor);
        }
    }
}