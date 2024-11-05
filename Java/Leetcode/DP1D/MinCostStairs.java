package com.brianprojects.Leetcode.DP1D;

//Time Complexity: O(n) | Space Complexity : O(n)
public class MinCostStairs {
    public int minCostClimbingStairs(int[] cost){
        if(cost == null || cost.length <=0){
            return 0;
        }
        int[] dp = new int[cost.length+1];
        dp[cost.length-1] = cost[cost.length-1];
        for(var i = cost.length-1; i>=0; i--){
            if(i+2 >=dp.length){
                continue;
            }
            dp[i] = Math.min(cost[i]+dp[i+1],cost[i]+dp[i+2] );
        }

        return Math.min(dp[0], dp[1]);
    }
    public int minCostClimbingStairs2(int[] cost){
        if(cost==null){return -1;}
        int n = cost.length;
        for(int i = 2; i<n; i++){
            cost[i] = Math.min(cost[i]+cost[i-2], cost[i]+cost[i-1]);
        }
        return Math.min(cost[n-1], cost[n-2]);
    }

}
/*

 */