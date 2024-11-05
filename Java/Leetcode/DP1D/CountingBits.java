package com.brianprojects.Leetcode.DP1D;

public class CountingBits {
    public int[] countingBits(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i<dp.length; i++){

            int count = 0;
            int start = i;
            while( start>0){
                count+=1;
                start&=(start-1);
            }
            dp[i] = count;
        }
        return dp;
    }
}
