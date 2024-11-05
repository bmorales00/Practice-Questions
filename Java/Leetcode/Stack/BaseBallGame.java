package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class BaseBallGame {
    //Time Complexity: O(s) || Space Complexity: O(1)
    public int calPoints(String[] operations){
        if(operations  ==null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for(var st: operations){
            if(!st.equals("C") && !st.equals("D") && !st.equals("+")){
                stack.push(Integer.parseInt(st));
            }
            else if(st.equals("C")){
                stack.pop();
            }
            else if(st.equals("D")){
                stack.push(stack.peek()*2);
            }
            else if(st.equals("+")){
                var popped = stack.pop();
                int item = popped + stack.peek();
                stack.push(popped);
                stack.push(item);
            }
        }
        while(!stack.isEmpty()){
            total+=stack.pop();
        }
        return total;
    }
}
