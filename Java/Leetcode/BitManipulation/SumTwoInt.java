package com.brianprojects.Leetcode.BitManipulation;

public class SumTwoInt {
    public int getSum(int a, int b){ // a= 1, b == 2
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
