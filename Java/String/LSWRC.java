package com.brianprojects.LeetQues75.String;

import java.util.HashMap;
import java.util.HashSet;

public class LSWRC {
    /*
    Given a string s, find the length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxSub = 0;
        int l = 0;
        int r = 0;
        while(r<s.length()){
            if(map.containsKey(s.charAt(r)) && s.charAt(r) != s.charAt(l)){
                l = map.get(s.charAt(r)) +1;
                var temp = l;
                map.clear();
                while(temp<r){
                    map.put(s.charAt(temp),temp++);
                }
            }
            else if(map.containsKey(s.charAt(r)) && s.charAt(r) == s.charAt(l)){
                map.remove(s.charAt(r));
                l+=1;
            }
            map.put(s.charAt(r), r);
            maxSub= Math.max(maxSub, (r-l)+1);
            r+=1;
        }

        return maxSub;
    }
}

