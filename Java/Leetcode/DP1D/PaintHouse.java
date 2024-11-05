package com.brianprojects.Leetcode.DP1D;

public class PaintHouse {
    //Time Complexity: O(n) || Space Complexity:O(1)
    public int minCost(int[][] costs){
        if(costs == null){return -1;}


        for(int i = 1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }

        int last = costs.length-1;
        return Math.min(costs[last][0],Math.min(costs[last][1], costs[last][2]));
    }


}
