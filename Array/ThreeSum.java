package com.brianprojects.LeetQues75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    Given an integer array nums, return all the triplets
    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
     */

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(); //[-4,-1,-1,0,1,2]
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { //left = 1
                int left = i+1, right = nums.length-1, sum = 0 - nums[i]; //right = 5 //sum = 0-nums[0] = -4
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++; right--;
                    } else if (nums[left] + nums[right] < sum) {
                        while (left < right && nums[left] == nums[left+1]) left++;
                        left++;
                    } else {
                        while (left < right && nums[right] == nums[right-1]) right--;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
