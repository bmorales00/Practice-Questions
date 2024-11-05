package com.brianprojects.Leetcode.Array;

public class NonDecArray {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public boolean checkPossibility(int[] nums){
        if(nums == null){return false;}
        boolean used = false;
        for(int i =1; i<nums.length-1;i++){
            if(nums[i] > nums[i+1] && nums[i-1] > nums[i+1] && nums[i-1]>nums[i]){return false;}
            if(nums[i] > nums[i+1] && nums[i-1] > nums[i+1]){
                if(used){return false;}
                nums[i+1] = nums[i];
                used= true;
            }
            else if(nums[i] > nums[i+1] && nums[i-1] < nums[i+1]){
                if(used){return false;}
                nums[i] = nums[i-1];
                used = true;
            }
            else if(nums[i]< nums[i+1] && nums[i-1]> nums[i+1]){
                if(used){return false;}
                nums[i-1] = nums[i];
                used = true;
            }
            else if(nums[i] < nums[i+1] && nums[i-1] > nums[i]){
                if(used){return false;}
                nums[i] = nums[i-1];
                used = true;
            }

        }
        return true;
    }
}
