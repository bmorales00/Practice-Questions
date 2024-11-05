package com.brianprojects.Leetcode.DP2D;

public class MaxAlternatingSubSeqSum {
    //Time Complexity: O(n) || Space Complexity : O(1)
    public long maxAlternatingSum(int[] nums){
        long evenCount = 0;
        long oddCount = 0;
        long max = 1;
        int n = nums.length;

        for(int i = 0; i<n-1;){
            while(i<n-1 && nums[i] <= nums[i+1]){
                i++;
            }
            evenCount+=nums[i];
            max = Math.max(max,evenCount-oddCount);
            int j =i;
            while(j<n-1&&nums[j]>=nums[j+1]){
                j++;
            }
            if(i!=j){oddCount+=nums[j]; i=j;}
            max = Math.max(max,evenCount-oddCount);
        }

        return max;
    }
}
