package com.brianprojects.LeetQues75.Array;

import java.util.Arrays;

public class FindMin {
    /*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
    the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
    Notice that rotating an
    array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    You must write an algorithm that runs in O(log n) time.
     */

    public int findMin(int[] nums){
        var mid = nums.length/2;
        int min= nums[mid];
        int start = 0;

        if(nums[mid] >= nums[0] && nums[0] > nums[nums.length-1]){
            start = mid+1;
            mid = nums.length;
        }
        for(var i = start; i<mid; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }

}
