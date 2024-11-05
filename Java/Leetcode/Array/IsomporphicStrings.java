package com.brianprojects.Leetcode.Array;

public class IsomporphicStrings {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public boolean isIsomporphic(String s, String t){
        if(s.length() != t.length()){return false;}
        int[] word1 = new int[26];
        int[] word2 = new int[26];


        for(int i = 0; i < s.length(); i++){
            if(word1[s.charAt(i)- 'a'] != word2[t.charAt(i)- 'a']) return false;
            word1[s.charAt(i) - 'a'] = i+1;
            word2[t.charAt(i) -'a'] = i+1;
        }
        return true;
    }
}
