import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValuesFromText {
    public static void main(String[] args) {
        String s = "The price is $45.99, and the discount is 10.50.";
        Matcher matcher = Pattern.compile("\\$?\\d+(\\.\\d{2})?").matcher(s);

        while (matcher.find()) System.out.println(matcher.group());

    }
}
