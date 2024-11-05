package com.brianprojects.Leetcode.Graphs;

import java.util.*;

public class ShortestBridge {
    //Time Complexity: O(n^2) || Space Complexity: O(n^2)
    public int shortestBridge(int[][] grid){
        if(grid == null){return -1;}
        int n = grid.length;
        int shortest = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        int r = 0;
        boolean islandFound = false;
        while(r<n ){
            int c = 0;
            while(c<n){
                if(grid[r][c] ==1){
                    dfs(grid, r,c, visited,dir,queue);
                    islandFound = true;
                    break;
                }
                c++;
            }
            if(islandFound){break;}
            r++;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                int[] current = queue.poll();
                for(int[] d: dir){
                    int cr = current[0] + d[0];
                    int cc = current[1] + d[1];
                    if(cr >=0 && cr<n && cc >=0 && cc<n && !visited[cr][cc]){
                        if(grid[cr][cc] ==1 && !visited[cr][cc]){return shortest;}
                        visited[cr][cc] = true;
                        queue.add(new int[]{cr,cc});
                    }
                }
                size--;
            }
            shortest++;
        }

        return shortest;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited, int[][] dir,Queue<int[]> queue) {
        if(r<0 ||c <0 ||r>=grid.length || c>=grid.length){return;}
        if(visited[r][c] || grid[r][c] !=1){return;}
        visited[r][c] = true;
        queue.add(new int[]{r,c});
        for(int[] d : dir){
            dfs(grid,r+d[0], c+d[1],visited,dir,queue);
        }
    }

}
