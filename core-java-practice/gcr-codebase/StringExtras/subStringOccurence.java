import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "anna";
        String s1 = "an";
        int count = 0;
        
        int sub = s1.length();
        
        for(int i=0;i<s.length()-sub;i++){
            if(s.substring(i,sub).equals(s1)){
                count++;
            }
        }
        System.out.print(count);
    }
}