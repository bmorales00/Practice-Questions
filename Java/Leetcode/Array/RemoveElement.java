package com.brianprojects.Leetcode.Array;

public class RemoveElement {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int removeElement(int[] nums, int val){
        if(nums == null || val <0){
            return 0;
        }

        int remaining = nums.length;

        int slow = 0;
        int fast = 0;

        while(fast < remaining && slow < remaining){
            if(nums[slow] == val){
                fast = slow;
                while(!(fast >= remaining) && nums[fast] == val){
                    fast++;
                }
                if(fast >= remaining){
                    break;
                }
                nums[slow] = nums[fast];
                nums[fast] = val;
            }
            slow++;
        }
        return slow;
    }
}
