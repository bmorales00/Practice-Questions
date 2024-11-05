package com.brianprojects.LeetQues75.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidAnagram {
    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters
    of a different word or phrase, typically using all the original letters exactly once.
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(var ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }
            else{
                map.put(ch, map.get(ch)+1);
            }
        }
        for(var ch:t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }

            if(map.containsKey(ch) && map.get(ch) != 0){
                map.replace(ch, map.get(ch), map.get(ch)-1);
            }
            else{
                map.replace(ch, map.get(ch), map.get(ch)+1);
            }
        }

        for(var v: map.values()){
            if(v != 0){
                return false;
            }
        }

        return true;
    }
}
//        while(pointer < s.length()){
//            if(!set.contains(s.charAt(pointer))){
//                set.add(s.charAt(pointer));
//            }
//            else{
//                set.remove(s.charAt(pointer));
//            }
//            if(!set.contains(t.charAt(pointer))){
//                set.add(t.charAt(pointer));
//            }
//            else {
//                set.remove(t.charAt(pointer));
//            }
//            pointer++;
//        }
//        return set.size() ==0;
