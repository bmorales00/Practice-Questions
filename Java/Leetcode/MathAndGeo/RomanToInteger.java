package com.brianprojects.Leetcode.MathAndGeo;

import java.util.HashMap;

public class RomanToInteger {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int romanToInteger(String s){
        if(s == null || s.length() ==0){return -1;}
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);map.put('X', 10);
        map.put('L', 50);map.put('C', 100);map.put('D', 500);map.put('M', 1000);
        int p1 = 0;
        int total = 0;
        while(p1 < s.length()){
            if(p1+1 <s.length() && map.get(s.charAt(p1+1)) > map.get(s.charAt(p1))){
                total+=map.get(s.charAt(p1+1)) - map.get(s.charAt(p1));
                p1++;
            }
            else{
                total+=map.get(s.charAt(p1));
            }
            p1++;
        }
        return total;
    }
}
