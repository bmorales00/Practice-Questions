package com.brianprojects.LeetQues75.Array;

public class ContainerWater {
    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
     */
    public int maxArea(int[] nums){
        var leftPointer = 0;
        var rightPointer = nums.length-1;
        int mArea = 0;
        while(leftPointer < rightPointer){
            mArea = Math.max(mArea, ((rightPointer-leftPointer)*Math.min(nums[leftPointer], nums[rightPointer])));
            if(nums[leftPointer] <= nums[rightPointer]){
                leftPointer++;
            }
            else{
                rightPointer--;
            }
        }
        return mArea;
    }
}
