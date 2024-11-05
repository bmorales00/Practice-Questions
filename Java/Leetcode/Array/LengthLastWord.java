package com.brianprojects.Leetcode.Array;

public class LengthLastWord {
    // Space Complexity: O(1) | Time Complexity: O(n)
    public int lengthOfLastWord(String s){
        if(s == null){
            return 0;
        }
        int count = 0;
        for(var i = s.length()-1; i>=0; i--){
            if(Character.isSpaceChar(s.charAt(i)) && count ==0){
                continue;
            }
            if(Character.isSpaceChar(s.charAt(i)) && count !=0){
                break;
            }
            count++;
        }

        return count;
    }
}
