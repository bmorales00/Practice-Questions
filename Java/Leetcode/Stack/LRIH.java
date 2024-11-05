package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class LRIH {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea  = Integer.MIN_VALUE;
        for(var i = 0; i< heights.length; i++){
            int pop = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                maxArea = Math.max(maxArea,(i - stack.peek()[0]) * stack.peek()[1]);
                pop = stack.peek()[0];
                stack.pop();

            }
            stack.push(new int[]{pop, heights[i]});
        }
        int last = heights.length-1;
        while(!stack.isEmpty()){
            maxArea = Math.max(maxArea, (last - stack.peek()[0] + 1) * stack.peek()[1]);
            stack.pop();
        }
        return maxArea;
    }
}
