package com.brianprojects.Leetcode.SlidingWindow;

import java.util.Arrays;

public class FreqMostFreqElement {
    //Time Complexity: O(n log n) || Space Complexity: O(1)
    public int maxFrequency(int[] nums, int k ){
        if(nums == null){
            return 0;
        }
        Arrays.sort(nums);
        int max  = 1;
        int r = 0;
        long total = 0;

        for(var l = 0;l<nums.length; l++){
            total +=nums[l]; //1

            while(total + k < (long)nums[l] *(l-r+1)){
                total-=nums[r];
                r++;
            }
            max = Math.max(max, (l-r+1));
        }

        return max;
    }

}
