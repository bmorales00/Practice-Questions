package com.brianprojects.Leetcode.Tree;

public class TrimBST {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root == null){return null;}

        return dfs(root, low, high);
    }

    private TreeNode dfs(TreeNode root, int low, int high) {
        if(root == null){return null;}

        if(low<=root.val && root.val <= high){
            root.left = dfs(root.left, low,high);
            root.right = dfs(root.right, low, high);
        }
        else if(root.val <low){
            return dfs(root.right, low, high);
        }
        else{
            return dfs(root.left, low, high);
        }
        return root;
    }
}
