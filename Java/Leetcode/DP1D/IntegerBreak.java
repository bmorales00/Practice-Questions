package com.brianprojects.Leetcode.DP1D;

public class IntegerBreak {
    //Time Complexity: O(n^2) | Space O(n)
    public int integerBreak(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(var i = 2; i<dp.length; i++){
            int x = 1;
            int y = i-1;

            while(x < i && y>0){
                dp[i] = Math.max(dp[i], x * Math.max(dp[y], y));
                x++;y--;
            }
        }
        return dp[n];
    }

    //Time Complexity: O(1) | Space is O(1)
    public int integerBreak2(int n){
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        else if (n == 3)
            return 2;

        for (int i = 0; i <= 4; i += 2) {
            int powerPart = 0;
            if ((n - i) % 3 == 0) {
                powerPart = (int) Math.pow(3, (n - i) / 3);
                return i == 0 ? powerPart : powerPart * i;
            }
        }
        return -1;
    }
}
/*

 */