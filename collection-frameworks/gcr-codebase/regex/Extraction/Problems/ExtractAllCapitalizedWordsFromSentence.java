import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllCapitalizedWordsFromSentence {
    public static void main(String[] args) {
        String s = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        //[A-Z] --> any first capital letter
        //[a-z] --> any lowercase letter
        //+ --> at least 1 or more than 1
        String regex="[A-Z][a-z]+";

        Matcher matcher = Pattern.compile(regex).matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
