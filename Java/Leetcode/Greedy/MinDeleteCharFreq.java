package com.brianprojects.Leetcode.Greedy;

public class MinDeleteCharFreq {
    //Time Complexity: O(26*n) || Space Complexity: O(n)
    public int minDeletions(String s){
        if(s == null){return -1;}
        boolean[] count = new boolean[100001];
        int[] chars = new int[26];
        int min = 0;
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }
        for(int i = 0; i<chars.length; i++){
            if(chars[i] ==0){continue;}
            int val = chars[i];
            while(count[val] && val != 0){
                val--;
                min++;
            }
            count[val] = true;
        }
        return min;
    }
}
