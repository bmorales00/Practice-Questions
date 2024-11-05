package com.brianprojects.Leetcode.Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    //Time Complexity: O(n^2) || Space Complexity: O(n^2)
    public int shortestPathBinaryMatrix(int[][] grid){
        if(grid == null || grid[0][0] != 0 || grid[grid.length-1][grid.length-1] != 0){return -1;}
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            grid[current[0]][current[1]] +=1;
            int num = grid[current[0]][current[1]];
            for(var d:dir){
                if(current[0] + d[0] >=0 && current[0] +d[0] <n && current[1]+d[1] >=0 && current[1]+d[1] <n &&
                grid[current[0] + d[0]][current[1]+d[1]] == 0){
                    grid[current[0] + d[0]][current[1]+d[1]] = num;
                    queue.offer(new int[]{current[0] + d[0],current[1]+d[1]});
                }
            }

        }
        return grid[grid.length-1][grid.length-1] == 0?-1:grid[grid.length-1][grid.length-1];
    }
}

