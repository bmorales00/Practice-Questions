package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class ConverBSTGreater {
    //Time Complexity: O(n) || Space Complexity: O(n)
    int sum = 0;
    public TreeNode convertBST(TreeNode root){
        if(root == null){return null;}
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return root;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null){return;}
        dfs(root.right, list);
        if(!list.isEmpty()){
            root.val+=list.get(list.size()-1);
        }
        list.add(root.val);
        dfs(root.left, list);
    }

    public TreeNode convertBST2(TreeNode root){

        return bst(root);
    }

    private TreeNode bst(TreeNode root) {
        if(root==null) return null;
        bst(root.right);
        sum+=root.val;
        root.val=sum;
        bst(root.left);

        return root;
    }
}
