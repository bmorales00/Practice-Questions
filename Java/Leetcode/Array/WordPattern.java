package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class WordPattern {
    //Time Complexity: O(s) || Space Complexity: O(p)
    public boolean wordPattern(String pattern, String s){
        var strList = s.split(" ");
        if(s.length() <=0 || pattern.length() <=0 || strList.length != pattern.length()){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for(var i = 0; i<strList.length; i++){
            if(!map.containsKey(pattern.charAt(i)) && map.containsValue(strList[i])){
                return false;
            }
            else if(map.containsKey(pattern.charAt(i)) &&  !map.get(pattern.charAt(i)).equals(strList[i])){
                return false;
            }
            map.put(pattern.charAt(i), strList[i]);
        }

        return true;
    }
}
