package com.brianprojects.Leetcode.Array;

public class ConcatOfArray {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int[] getConcatenation(int[] nums){

        if(nums == null || nums.length ==0){return new int[0];}
        int n = nums.length*2;
        int[] res = new int[n];

        for(int i = 0; i<nums.length; i++){
            res[i] = nums[i];
            res[i+nums.length] = nums[i];
        }
        return res;
    }
}
