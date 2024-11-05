package com.brianprojects.Leetcode.DP1D;

public class ClimbingStairs {
    /*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    //Runtime is of Linear Time Complexity O(n)

    public int climbStairs(int steps){
        int[] dp = new int[steps+1];
        dp[dp.length-1] = 1;
        dp[dp.length-2] = 1;

        int one = dp.length-1;
        int two = dp.length-2;
        for(var i = dp.length-3; i>=0; i--){
            dp[i] = dp[one--]+dp[two--];
        }
        return dp[0];
    }

    //Recursion
    public int climbStairsV2(int steps){
        if(steps< 0){
            return 0;
        }
        if(steps == 0){
            return 1;
        }

        return climbStairsV2(steps-1) + climbStairsV2(steps-2);
    }
}


/*
    Recustion (Top Down Approach)

/**
 * Question   : Climbing Stairs
 * Complexity : Time: O(2^n) ; Space: O(n)

class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}



Recustion + Memoization (Top Down Approach)


 * Question   : Climbing Stairs
 * Complexity : Time: O(n) ; Space: O(n)
class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        return memo.get(n);
    }
}
/*
    DP (Bottom Up Approach)

/**
 * Question   : Climbing Stairs
 * Complexity : Time: O(n) ; Space: O(n)


class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

DP + Optimization (Bottom Up Approach)

        To calculate the new value we only leverage the previous two values. So we don't need to use an array to store all the previous values.

/**
 * Question   : Climbing Stairs
 * Complexity : Time: O(n) ; Space: O(1)
 */

/*
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
}
*/