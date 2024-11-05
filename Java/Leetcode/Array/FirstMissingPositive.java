package com.brianprojects.Leetcode.Array;

import java.util.Arrays;

public class FirstMissingPositive {
    //Time Complexity: O(n log n ) || Space Complexity: O(1)
    public int firstMissingPositive(int[] nums){
        if(nums == null){return 0;}
        Arrays.sort(nums);

        int small = 1;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] <=0 || small>nums[i]){
                continue;
            }
            if(nums[i]>small){
                return small;
            }
            small++;
        }
        return small;
    }
    public int firstMissingPositive2(int[] nums){
        if(nums == null){return 0;}
        boolean[] n = new boolean[nums.length+2];

        for(int val:nums){
            if(val>0 && val<=nums.length){
                n[val]= true;
            }
        }
        for(int i = 1;i<n.length;i++){
            if(!n[i]){
                return i;
            }
        }
        return 0;
    }
}
