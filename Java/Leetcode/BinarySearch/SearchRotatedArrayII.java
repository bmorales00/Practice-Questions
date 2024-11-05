package com.brianprojects.Leetcode.BinarySearch;

public class SearchRotatedArrayII {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public boolean search(int[] nums, int target){
        if(nums == null){return false;}
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start+((end-start)/2);
            if(nums[mid]== target){return true;}
            if(nums[mid] == nums[start]){start++;continue;}
            if(nums[start] < nums[mid]){
                if(target>=nums[start] && target<nums[mid]){end = mid-1;}
                else{start = mid+1;}
            }
            else{
                if(target<=nums[end] && target>nums[mid]){start = mid+1;}
                else{end = mid-1;}
            }
        }
        return nums[start] == target;
    }

}

/*
if((target > nums[mid]  && target <= nums[end]) || (target< nums[mid] && target <nums[end] && target <nums[start])){
            return search(nums, target, mid+1, end);
        }
        else{
            return search(nums, target, start,mid-1);
        }
 */