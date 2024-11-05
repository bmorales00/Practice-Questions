package com.brianprojects.Leetcode.DP1D;

public class Fibonacci {
    //Recurrsion
    static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        System.out.println("The fib: "+ n);
        return fib(n-1)+fib(n-2);
    }
    //Bottom Up : Tabulation
    static int fibDP(int n){
        int[] dp = new int[n+1];
        //dp[0] = 0 by default since we created a new dp array
        dp[1] = 1;

        for(var i = 2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
            System.out.println(dp[i]);
        }

        return dp[n];
    }
    //Top Down // Memoization
    static int fibmem(int n){
        int[] dp = new int[n+1];
        fibmem(n, dp);
        return dp[n];
    }

    private static int fibmem(int n, int[] dp) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibmem(n-1, dp)+ fibmem(n-2, dp);
        System.out.println(dp[n]+" at index: "+n);
        return dp[n];
    }
}
