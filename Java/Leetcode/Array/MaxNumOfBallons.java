package com.brianprojects.Leetcode.Array;

public class MaxNumOfBallons {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int maxNumberOfBallons(String text){
        if(text.length() <=0){
            return 0;
        }
        var word = "balon";
        int[] arr = new int[26];
        int nums = Integer.MAX_VALUE;
        for(var ch:text.toCharArray()){
            arr[ch-'a']++;
        }
        for(var ch: word.toCharArray()){
            if(arr[ch - 'a'] == 0 ){
                return 0;
            }

            nums = ch=='o' || ch=='l' ?Math.min(nums,arr[ch-'a']/2): Math.min(nums,arr[ch-'a']/1);
        }
        return nums;
    }
}
