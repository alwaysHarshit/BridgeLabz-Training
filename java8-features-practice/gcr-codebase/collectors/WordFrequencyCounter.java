import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    
    public static Map<String, Integer>  countWordFrequency(List<String> words){
        Map<String, Integer> frequency = words.stream()
                                            .collect(Collectors.toMap(
                                                Function.identity(),
                                                word -> 1,
                                                Integer::sum));
        return frequency;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph: ");
        String paragraph = scanner.nextLine().toLowerCase();
        List<String> words = Arrays.asList( paragraph.split("\\W*\\s\\W*" ));

        System.out.println(countWordFrequency(words));
    }
}
