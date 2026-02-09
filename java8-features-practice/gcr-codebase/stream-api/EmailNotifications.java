
import java.util.Arrays;
import java.util.List;

public class EmailNotifications {
     public static void sendEmailNotification(String email){
        System.out.println("An email recieved on "+email);
     }
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("ava@gmail.com","janeava@gmail.com","lizava@gmail.com","violetava@gmail.com","roseava@gmail.com","kateava@gmail.com");

        emails.forEach(email->sendEmailNotification(email));
    }
}
