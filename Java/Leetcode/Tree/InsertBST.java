package com.brianprojects.Leetcode.Tree;


public class InsertBST {
    //Time Complexity: O(log n) || Space Complexity: O(1)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }
        else{
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }
}
