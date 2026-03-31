import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "Find the longest word";
        String[] st = s.split("\\s+");
        
        String max = st[0];
        for(String sb : st){
            if(sb.length() > max.length()){
                max = sb;
            }
        }
        System.out.print(max);
    }
}
