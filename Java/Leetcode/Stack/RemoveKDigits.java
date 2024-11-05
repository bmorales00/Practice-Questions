package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class RemoveKDigits {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public String removeKDigits(String num, int k){
        if( num.length() ==0 ){
            return "";
        }

        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        StringBuilder smallNum = new StringBuilder();
        int left  = k;

        for(var ch: num.toCharArray()){
            while(left!=0 && !stack.isEmpty() &&  Character.getNumericValue(ch) < Character.getNumericValue(stack.peek())){
                stack.pop();
                left--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty()){
            if(left != 0){
                stack.pop();
                left--;
            }
            else{
                stack2.push(stack.pop());
            }
        }
        while(!stack2.isEmpty()){
            if(smallNum.length() == 0 && Character.getNumericValue(stack2.peek()) == 0){
                stack2.pop();
                continue;
            }
            smallNum.append(stack2.pop());
        }

        return  smallNum.toString().length() == 0? "0":smallNum.toString() ;
    }
}
