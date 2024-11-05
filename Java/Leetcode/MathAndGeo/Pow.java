package com.brianprojects.Leetcode.MathAndGeo;

public class Pow {
    //Time Complexity: O(log n) || Space Complexity : O(1)
    public double myPow(double x, int n){
        double result = 1;
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        while(n != 0) {
            if(n % 2 != 0) {
                result = x * result;
            }
            x = x*x;
            n = n / 2;
        }
        return result;
    }
}
/*
the apporach here is divide and conquer, we are essentiaally doing a bsearch through every repated work in the exponent.
 */