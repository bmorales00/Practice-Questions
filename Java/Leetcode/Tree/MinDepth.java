package com.brianprojects.Leetcode.Tree;


public class MinDepth {
    public int minDepth(TreeNode root){
        if(root == null ){
            return -1;
        }
        if(isLeaf(root)){return -1;}
        return minDepth(root, 1);
    }
    public int minDepth(TreeNode root, int count){
        if(root == null){return Integer.MAX_VALUE;}
        if(isLeaf(root)){
            return count;
        }
        return Math.min(minDepth(root.left, count+1), minDepth(root.right, count+1));
    }
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
