package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentRedactionEngine  {
    //Rule 1
    public static String rule1(String s){
        //group 1: (ID:)- same
        //group 2: (first 3 alphabats)->change
        //group 3: (all 6 digits)-> change
        String regex="(ID:)([A-Z]{3})(\\d{6})";
        return  s.replaceAll(regex,"$1XXX******");
    }
    //rule 2
    public static String rule2(String s){
        //group-1: ACCT- SAME
        //GROUP-2 FIRST 8 DIGIT MASK
        String regex="(ACCT)-(\\d{4})-(\\d{4})-(\\d{4})";

        /*
        here i will will capture only the group which will not change
         */
        String regex2="ACCT-\\d{4}-\\d{4}-(\\d{4})";
        return s.replaceAll(regex2, "ACCT---$1");
    }

    //rule 3
    public static String rule3(String s){
        String regex="(?i)\\b(\\w+)(\\s+\\1\\b)+";
        return s.replaceAll(regex, "$1");
    }
    //rule 4
     public static String rule4(String s){
        String regex="([!?.])\\1{2,}";
        return s.replaceAll(regex, "$1");
     }



    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int testCases=Integer.parseInt(bf.readLine());

        while (testCases-- > 0){
            String txt= bf.readLine();
            String s = rule4(rule3(rule2(rule1(txt))));
            System.out.println(s);
        }
    }
}
