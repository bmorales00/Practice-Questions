package com.brianprojects.Leetcode.Greedy;

public class MinMaxArray {

    //Time Complexity: O(n) || Space Complexity: O(1)
    public int minimizeArrayValue(int[] nums){
        if(nums == null){return  -1;}

        long total = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length; i++){
            total+=nums[i];
            double d = (double) total / (i+1);
            max = Math.max(max,(int) Math.ceil(d));
        }

        return max;
    }
}
