package com.brianprojects.Leetcode.Array;

public class PivotIndex {
    public int pivotIndex(int[] nums){
        if(nums.length <=0 || nums == null){
            return -1;
        }

        int[] left  = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];

        for(var i = 1; i< left.length; i++){
            left[i] = left[i-1]+nums[i];
        }
        for(var i = nums.length-2; i>=0; i--){
            right[i] = right[i+1]+nums[i];
        }

        for(var i = 0 ;i<left.length; i++){
            if(left[i] == right[i]){
                return i;
            }
        }
        return -1;
    }
}
