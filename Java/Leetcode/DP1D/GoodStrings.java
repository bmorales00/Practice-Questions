package com.brianprojects.Leetcode.DP1D;

public class GoodStrings {

    //Time Complexity: O(high) || Space Complexity:O(high)
    private final int MOD = (int) 1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        if(low <= 0 || high <= 0 || zero <= 0 || one <=0){return 0;}
        int small = Math.min(zero,one);
        int big = Math.max(zero,one);
        int[] dp = new int[high+1];
        dp[0] = 1;
        return dp(low, high, small, big, dp);
    }

    private int dp(int low, int high, int zero, int one, int[] dp) {
        int count =0;

        for(int i =1; i<=high; i++){
            if(i>= one){
                dp[i] = (dp[i-zero] + dp[i-one])%MOD;
            }
            else if(i>=zero){
                dp[i] = dp[i-zero]%MOD;
            }
            if(i >= low){
                count =(count+dp[i]) % MOD;
            }
        }

        return count;
    }


}
