package com.brianprojects.Leetcode.Algo.Array.Implementations.KadanesAlgo;

public class LargestContigSubArray {
    public static int check(int[] nums){
        if(nums == null){return -1;}
        int curr = nums[0];
        int max = 0;

        for(var val: nums){
            if (max < 0){
                max = 0;
            }
            max+=val;
            curr = Math.max(curr,max);
        }

        return curr;
    }
}
