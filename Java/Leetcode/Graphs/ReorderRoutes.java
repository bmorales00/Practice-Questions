package com.brianprojects.Leetcode.Graphs;

import java.util.*;

public class ReorderRoutes {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int minReorder(int n, int[][] connections) {
        //ajdacency list where int[] will be [dest,cost]
        List<int[]>[] cons = new List[n];
        
        for(int[] con : connections) {
            if (cons[con[0]] == null) cons[con[0]] = new ArrayList<int[]>();
            if (cons[con[1]] == null) cons[con[1]] = new ArrayList<int[]>();
            cons[con[0]].add(new int[]{con[1],1});//original direction, costs 1
            cons[con[1]].add(new int[]{con[0],0});//oposite directions, costs 0
        }
        return dfs(0,cons,new boolean[n]);
    }
    private int dfs(int curr, List<int[]>[] cons, boolean[] visited) {
        int cost = 0;
        visited[curr]=true;
        for(int[] neigh : cons[curr]) {
            if (!visited[neigh[0]]) {
                cost += neigh[1];
                cost += dfs(neigh[0],cons,visited);
            }
        }
        return cost;
    }

}
/*
public int minReorder(int n , int[][] connections){
        if(connections == null){return -1;}
        HashSet<Integer> visited = new HashSet<>();
        return dfs(n,connections, 0 , visited);

    }

    private int dfs(int n, int[][] connections, int target,HashSet<Integer> visited) {

        int total = 0;
        for(int i = 0; i<connections.length; i++){
            if(visited.contains(i)){continue;}
            visited.add(i);
            if(connections[i][0] == target){
//                swap(connections, i);
                total+=dfs(n,connections,connections[i][1], visited)+1;
            }
            else if(connections[i][1] == target){
                total+=dfs(n,connections,connections[i][0],visited);
            }
            else{
                visited.remove(i);
            }
        }
        return total;
    }
 */


