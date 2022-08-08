package com.brianprojects.LeetQues75.Tree.Graphs;

import java.util.HashMap;

public class CloneGraph {
    public Node cloneGraph(Node node){
        HashMap<Node, Node> visited = new HashMap<>();
        cloneGraph(node, visited);
        Node clonedGraph = visited.get(node);
        return clonedGraph;
    }
    private void cloneGraph(Node node,HashMap<Node, Node> visited){
        var current = node;
        if(current == null){
            return;
        }
        if (!visited.containsKey(current)){
            visited.put(current, new Node(current.val));
        }
        else{
            return;
        }

        for(Node neighbor: current.neighbors){
            cloneGraph(neighbor, visited);
            visited.get(current).neighbors.add(visited.get(neighbor));
        }

    }


}
