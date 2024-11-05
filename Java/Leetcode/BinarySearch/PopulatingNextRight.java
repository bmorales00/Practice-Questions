package com.brianprojects.Leetcode.BinarySearch;

import java.util.HashMap;

public class PopulatingNextRight {
    //Time Complexity: O(n) || Space Complexity: O(n)
    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root){
        if(root == null){return null;}

        HashMap<Integer, Node> map = new HashMap<>();

        dfs(root,map, 0);

        return root;
    }

    private void dfs(Node root, HashMap<Integer, Node> map, int height) {
        if(root == null){return;}
        dfs(root.right,map,height+1);
        dfs(root.left,map,height+1);
        if(!map.containsKey(height)){map.put(height, root);}
        else{root.next = map.get(height);map.replace(height, map.get(height), root);}
    }

    public Node connect2(Node root){
        if(root == null){return null;}

        //HashMap<Integer, Node> map = new HashMap<>();

        dfs(root,null);

        return root;
    }
    private void dfs(Node root, Node parent){
        if(root == null){return;}
        if(parent != null){root.next = parent.right;}
        dfs(root.left, root);
        dfs(root.right,root);
        if(parent != null){root.next = parent.right;}
    }
}
/*
if (root == null) {
        return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
 */