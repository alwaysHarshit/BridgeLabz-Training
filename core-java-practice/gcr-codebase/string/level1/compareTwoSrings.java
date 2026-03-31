package level1;

import java.util.Scanner;

public class compareTwoSrings {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        System.out.print("These strings are equal:"+checkFuntion(s1,s2,0));
    }

    private static boolean checkFuntion(String s1, String s2,int index) {
        if(index ==s1.length()) return true;
        if(s1.charAt(index)!=s2.charAt(index)) return false;
        return checkFuntion(s1, s2, index+1);
    }

}
