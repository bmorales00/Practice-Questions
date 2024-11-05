package com.brianprojects.Leetcode.Array;

import java.util.Stack;

public class IsSubsequence {
    //Space Complexity: O(n) || Time Complexity: O(n)
    public boolean isSubsequence(String s, String t){
        if(s.length() > t.length() || s == null || t == null){
            return false;
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(var ch: s.toCharArray()){
            stack1.push(ch);
        }
        for(var ch: t.toCharArray()){
            stack2.push(ch);
        }

        while(!stack2.empty() && !stack1.empty()){
            if(stack1.peek() == stack2.peek()){
                stack1.pop();
            }
            stack2.pop();
        }
        return stack1.isEmpty();
    }
}
