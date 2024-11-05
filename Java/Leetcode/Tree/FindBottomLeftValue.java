package com.brianprojects.Leetcode.Tree;

public class FindBottomLeftValue {
    //Time Complexity: O(n) || Space Complexity: (1)
    int maxDepth = 0;
    int val;
    public int findBottomLeftValue(TreeNode root){
        if(root.left == null && root.right == null){
            return root.val;
        }
        int depth = maxDepth;
        val = root.val;
        dfs(root, depth);
        return val;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null){
            return;
        }

        dfs(root.left, depth+1);
        if(depth > maxDepth){
            maxDepth = depth;
            val = root.val;
        }
        dfs(root.right, depth+1);
    }
}
