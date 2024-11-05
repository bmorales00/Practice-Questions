package com.brianprojects.Leetcode.DP2D;

public class LastStoneWeight2 {
    //Time Complexity: O(sum*n) || Space Complexity: O(sum*n)
    public int lastStoneWeightII(int[] stones){
        int Sum = 0, S2 = 0;
        for (int s : stones) Sum += s;
        int n = stones.length;
        boolean[][] dp = new boolean[(Sum/2) + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= Sum / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    dp[s][i] = true;
                    S2 = Math.max(S2, s);
                }
            }
        }
        return Sum - 2 * S2;
    }
}
