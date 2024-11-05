package com.brianprojects.Leetcode.TwoPointers;

import java.util.*;

public class FourSum {
    //Time Complexity: O(n * log n) + O(ij) || O(size of result) or O(n)
    public List<List<Integer>> fourSum(int[] nums, int target){
        if( nums == null || nums.length <=0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(var i = 0; i<nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]){continue;}
            for(var j = i+1; j<=nums.length-3;j++){
                if(j > i+1 && nums[j] == nums[j-1]){continue;}
                int left = j+1;
                int right = nums.length-1;
                long sum = nums[i] + nums[j];
                while(left < right){
                    if(sum + (nums[left] + nums[right]) == target){
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while(left+1 < right && nums[left+1] == nums[left]){
                            left++;
                        }
                        while(right-1> left && nums[right-1] == nums[right]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if( sum +(nums[left] + nums[right]) < target){
                        while(left+1 < right && nums[left+1] == nums[left]){
                            left++;
                        }
                        left++;
                    }
                    else{
                        while(right-1> left && nums[right-1] == nums[right]){
                            right--;
                        }
                        right--;
                    }
                }

            }
        }
        return res;
    }

}

