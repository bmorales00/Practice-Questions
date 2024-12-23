package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */

    //Runtime is O(n)
    public int[] twoSum(int[] nums, int target){
        // k,v = value, index
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(var i = 0; i<nums.length; i++){
            if(map.containsKey(target -nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}