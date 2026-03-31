import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringExpiringMemberships {
    
    public static void main(String[] args) {
        GymManager manager = new GymManager();

        manager.addMember(new GymMember("ID1","Ava","01-03-2026"));
        manager.addMember(new GymMember("ID2","Lia","19-02-2026"));
        manager.addMember(new GymMember("ID3","Kate","06-06-2026"));
        manager.addMember(new GymMember("ID4","Lisa","18-03-2026"));
        manager.addMember(new GymMember("ID5","Jane","05-11-2026"));
        manager.addMember(new GymMember("ID6","Violet","22-02-2026"));
        manager.addMember(new GymMember("ID7","Bella","15-04-2026"));
        manager.addMember(new GymMember("ID8","Mia","15-02-2026"));
        manager.addMember(new GymMember("ID9","Caty","24-09-2026"));
        manager.addMember(new GymMember("ID10","Amelia","13-12-2026"));

        manager.displayMembersWithSoonMembershipExpiryDate();


    }
}

class GymMember{
    protected String id;
    protected String name;
    protected LocalDate membershipExpiryDate;

    public GymMember(String id, String name, String membershipExpiryDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
            this.membershipExpiryDate = LocalDate.parse(membershipExpiryDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.id = id;
        this.name = name;
        
    }

    @Override
    public String toString() {
        return String.format("[Member ID: %s, Name: %s, Membership expiry date: %s]", id, name, membershipExpiryDate);
    }

}

class GymManager{
    private final List<GymMember> members;

    public GymManager() {
        this.members = new ArrayList<>();
    }

    public void addMember(GymMember member){
        if(member!= null && !members.contains(member)){
            members.add(member);
        }
    }
    
    public void displayMembersWithSoonMembershipExpiryDate(){

        LocalDate today = LocalDate.now();

        List<GymMember> filteredMembers = members.stream()
                                                .filter(member -> ChronoUnit.DAYS.between(today, member.membershipExpiryDate)<=30 && ChronoUnit.DAYS.between(today, member.membershipExpiryDate)>=0)
                                                .sorted(Comparator.comparing(member -> member.membershipExpiryDate))
                                                .collect(Collectors.toList());

        if(filteredMembers.isEmpty()){
            System.out.println("No members found");
            return;
        }

        System.out.println("Members whose membership is expiring within 30 days");
        filteredMembers.forEach(System.out::println);
    }
}