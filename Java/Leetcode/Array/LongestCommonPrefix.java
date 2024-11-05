package com.brianprojects.Leetcode.Array;

public class LongestCommonPrefix {
    //SPace Complexity: O(n)  | Time Complexity: O(n)
    public String longestCommonPrefix(String[] strs){
        if(strs == null){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }
        var smallestString = 0;
        for(var i = 1; i<strs.length; i++){
            smallestString = strs[i].length() < strs[smallestString].length()?i:smallestString;
        }
        StringBuilder prefix = new StringBuilder(strs[smallestString]);
        int i = 0;

        while( i < prefix.length()){
            for(var str : strs){
                if(str.charAt(i) != prefix.charAt(i)){
                    prefix.delete(i, prefix.length());
                    return prefix.toString();
                }
            }
            i++;
        }

        return prefix.toString();
    }
}
