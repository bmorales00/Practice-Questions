package com.brianprojects.Leetcode.SlidingWindow;

public class MaxNumVowelsSubStr {

    //Time Complexity: O(n) || Space Complexity: O(1)
    public int maxVowels(String s, int k){
        if(s == null){return 0;}
        int max = 0;
        int sum  =0;
        int[] letters = new int[26];
        letters['a'-'a']++;letters['e'-'a']++;letters['i'-'a']++;
        letters['o'-'a']++;letters['u'-'a']++;
        for(int i = 0; i<k;i++){
            sum+=letters[s.charAt(i)-'a'];
        }
        max=Math.max(sum,max);
        for(int i = k; i<s.length();i++){
            sum-=letters[s.charAt(i-k)-'a'];
            sum+=letters[s.charAt(i)-'a'];
            max=Math.max(max,sum);
        }
        return max;
    }
    public int maxVowels2(String s, int k){
        if(s == null){return 0;}
        int max = 0;
        int sum  =0;
        for(int i = 0; i<k;i++){
            sum+=isVowel(s.charAt(i))?1:0;
        }
        max=Math.max(sum,max);
        for(int i = k; i<s.length();i++){
            sum-=isVowel(s.charAt(i-k))?1:0;
            sum+=isVowel(s.charAt(i))?1:0;
            max=Math.max(max,sum);
        }
        return max;
    }
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u';
    }
}
