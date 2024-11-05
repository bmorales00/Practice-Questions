package com.brianprojects.Leetcode.DP1D;

import java.util.Arrays;

public class BestTeam {
    //Time Complexity: O(n^2) || Space Complexity: O(n)
    public int beatTeamScore(int[] scores, int[] ages){
        int size = scores.length;
        int[][] list = new int[size][2];
        for(int i = 0; i < size; i++){
            list[i][0] = ages[i];
            list[i][1] = scores[i];
        }
        Arrays.sort(list, (a,b) -> a[0] != b[0] ? a[0]-b[0]: a[1]-b[1]);

        int[] dp = new int[size];
        dp[0] = list[0][1];
        for(int i =1; i<size; i++){
            int current = list[i][1];
            for(int j =0; j<i;j++){
                if(list[i][1]>= list[j][1]){
                    current = Math.max(current, list[i][1]+dp[j]);
                }
            }
            dp[i] = current;
        }
        int max = 0;
        for(int n:dp){
            max = Math.max(max,n);
        }
        return max;
    }


}
