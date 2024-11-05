package com.brianprojects.Leetcode.Graphs;

//Union Find Algorithm

//Time Complexity: O(N) | Space Complexity : O(N) N is the length if Nodes
public class Redundant {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length <= 0) {
            return new int[0];
        }

        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for (var i = 1; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }


        for (var i = 0; i < edges.length; i++) {
            int a = edges[i][0]; //1
            int b = edges[i][1]; //2

            int parentA = findParent(a, parent);
            int parentB = findParent(b, parent);


            if (parent[parentA] == parent[parentB]) {
                return edges[i];
            }
            if (rank[parentA] >= rank[parentB]) {
                rank[a]++;
                parent[parentB] = a;
            } else {
                rank[b]++;
                parent[parentA] = b;
            }
        }

        return edges[edges.length - 1];
    }

    private int findParent(int child, int[] parent) {
        while (child != parent[child]) {
            child = parent[child];
        }
        return child;
    }

}