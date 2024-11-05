package com.brianprojects.LeetQues75.Tree.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//O(n^2)
public class NumberOfConnectedGraphs {
    /*
    You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates
    that there is an edge between ai and bi in the graph.
    Return the number of connected components in the graph
     */

    public int makeConnected(int n, int[][] connections){
        Set<Integer> visited = new HashSet<>();
        int numOfGraphs = 0;
        int start = 0;

        for (int[] connection : connections) {
            numOfGraphs += connectedGraphs(connections, connection[start], visited);
        }

        return numOfGraphs;
    }

    private int connectedGraphs(int[][] connections, int node,Set<Integer> visited) {
        if(visited.contains(node)){
            return 0;
        }
        for(int[] connection : connections) {
            if(connection[0] == node && connection.length ==2){
                return connectedGraphs(connections, connection[1], visited);
            }
        }
        visited.add(node);

        return 1;
    }
}
