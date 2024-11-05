package com.brianprojects.Leetcode.TwoPointers;

public class MoveZeroes {
    // Time Complexity: O(n) || Space Complexity: O(1)
    public void moveZeroes(int[] nums){
        if(nums == null || nums.length <=0){
            return;
        }
        var boundary = -1;
        for(var i = 0; i< nums.length; i++){
            if(nums[i] != 0){
                var temp = nums[++boundary];
                nums[boundary] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
