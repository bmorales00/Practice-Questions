package com.brianprojects.Leetcode.BinarySearch;

public class SingleElementSA {
    public int singleNonDuplicate(int[] nums){
        if(nums == null){return 0;}
        if(nums.length == 1){return nums[0];}

        for(int i =1; i<nums.length; i+=2){
            if(nums[i-1] != nums[i]){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}
