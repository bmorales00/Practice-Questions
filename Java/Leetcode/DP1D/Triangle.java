package com.brianprojects.Leetcode.DP1D;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size()-1;
        int[] temp = new int[0];

        for(var i = row; i>=0; i--){
            int size = triangle.get(i).size();
            int[] dp = new int[size];

            for(var y = 0; y<dp.length; y++){
                dp[y] = triangle.get(i).get(y);
                if(!(i+1 >= triangle.size()) && y+1 < temp.length){
                    dp[y] += Math.min(temp[y], temp[y+1]);
                }
            }
            temp = dp;
        }
        return temp[0];
    }

}
/*
// Recursion

    private int getMinTotal(List<List<Integer>> triangle, int x, int y) {
            if(x >= triangle.size()-1){
                return triangle.get(x).get(y);
            }
            int total = triangle.get(x).get(y);
            total += Math.min(getMinTotal(triangle, x+1, y), getMinTotal(triangle, x+1,y+1));

            return total;
        }
 */

