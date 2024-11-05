package com.brianprojects.Leetcode.Array;

public class CountingSort {
    public void countingSort(int[] arr){
        int max = 0;
        for(int val : arr){
            max=Math.max(max,val);
        }
        int[] arr2 = new int[max+1];
        for(int val: arr){
            arr2[val]++;
        }
        int index = 0;
        for(int i = 0; i<arr2.length; i++){
            for(int j = 0; j<arr2[i]; j++){
                arr[index++] = i;
            }
        }
    }
}
