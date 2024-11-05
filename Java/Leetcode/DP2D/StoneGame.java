package com.brianprojects.Leetcode.DP2D;

public class StoneGame {
    //Time Complexity: O(1) | Space Complexity: O(1)
    public boolean stoneGame(int[] piles){

        int alice = 0;
        int bob = 0;
        int x = 0;
        int y = 0;
        for(int i = 0, v = 1 ; i<piles.length; i+=2, v+=2){
            x += piles[i];
            y += piles[v];
        }
        alice = Math.max(x,y);
        bob = Math.min(x,y);

        return alice>bob;
    }
    //Time Complexity: O(n^2) | Space Complexity: O(n^2)
    public boolean stoneGame2(int[] piles){
        int n = piles.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }
}