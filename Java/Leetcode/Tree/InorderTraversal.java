package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<Integer> inorderTraversal(TreeNode root){
        if(root == null){return new ArrayList<>();}

        List<Integer> res = new ArrayList<>();

        dfs(res, root);
        return res;
    }
    private void dfs(List<Integer> res, TreeNode root) {
        if(root == null){return;}
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }
}
