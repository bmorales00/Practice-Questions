package com.brianprojects.Leetcode.Algo.Array.Implementations.Searching;

public class BinarySearch {
    //Time Complexity: O(log n)
    //Space Complexity: O(n)
    public static int binarySearch(int[] arr, int target){
        if(arr == null){return -1;}

        int start = 0;
        int end = arr.length;
        while(start <= end){
            int mid = (end+start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
