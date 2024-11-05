package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinTimeApples {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int minTime(int n, int[][] edges, List<Boolean> hasApple){
        if(edges == null || hasApple == null){return 0;}
        //Bi-Directional
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        fillGraph(graph,edges);

        return dfs(graph, 0,hasApple, visited, 0);
    }
    private int dfs(HashMap<Integer, List<Integer>> graph, int node, List<Boolean> hasApple,  boolean[] visited, int steps){
        if(visited[node]){
            return 0;
        }
        visited[node] = true;
        int cost = 0;

        for(int n:graph.getOrDefault(node, new ArrayList<>())){
            cost+= dfs(graph, n, hasApple, visited, 2);
        }
        return  cost == 0 && !hasApple.get(node)?0:cost+steps;
    }

    private void fillGraph(HashMap<Integer, List<Integer>> graph,int[][] edges) {
        for (int[] edge : edges) {
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>()); // Adjecency list representation.
            list.add(edge[1]);
            graph.put(edge[0], list);

            list = graph.getOrDefault(edge[1], new ArrayList<>()); // Adjecency list representation.
            list.add(edge[0]);
            graph.put(edge[1], list);
        }
    }
}
