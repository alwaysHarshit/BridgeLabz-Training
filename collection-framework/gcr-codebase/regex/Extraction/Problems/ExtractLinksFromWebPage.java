package regex.Extraction.Problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinksFromWebPage {
    public static void main(String[] args) {
        String s = "Visit https://www.google.com and http://example.org";

        //? = OPTIONAL (0 or 1 time) It applies to the thing immediately before it.
        // https here s is optional
        // then : --> match exactly what after this
        // here match exactly : followed by / followed by /
        String regex = "https?://[\\w.-]+";

        Matcher matcher = Pattern.compile(regex).matcher(s);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
