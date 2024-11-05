package com.brianprojects.Leetcode.BinarySearch;

import java.util.Arrays;

public class MintheMaxDiff {
    //Time Complexity: O(n *log m) || Space Complexity: O(1)
    public int minimizeMax(int[] nums , int p){
        if(nums == null){return -1;}
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1];
        int min = Integer.MAX_VALUE;
        while(low<= high){
            int q = 0;
            int i = 0;
            int mid = (low+high)/2;
            while(i<nums.length-1 && q<p){
                if(nums[i+1]- nums[i] <= mid){
                    i+=2;
                    q++;
                }
                else{
                    i++;
                }
            }
            if(q==p){min = Math.min(min, mid); high =mid-1;}
            else{low = mid+1;}
        }
        return min;
    }
}
