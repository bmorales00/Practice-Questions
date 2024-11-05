package com.brianprojects.Leetcode.DP2D;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix){
        if(matrix == null){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[r-1].length;
        int maxSquare = 0;
        int[][] dp = new int[r][c];
        for(var x = 0; x<r; x++){
            for(var y = 0;y<c; y++){
                if(matrix[x][y] == '0'){
                    dp[x][y] = 0;
                    continue;
                }
                dp[x][y] = 1;
                if(x>0 && y>0){
                    dp[x][y] += Math.min(Math.min(dp[x-1][y],dp[x][y-1]),dp[x-1][y-1]);
                }
                maxSquare = Math.max(maxSquare, dp[x][y]);

            }
        }
        return maxSquare*maxSquare;
    }


}
/*
int sq = Math.min(Math.min((dp[x+1][y]-'0'),(dp[x][y+1]-'0')),(dp[x+1][y+1]-'0')) + matrix[x][y] -'0';
                maxSquare = Math.max(maxSquare, sq);
                dp[x][y] = (char) (sq+'0');
 */
