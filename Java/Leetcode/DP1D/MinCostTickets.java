package com.brianprojects.Leetcode.DP1D;

public class MinCostTickets {
    //Time Complexity: O(n) ||Space Complexity: O(n)
    public int mincostTickets(int[] days, int[] costs){
        if(days == null){return 0;}
        int last = days[days.length-1];
        boolean[] set = new boolean[last+1];
        int[] dp = new int[last+1];
        for(int val: days){
            set[val] = true;
        }

        for(int i = 1; i<=last; i++){
            if(!set[i]){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = costs[0] + dp[i-1];
            dp[i]= Math.min(costs[1] + dp[Math.max(i-7,0)], dp[i]);
            dp[i]= Math.min(costs[2] + dp[Math.max(i-30,0)], dp[i]);
        }
        return dp[last];
    }


}
