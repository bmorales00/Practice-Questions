package com.brianprojects.Leetcode.Tree;

public class SubTree {
    //**** Subtree of Another Tree
    /*
    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root
    with the same structure and node values of subRoot and false otherwise.
    A subtree of a binary tree tree is a tree that consists of a
    node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
     */

    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        }

        return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);

    }

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
