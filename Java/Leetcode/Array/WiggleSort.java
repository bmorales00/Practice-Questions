package com.brianprojects.Leetcode.Array;

public class WiggleSort {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public void wiggleSort(int[] nums){
        if(nums == null){return;}

        for(int i = 1; i<nums.length; i++){
            if(i%2 == 0){
                if(!(nums[i] <= nums[i-1])){
                    swap(nums, i, i-1);
                }
            }
            else{
                if(!(nums[i] >= nums[i-1])){
                    swap(nums, i, i-1);
                }
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
