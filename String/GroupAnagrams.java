package com.brianprojects.LeetQues75.String;

import java.util.*;

public class GroupAnagrams {
    /*
    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different
    word or phrase, typically using all the original letters exactly once.
     */
    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for(var word: strs){
            char[] count = new char[26];
            for(var ch: word.toCharArray()){
                count[ch-97]++;
            }
            String key = String.valueOf(count);
            if(map.containsKey(key)){
                map.get(key).add(word);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        return new ArrayList<>(map.values());
    }
}
