package regex.Extraction.Problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllEmailAddressesFromText {
    public static void main(String[] args) {
        String s = "Contact us at support@example.com and info@company.org";

        //[\w.-]+ --> start with any letter , number, . or -  atleast 1 or more than 1 time
        //@[a-zA-Z]+ --> start with @ and any letter at least 1 more more than 1 time
        // \\.--> then check for .dot
        // [a-zA-Z]+ after . check or any letter
        String regex="[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]+";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
