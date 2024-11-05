package com.brianprojects.Leetcode.Graphs;

import java.util.ArrayDeque;

import java.util.Queue;

//Multi Source BFS where we gather multiple starting nodes and add them to a queue and resume the bfs.

// The time complexity is : O(m*n) | The space complexity is O(r) r being the potential rotten tomatoes
public class RottingOranges {
    public int orangeRotting(int[][] grid){
        if(grid.length==0){
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for(var r = 0; r<row; r++){
            for(var c = 0; c<col; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r, c});
                }
                if(grid[r][c] == 1){
                    freshOranges++;
                }
            }
        }
        int minutes = 0;
        while(!queue.isEmpty() && freshOranges > 0){
            int currentSize = queue.size();
            var fourWay = new int[][]{{-1,0},{1,0},{0,1}, {0,-1}};
            for(var i = currentSize; i>0; i--){
                var rotten = queue.poll();
                for(var direction: fourWay){
                    var r = rotten[0]+direction[0];
                    var c = rotten[1]+direction[1];
                    if(r < 0 || r>=grid.length || c <0 || c>=grid[r].length || grid[r][c] !=1){
                        continue;
                    }
                    grid[r][c] =2;
                    freshOranges--;
                    queue.offer(new int[]{r,c});
                }
            }
            minutes = queue.size()>0? minutes+1:minutes;
        }

        return freshOranges ==0? minutes: -1;
    }

}
