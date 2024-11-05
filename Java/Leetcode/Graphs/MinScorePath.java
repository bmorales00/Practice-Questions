package com.brianprojects.Leetcode.Graphs;

public class MinScorePath {
    public int minScore(int n,int[][] roads){
        boolean[] visited = new boolean[n+1];
        int min= 100001;
        for (int[] road : roads) {
            min = Math.min(min, dfs(roads, visited, road[0]));
        }
        return min;
    }

    private int dfs(int[][] roads, boolean[] visited,int a) {
        //if(visited[roads[index][0]] && visited[roads[index][1]]){return roads[index][2];}
        int min = 100001;
        for(int i = 0; i<roads.length;i++){
            if(roads[i][0] == a && !(visited[a]&&visited[roads[i][1]])){
                visited[a]  = true;
                int b = roads[i][1];
                min = Math.min(min,Math.min(roads[i][2],dfs(roads,visited, b)));
            }
            else if(roads[i][0] == a && (visited[a]&&visited[roads[i][1]])){
                return Math.min(min,roads[i][2]);
            }
        }
        return min;
    }
}
