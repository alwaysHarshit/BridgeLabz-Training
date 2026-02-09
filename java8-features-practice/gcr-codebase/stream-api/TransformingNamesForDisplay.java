import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {

    public static void displayNamesInUppercase(List<String> names){
        
        List<String> uppercasedNames = names.stream()
                                            .map(String::toUpperCase)
                                            .sorted()
                                            .collect(Collectors.toList());

        System.out.println(uppercasedNames);
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(new String[] {"Ava","Luna","Jane","Bella","Anna","Alexa"}));
        displayNamesInUppercase(names);
    }
}
