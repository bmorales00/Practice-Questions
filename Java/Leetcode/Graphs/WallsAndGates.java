package com.brianprojects.Leetcode.Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] grid){

        if(grid == null || grid[0] == null){
            return;
        }

        int row = grid.length;
        int col = grid[0].length;
        int inf = 2147483647;

        Queue<int[]> queue = new ArrayDeque<>();

        for(var r = 0; r<row; r++){
            for(var c = 0; c<col; c++){
                if(grid[r][c] == 0){
                    queue.offer(new int[]{r,c});
                }
            }
        }
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            for(var i = currentSize; i>0; i--){
                var currentGate = queue.poll();
                int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};
                var prev_r = currentGate[0];
                var prev_c = currentGate[1];

                for(var direction : directions){
                    var r = prev_r + direction[0];
                    var c = prev_c+direction[1];
                    if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != inf){
                        continue;
                    }
                    grid[r][c] = grid[prev_r][prev_c]+1;
                    queue.add(new int[]{r,c});
                }

            }
        }

    }
}
