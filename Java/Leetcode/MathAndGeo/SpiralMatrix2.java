package com.brianprojects.Leetcode.MathAndGeo;

public class SpiralMatrix2 {
    //Time Complexity: O(m*n) || Space Complexity: O(m*n)
    public int[][] generateMatrix(int n){
        if(n <= 0 ){return  new int[0][0];}
        int[][] matrix = new int[n][n];

        dfs(matrix, 0 , 0, 1 );

        return matrix;

    }

    private void dfs(int[][] matrix, int m, int n, int prev) {
        if(m >= matrix.length || m<0 || n<0 || n>= matrix.length || matrix[m][n] !=0){
            return;
        }
        matrix[m][n] = prev;
        if(m>0 && matrix[m-1][n] == 0 && matrix[m][n+1] == 0){
            dfs(matrix, m-1,n,prev+1);
        }
        dfs(matrix, m,n+1,prev+1);
        dfs(matrix, m+1,n,prev+1);
        dfs(matrix, m,n-1,prev+1);
        dfs(matrix, m-1,n,prev+1);
    }
}
