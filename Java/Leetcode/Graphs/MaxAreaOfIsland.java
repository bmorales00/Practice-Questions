package com.brianprojects.Leetcode.Graphs;

// Time Complexity: O(v*e) | Space Complexity is O(1)
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid){
        if(grid.length == 0){
            return 0;
        }

        int maxArea = 0;
        int row = grid.length;
        int col  = grid[0].length;

        for(int r = 0; r<row; r++){
            for(int c = 0; c<col;c++){
                if(grid[r][c] != 0){
                    maxArea = Math.max(maxArea,dfs(grid, r,c));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r<0 || r>=grid.length || c<0 || c>grid[r].length){
            return 0;
        }
        if(grid[r][c]==0){
            return 0;
        }

        grid[r][c] = 0;
        return dfs(grid, r-1, c) +dfs(grid, r+1, c)
        +dfs(grid, r, c-1) +  dfs(grid, r, c+1) +1;
    }
}
