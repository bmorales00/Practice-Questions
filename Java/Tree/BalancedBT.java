package com.brianprojects.LeetQues75.Tree;

public class BalancedBT {
    /*
    Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined as:
    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

     */

    public boolean isBalanced(TreeNode root) {

        return maxDepth(root) >-1;
    }
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSub = maxDepth(root.left);
        int rightSub = maxDepth(root.right);

        if(leftSub == -1 || rightSub ==-1 || Math.abs(leftSub-rightSub) >1){
            return -1;
        }


        return  Math.max(leftSub,rightSub)+1;

    }
}
