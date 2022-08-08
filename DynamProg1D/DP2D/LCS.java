package com.brianprojects.LeetQues75.DynamProg1D.DP2D;

public class LCS {
    /*
    Given two strings text1 and text2, return the length of their longest common subsequence.
    If there is no common subsequence, return 0.
    A subsequence of a string is a new string generated from the original string with some characters
    (can be none) deleted without changing the relative order of the remaining characters.
    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.
     */

    public int longestCommonSubsequence(String str1 , String str2){
        int[][] strArray = new int[str1.length()+1][str2.length()+1];
        for(var i = 0; i < str1.length(); i++){
            for(var j = 0; j< str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    strArray[i+1][j+1] = 1+strArray[i][j];
                }
                else{
                    strArray[i+1][j+1] = Math.max(strArray[i][j+1],strArray[i+1][j]);
                }
            }
        }
        return strArray[str1.length()][str2.length()];
    }
}
/*
int[][] strArray = new int[str1.length()][str2.length()];
        int maxLCS = 0;
        int maxIndex = str2.length();

        for(var i = str1.length()-1; i >= 0; i--){
            int idk = 0;
            for(var j = str2.length()-1; j>=0; j--){
                if(str1.charAt(i) == str2.charAt(j) && j < maxIndex && idk == 0){
                    maxIndex = j;
                    strArray[i][j] = Math.max(maxLCS + 1, 0);
                    idk = strArray[i][j];
                    maxLCS = strArray[i][j];

                }
                else if(str1.charAt(i) == str2.charAt(j) && j > maxIndex ){

                    maxIndex = j;
                    strArray[i][j] = Math.min(maxLCS - 1, 1);
                }
                strArray[i][j] = strArray[i][j];
                //strArray[i][j] = Math.max(strArray[i][j], maxLCS);
            }
        }
        return maxLCS;
 */
