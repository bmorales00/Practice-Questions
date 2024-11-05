package com.brianprojects.Leetcode.BitManipulation;

import java.util.Arrays;

public class SingleNumber {
    //Time Complexity:O(n) || Space Complexity:O(n)
    public int singleNumber(int[] nums){
        if(nums.length == 1){return nums[0];}
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-1; i+=2){
            if(nums[i] != nums[i+1]){return nums[i];}
        }
        return nums[nums.length-1];
    }
    public int singleNumber2(int[] nums){
        if(nums.length == 1){return nums[0];}
        int res = nums[0];
        for(int i = 1; i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }
}
