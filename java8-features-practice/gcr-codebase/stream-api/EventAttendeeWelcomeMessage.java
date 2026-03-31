import java.util.Arrays;
import java.util.List;

public class EventAttendeeWelcomeMessage {

    public static void printMessage( List<String> guestList ){
        guestList.forEach(name -> System.out.println("Welcome "+name+"!"));
    }
    public static void main(String[] args) {
        
        List<String> guestList = Arrays.asList("Ava","Alex","Lisa","Liz","Bella","Jennie","Candice","Anna");

        printMessage(guestList);

    }
}
