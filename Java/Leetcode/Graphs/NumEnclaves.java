package com.brianprojects.Leetcode.Graphs;

public class NumEnclaves {
    //Time Complexity: O(VE) || Space Complexity: O(1)
    public int numEnclaves(int[][] grid){
        if(grid == null){return 0;}
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i = 0; i<m; i++){
            if(i==0 || i == m-1){
                for(int j = 0; j<n;j++){
                    if(grid[i][j] == 1){
                        dfs(grid, i, j);
                    }
                }
            }
            else{
                if(grid[i][0] == 1){dfs(grid,i,0);}
                if(grid[i][n-1] == 1){dfs(grid,i,n-1);}
            }

        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 1){res++;}
            }
        }
        return res;
    }


    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>grid[0].length || grid[i][j] ==0){return;}
        grid[i][j] = 0;
        dfs(grid, i+1, j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
