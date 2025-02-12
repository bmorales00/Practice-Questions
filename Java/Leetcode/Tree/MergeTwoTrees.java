package com.brianprojects.Leetcode.Tree;

public class MergeTwoTrees {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){return root2;}
        if(root2 == null){return root1;}
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 != null && root2 == null){
            return root1;
        }
        if(root1 == null){
            return root2;
        }
        root1.val +=root2.val;
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);

        return root1;
    }
}
