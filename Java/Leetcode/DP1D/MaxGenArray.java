package com.brianprojects.Leetcode.DP1D;

public class MaxGenArray {
    public int getMaximumGenerated(int n){
        if(n == 0){return 0;}
        if(n == 1 || n ==2){return 1;}
        int[] dp = new int[n+1];
        dp[1]=1;

        for(int i =1; i<=n/2;i++){
            if(i*2<=n){
                dp[i*2] = dp[i];
            }
            if((i*2)+1<=n){
                dp[(i*2)+1] = dp[i]+dp[i+1];
            }
        }
        int max = 0;
        for(int val:dp){
            max=Math.max(val,max);
        }
        return max;
    }
}
