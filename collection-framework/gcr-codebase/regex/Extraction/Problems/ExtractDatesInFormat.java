package regex.Extraction.Problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDatesInFormat {
    public static void main(String[] args) {
        String s = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        String regex="[\\d]{2}/[\\d]{2}/[\\d]{4}";

        Matcher matcher = Pattern.compile(regex).matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
