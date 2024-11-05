package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAna {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<Integer> findAnagrams(String s, String p){
        if(s.length()== 0 || p.length()== 0|| p.length() > s.length()) return new ArrayList<>();
        int[] word = new int[26];
        int[] ana = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i =0 ; i<p.length(); i++){
            word[p.charAt(i) - 'a']++;
            ana[s.charAt(i) - 'a']++;
        }

        for(int i= 0; i<=s.length()-p.length(); i++){
            if(Arrays.equals(word,ana)){res.add(i);}
            if(i+p.length() < s.length()){
                ana[s.charAt(i) - 'a']--;
                ana[s.charAt(i+p.length()) - 'a']++;
            }
        }
        return res;
    }
}
