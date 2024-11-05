package com.brianprojects.Leetcode.Graphs;

public class ClosedIslands {
    //Time Complexity: O(v*e) || Space Complexity:O(1)
    public int ClosedIsland(int[][] grid){
        if(grid == null){return 0;}

        int r = grid.length;
        int c = grid[0].length;
        int num = 0;

        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == 0 && isClosedIsland(grid,i,j)){
                    num++;
                }
            }
        }
        return num;
    }

    private boolean isClosedIsland(int[][] grid, int r, int c) {
        if(r>=grid.length || r<0 || c>=grid[r].length || c<0){return false;}
        if(grid[r][c] == 1){return true;}
        grid[r][c] = 1;
        if(isClosedIsland(grid,r-1,c) && isClosedIsland(grid,r+1,c)
                && isClosedIsland(grid,r,c-1) && isClosedIsland(grid,r,c+1)){
            return true;
        }
        else{
            grid[r][c] = 0;
            return false;
        }
    }
}
