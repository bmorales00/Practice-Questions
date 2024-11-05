package com.brianprojects.Leetcode.MathAndGeo;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        List<List<Integer>> finalRes = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m; i++){
            finalRes.add(new ArrayList<>());
            for(int j = 0; j<n;j++){
                finalRes.get(i).add(grid[i][j]);
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int r =  (i+((j+k)/n))%m;
                int c  = (j + k) %n;
                finalRes.get(r).set(c, grid[i][j]);
            }
        }
        return finalRes;
    }
}
