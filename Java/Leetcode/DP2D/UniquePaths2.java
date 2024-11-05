package com.brianprojects.Leetcode.DP2D;

public class UniquePaths2 {
    //Time Complexity: O(n^2) || Space Complexity: O(n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[row-1][col-1] !=0){return 0;}
        int[][] paths = new int[row+1][col+1];
        paths[row-1][col-1] = 1;
        for(int r = row-1; r>=0; r--){
            for(int c = col-1; c>=0; c--){
                if(r == row-1 && c == col-1 || obstacleGrid[r][c] == 1){continue;}
                paths[r][c] = paths[r][c] + paths[r+1][c] +paths[r][c+1];
            }
        }
        return paths[0][0];
    }
}
