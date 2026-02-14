import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatingWordsInSentence {
    public static void main(String[] args) {

        String s = "This is is a repeated repeated word test.";
        /*
        (\w+)\s+\1
Read it like a machine:

Capture a word → space(s) → same word again
         */

        String regex = "(\\w+)\\s+\\1";

        Matcher matcher = Pattern.compile(regex).matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
