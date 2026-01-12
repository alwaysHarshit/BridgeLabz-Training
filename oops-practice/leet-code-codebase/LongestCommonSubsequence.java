/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";

        //solved by only recusrion:-> f(index1, index2): length of common sequence till index1 and index2
        System.out.println("this is the answer from recursion: "+byRecursion(text1,text2,text1.length()-1,text2.length()-1));

        //solve by Tabulation
        System.out.println("this is the answer from Tabulation: "+byTabulation(text1,text2));
    }

    private static int byTabulation(String s1, String s2) {

        // dp[i][j] -> lognest subsequece tile i and j;
        int[][]dp=new int[s1.length()+1][s2.length()+1];

        //base case: from recursion we can see that if index become -ve we return 0 but i dp we can't store -ve index
        // so we perform shifting in which index i=0 means index -1, i=1 means index 0  and index i =k means index k-1;

        for (int i = 0; i <s1.length(); i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j]=0;
        }

        // building dp
        for (int i = 1; i <=s1.length() ; i++) {
            for (int j = 1; j <=s2.length() ; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        // returning answer
        return dp[s1.length()][s2.length()];
    }

    private static int byRecursion(String s1, String s2, int index1, int index2) {

        // base case: if index is negative that mean no element to select so length of longest subsequece is 0;
        if(index1<0 || index2<0) return 0;

        // if character matches then count 1 add call the previous elements
        if (s1.charAt(index1)==s2.charAt(index2)){
            return 1+byRecursion(s1, s2, index1-1, index2-1);
        }else{
            return Math.max(byRecursion(s1, s2, index1-1, index2), byRecursion(s1, s2, index1, index2-1));
        }
    }
}
