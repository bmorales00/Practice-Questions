package com.brianprojects.Leetcode.Array;

public class SortColors {
    // The Time Complexity: O(n * log n) || Space Complexity : O(1)
    public void sortColors(int[] nums){
        if(nums.length <0|| nums == null){
            return;
        }
        sort(nums, 0, nums.length-1 );
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        var boundary = partition(array, start, end);

        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (var i = start; i <= end; i++)
            if (array[i] <= pivot)
                swap(array, i, ++boundary);

        return boundary;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
