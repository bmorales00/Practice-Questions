package com.brianprojects.Leetcode.Array;

public class MinPenalty {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int bestClosingTime(String customers){
        if(customers == null){return -1;}
        int[] prefix = new int[customers.length()+1];
        int[] postfix = new int[customers.length()+1];
        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 1; i<prefix.length; i++){
            prefix[i] = customers.charAt(i-1) == 'N'?prefix[i-1]+1:prefix[i-1];
        }
        for(int i = postfix.length-2; i>=0; i--){
            postfix[i] = customers.charAt(i) == 'Y'?postfix[i+1]+1:postfix[i+1];
        }
        for(int i = 0; i<prefix.length; i++){
            if(postfix[i]+prefix[i] < min){
                min = postfix[i]+prefix[i];
                index = i;
            }
        }
        return index;
    }
}
