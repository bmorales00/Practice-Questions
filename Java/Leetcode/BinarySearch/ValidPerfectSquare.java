package com.brianprojects.Leetcode.BinarySearch;

public class ValidPerfectSquare {
    //Time Complexity: O(log n) || Space Complexity: O(1)
    public boolean isPerfectSquare(int num){
        if(num == 0){return false;}
        if(num == 1){return true;}
        if(num == Integer.MAX_VALUE || num == Integer.MAX_VALUE-1){
            return  false;
        }
        long start = 0;
        long end = num-1;

        while(start<=end){
            long mid = (start+end)/2;
            long res = mid*mid;
            if(res == num){
                return true;
            }
            if(res < num){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}
