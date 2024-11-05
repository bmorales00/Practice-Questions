package com.brianprojects.Leetcode.Array;

public class RangeSumQuery2D {

    private int[][] prefix;
    public RangeSumQuery2D(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.prefix = new int[n+1][m+1];
        fill(matrix, this.prefix,n,m);
    }

    //Time Complexity: O(n*m) || Space Complexity: O(n*m)
    private void fill(int[][] matrix, int[][] prefix, int n, int m) {
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1]+matrix[i-1][j-1]-prefix[i-1][j-1];
            }
        }
    }

    //Time Complexity:O(1) || Space Complexity: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2){
        int sum = this.prefix[row2+1][col2+1];
        int top = this.prefix[row1][col2+1];
        int left = this.prefix[row2+1][col1];
        int remainder =this.prefix[row1][col1];
        return (sum-top-left)+remainder;
    }
}
