/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */

import java.util.Arrays;

public class LongestCommonSubsequence {

    //using top-down approach
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i + 1][j + 1];
        for (int index = 0; index < i + 1; index++) {
            Arrays.fill(dp[index], -1);
        }
        return fun(text1, text2, i, j, dp);
    }

    int fun(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + fun(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(fun(s1, s2, i - 1, j, dp), fun(s1, s2, i, j - 1, dp));
        }
    }

    //using buttom-up appraoch
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }

}
