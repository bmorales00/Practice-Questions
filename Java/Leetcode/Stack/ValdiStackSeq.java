package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

//Time Complexity: O(n) || Space Complexity: O(n)
public class ValdiStackSeq {
    public boolean validateStackSequences(int[] pushed, int[] popped){
        if(pushed == null || popped == null){return false;}
        Stack<Integer> stack  = new Stack<>();
        int j = 0;
        int i = 0;
        while(i<pushed.length){
            if(pushed[i] == popped[j]){
                j++;i++;
            }
            else if(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;

            }
            else{
                stack.push(pushed[i++]);
            }
        }
        while(!stack.isEmpty() && j<popped.length){
            if(stack.peek()!= popped[j]){
                return false;
            }
            stack.pop();
            j++;
        }
        return true;
    }
}
