package com.brianprojects.Leetcode.BitManipulation;

public class MissingNumber {
    /*
    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.
     */

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;

    }
}
