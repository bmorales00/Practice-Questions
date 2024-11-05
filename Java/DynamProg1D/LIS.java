package com.brianprojects.LeetQues75.DynamProg1D;

public class LIS {
    /*
    **** LONGEST INCREASING SUBSEQUENCE:

    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    A subsequence is a sequence that can be derived from an array by deleting some or no elements
    without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of
    the array [0,3,1,6,2,2,7].
     */

    public int lengthOfLIS(int[] nums) {
        int[] subsequence = new int[nums.length];
        subsequence[0] = 1;
        int maxTarget = 0;
        for (var target = 1; target < nums.length; target++) {
            int max = 0;
            for (var value = 0; value < target; value++) {
                if (nums[value] < nums[target]) {
                    max = Math.max(max, subsequence[value]);
                }
            }
            subsequence[target] = max+1;
            maxTarget = Math.max(subsequence[target], maxTarget);
        }
        return maxTarget;
    }
}
