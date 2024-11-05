package com.brianprojects.Leetcode.Array;

import java.util.Arrays;

public class RangeSumQuery {
    private final int[] numsCopy;
    public RangeSumQuery(int[] nums) {
        this.numsCopy = Arrays.copyOf(nums,nums.length);
    }

    public int sumRange(int left, int right) {
        int total = 0;
        for(int i = left; i<=right; i++){
            total+=numsCopy[i];
        }
        return total;
    }
}
