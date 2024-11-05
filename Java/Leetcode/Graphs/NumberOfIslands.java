package com.brianprojects.Leetcode.Graphs;

public class NumberOfIslands {
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number
     of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
     */

    // The runtime complexity is linear time : O(VE) V being the vertex or rows, and E being the edges of the graph or
    //columns.
    //Space Complexity: O(1)
    public int numIslands(char[][] grid) {
        int m = grid.length; //mxn or 4x5 and m would equal to 4
        int numOfIslands = 0;

        for(var i = 0; i<m; i++) {
            for(var w = 0; w<grid[i].length; w++){
                if(grid[i][w] == '1'){
                    dfs(grid, i, w);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    private void dfs(char[][] grid, int i, int w) {

        if(i < 0 || i >=grid.length || w < 0|| w>=grid[i].length || grid[i][w] != '1'){
            return;
        }
        if(grid[i][w] == '1'){
            grid[i][w] = '0';
        }
        dfs(grid, i-1, w);
        dfs(grid, i+1, w);
        dfs(grid, i, w-1);
        dfs(grid,i, w+1);

    }
}
