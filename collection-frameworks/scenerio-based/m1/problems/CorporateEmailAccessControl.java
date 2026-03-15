package m1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CorporateEmailAccessControl {
    static  final Pattern P=Pattern.compile("^([a-z]{3,})\\.([a-z]{3,})(\\d{4})@(sales|marketing|IT|product)\\.company.com$");
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(bf.readLine().trim());

        while(t-- >0){
            String email=bf.readLine().trim();
            boolean test=P.matcher(email).matches();
            System.out.println("ACCESS "+(test?"Granted":"Denied"));
        }
    }
}
