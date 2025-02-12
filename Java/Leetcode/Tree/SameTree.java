package com.brianprojects.Leetcode.Tree;

public class SameTree {
    /*
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     */

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null){
            return true;
        }

        if(p == null && q != null || p != null && q == null || p.val != q.val){
            return false;
        }

        return (isSameTree(p.left ,q.left) && isSameTree(p.right, q.right));
    }
}
