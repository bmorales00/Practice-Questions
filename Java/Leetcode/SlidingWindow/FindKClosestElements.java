package com.brianprojects.Leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    //Time Complexity: O(n * log n) + O(k) || Space Complexity: O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        if(arr == null || k<=0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

        int i = search(arr,0,arr.length-1,x);

        int l = i-1;
        int r = i+1;

        while(l>=0 && r< arr.length && (r-l) !=k+1){
            if(x - arr[l] <= arr[r]-x){
                l--;
            }
            else{
                r++;
            }
        }
        while(l>=0 &&(r-l) !=k+1){
            l--;
        }
        while(r<arr.length && (r-l) !=k+1){
            r++;
        }

        for(var j = l+1; j<r; j++){
            res.add(arr[j]);
        }
        return res;
    }

    private int search(int[] arr, int start, int end,int target) {
        if(end<start){
            if(end<0){
                return start;
            }
            if(start >= arr.length){
                return end;
            }
            return target-arr[end] <= arr[start]-target?end:start;
        }
        int mid = (end+start)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] < target){
            return search(arr, mid+1, end, target);
        }
        else{
            return search(arr, start, mid-1, target);
        }
    }
}

