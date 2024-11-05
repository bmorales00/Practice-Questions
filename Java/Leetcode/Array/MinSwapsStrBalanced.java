package com.brianprojects.Leetcode.Array;

public class MinSwapsStrBalanced {

    //Time Complexity: O(n) || Space Complexity: O(1)
    public int minSwaps(String s){
        if(s== null){return 0;}
        int extra = 0;
        int swaps = 0;
        int j = s.length()-1;
        for(int i = 0; i<s.length(); i++){
            extra = s.charAt(i) == '[' ? extra+1:extra-1;
            if(extra <0){
                while(j > i){
                    if(s.charAt(j) == '['){
                        j--;
                        swaps++;
                        extra =1;
                        break;
                    }
                    j--;
                }
            }

        }
        return swaps;
    }
    public int minSwaps2(String s){
        if(s == null){return 0;}
        int close = 0;
        int max = 0;
        for(int i = 0; i<s.length();i++){
            close = s.charAt(i)=='['? close-1:close+1;
            max=Math.max(max,close);
        }
        return (max+1)/2;
    }
}
