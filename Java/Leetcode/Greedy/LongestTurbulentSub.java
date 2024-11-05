package com.brianprojects.Leetcode.Greedy;

public class LongestTurbulentSub {

    //Time Complexity: O(n) || Space Complexity: O(1)
    public int maxTurbulenceSize(int[] arr){
        if(arr == null){return -1;}
        if(arr.length == 1){return 1;}
        int max = Integer.MIN_VALUE;
        int case1 = 0;
        int case2 = 0;

        for(int i = 0; i<arr.length-1; i++){
            if(i%2==0){
                case1 = arr[i]<arr[i+1]?case1+1:0;
                case2 = arr[i]>arr[i+1]?case2+1:0;
            }
            else{
                case1 = arr[i] >arr[i+1]?case1+1:0;
                case2 = arr[i]<arr[i+1]?case2+1:0;
            }
            max = Math.max(max,Math.max(case1,case2));
        }
        return max+1;
    }
}
