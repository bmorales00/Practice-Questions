package com.brianprojects.LeetQues75.Array;

import java.util.HashMap;

public class TwoSum2 {
    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space.
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(var i = 0; i<nums.length; i++){
            if(map.containsKey(target -nums[i])){
                result[0] = map.get(target - nums[i]) +1;
                result[1] = i+1;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
