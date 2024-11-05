package com.brianprojects.Leetcode.SlidingWindow;

public class BSStock {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

     */

    //RUntime is : O(n) since it iterates through the array essentially once
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

    public int maxProfit2(int[] prices) {
        if(prices == null){
            return 0;
        }
        int buy = prices[0];
        int sell = 0;


        for(int i : prices){
            buy = Math.min(buy, i);
            sell = Math.max(sell, i-buy);
        }

        return sell;
    }
}



