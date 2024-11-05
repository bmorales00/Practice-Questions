package com.brianprojects.Leetcode.TwoPointers;

import java.util.Arrays;

public class AverageOfNeighbors {
    //Time Complexity: O(n logn )
    //Space Complexity: O(n)
    public int[] rearrangeArray(int[] nums){
        if(nums == null ){return new int[0];}
        if(nums.length <=2){return nums;}
        Arrays.sort(nums);
        int mid = nums.length%2 ==0?nums.length/2:(nums.length/2)+1;
        int[] res = new int[nums.length];

        for(int i = 0; i<nums.length; i+=2){
            res[i] = nums[i/2];
        }
        for(int i = 1; i<nums.length; i+=2){
            res[i] = nums[mid++];
        }
        return res;
    }
}

