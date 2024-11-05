package com.brianprojects.LeetQues75.Tree;

import java.util.ArrayDeque;

public class InvertTree {

    /*
    Given the root of a binary tree, invert the tree, and return its root.
     */

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayDeque<TreeNode> queue= new ArrayDeque<TreeNode>();
        //Reference to the OLD TREE
        //var current = root;
        queue.add(root); // 2
        //Reference to the NEW TREE
        //TreeNode newTree = new TreeNode(root.val); //2

        while(!queue.isEmpty()){
            var current = queue.removeFirst(); //2
            TreeNode leftChild = null;
            TreeNode rightChild = null;
            if(current.right != null){ //3
                leftChild = current.right;
                //newTree.leftChild = current.rightChild; //3
                queue.add(current.right); //3
            }
            if(current.left != null){
                rightChild = current.left;
                //newTree.rightChild = current.leftChild;
                queue.add(current.left);
            }
            current.left = leftChild;
            current.right = rightChild;
        }

        return root;
    }

}
