package com.brianprojects.Leetcode.BitManipulation;

public class CountingBits {
    /*
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    ans[i] is the number of 1's in the binary representation of i.
     */

    public int[] countBits(int num){ // n = 4
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++){
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}
