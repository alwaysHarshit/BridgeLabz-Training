import java.util.Scanner;

public class displayCharacterType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        String[][] result = processString(text);
        displayTable(result);
    }
    
    public static String classifyCharacter(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }
        
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    
    public static String[][] processString(String text) {
        String[][] result = new String[text.length()][2];
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            result[i][0] = String.valueOf(c);
            result[i][1] = classifyCharacter(c);
        }
        
        return result;
    }
    
    public static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        System.out.println("----------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
} 