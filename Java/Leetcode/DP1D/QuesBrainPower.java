package com.brianprojects.Leetcode.DP1D;

public class QuesBrainPower {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public long mostPoints(int[][] questions){
        if(questions == null){return 0;}
        int l = questions.length;
        long[] dp = new long[l];
        dp[l-1] = questions[l-1][0];
        for(int i = l-2; i>=0;i--){
            int brain = i+questions[i][1]+1;
            dp[i] = brain<l?Math.max(dp[i+1], questions[i][0]+dp[brain]): Math.max(dp[i+1],questions[i][0]);
        }
        return dp[0];
    }

}
