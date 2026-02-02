package regex.advance.problem;

import java.util.regex.Pattern;

public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        String s = "4152111022221478";
        System.out.println(s.length());

        String regex="^4\\d{15}";
        System.out.println(Pattern.compile(regex).matcher(s).matches());
    }
}
