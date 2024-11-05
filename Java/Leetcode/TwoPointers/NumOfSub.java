package com.brianprojects.Leetcode.TwoPointers;

import java.util.Arrays;

public class NumOfSub {
    //Time Complexity O(n logn) + O(n)
    //Space Complexity: O(n) for the pow array
    public int numSubseq(int[] nums, int target){
        if(nums == null || target <=0){return 0;}
        Arrays.sort(nums);
        int slow = 0;
        int fast = nums.length-1;
        int mod = 1000000007;
        int numOfSub = 0;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i<nums.length; i++){
            pow[i] = pow[i-1]*2 %mod;
        }
        while(slow <= fast){
            if(nums[slow]+nums[fast] > target){
                fast--;
            }
            else{
                numOfSub= (numOfSub+pow[fast-slow++]) %mod;
            }
        }
        return numOfSub;
    }

}
