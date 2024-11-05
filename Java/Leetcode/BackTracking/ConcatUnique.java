package com.brianprojects.Leetcode.BackTracking;

import java.util.HashSet;
import java.util.List;

public class ConcatUnique {
    //Time Complexity O(n*w) || Space Complexity: O(n)
    int max = 0;
    public int maxLength(List<String> arr){
        if(arr == null){return 0;}
        for(int i = 0; i<arr.size(); i++){
            backtrack(arr, i, new HashSet<>());
        }
        return max;
    }

    private void backtrack(List<String> arr, int start, HashSet<Character> set) {
        if(start>=arr.size()){return;}

        String w = arr.get(start);
        for(int j = 0; j<w.length(); j++){
            if(set.contains(w.charAt(j))){removeChar(j,w,set); return;}
            set.add(w.charAt(j));
        }
        max = Math.max(max, set.size());
        for(int i = start; i<arr.size(); i++){
            backtrack(arr,i+1, set);
        }
        removeChar(w.length(), w, set);
    }

    private void removeChar(int j, String w, HashSet<Character> set) {
        for(int i = 0; i<j; i++){
            set.remove(w.charAt(i));
        }
    }


}
