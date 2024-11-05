package com.brianprojects.Leetcode.Greedy;

import java.util.*;

public class TwoCity {
    //Time Complexity: O(n log n) || Space Complexity: O(n)
    public int twoCitySchedCost(int[][] costs) {
        if(costs == null){return 0;}
        int[][] diff =new int[costs.length][2];
        int total = 0;
        for(int i = 0; i<costs.length; i++){
            diff[i][0] = costs[i][1] - costs[i][0];
            diff[i][1] = i;
        }
        Arrays.sort(diff, Comparator.comparing(a ->a[0]));

        for(int i = 0; i<diff.length; i++){
            if(i<diff.length/2){
                total+=costs[diff[i][1]][1];
            }
            else{
                total+=costs[diff[i][1]][0];
            }
        }
        return total;
    }

    public int twoCitySchedCost2(int[][] costs) {
        if(costs == null){return 0;}
        List<Integer> res = new ArrayList<>();
        int mid = costs.length/2;
        int smallest = Integer.MAX_VALUE;
        dfs(0, 0, 0, 0,costs,res);

        for(int v:res){
            smallest = Math.min(smallest,v);
        }
        return smallest;
     }
     private void dfs(int i, int aCount, int bCount, int total,int[][] costs,List<Integer> res){
         int mid = costs.length/2;
         if(i>costs.length){return;}

         if(aCount == mid && bCount == mid){
             res.add(total);
             return;
         }
         if(aCount<mid){
             total+=costs[i][0];
             dfs(i+1, aCount+1,bCount,total,costs,res);
             total-=costs[i][0];
         }
         if(bCount<mid){
             total+=costs[i][1];
             dfs(i+1, aCount,bCount+1,total,costs,res);
             total-=costs[i][1];
         }

     }
}
