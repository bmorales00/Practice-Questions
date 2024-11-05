package com.brianprojects.Leetcode.Greedy;

public class MaxSubArray {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.
     */


    //Runtime Complexity is: O(n), it only traverses through the array once.

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
            maxSumNow+=n; // -2 , 1 , -2 , 4 , 3 , 5 , 6 ,
            maxSum = Math.max(maxSum, maxSumNow); //-2 //1 // 1 //4 // 4 // 5 /6
        }
        return maxSum;

    }

}
