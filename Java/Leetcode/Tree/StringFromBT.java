package com.brianprojects.Leetcode.Tree;

public class StringFromBT {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public String tree2str(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        dfs(root, str);
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    private void dfs(TreeNode root, StringBuilder str) {
        if(root == null){
            str.deleteCharAt(str.length()-1);
            return;
        }

        str.append(root.val);
        if(isLeafNode(root)){
            str.append(')');
            return;
        }
        str.append('(');
        if(hasRightChildOnly(root)){
            str.append(')');

        }
        else{
            dfs(root.left, str);
        }
        str.append('(');
        dfs(root.right, str);
        str.append(')');


    }

    private boolean hasRightChildOnly(TreeNode root) {
        return root.right != null && root.left == null;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

