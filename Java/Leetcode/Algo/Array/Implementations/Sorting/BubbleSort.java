package com.brianprojects.Leetcode.Algo.Array.Implementations.Sorting;

public class BubbleSort {
    //Time Complexity: O(n^2)
    //Space Complexity:O(1)
    public static void bubbleSort(int[] arr){
        if(arr == null){return;}
        for(int i = 0; i<arr.length-1; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] <= arr[i]){
                    var temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
