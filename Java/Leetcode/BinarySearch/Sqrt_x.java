package com.brianprojects.Leetcode.BinarySearch;

public class Sqrt_x {
    //Time Complexity:O(log n) || Space Complexity: O(1)
    public int mySqrt(int x){
        long start = 0;
        long end  = x;

        while(start<end){
            long mid = start+((end-start)/2);
            if(mid*mid == x){return (int)mid;}
            if(mid*mid>x){end = mid-1;}
            else{start = mid+1;}
        }
        return start*start>x?(int)start-1:(int)start;
    }
}
