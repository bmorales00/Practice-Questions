package com.brianprojects.Leetcode.TwoPointers;

import java.util.Arrays;

public class MinDiffHighAndLow {

    //Time Complexity: O(n *log n) || Space Complexity: O(1)
    public int minimumDifference(int[] nums, int k){
        if(k == 1||nums.length ==0 || k> nums.length){
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[k-1] - nums[0];

        for(var i = k; i<nums.length;i++){
            min = Math.min(min, nums[i] - nums[(i-k)+1]);
        }


        return min;
    }
}
