package com.brianprojects.LeetQues75.Tree;

public class MaxPathSum {
    /*
    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
    A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
    The path sum of a path is the sum of the node's values in the path.
    Given the root of a binary tree, return the maximum path sum of any non-empty path.
     */
    int maxSumResult = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return Math.max(dfs(root), maxSumResult);
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftTree = dfs(root.left);
        int rightTree = dfs(root.right);
        int max = leftTree +rightTree +root.val;
        root.val = Math.max(Math.max(leftTree+root.val, rightTree+root.val), root.val);
        maxSumResult = (Math.max(Math.max(maxSumResult, max),root.val));

        return root.val;
    }
}

/*
static int res = 0;
    public int maxPathSum(TreeNode root) {
        res = root.val;

        dfs(root);

        return res;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        res = Math.max(res, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }
 */