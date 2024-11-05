package com.brianprojects.Leetcode.DP2D;

public class MonotoneIncreasing {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int minFlipMonoIncr(String s){
        if(s == null){return 0;}
        int zeroes = 0;
        int ones = 0;
        for(char ch:s.toCharArray()){
            if(ch == '0'){
                zeroes++;
            }
        }
        int min = zeroes;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '0'){zeroes--;}
            else{ones++;}
            min = Math.min(min, zeroes+ones);
        }
        return min;
    }
    public int minFlipMonoIncr2(String s){
        if(s== null){return 0;}
        int flips = 0;
        int ones = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
            else{
                flips = Math.min(flips+1, ones);
            }
        }
        return flips;
    }
}
