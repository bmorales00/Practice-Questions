package com.brianprojects.LeetQues75.DynamProg1D;

public class CoinChange {
    /*
    You are given an integer array coins representing coins of different denominations
    and an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.
     */


    public int coinChange(int[] coins, int amount){ //LETS SAY THE AMOUNT WAS 11 AND THE COINS WERE AS FOLLOWED:
        // [ 2, 3, 4 ,6]
        int[] dp = new int[amount+1]; //THIS ARRAY IS GONNA HAVE A SIZE OF 11+1 WHICH IS 12 SO IT WILL LOOK LIKE THIS:
        //[0,0,0,0,0,0,0,0,0,0,0,0] == SIZE OF 12
        for(int target = 1; target< dp.length; target++){ // TARGET WILL CONTINUE GOING UP AS LONG AS IT IS LESS THAN 12
            dp[target] = dp.length; // DP[TARGET] = 12 AS WE CONTINUE
            for(int coin: coins){ // COIN == [2,3,4,6]
                if(target>=coin){ // 1 IS NOT GREATER THAN ANY AMOUNT IN THE ARRAY SO WE MOVE ON
                    dp[target] = Math.min(dp[target], dp[target-coin]+1);
                }
            }
        }
        return dp[amount] == dp.length ? -1:dp[amount];
    }
}
