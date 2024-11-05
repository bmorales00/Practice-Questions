package com.brianprojects.Leetcode.Array;

public class FindIndexFirstOcc {
    //Time Complexity: O(n*m) || Space Complexity: O(1)
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){return -1;}
        if(needle.equals(haystack)){return 0;}
        int n = needle.length();
        int m = haystack.length();

        for(int i = 0; i<=m-n; i++){
            if(haystack.charAt(i) != needle.charAt(0)){continue;}
            if(i+n<=haystack.length() && haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
