package com.brianprojects.Leetcode.BitManipulation;

public class ShuffleArray {
    //Time Complexity: O(n) || Space Complexity:O(n)
    public int[] shuffle(int[] nums, int n){
        if(nums == null){return null;}
        int[] res = new int[nums.length];
        int i =0;
        int j = n;
        int v = 0;
        while(j<res.length){
            res[v] = nums[i++];
            res[v+1] = nums[j++];
            v+=2;
        }
        return res;
    }
}
