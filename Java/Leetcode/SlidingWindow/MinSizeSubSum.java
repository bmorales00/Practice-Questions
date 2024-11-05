package com.brianprojects.Leetcode.SlidingWindow;

public class MinSizeSubSum {
    //TIme Complexity: O(n) || Space Complexity: O(1)
    public int minSubArrayLen(int target, int[] nums){
        if(target == 0 || nums == null){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int total = nums[0];
        int r = 0;

        for(var i = 0; i<nums.length; i++){
            if(min == 1){
                return 1;
            }
            while(r!=nums.length-1 && total<target){
                total+=nums[r+1];
                r++;
            }
            if(total >= target){
                min = Math.min(min, (r-i)+1);
                total-=nums[i];
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}
