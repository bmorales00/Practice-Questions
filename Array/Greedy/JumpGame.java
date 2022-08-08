package com.brianprojects.LeetQues75.Array.Greedy;

import java.util.HashSet;
import java.util.Set;

public class JumpGame {
    /*
    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.
     */

    public static boolean canJump(int[] nums){
        if(nums == null){
            return false;
        }
        if(nums.length <=1){
            return true;
        }
        int goal = nums.length-1;
        int last = nums.length-1;

        for(var i = nums.length-2; i>=0; i--){
            if(nums[i] + i  == goal || goal - i <= nums[i] || nums[i] + i  == last ){
                goal = i;
            }
        }
        return goal == 0;
    }
}
