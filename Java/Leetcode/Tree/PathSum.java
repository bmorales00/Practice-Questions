package com.brianprojects.Leetcode.Tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }

        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if(root == null){
            return false;
        }
        if(isLeafNode(root) && sum+root.val == targetSum){
            return true;
        }
        return dfs(root.left, targetSum, sum+root.val) || dfs(root.right, targetSum, sum+root.val);
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
