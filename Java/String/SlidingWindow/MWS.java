package com.brianprojects.LeetQues75.String.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MWS {
    //Minimum Window SubString
    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
    every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
    The testcases will be generated such that the answer is unique.
    A substring is a contiguous sequence of characters within the string.
     */
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        String res = "";
        int need = t.length();
        int have = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for(var ch: t.toCharArray()){
            if(!(tMap.containsKey(ch) && sMap.containsKey(ch))){
                tMap.put(ch, 1);
                sMap.put(ch, 0);
            }
            else{
                tMap.put(ch, tMap.get(ch)+1);
            }
        }
        while(end< s.length()){

            if(sMap.containsKey(s.charAt(end))){
                sMap.replace(s.charAt(end), sMap.get(s.charAt(end)), sMap.get(s.charAt(end))+1);
                have = sMap.get(s.charAt(end)) <= tMap.get(s.charAt(end))? have+1: have;
            }

            if(have >= need && end+1-start <= minLength){
                minLength = end+1 - start;
                res = s.substring(start, end+1);
            }
            while(have == need){
                if(end+1-start <= minLength){
                    minLength = end+1 - start;
                    res = s.substring(start, end+1);
                }
                if(sMap.containsKey(s.charAt(start))){
                    sMap.replace(s.charAt(start), sMap.get(s.charAt(start)), sMap.get(s.charAt(start))-1);
                    have = sMap.get(s.charAt(start)) < tMap.get(s.charAt(start))? have-1: have;
                }

                start++;
            }
            end++;
        }

        return res;
    }
}

