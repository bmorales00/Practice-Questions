package com.brianprojects.Leetcode.Graphs;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountSubIslands {
    //Time Complexity: O(m*n) || Space Complexity: O(1)
    public int countSubIslands(int[][] grid1, int[][] grid2){
        if(grid1.length != grid2.length ){return -1;}

        int count = 0;
        int r = grid1.length;
        int c = grid1[0].length;


        for(int i = 0; i<r; i++){
            for(int j =0; j<c;j++){
                if(grid1[i][j] == 1 && grid2[i][j] == 1 &&dfs(grid1,grid2,i,j, new HashSet<>())){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c, HashSet<List<Integer>> visited) {
        if(r <0 || r>=grid1.length || c<0 || c >=grid1[0].length){return true;}
        List<Integer> cord = new ArrayList<>(List.of(r,c));
        if(grid1[r][c] == 0 && grid2[r][c] == 0 || grid1[r][c] == 1 && grid2[r][c] == 0 || visited.contains(cord)){return true;}
        if(grid1[r][c] == 0 && grid2[r][c] == 1){return false;}
        visited.add(List.of(r,c));
        grid1[r][c] = 0;
        return  dfs(grid1,grid2,r-1,c, visited)&&
                dfs(grid1,grid2,r+1,c,visited)&&
                dfs(grid1,grid2, r,c-1,visited)&&
                dfs(grid1,grid2,r,c+1,visited);
    }
    /*
    boolean subIsland;
    int[][] grid1;
    int[][] grid2;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    subIsland = true;
                    flood(i, j);
                    if (subIsland) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void flood(int i, int j) {
        if (subIsland && grid1[i][j] == 0) {
            subIsland = false;
        }
        grid2[i][j] = 0;
        if (j > 0 && grid2[i][j - 1] == 1) { flood(i, j - 1); }
        if (i > 0 && grid2[i - 1][j] == 1) { flood(i - 1, j); }
        if (j < grid2[0].length - 1 && grid2[i][j + 1] == 1) { flood(i, j + 1); }
        if (i < grid2.length - 1 && grid2[i + 1][j] == 1) { flood(i + 1, j); }
    }
     */
}
