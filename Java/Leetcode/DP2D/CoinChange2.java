package com.brianprojects.Leetcode.DP2D;

public class CoinChange2 {
    //Time Complexity: O(m*n) || Space Complexity: O(m*n)
    public int change(int amount, int[] coins){
        if(coins == null){return 0;}
        int[][] dp = new int[coins.length][amount+1];
        for(int r = coins.length-1; r>=0; r--){
            dp[r][0] = 1;
            for(int c = 1; c<dp[r].length; c++){
                if(coins[r] <= c){dp[r][c]= dp[r][c-coins[r]];}
                if(r<coins.length-1){dp[r][c]+=dp[r+1][c];}
            }
        }

        return dp[0][amount];
    }
    public int change2(int amount, int[] coins){
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
