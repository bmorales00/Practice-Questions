package com.brianprojects.Leetcode.MathAndGeo;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    //Time Complexity: O(m*n) || Space Complexity: O(m*n)
    public List<Integer> spiralMatrix(int[][] matrix){
        if(matrix == null){return null;}

        List<Integer> res = new ArrayList<>();

        dfs(matrix, res, 0 , 0);

        return res;
    }

    private void dfs(int[][] matrix, List<Integer> res, int r, int c) {
        if(r >=matrix.length || r<0  || c >= matrix[0].length || c<0){return;}
        if(matrix[r][c] == -101){return;}
        res.add(matrix[r][c]);
        matrix[r][c] = -101;

        if(r-1 < 0 || matrix[r-1][c] == -101){
            dfs(matrix,res,r,c+1);
        }
        dfs(matrix,res,r+1,c);
        dfs(matrix,res,r,c-1);
        dfs(matrix,res,r-1,c);
    }
}
