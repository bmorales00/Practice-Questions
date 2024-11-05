package com.brianprojects.Leetcode.DP2D;

public class LCS {
    /*
    Given two strings text1 and text2, return the length of their longest common subsequence.
    If there is no common subsequence, return 0.
    A subsequence of a string is a new string generated from the original string with some characters
    (can be none) deleted without changing the relative order of the remaining characters.
    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.
     */

    //Runtime is O(str1*str2) or O(mn)
    //The space complexity is O(mn) as well for the dp matrix
    public int longestCommonSubsequence(String str1 , String str2){
        var dp = new int[str1.length()+1][str2.length()+1];

        for(var h =1; h<dp.length; h++){

            for(var v = 1; v<dp[h].length; v++){
                if(str1.charAt(h-1) == str2.charAt(v-1)){
                    dp[h][v] = dp[h-1][v-1] +1;
                }
                else{

                    dp[h][v] = Math.max(dp[h-1][v], dp[h][v-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
