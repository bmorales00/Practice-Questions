package com.brianprojects.Leetcode.TwoPointers;

public class ReverseString {
    public void reverseString(char[] s){
        if(s.length <0 || s == null){
            return;
        }

        for(var i = 0; i<s.length/2; i++){
            var temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}
