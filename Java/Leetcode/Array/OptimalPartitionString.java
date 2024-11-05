package com.brianprojects.Leetcode.Array;

public class OptimalPartitionString {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int partitionString(String s){
        if(s == null){return 0;}

        boolean[] charBank = new boolean[26];
        int r = 0;
        int min = 0;

        while(r<s.length()){
            if(charBank[s.charAt(r) - 'a']){
                min++;
                charBank = new boolean[26];
            }
            else{
                charBank[s.charAt(r) - 'a'] = true;
                r++;
            }
        }
        for(boolean bool:charBank){
            if(bool){
                min++;
                break;
            }
        }
        return min;
    }
}
