import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
License plate format: Starts with two uppercase letters, followed by four digits.

 */
public class ValidateLicensePlateNumber {
    public static void main(String[] args) {
        String regex="^[A-Z]{2}[0-9]{4}$";
        String[] chars={"AB1234","A12345","AB1211"};

        Pattern pattern=Pattern.compile(regex);
        for (String s:chars){
            Matcher matcher = pattern.matcher(s);
            System.out.println(matcher.matches());
        }


    }
}
