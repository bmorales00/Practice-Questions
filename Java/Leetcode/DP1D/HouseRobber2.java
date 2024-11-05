package com.brianprojects.Leetcode.DP1D;

import java.util.Arrays;

public class HouseRobber2 {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
    All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
    Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police
    if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house,
    return the maximum amount of money you can rob tonight without alerting the police.
     */

    public static int rob(int[] nums){
        if(nums == null){
            return 0;
        }
        if(nums.length <=1){
            return nums[0];
        }
        int first = 0;
        int second = 0;
        int currentMax;
        for(int i=0; i<nums.length-1; i++) {
            int current = second + nums[i];
            second = Math.max(second, first);
            first = current;
        }
        currentMax =Math.max(first,second);
        first =0;
        second=0;
        for(int i=nums.length-1; i>0; i--) {
            int current = second + nums[i];
            second = Math.max(second, first);
            first = current;
        }
        currentMax =Math.max(Math.max(first,second), currentMax);
        return currentMax;
    }

    public static int robV2(int[] nums){
        if(nums == null){
            return 0;
        }
        if(nums.length <= 1){
            return nums[0];
        }
        int max = Math.max(nums[0], nums[1]);

        var arrayCopy = Arrays.copyOf(nums, nums.length);

        //Forward
        for(var i = 2; i <nums.length-1; i++){
            if(i-3 >=0){
                nums[i] = Math.max(nums[i] + nums[i-2], nums[i] + nums[i-3]);
            }
            else{
                nums[i] = nums[i] + nums[i-2];
            }
            max = Math.max(nums[i], max);
        }

        //Backwards
        max = Math.max(max, nums[arrayCopy.length-1]);
        for(var i = arrayCopy.length-3; i >0; i--){
            if(i+3 <=arrayCopy.length-1){
                arrayCopy[i] = Math.max(arrayCopy[i] + arrayCopy[i+2], arrayCopy[i] + arrayCopy[i+3]);
            }
            else{
                arrayCopy[i] = arrayCopy[i] + arrayCopy[i+2];
            }
            max = Math.max(arrayCopy[i], max);
        }

        return max;
    }
}
//        if(nums == null){
//            return 0;
//        }
//        if(nums.length <=1){
//            return nums[0];
//        }
//
//        int counter = 2;
//        int maxCounter = Math.max(nums[0], nums[1]);
//
//        int[] dp = Arrays.copyOf(nums, nums.length);
//
//        while(counter < nums.length-1){
//            if(!(counter -2  <= 0 && counter-3<=0)){
//                nums[counter] = Math.max(nums[counter-2] ,nums[counter-3]) + nums[counter];
//            }
//            else{
//                nums[counter]= nums[counter-2] + nums[counter];
//            }
//            maxCounter = Math.max(maxCounter, nums[counter]);
//            counter++;
//        }
//        counter-=2;
//        maxCounter = Math.max(maxCounter,dp[nums.length-1]);
//        while(counter > 0){
//            if(counter +2  <= dp.length -1 && counter+3<=dp.length-1){
//                dp[counter] = Math.max(dp[counter+2] ,dp[counter+3]) + dp[counter];
//            }
//            else{
//                dp[counter]= dp[counter+2] + dp[counter];
//            }
//            maxCounter = Math.max(maxCounter, dp[counter]);
//            counter--;
//        }
//
//        return maxCounter;
