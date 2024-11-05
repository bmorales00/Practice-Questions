package com.brianprojects.Leetcode.Tree;

public class SymmetricTrees {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public boolean isSymmetric(TreeNode root){
        if(root == null){return false;}
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){return true;}
        if((root1 == null  || root2 == null || root1.val != root2.val)){return false;}
        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right, root2.left);
    }
}
