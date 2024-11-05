package com.brianprojects.Leetcode.DP1D;

//Time Complexity is : O(n) * O(sqrt(n))
//Space Complexity: O(n)
public class PerfectSquares {
    public int numSquares(int n){
        if(n == 0){
            return 0;
        }
        if(n <4){
            return n;
        }

        int sqrt = (int)Math.sqrt(n);
        int[] arr = new int[sqrt];
        int[] dp = new int[n+1];

        for(var i =0; i<arr.length; i++){
            int i2 = i+1;
            arr[i] = i2*i2;
        }

        for(var target = 1; target<dp.length; target++){
            dp[target] = dp.length;
            for(int num:arr){
                if(target >= num){
                    dp[target] = Math.min(dp[target], dp[target-num]+1);
                }
            }
        }
        return dp[n];
    }
}
/*
int[] dp = new int[n + 1];
	Arrays.fill(dp, Integer.MAX_VALUE);
	dp[0] = 0;
	for(int i = 1; i <= n; ++i) {
		int min = Integer.MAX_VALUE;
		int j = 1;
		while(i - j*j >= 0) {
			min = Math.min(min, dp[i - j*j] + 1);
			++j;
		}
		dp[i] = min;
	}
	return dp[n];
 */