package com.brianprojects.Leetcode.BinarySearch;

public class InsertPosition {
    //Time Complexity: O(log n) || Space Complexity: O(1)
    public int searchInsert(int[] nums, int target){
        if(nums == null){
            return 0;
        }

        return search(nums, target, 0,nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if(start>end){
            return start ;
        }
        int mid = (end +start)/2;
        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] < target){
            return search(nums, target, mid+1, end);
        }
        else{
            return search(nums,target,start,mid-1);
        }

    }
}

