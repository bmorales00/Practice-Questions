package com.brianprojects.Leetcode.Algo.Array.Implementations.Sorting;

public class CountingSort {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int[] countingSort(int[] arr){
        if(arr == null){return null;}
        int max = Integer.MIN_VALUE;
        for(int val: arr){
            max = Math.max(max, val);
        }
        int[] temp = new int[max+1];
        for(int val: arr){
            temp[val]++;
        }
        for(int i = 1; i<temp.length; i++){
            temp[i]+=temp[i-1];
        }
        int[] res = new int[arr.length];
        for(int i = res.length-1; i>=0; i--){
            res[temp[arr[i]]-1] = arr[i];
            temp[arr[i]]--;
        }
        return res;
    }
}
