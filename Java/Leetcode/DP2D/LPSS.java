package com.brianprojects.Leetcode.DP2D;

public class LPSS {
    public int longestPalindromeSubseq(String s){
        StringBuilder s2 = new StringBuilder();
        for(int i = s.length()-1; i>=0;i--){
            s2.append(s.charAt(i));
        }
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 1; i<dp.length; i++){
            for(int j =1; j<dp.length; j++){
                dp[i][j] = s.charAt(i-1) == s2.charAt(j-1)? dp[i-1][j-1]+1:Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[s.length()][s.length()];
    }
    public int longestPalindromeSubseq2(String s){
        char[] c = s.toCharArray();
        int n = c.length, max = 0;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++) {
            dp[j] = 1;
            max = 0;
            for(int i = j-1; i >= 0; i--) {
                int len = dp[i];
                if(c[i] == c[j]) {
                    dp[i] = 2 + max;
                }
                max = Math.max(max, len);
            }
        }
        for(int len: dp) max = Math.max(max, len);
        return max;
    }
}
