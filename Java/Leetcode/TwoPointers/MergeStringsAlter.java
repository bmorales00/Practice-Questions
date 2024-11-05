package com.brianprojects.Leetcode.TwoPointers;

public class MergeStringsAlter {
    //Time Complexity: O(n) || Space Complexity:O(n)
    public String mergeAlternately(String word1, String word2) {
        if(word1== null || word2 == null){return "";}
        int i = 0;
        int j = 0;

        int w1 = word1.length();
        int w2 = word2.length();
        StringBuilder res = new StringBuilder();
        while(i< w1 && j < w2){
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        while(i<w1){
            res.append(word1.charAt(i++));
        }
        while(j<w2){
            res.append(word2.charAt(j++));
        }

        return res.toString();
    }
}
