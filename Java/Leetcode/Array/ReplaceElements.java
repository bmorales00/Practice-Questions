package com.brianprojects.Leetcode.Array;

public class ReplaceElements {
    // Space Complexity: O(n) || Time Complexity: O(n^2)
    public int[] replaceElemets(int[] arr){
        if(arr == null){
            return new int[0];
        }

        int[] arr1 = new int[arr.length];
        arr1[arr1.length-1] = -1;
        int max = findMax(1, arr);

        for(var i = 0; i<arr.length-1; i++){
            if(max == i){
                max = findMax(i+1, arr);
            }
            arr1[i] = arr[max];
        }
        return arr1;
    }
    private int findMax(int x, int[] arr) {
        int max = x;
        for(var i = x+1; i<arr.length; i++ ){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }


}
