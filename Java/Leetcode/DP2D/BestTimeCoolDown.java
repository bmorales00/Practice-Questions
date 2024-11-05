package com.brianprojects.Leetcode.DP2D;

//Time Complexity: O(n) | Space Complexity: O(1)
//*********** Work On This!!
public class BestTimeCoolDown {
    public int maxProfit(int[] prices){
        if(prices == null || prices.length <= 1) return 0;

        int buy0 = -prices[0];
        int buy1 = buy0;
        int sell0 = 0;
        int sell1 = 0;
        int sell2 = 0;

        for(int i = 1; i < prices.length; i++) {
            buy0 = Math.max(buy1, sell2 - prices[i]);
            sell0 = Math.max(sell1, buy1 + prices[i]);
            buy1 = buy0; sell2 = sell1; sell1 = sell0;
        }
        return sell0;
    }

}
/*
if(prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        sell[1] = Math.max(sell[0], prices[1] + buy[0]);

        for(int i = 2; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);
        }

        return sell[n - 1];
 */

/*
1. Define States

To represent the decision at index i:

    buy[i]: Max profit till index i. The series of transaction is ending with a buy.
    sell[i]: Max profit till index i. The series of transaction is ending with a sell.

To clarify:

    Till index i, the buy / sell action must happen and must be the last action. It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
    In the end n - 1, return sell[n - 1]. Apparently we cannot finally end up with a buy. In that case, we would rather take a rest at n - 1.
    For special case no transaction at all, classify it as sell[i], so that in the end, we can still return sell[n - 1]. Thanks @alex153 @kennethliaoke @anshu2.

2. Define Recursion

    buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1, or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
    sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1, or buy at/before i - 1, then sell at i.

So we get the following formula:

buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

3. Optimize to O(1) Space

DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.

    Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
    Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]

Then arrays turn into Fibonacci like recursion:

b0 = Math.max(b1, s2 - prices[i]);
s0 = Math.max(s1, b1 + prices[i]);

4. Write Code in 5 Minutes

First we define the initial states at i = 0:

    We can buy. The max profit at i = 0 ending with a buy is -prices[0].
    We cannot sell. The max profit at i = 0 ending with a sell is 0.

 */