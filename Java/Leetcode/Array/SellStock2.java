package com.brianprojects.Leetcode.Array;

public class SellStock2 {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int maxProfit(int[] prices){
        if(prices == null){return -1;}

        int profit = 0;

        for(int i =0; i<prices.length; i++){
            if(i+1< prices.length && prices[i] >prices[i+1]){
                continue;
            }
            int l = i;
            while(l+1<prices.length && prices[l+1] >prices[l]){
                l++;
            }
            profit+=prices[l]-prices[i];
            i=l;
        }

        return profit;
    }
}
