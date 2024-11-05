package com.brianprojects.LeetQues75.String;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
     */

    public static boolean isValid(String s){
        var stack  = new Stack<Character>();
        for(var ch: s.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(ch == ')' && stack.peek() != '('){
                return false;
            }
            else if(ch == ']' && stack.peek() != '['){
                return false;
            }
            else if(ch == '}' && stack.peek() != '{'){
                return false;
            }
            else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
