package com.brianprojects.Leetcode.Graphs;

public class IslandPerimeter {

    //Time Complexity: O(rc) || Space Complexity: O(1)
    public int islandPerimeter(int[][] grid){
        if(grid == null){return 0;}
        int r = grid.length;
        int c = grid[0].length;
        int sum =0;

        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] != 0){
                    sum = dfs(grid, i,j);
                    return sum;
                }
            }
        }
        return sum;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r<0 || c<0||r>=grid.length || c>=grid[0].length ||grid[r][c] == 0){return 1;}
        if(grid[r][c] == -1){return 0;}
        grid[r][c] = -1;
        int sum = 0;
        sum+=dfs(grid, r-1,c);//up
        sum+=dfs(grid,r+1,c);//down
        sum+=dfs(grid,r,c-1);//left
        sum+=dfs(grid,r,c+1);//right

        return sum;
    }

    public int islandPerimeter2(int[][] grid){
        int rows = grid.length, cols = grid[0].length;
        int res = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 1) continue;

                res += 4;
                if (r > 0 && grid[r - 1][c] == 1) res -= 2; // look up
                if (c > 0 && grid[r][c - 1] == 1) res -= 2; // look left
            }
        }
        return res;
    }
}
