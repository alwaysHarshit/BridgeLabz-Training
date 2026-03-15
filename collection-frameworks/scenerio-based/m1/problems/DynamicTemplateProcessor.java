package m1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DynamicTemplateProcessor {
    static final Pattern PATTERN = Pattern.compile("\\$\\{(DATE|UPPER|LOWER|REPEAT):([^}]+)\\}");
    static final Pattern DATE_PATTERN = Pattern.compile("(0[1-9]|[12]\\d|3[0-1])-(0[1-9]|1[0-2])-(19\\d{2}|20\\d{2})");

    public static void main(String[] args) throws IOException {
        BufferedReader  bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine().trim());

        while (t-- > 0){
            String s = bf.readLine();
            String validator = validator(s);
            System.out.printf("%s%n",validator);

        }
    }

    private static String validator(String s) {
        Matcher matcher = PATTERN.matcher(s);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()){
            String type= matcher.group(1);
            String value = matcher.group(2);

            String result;
            switch (type) {
                case "UPPER":
                    result = value.toUpperCase();
                    break;
                case "LOWER":
                    result = value.toLowerCase();
                    break;
                case "DATE":
                    result = convertDate(value);
                    break;
                case "REPEAT":
                    result = repeat(value);
                    break;
                default:
                    result = "INVALID";
                    break;
            }

            matcher.appendReplacement(stringBuilder, Matcher.quoteReplacement(result));
        }

        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();

    }

    private static String repeat(String value) {
        // value coming in is already "Hi,3"
        String[] parts = value.split(",");

        if (parts.length != 2) return "INVALID";

        try {
            String word  = parts[0].trim();
            int count    = Integer.parseInt(parts[1].trim());
            if (count <= 0) return "INVALID";
            return (word + "").repeat(count).trim();
        } catch (NumberFormatException e) {
            return "INVALID";
        }
    }
    private static String convertDate(String value) {
        Matcher m=DATE_PATTERN.matcher(value);
        if(!m.matches()) return "INVALID";
        int day=Integer.parseInt(m.group(1).trim());
        int month=Integer.parseInt(m.group(2).trim());
        int year=Integer.parseInt(m.group(3).trim());

        int []maxDays={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(year % 400==0 ||(year%100!=0 &&year%4==0)) maxDays[2]=29;
        if(day>maxDays[month]) return "INVALID";
        return year+"/"+month+"/"+day;
    }
}
