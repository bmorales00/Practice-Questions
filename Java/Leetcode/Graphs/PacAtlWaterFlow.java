package com.brianprojects.Leetcode.Graphs;

import java.util.ArrayList;
import java.util.List;

public class PacAtlWaterFlow {
    /*
     Pacific Atlantic Water Flow:
     There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
     The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's
     right and bottom edges.
     The island is partitioned into a grid of square cells.
     You are given an m x n integer matrix heights where heights[r][c] represents the height above
     sea level of the cell at coordinate (r, c).
     The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
     and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from
     any cell adjacent to an ocean into the ocean.
     Return a 2D list of grid coordinates result where result[i] = [ri, ci]
     denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
     */
    //The Runtime is O(A*P).
    //The space is of O(A+P)

    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> pacific = new ArrayList<>();
    List<List<Integer>> atlantic = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int r = heights.length; // 5
        int c =  heights[0].length; //5

        //DOING HORIZONTAL TRAVERSE FIRST
        //PASSING THROUGH PACIFIC FIRST
        for(var i = 0; i<c; i++ ){
            dfs(0, i,heights[0][i],heights, result, pacific);
        }
        //DOING VERTICAL TRAVERSE
        for(var i = 0; i<r; i++){
            dfs(i, 0, heights[i][0],heights, result,pacific);
        }

        //DOING HORIZONTAL
        for(var i = c-1; i>=0; i-- ){
            dfs(r-1, i,heights[r-1][i],heights, result, atlantic);
        }
        //DOING VERTICAL
        for(var i = r-1; i>=0; i--){
            dfs(i, c-1, heights[i][c-1], heights, result, atlantic);
        }
        for(var i = 0; i< atlantic.size(); i++){
            if(pacific.contains(atlantic.get(i))){
                result.add(atlantic.get(i));
            }
        }

        return result;
    }

    private void dfs(int row, int column, int prev, int[][] heights, List<List<Integer>> result, List<List<Integer>> visited){
        if(row >= heights.length || row < 0|| column >=heights[0].length || column < 0
                || visited.contains(List.of(row, column)) || heights[row][column] < prev){
            return;
        }
        visited.add(List.of(row,column));
        dfs(row -1, column, heights[row][column], heights,result, visited);//UP
        dfs(row +1, column, heights[row][column], heights, result, visited);//DOWN
        dfs(row, column-1, heights[row][column], heights,result,visited);//LEFT
        dfs(row, column+1, heights[row][column],heights,result,visited);//RIGHT

    }
}
