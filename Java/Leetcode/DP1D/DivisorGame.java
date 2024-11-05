package com.brianprojects.Leetcode.DP1D;

public class DivisorGame {
    //Time Complexity: O(1) || Space ComplexityL O(1)
    public boolean divisorGame(int n){
        if(n <= 1){return false;}
        return n % 2 == 0;
    }
}
