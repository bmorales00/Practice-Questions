package com.brianprojects.Leetcode.Tree;

public class DeleteBST {
    //Time Complexity: O(log n) || Space Complexity: O(1)
    public TreeNode deleteNode(TreeNode root, int key){
        TreeNode parent = root;
        TreeNode current = root;
        while(current != null && current.val != key){
            parent=current;
            current = key<current.val?current.left:current.right;
        }
        if(current == null){
            return root;
        }
        if(parent.left != null && parent.left.val == key){
            parent.left = current.left;
            current = current.right;
        }
        else if(parent.right != null && parent.right.val == key){
            parent.right = current.right;
            current =current.left;
        }
        else if(root.val == key){
            current = root.right;
            root = root.left;
        }
        return insertNode(root, current);

    }

    private TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null){
            return node;
        }
        if(node == null){
            return root;
        }
        if(node != null && node.val < root.val){
            root.left = insertNode(root.left, node);
        }
        else{
            root.right = insertNode(root.right,node);
        }
        return root;
    }
}
