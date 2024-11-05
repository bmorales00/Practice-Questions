package com.brianprojects.Leetcode.BinarySearch;

public class SquaresSortedArray {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int[] sortedSqaures(int[] nums){
        int[] res = new int[nums.length];
        int l =0;
        int r = nums.length-1;

        for(var i = res.length-1; i>=0; i--){
            if(Math.abs(nums[r]) > Math.abs(nums[l])){
                res[i] = nums[r]*nums[r];
                r--;
            }
            else if(Math.abs(nums[r]) < Math.abs(nums[l])){
                res[i] = nums[l]*nums[l];
                l++;
            }
            else if((Math.abs(nums[r]) == Math.abs(nums[l]) && l!=r)){
                res[i] = nums[l]*nums[l];
                l++;
            }
            else{
                res[i] = nums[l]*nums[l];
            }
        }
        return res;
    }
}
