package com.brianprojects.Leetcode.Algo.Array.Implementations.Sorting;

public class QuickSort {
    public static void sort(int[] array){
        sort(array, 0, array.length-1);
    }
    private static void sort(int[] array, int start, int end){
        if(start >=end){
            return;
        }
        var boundary = partition(array, start, end);

        sort(array, start, boundary-1);
        sort(array, boundary+1, end);

    }
    private static int partition(int[] array, int start, int end ){
        var pivot = array[end];
        var boundary = start -1;
        for(var i = start; i<=end; i++){
            if(array[i] <= pivot){
                boundary++;
                var temp = array[i];
                array[i] = array[boundary];
                array[boundary] = temp;
            }
        }
        return boundary;
    }
}
