package com.brianprojects.Leetcode.MathAndGeo;

public class RotateImage {
    //Time Complexity: O(n^2) || Space Complexity: O(1)
    public void rotate(int[][] matrix){
        if(matrix == null){return;}
        int n = matrix.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
/*
Transpose:
         1 4 7
         2 5 8
         3 6 9

and then swap the first and last index of each row to get the result:

 Result:
             7  4  1
             8  5  2
             9  6  3
 */