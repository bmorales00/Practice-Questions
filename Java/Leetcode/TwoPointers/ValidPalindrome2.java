package com.brianprojects.Leetcode.TwoPointers;

public class ValidPalindrome2 {
    //Time Complexity: O(substring of start+1 + substring of end-1 length) || Space Complexity: O(1)
    boolean used= false;
    public boolean validPalindrome(String s){
        if(s == null){
            return false;
        }
        if(s.length() == 0){
            return true;
        }

        int start = 0;
        int end = s.length()-1;

        while(start < s.length()/2){
            if(s.charAt(start) != s.charAt(end)){
                if(s.charAt(start+1) != s.charAt(end) && s.charAt(start) != s.charAt(end-1)){
                    return false;
                }
                else if(!used){
                    used = true;
                    return validPalindrome(s.substring(start+1,end+1)) || validPalindrome(s.substring(start,end));
                }
                else {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }
}

/*
if(str.charAt(start+1) == str.charAt(end)){
                    start++;
                    one++;

                }
                if(str.charAt(start) == str.charAt(end-1)){
                    end--;
                    one++;
                }
 */
//if(str.charAt(start) != str.charAt(end) && (start+1 != mid && end!= mid) || str.charAt(start+1) != str.charAt(start) || str.charAt(start+1) != str.charAt(end)){