package com.brianprojects.Leetcode.BinarySearch;

public class ArrangingCoins {
    public int arrangeCoins(int n){
        if(n <= 0 ){
            return 0;
        }

        int count = 0;
        int ith = 1;
        int leftOver = n;

        while(leftOver >= ith){
            leftOver -= ith++;
            count++;
        }
        return count;
    }
}
