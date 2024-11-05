package com.brianprojects.Leetcode.TwoPointers;

import java.util.HashSet;

public class RemoveDuplicate {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int removeDuplicates(int[] nums){
        if(nums == null){
            return 0;
        }

        HashSet<Integer> visited = new HashSet<>();

        int slow = 0;
        int fast = 0;

        while(fast < nums.length){
            if(!visited.contains(nums[fast])){
                visited.add(nums[fast]);
                var temp= nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
