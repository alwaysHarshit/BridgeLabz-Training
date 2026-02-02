package regex.basic.problems;

import java.util.regex.Pattern;

/*
A valid hex color:
Starts with a #
Followed by 6 hexadecimal characters (0-9, A-F, a-f).

 */
public class ValidateHexColorCode {
    public static void main(String[] args) {
        String[] chars={"#FFA500","#ff4500","#123"};
        String regex="^#[0-9A-Fa-f]{6}";
        Pattern pattern = Pattern.compile(regex);

        for (String s:chars){
            System.out.println(pattern.matcher(s).matches());
        }
    }
}
