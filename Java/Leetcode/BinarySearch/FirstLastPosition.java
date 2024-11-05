package com.brianprojects.Leetcode.BinarySearch;

public class FirstLastPosition {
    //Time Complexity: O(log n) || Space Complexity: O(1)
    public int[] searchRange(int[] nums, int target){

        int indexOfTarget = search(nums, target, 0, nums.length-1);
        if(indexOfTarget ==-1000000001){
            return new int[]{-1,-1};
        }

        int l = indexOfTarget;
        int r = indexOfTarget;
        while(l-1 >=0 && nums[l-1] == target){
            l-=1;

        }
        while(r+1< nums.length && nums[r+1] == target){
            r+=1;
        }
        return new int[]{l, r};
    }

    private int search(int[] nums, int target, int start, int end) {
        if(start>end){
            return -1000000001;
        }
        int mid = (end+start)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] < target){
            return search(nums, target, mid+1, end);
        }
        else{
            return search(nums,target,start, mid-1);
        }
    }
}
