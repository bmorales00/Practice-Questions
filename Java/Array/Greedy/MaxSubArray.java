package com.brianprojects.LeetQues75.Array.Greedy;

public class MaxSubArray {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.
     */


    public int maxSubArray(int[] nums){

        if(nums.length == 1){
            return nums[0];
        }

        int maxSum = nums[0]; // [-2,1,-3,4,-1,2,1,-5,4]
        int maxSumNow = 0;

        for(var n: nums){
            if(maxSumNow < 0){
                maxSumNow = 0;
            }
            maxSumNow+=n;
            maxSum = Math.max(maxSum, maxSumNow);
        }
        return maxSum;

    }

}
