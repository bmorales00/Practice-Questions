package com.brianprojects.Leetcode.Algo.Array.Implementations.Sorting;

public class MergeSort {
    //O(n log*n) Time Complexity
    //O(n) Space Complexity
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length == 1){return;}
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right  = new int[arr.length-mid];
        for(int i = 0; i<left.length;i++){
            left[i] =  arr[i];
        }
        for(int i = 0; i<right.length; i++){
            right[i] = arr[i+mid];
        }
        mergeSort(left);
        mergeSort(right);
        sort(left, right, arr);
    }

    private static void sort(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int z = 0;
        while(i< left.length && j <right.length && z <arr.length){
            if(left[i] <= right[j]){
                arr[z++] = left[i++];
            }
            else{
                arr[z++] = right[j++];
            }

        }
        while(i<left.length && z<arr.length){
            arr[z++] = left[i++];
        }
        while(j<right.length && z<arr.length){
            arr[z++] = right[j++];
        }
    }
}
