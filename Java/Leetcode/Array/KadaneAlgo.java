package com.brianprojects.Leetcode.Array;

public class KadaneAlgo {
    public int maxSubArray(int[] arr){
        int finalMax = arr[0];
        int currentMax  = arr[0];

        for(int i = 1; i<arr.length; i++){
            currentMax = Math.max(arr[i], currentMax+arr[i]);
            finalMax = Math.max(finalMax, currentMax);
        }
        return finalMax;
    }
}
