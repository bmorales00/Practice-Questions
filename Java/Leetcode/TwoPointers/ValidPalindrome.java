package com.brianprojects.Leetcode.TwoPointers;

public class ValidPalindrome {
    // Time Complexity: O(s.length) || Space Complexity: O(s.length)
    public boolean isPalindrome(String s){
        if(s == null){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        StringBuilder str = new StringBuilder();
        for(var ch: s.toCharArray()){
            if(Character.isAlphabetic(ch)){
                str.append(Character.toLowerCase(ch));
            }
            else if(Character.isDigit(ch)){
                str.append(ch);
            }
        }

        var start = 0;
        var end = str.length()-1;

        while(start < str.length()/2){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
