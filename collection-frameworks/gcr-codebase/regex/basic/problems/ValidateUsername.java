import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
A valid username:
Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
Must start with a letter
Must be between 5 to 15 characters long

 */
public class ValidateUsername {
    public static void main(String[] args) {
        //^ start with any [a-z A-Z] letter
        //then contains letter,numbers, undersocer(we can use \\w)  in place of this [a-zA-Z_0-9]
        String regex="^[a-zA-Z][a-zA-Z_0-9]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("user_123");
        System.out.println(matcher.matches());
    }
}

