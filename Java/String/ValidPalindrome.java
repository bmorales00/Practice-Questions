package com.brianprojects.LeetQues75.String;

import java.util.Stack;

public class ValidPalindrome {
    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
    non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
     */

    public static  boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        StringBuilder str = new StringBuilder(s.length());
        for(var ch:s.toLowerCase().toCharArray()){
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
                str.append(ch);
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            if(str.charAt(index++) != stack.pop()){
                return false;
            }
        }
        return true;
    }
}
