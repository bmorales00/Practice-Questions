package com.brianprojects.Leetcode.SlidingWindow;

public class Threshold {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int numOfSubarrays(int[] arr, int k, int threshold){
        if(k>arr.length){return 0;}
        int numOfSub = 0;
        int total = 0;
        for(int i = 0; i<k; i++){
            total+=arr[i];
        }
        if(total/k >= threshold){numOfSub++;}

        for(int i = k; i<arr.length; i++){
            total-=arr[i-k];
            total+=arr[i];
            if(total/k>=threshold){numOfSub++;}
        }

        return numOfSub;
    }
}
