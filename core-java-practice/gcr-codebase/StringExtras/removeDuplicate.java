import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "anna";
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                continue;
            }else{
              set.add(c);
              sb.append(c);
            }
        }
        System.out.print(sb.toString());
    }
}