package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class Find132Pattern {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public boolean find132Pattern(int[] nums){
        if(nums == null){return false;}

        Stack<Integer> jStack = new Stack<>();
        int i = Integer.MIN_VALUE;

        for(int  k = nums.length-1; k>=0; k--){
            if(nums[k] < i){
                return true;
            }
            while(!jStack.isEmpty() && nums[k] > jStack.peek()){
                i = jStack.pop();
            }
            jStack.push(nums[k]);
        }

        return false;
    }
}
