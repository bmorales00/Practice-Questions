package com.brianprojects.Leetcode.TwoPointers;

import java.util.HashMap;

public class RemoveDuplicate2 {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int removeDeplicates(int[] nums){
        if(nums == null){return -1;}
        HashMap<Integer, Integer> visited = new HashMap<>();

        int slow = 0;
        int fast = 0;
        int n = nums.length;

        while(fast<n){
            if(!visited.containsKey(nums[fast])){
                visited.put(nums[fast], 1);
                swap(nums, slow,fast);
                slow++;
            }
            else if(visited.containsKey(nums[fast]) && visited.get(nums[fast]) <2){
                int oldVal = visited.get(nums[fast]);
                visited.replace(nums[fast], oldVal,oldVal+1);
                swap(nums, slow,fast);
                slow++;
            }
            fast++;

        }
        return slow;
    }
    private void swap(int[] nums, int slow, int fast){
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }
}
