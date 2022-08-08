package com.brianprojects.LeetQues75.Array;

public class BSStock {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

     */

    public int maxProfit(int[] prices) {
        int profit = 0;
        int leftPointer = 0;
        int rightPointer = 1;

        while(rightPointer < prices.length){
            if(prices[leftPointer] < prices[rightPointer]){
                profit = Math.max(profit, prices[rightPointer++] - prices[leftPointer]);
            }
            else{
                leftPointer++;
                rightPointer = leftPointer +1;
            }
        }

        return profit;
    }
}



//        int profit = 0;
//        for (var i = 0; i <= prices.length - 2; i++) {
//            for (var n = i + 1; n < prices.length; n++) {
//                if (prices[i] < prices[n]) {
//                    profit = Math.max(profit, prices[n] - prices[i]);
//                }
//            }
//        }
//        return profit;
