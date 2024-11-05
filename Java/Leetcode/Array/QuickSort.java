package com.brianprojects.Leetcode.Array;

public class QuickSort {
    public void sort(int[] array){
        sort(array, 0, array.length-1);
    }
    private void sort(int[] array, int start, int end){
        if(start >=end){
            return;
        }
        var boundary = partition(array, start, end);

        sort(array, start, boundary-1);
        sort(array, boundary+1, end);

    }
    //DIFFERENT IMPLEMENTATION APART FROM SORTING, THIS WILL HELP FIND THE PARTITIONER BOUNDARY
    private int partition(int[] array, int start, int end ){
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
