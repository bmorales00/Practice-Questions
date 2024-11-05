package com.brianprojects.Leetcode.MathAndGeo;

public class MatrixDiagonalSum {
    //Time Complexity:O(n) || Space Complexity:O(1)
    public int diagonalSum(int[][] mat){
        if(mat == null){return -1;}
        int l = 0;
        int r = mat.length-1;
        int sum  = 0;

        for (int[] m : mat) {
            sum+= l==r? m[l]:m[l]+m[r];
            l++;
            r--;
        }
        return sum;
    }
}
