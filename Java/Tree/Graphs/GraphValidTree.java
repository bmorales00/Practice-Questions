package com.brianprojects.LeetQues75.Tree.Graphs;

import java.util.HashSet;
import java.util.Set;

public class GraphValidTree {
    /*
    Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
    write a function to check whether these edges make up a valid tree.
     */

    public boolean validTree(int n, int[][] edges){
        Set<Integer> visited = new HashSet<>();
        int prev = edges[0][0];
        for(var i =0; i<edges.length; i++){
            int node = edges[i][0];
            if(!isValidTree(edges, visited, node, prev) && visited.size() != n){
                return false;
            }
        }
        return visited.size() == n;
    }

    private boolean isValidTree(int[][] edges, Set<Integer> visited, int node, int prev) {
        if(visited.contains(node) && prev != node){
            return false;
        }
        if(visited.contains(node) && prev == node){
            return true;
        }
        visited.add(node);
        for(int[] edge : edges) {
            if(edge[0] == node && !isValidTree(edges, visited, edge[1], node)){
                return false;
            }
        }
        return true;
    }
}
/*
class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    private Set<Integer> vis = new HashSet<>();

    boolean dfs(int node, int parent) {
        if (vis.contains(node)) return false;
        vis.add(node);
        for (int neighbour : adj.get(node)) {
            if (parent != neighbour) {
                boolean result = dfs(neighbour, node);
                if (!result) return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1) && vis.size() == n;
    }

 */