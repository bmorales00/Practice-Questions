package com.brianprojects.Leetcode.Algo.Array.Implementations.Searching;

public class LinearSearch {
    //O(n) Time Complexity
    //O(1) Space Complexity
    public static int LinearSearch(int[] arr, int x){
        if(arr == null){return -1;}
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x){return i;}
        }
        return -1;
    }
}
