package com.brianprojects.Leetcode.Graphs;


/*
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
//  The hashmap will be used as the key will contain the original node while the value will contain the brand
//  new hard copy

/*
 * DFS - Recursive
 *
 * Time Complexity: O(V + E)
 *
 * Space Complexity: O(V). Both Recursions Stack and HashMap will take O(V) space
 *
 * V = Number of nodes. E = Number of edges in the graph.
 */

import java.util.HashMap;

public class CloneGraph {
    //Time Complexity: O(V+E) || Space Complexity:O(V+E)
    public Node cloneGraph(Node node){
        HashMap<Node, Node> visited = new HashMap<>();
        cloneGraph(node, visited);
        return visited.get(node);
    }
    private void cloneGraph(Node node,HashMap<Node, Node> visited){
        if(node == null){
            return;
        }
        if (!visited.containsKey(node)){
            visited.put(node, new Node(node.val));
        }
        else{
            return;
        }
        for(Node neighbor: node.neighbors){
            cloneGraph(neighbor, visited);
            visited.get(node).neighbors.add(visited.get(neighbor));
        }

    }


}
