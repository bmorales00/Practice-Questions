package com.brianprojects.Leetcode.BinarySearch;
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;

        while(start < end){
            int mid = (start+end)/2;
            if(target == nums[mid]){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(target > nums[mid] && target <=nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return nums[start] == target? start: -1;
    }


}
