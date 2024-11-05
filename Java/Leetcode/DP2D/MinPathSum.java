package com.brianprojects.Leetcode.DP2D;

//Time Complexity: O(mxn) | Space Complexity : O(mxn)
public class MinPathSum {
    public int minPathSum(int[][] grid){
        if(grid == null){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r+1][c+1];

        for(var row = 0; row<r;row++){
            for(var col = 0; col<c; col++){
                dp[row][col] += grid[row][col];
                dp[row][col+1] = dp[row][col+1] == 0 ? dp[row][col] : Math.min(dp[row][col], dp[row][col+1]);
                dp[row+1][col] = dp[row+1][col] == 0 ? dp[row][col] : Math.min(dp[row][col], dp[row+1][col]);
            }
        }
        return dp[r-1][c-1];
    }
}
