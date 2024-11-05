package com.brianprojects.LeetQues75.DynamProg1D;

public class HouseRobber {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
    and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house, return the maximum
    amount of money you can rob tonight without alerting the police.
     */
    public static int rob(int[] nums){
        if(nums == null){
            return 0;
        }
        if(nums.length <=1){
            return nums[0];
        }

        int counter = 2;
        int maxCounter = Math.max(nums[0], nums[1]);

        while(counter < nums.length){
            if(!(counter -2  <= 0 && counter-3<=0)){
                nums[counter] = Math.max(nums[counter-2] + nums[counter], nums[counter-3]+ nums[counter]);
            }
            else{
                nums[counter]= nums[counter-2] + nums[counter];
            }
            maxCounter = Math.max(maxCounter, nums[counter]);
            counter++;
        }

        return maxCounter;

    }
}


/*
public int rob(int[] num) {
    int rob = 0; //max monney can get if rob current house
    int notrob = 0; //max money can get if not rob current house
    for(int i=0; i<num.length; i++) {
        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
        rob = currob;
    }
    return Math.max(rob, notrob);
}
 */
