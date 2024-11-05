package com.brianprojects.Leetcode.Greedy;

public class MaxSumCircularSubArray {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int maxSubarraySumCircular(int[] nums){
        if(nums.length == 1){return nums[0];}
        int max = nums[0];
        int min = nums[0];
        int currentMax = 0;
        int currentMin = 0;
        int total = 0;

        for(int num: nums){
            total+=num;

            currentMax = Math.max(num+currentMax, num);
            max  = Math.max(currentMax,max);

            currentMin = Math.min(num+currentMin, num);
            min = Math.min(currentMin,min);
        }

        return max<0?max:Math.max(total-min, max);
    }
}

/*
int sum= nums[l];
            int lSum =nums[l];
            int r = (l+1)%nums.length;
            boolean hasCrossedNeg = nums[l] <= 0;
            while(r != l ){
                if (!hasCrossedNeg && nums[r] >0) {
                    sum += nums[r];
                }
                else if(nums[r] <0){
                    hasCrossedNeg = true;
                }
                lSum+=nums[r];
                r = (r+1)%nums.length;
                max = Math.max(Math.max(max,sum), lSum);
            }
            l++;
 */