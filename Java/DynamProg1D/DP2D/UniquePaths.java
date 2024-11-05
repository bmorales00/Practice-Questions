package com.brianprojects.LeetQues75.DynamProg1D.DP2D;

public class UniquePaths {
    public static int uniquePaths(int m, int n){
        int[][] path = new int[m+1][n+1];
        path[m-1][n-1] = 1;
        for(var r = m-1; r>=0; r--){
            for(var c =  n-1; c>=0;c--){
                path[r][c] = path[r][c] +path[r+1][c]+path[r][c+1];
            }
        }
        return path[0][0];
    }
}
