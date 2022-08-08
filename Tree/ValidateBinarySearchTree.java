package com.brianprojects.LeetQues75.Tree;


import com.brianprojects.LeetQues75.Tree.TreeNode;

public class ValidateBinarySearchTree {
    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

     */

    public boolean isValidBST(TreeNode root){

        return isValidBST(Long.MIN_VALUE, root,Long.MAX_VALUE);
    }
    private boolean isValidBST(Long min, TreeNode root,Long max){
        if(root == null){
            return true;
        }
        if(root.val >= max || root.val <= min){
            return false;
        }

        return isValidBST(min,root.left, (long) root.val) && isValidBST((long) root.val, root.right, max);
    }

}



/*
if(root == null){
            return true;
        }
        if(root.left != null && (root.left.val >= root.val ||(root.val > parentRoot.val && root.left.val < parentRoot.val)||
                (root.val > mainRoot.val && root.left.val < mainRoot.val))){
            return false;
        }
        if(root.right != null && (root.right.val <= root.val || (root.val < parentRoot.val && root.right.val >= parentRoot.val)||
                (root.val < mainRoot.val && root.right.val >= mainRoot.val))){
            return false;
        }

        return isValidBST(root.left, root, mainRoot) && isValidBST(root.right, root, mainRoot);
 */