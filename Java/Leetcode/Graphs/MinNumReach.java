package com.brianprojects.Leetcode.Graphs;

import java.util.ArrayList;
import java.util.List;

public class MinNumReach {
    //Time Complexity: O(V+E) || Space Complexity: O(n)
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges){
        if(edges == null){return new ArrayList<>();}
        List<Integer> res = new ArrayList<>();
        boolean[] notIncoming = new boolean[n];

        for (List<Integer> edge : edges) {
            notIncoming[edge.get(1)] = true;
        }

        for(int i = 0; i<notIncoming.length; i++){
            if(!notIncoming[i]){
                res.add(i);
            }
        }
        return res;
    }
}
