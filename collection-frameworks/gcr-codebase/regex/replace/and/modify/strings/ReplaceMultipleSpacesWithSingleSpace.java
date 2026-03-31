import java.util.regex.Pattern;

public class ReplaceMultipleSpacesWithSingleSpace {
    public static void main(String[] args) {
        String s = "This     is an        example    with multiple spaces.";

        String regex="\\s{2,}";

        Pattern.compile(regex).matcher(s);
        String s1 = s.replaceAll(regex, " ");
        System.out.println(s1);

    }

}
