import java.util.Scanner;

public class FlipkeyLogicalProblem {
    public static String CleanseAndInvert(String input) {
        //validation
        if (input == null || input.length() < 6){
            System.out.println("first");
            return null;
        }

        //must not contain any space, digit or
        //special characters.
        if (!input.matches("^[A-Za-z]+$")){
            System.out.println("second");
            return null;
        }


        StringBuilder stringBuilder = new StringBuilder();


        /*
        Convert the input to lowercase.
            ● Remove all characters whose ASCII values are
            even numbers.
            ● Reverse the remaining characters.
            ● In the reversed string, convert characters that
            have even positioned character (0 based
                index) to uppercase. Refer to the sample input
                and output.
         */

        for(char c:input.toLowerCase().toCharArray()){
            if((c-'a') % 2!=0){
                System.out.println("char is c"+ c + "and value is :" + (c-'a'));
                stringBuilder.append(c);
            }
        }
        stringBuilder.reverse();
        stringBuilder.replace(0,1, String.valueOf(Character.toUpperCase(stringBuilder.charAt(0))));

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();

        String password=CleanseAndInvert(s);


        if(password!=null){
            System.out.println("The generated key is - "+password);
        }else {
            System.out.println("Invalid Input");
        }
    }
}
