package com.brianprojects.Leetcode.DP1D;

//Time Complexity: O(n*t) where n is the number of elements in the array and t is the target value.
//For every target value we traverse through the array to find out the num of times to reach current value.

//Space Complexity: O(n*t)/O(t)
public class CombinationSumIV {
    //Bottom Up Tabulation
    public int combinationSum4(int[] nums, int target){
        if(nums == null|| nums.length <=0){
            return 0;
        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        int sum = 0;
        for(var i = 1; i< target; i++){
            int index = 0;
            while(index <  nums.length){
                if(!(nums[index] > i)){
                    dp[i] += dp[i-nums[index]];
                }
                index++;
            }
        }
        for(var n : nums){
            if(n <= target){
                sum+= dp[target-n];
            }
        }
        return sum;
    }
}
/*
comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i]
 */
